package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage extends BasePage {
    private final ElementsCollection price = $$("[data-at='H3']");
    private final SelenideElement pageTitle = $("[data-at='H1']");

    public PaymentPage switchToPaymentWindow(int index) {
        switchToWindow(index);
        return this;
    }

    public PaymentPage checkPageTitle(String expectedTitle) {
        pageTitle.shouldHave(text(expectedTitle));
        return this;
    }

    public PaymentPage checkPriceAmout(String expectedPrice) {
        price.get(0).shouldHave(text(expectedPrice));
        return this;
    }

}
