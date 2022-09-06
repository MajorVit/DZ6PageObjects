package test;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.DzRegistPage;


public class DzRegistFormPage {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void formTest() {
        DzRegistPage DzRegistPage = new DzRegistPage();
        DzRegistPage.openPage()
        .setFirstName("Vital")
        .setLastName("Major")
        .setEmail("Vital@mail.ru")
        .setGender("Male")
        .setNumber("8929555555")
        .setBirthDate("30", "July", "2000")
        .setUserSubjects("Arts")
        .setHobbies("Sports")
        .setUploadFile("src/test/resources/test.jpg")
        .setCurrentAddress("Pervaya 1")
        .setStateAndCity("NCR", "Delhi")
        .pressSubmit();

        DzRegistPage.checkResultsTableVisible()
                .checkResult("Student Name", "Vital Major")
                .checkResult("Student Email", "Vital@mail.ru")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8929555555")
                .checkResult("Date of Birth", "30 july,2000")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Sport")
                .checkResult("Picture", "test.jpg")
                .checkResult("Address", "Pervaya 1")
                .checkResult("State and City", "NCR Delhi")
                .pressCloseLargeModal();


    }
}
