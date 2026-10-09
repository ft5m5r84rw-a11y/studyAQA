package webshop.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import webshop.util.AttachManager;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    @BeforeAll
    static void before() {
        Configuration.browserSize = "1920x1080";
    }

    @BeforeAll
    static void setUpALL(){
        SelenideLogger.addListener("allureSelenide", new AllureSelenide());
    }

    @AfterEach
    void tearDown() {
        AttachManager.takeScreenshot();
        AttachManager.getPageSource();
        AttachManager.getBrowserConsoleLogs();

        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

/*    @BeforeEach
    void closeDriver() {
        closeWebDriver();
    }*/
}
