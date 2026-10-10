package webshop.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import webshop.config.WebDriverConfig;
import webshop.util.AttachManager;

import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static webshop.config.Config.getSelenoidChromeOptions;
import static webshop.config.Config.getWebDriverConfig;


public class TestBase {
    private static final Logger log = LoggerFactory.getLogger(TestBase.class);
    private static final WebDriverConfig config = getWebDriverConfig();

    @BeforeAll
    static void setUp() {

        SelenideLogger.addListener("allureSelenide", new AllureSelenide());

        Configuration.browserSize = config.browserSize();
        Configuration.browser = config.browser();

        if ("remote".equals(System.getProperty("run"))) {

            Configuration.remote =
                    "https://" + config.selenoidUser() + ":" + config.selenoidPassword() + "@" + config.selenoidUrl();
            Configuration.browserCapabilities = getSelenoidChromeOptions();


        }
    }


    @AfterEach
    void tearDown() {
        AttachManager.takeScreenshot();
        AttachManager.getPageSource();
        AttachManager.getBrowserConsoleLogs();

        if ("remote".equals(config.run())) {
            AttachManager.addVideo();
        }
        clearBrowserCookies();
        clearBrowserLocalStorage();
    }

/*    @BeforeEach
    void closeDriver() {
        closeWebDriver();
    }*/
}

