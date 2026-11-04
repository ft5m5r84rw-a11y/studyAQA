package webshop.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;


public class WsWelcomePage extends BasePage {
    private final SelenideElement registerButton = $("a.ico-register");

    @Step("Открыть страницу регистрации")
    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return new WsRegistrationPage();

    }


}
