package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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

    public WelcomePage clickMenu() {
        navigatiorMenu.last().click();
        return this;
    }

    public WelcomePage clickStartQaButton() {
        startQaButton.click();
        return this;
    }

    public PaymentPage clickPaymentButton() {
        paymentButton.click();
        return new PaymentPage();
    }
}
