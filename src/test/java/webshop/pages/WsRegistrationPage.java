package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsRegistrationPage {
    private final SelenideElement pageTitle = $("div.page-title");
    private final SelenideElement femaleGenderRadio = $("input#gender-female");
    private final SelenideElement firstNameInput = $("input#FirstName");
    private final SelenideElement lastNameInput = $("input#LastName");
    private final SelenideElement emailInput = $("input#Email");
    private final SelenideElement passwordInput = $("input#Password");
    private final SelenideElement confirmPasswordInput = $("input#ConfirmPassword");
    private final SelenideElement submitRegistrationButton = $("input#register-button");
    private final SelenideElement resultText = $("div.result");
    private final ElementsCollection headerLinks = $$("div.header-links ul li a");


    public WsRegistrationPage register(String firstName, String lastName, String emailAddress, String password) {
        verifyRegistrationOpened()
                .selectFemaleGender()
                .enterFirstName(firstName)
                .enterLastName(lastName)
                .enterEmail(emailAddress)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .submitRegistration()
                .checkResultRegistration();

        return this;
    }

    @Step("Проверить открытие страницы регистрации")
    public WsRegistrationPage verifyRegistrationOpened() {
        pageTitle.shouldHave(text("Register"));
        return this;
    }

    @Step("Выбрать женский пол")
    public WsRegistrationPage selectFemaleGender() {
        femaleGenderRadio.click();
        return this;
    }

    @Step("Ввести имя: {firstName}")
    public WsRegistrationPage enterFirstName(String firstName) {
        firstNameInput.setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public WsRegistrationPage enterLastName(String lastName) {
        lastNameInput.setValue(lastName);
        return this;

    }

    @Step("Ввести электронную почту: {email}")
    public WsRegistrationPage enterEmail(String email) {
        emailInput.setValue(email);
        return this;

    }

    @Step("Ввести пароль")
    public WsRegistrationPage enterPassword(String password) {
        passwordInput.setValue(password);
        return this;

    }

    @Step("Подтвердить пароль")
    public WsRegistrationPage enterConfirmPassword(String password) {
        confirmPasswordInput.setValue(password);
        return this;

    }

    @Step("Нажать кнопку «Зарегистрироваться»")
    public WsRegistrationPage submitRegistration() {
        submitRegistrationButton.click();
        return this;
    }

    @Step("Проверить успешную регистрацию пользователя")
    public WsRegistrationPage checkResultRegistration() {
        resultText.shouldHave(text("Your registration completed"));
        return this;

    }

    @Step("Проверить отображение электронной почты пользователя: {email}")
    public WsRegistrationPage checkEmailIsShown(String email) {
        headerLinks.get(0).shouldHave(text(email));
        return this;
    }


}
