package test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static java.lang.String.format;
import static test.TestData.*;


public class RegistrationFormPageWithTestDataTests extends TestBase {


    //String firstName;
    //String lastName;
    //String day;
    //String month;
    //String year;

    //@BeforeEach
      //      void prepareTestData() {
        //firstName = "Vital";
         //lastName = "Major";
         //day = "08";
         //month = "July";
         //year = "2000";
    //}


    @Test
    void formTest() {
        open("/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("Vital@mail.ru");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8929555555");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        $(format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day)).click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("[for='hobbies-checkbox-1']").click();
        $("#uploadPicture").uploadFile(new File("src/test/resources/test.jpg"));
        $("#currentAddress").setValue("Pervaya 1");
        $("#state").click();
        $(byText("NCR")).click();
        $("#city").click();
        $(byText("Delhi")).click();
        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive table").$(byText("Student Name"))
                .parent().shouldHave(text(firstName + " " + lastName));

        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        $(".table-responsive table").$(byText("Date of Birth"))
                .parent().shouldHave(text(expectedDateOfBirth));

        $(".modal-body").shouldHave(text("Vital@mail.ru"));
        $(".modal-body").shouldHave(text("Male"));
        $(".modal-body").shouldHave(text("8929555555"));
        $(".modal-body").shouldHave(text("08 July,2000"));
        $(".modal-body").shouldHave(text("Arts"));
        $(".modal-body").shouldHave(text("Sport"));
        $(".modal-body").shouldHave(text("test.jpg"));
        $(".modal-body").shouldHave(text("Pervaya 1"));
        $(".modal-body").shouldHave(text("NCR Delhi"));

        $("#closeLargeModal").click();




    }
}

