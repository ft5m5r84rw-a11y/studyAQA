package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WelcomePage extends BasePage {
    private final ElementsCollection navigatiorMenu = $$(".t-menu__list li");
    private final SelenideElement startQaButton = $("a[href='#zeropopup']");
    private final SelenideElement paymentButton = $(byText("Бегу оплачивать"));

    public WelcomePage switchToWelcomeWindow(int index) {
        switchToWindow(index);
        return this;
    }


    @Step("Нажать на последний пункт меню")
    public WelcomePage clickMenu() {
        navigatiorMenu.last().click();
        return this;
    }

    @Step("Нажать на кнопку «Хочу вкатиться в  QA»")
    public WelcomePage clickStartQaButton() {
        startQaButton.click();
        return this;
    }

    @Step("Нажать на кнопку «Бегу оплачивать»")
    public PaymentPage clickPaymentButton() {
        paymentButton.click();
        return new PaymentPage();
    }
}
