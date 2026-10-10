package webshop.test;

import io.qameta.allure.*;
import net.datafaker.Faker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import webshop.pages.WsRegistrationPage;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static webshop.config.Config.WEB_SHOP_REGISTRATION_URL;


public class RegistrationTest extends TestBase {
    private static final Faker faker = new Faker();


    @Test
    @Severity(CRITICAL)
    @Feature("Регистрация")
    @Story("Регистрация нового пользователя")
    @Epic("Авторизация")
    @DisplayName("Успешная регистрация нового пользователя")
    @Description("Создаем нового пользователя со случайными данными через интерфейс")
    @Link(name = "TASK-007", url = "https://")
    void registrationTest() {
        String password = faker.harryPotter().character() + faker.number().positive();
        String emailAddress = faker.internet().emailAddress();

        open(WEB_SHOP_REGISTRATION_URL, WsRegistrationPage.class)
                .verifyRegistrationOpened()
                .selectFemaleGender()
                .enterFirstName(faker.name().firstName())
                .enterLastName(faker.name().lastName())
                .enterEmail(emailAddress)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkResultRegistration()
                .checkEmailIsShown(emailAddress);


    }
}
