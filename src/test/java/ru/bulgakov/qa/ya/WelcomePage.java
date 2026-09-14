package ru.bulgakov.qa.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class WelcomePage {
    private final ElementsCollection navigatiorMenu = $$(".t-menu__list li");
    private final SelenideElement startQaButton = $x("/html/body/div[1]/div[42]/div/div/div[32]/div/a/div");
    private final SelenideElement paymentButton = $(byText("Бегу оплачивать"));

    public WelcomePage clickMenu() {
        sleep(3000);
        switchTo().window(1);
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
