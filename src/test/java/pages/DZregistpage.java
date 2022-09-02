package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.*;

import java.io.File;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DZregistpage {

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
    public DZregistpage openPage() {
        open("/automation-practice-form");

        return this;
    }
    public DZregistpage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public DZregistpage clearFirstName() {
        firstNameInput.clear();

        return this;
    }

    public DZregistpage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public DZregistpage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public DZregistpage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public DZregistpage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public DZregistpage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(year, month, day);
        return this;
    }

    public DZregistpage setUserSubjects(String value1) {
        subjectsComponent.setSubjects(value1);
        return this;
    }

    public DZregistpage setHobbies(String value1) {
        hobbiesComponent.setHobbies(value1);

        return this;
    }
    public DZregistpage setStateAndCity(String value1, String value2) {
        stateAndCityComponent.setStateAndCity(value1, value2);

        return this;
    }

    public DZregistpage setUploadFile(String value) {
        uploadPicture.uploadFile(new File("src/test/resources/test.jpg"));

        return this;
    }
    public DZregistpage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public DZregistpage checkResultsTableVisible () {
        resultsTableComponent.checkVisible();

        return this;
    }

    public DZregistpage checkResult (String key, String value){
        resultsTableComponent.checkResult(key, value);

        return this;
    }
    public DZregistpage pressSubmit() {
        submit.click();

        return this;
    }
    public DZregistpage pressCloseLargeModal() {
        closeLargeModal.click();

        return this;
    }


}