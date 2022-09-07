package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
        //Configuration.timeout = 10000;
        Configuration.browserSize = "1920x1080";
    }
}
