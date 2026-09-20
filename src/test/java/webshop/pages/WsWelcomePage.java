package webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;


public class WsWelcomePage {
    private final SelenideElement registerButton = $("a.ico-register");

    public WsRegistrationPage openRegistration() {
        registerButton.click();
        return new WsRegistrationPage();

    }


}
