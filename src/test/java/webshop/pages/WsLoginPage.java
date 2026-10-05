package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsLoginPage {

    private final SelenideElement loginButton = $("a.ico-login");
    private final SelenideElement titleText = $("div.page-title");
    private final SelenideElement emailInput = $("input.email");
    private final SelenideElement passwordInput = $("input.password");
    private final SelenideElement rememberMeCheckbox = $("#RememberMe");
    private final SelenideElement submitLoginButton = $("input.login-button");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");


    public WsLoginPage openLogin() {
        loginButton.click();
        return this;

    }

    public WsLoginPage checkLoginPageOpened() {
        titleText.shouldHave(text("Welcome, Please Sign In!"));
        return this;

    }

    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;

    }

    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;

    }

    public WsLoginPage selectRememberMe() {
        rememberMeCheckbox.click();
        return this;

    }

    public WsLoginPage submitLogin() {
        submitLoginButton.click();
        return this;

    }

    public WsLoginPage checkUserEmail(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;

    }
}

