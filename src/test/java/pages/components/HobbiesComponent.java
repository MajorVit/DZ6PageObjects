package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HobbiesComponent {

    public HobbiesComponent setHobbies(String value1) {
        $("#hobbiesWrapper").$(byText(value1)).click();


        return this;
    }
}
