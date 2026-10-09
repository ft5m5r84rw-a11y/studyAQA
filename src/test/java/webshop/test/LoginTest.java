package webshop.test;

import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import net.datafaker.Faker;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import webshop.pages.WsLoginPage;
import webshop.pages.WsRegistrationPage;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.NORMAL;
import static webshop.config.Config.WEB_SHOP_LOGIN_URL;
import static webshop.config.Config.WEB_SHOP_REGISTRATION_URL;

public class LoginTest extends TestBase {
    private static final Faker faker = new Faker();
    private String emailAddress;
    private String password;

    @Nested
    public class PositiveTests {
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


        }

        @Test
        @DisplayName("Успешная авторизация зарегистрированного пользователя")
        @Severity(CRITICAL)
        @Owner("polina_solnyshkina")
        @Link(name = "TASK-005", url = "https://")
        void successLoginTest() {

            open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                    .checkLoginPageOpened()
                    .enterEmail(emailAddress)
                    .enterPassword(password)
                    .selectRememberMe()
                    .submitLogin()
                    .checkUserEmail(emailAddress);

        }

    }

    @ParameterizedTest(name = "Проверка ошибки валидации при вводе некорректной электронной почты: {0}")
    @Severity(NORMAL)
    @Owner("polina_solnyshkina")
    @Link(name = "TASK-006", url = "https://")
    @CsvFileSource(resources = "/email.csv")
    void invalidEmailLoginTest(String email) {
        open(WEB_SHOP_LOGIN_URL, WsLoginPage.class)
                .enterEmail(email)
                .enterPassword("password")
                .verifyEmailValidationErrorAppear()
                .submitLogin();
    }
}
