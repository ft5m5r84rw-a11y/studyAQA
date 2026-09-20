package webshop.test;

import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.WsLoginPage;
import webshop.pages.WsRegistrationPage;
import static com.codeborne.selenide.Selenide.*;
import static webshop.config.Config.WEB_SHOP_REGISTRATION_URL;

public class LoginTest {
    private static final Faker faker = new Faker();
    private String emailAddress;
    private String password;

    @BeforeEach
    void beforeEach() {
        password = faker.harryPotter().character() + faker.number().positive();
        emailAddress = faker.internet().emailAddress();

        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .register(
                        faker.name().firstName(),
                        faker.name().lastName(),
                        emailAddress,
                        password)
                .checkEmailIsShown(emailAddress);

        clearBrowserCookies();
        clearBrowserLocalStorage();

    }

    @Test
    void successLoginTest() {

        open(WEB_SHOP_REGISTRATION_URL, WsLoginPage.class)
                .openLogin()
                .checkLoginPageOpened()
                .enterEmail(emailAddress)
                .enterPassword(password)
                .selectRememberMe()
                .submitLogin()
                .checkUserEmail(emailAddress);

    }

}
