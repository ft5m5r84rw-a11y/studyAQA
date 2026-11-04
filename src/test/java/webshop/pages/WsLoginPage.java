package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
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

    @Step("Открыть страницу авторизации")
    public WsLoginPage openLogin() {
        loginButton.click();
        return this;

    }

    @Step("Проверить открытие страницы авторизации")
    public WsLoginPage checkLoginPageOpened() {
        titleText.shouldHave(text("Welcome, Please Sign In!"));
        return this;

    }

    @Step("Ввести электронную почту")
    public WsLoginPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;

    }

    @Step("Ввести пароль")
    public WsLoginPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;

    }

    @Step("Установить флажок «Запомнить меня»")
    public WsLoginPage selectRememberMe() {
        rememberMeCheckbox.click();
        return this;

    }

    @Step("Нажать кнопку «Войти»")
    public WsLoginPage submitLogin() {
        submitLoginButton.click();
        return this;

    }

    @Step("Проверить отображение ошибки валидации электронной почты")
    public WsLoginPage verifyEmailValidationErrorAppear() {
        $("span.field-validation-error").shouldBe(visible);
        return this;
    }

    @Step("Проверить отображение электронной почты пользователя: {email}")
    public WsLoginPage checkUserEmail(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;

    }
}

