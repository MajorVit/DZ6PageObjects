package test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import pages.DzRegistPage;

import static java.lang.String.format;

public class RegistrationFormPageWithFaker extends TestBase {


    Faker faker = new Faker();

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            mobileNumber = faker.phoneNumber().subscriberNumber(10),
            day = faker.number().numberBetween(1, 29) + "",
            month = "June",
            year = faker.number().numberBetween(2000, 2008) + "",
            subjects = "Arts",
            hobby_1 = "Sports",

            filePathResources = "src/test/resources/",
            fileName = "test.jpg",
            currentAddress = faker.address().fullAddress(),
            state = "NCR",
            city = "Delhi";


    @Test
    void fillFormTest () {
        DzRegistPage DzRegistPage = new DzRegistPage();
        DzRegistPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setNumber(mobileNumber)
                .setBirthDate(day, month, year)
                .setUserSubjects(subjects)
                .setHobbies(hobby_1)
                .setUploadFile(filePathResources + fileName)
                .setCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .pressSubmit();

        String expectedFullName = format("%s %s", firstName, lastName);
        String expectedDateOfBirth = format("%s %s,%s", day, month, year);
        String expectedStateAndCity = format("%s %s", state, city);

        DzRegistPage.checkResultsTableVisible()
                .checkResult("Student Name", expectedFullName)
                .checkResult("Student Email", email)
                .checkResult("Gender", gender)
                .checkResult("Mobile", mobileNumber)
                .checkResult("Date of Birth", expectedDateOfBirth)
                .checkResult("Subjects", subjects)
                .checkResult("Hobbies", hobby_1)
                .checkResult("Picture", fileName)
                .checkResult("Address", currentAddress)
                .checkResult("State and City", expectedStateAndCity)
                .pressCloseLargeModal();


    }
}
