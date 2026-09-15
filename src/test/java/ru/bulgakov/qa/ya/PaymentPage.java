package ru.bulgakov.qa.ya;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PaymentPage {
    private final ElementsCollection price = $$("[data-at='H3']");

    public PaymentPage verifiedPrice(String expectedPrice) {
        switchTo().window(2);
        price.get(0).shouldHave(text(expectedPrice));
        return this;
    }


}
