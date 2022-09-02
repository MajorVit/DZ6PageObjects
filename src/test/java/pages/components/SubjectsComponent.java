package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    public SubjectsComponent setSubjects(String value1) {
        $("#subjectsInput").setValue(value1).pressEnter();



        return this;
    }
}