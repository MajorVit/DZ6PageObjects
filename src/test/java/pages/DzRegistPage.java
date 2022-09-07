package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DzRegistPage {

    private CalendarComponent calendarComponent = new CalendarComponent();

    private ResultsTableComponent resultsTableComponent = new ResultsTableComponent();
    private SubjectsComponent subjectsComponent = new SubjectsComponent();
    private HobbiesComponent hobbiesComponent = new HobbiesComponent();
    private StateAndCityComponent stateAndCityComponent = new StateAndCityComponent();
private SelenideElement  firstNameInput = $("#firstName"),
        lastNameInput = $("#lastName"),
        emailInput = $("#userEmail"),
        uploadPicture = $("#uploadPicture"),
        currentAddressInput = $("#currentAddress"),
        submit = $(byText("Submit")),
        closeLargeModal = $("#closeLargeModal");
    public DzRegistPage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public DzRegistPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public DzRegistPage clearFirstName() {
        firstNameInput.clear();

        return this;
    }

    public DzRegistPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public DzRegistPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public DzRegistPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public DzRegistPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public DzRegistPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public DzRegistPage setUserSubjects(String value1) {
        subjectsComponent.setSubjects(value1);
        return this;
    }

    public DzRegistPage setHobbies(String value1) {
        hobbiesComponent.setHobbies(value1);

        return this;
    }
    public DzRegistPage setStateAndCity(String value1, String value2) {
        stateAndCityComponent.setStateAndCity(value1, value2);

        return this;
    }

    public DzRegistPage setUploadFile(String value) {
        uploadPicture.uploadFile(new File("src/test/resources/test.jpg"));

        return this;
    }
    public DzRegistPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public DzRegistPage checkResultsTableVisible() {
        resultsTableComponent.checkVisible();

        return this;
    }

    public DzRegistPage checkResult (String key, String value){
        resultsTableComponent.checkResult(key, value);

        return this;
    }
    public DzRegistPage pressSubmit() {
        submit.click();

        return this;
    }
    public DzRegistPage pressCloseLargeModal() {
        closeLargeModal.click();

        return this;
    }


}