package ru.bulgakov.qa.first_sprint.pages.ya;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentPage extends BasePage {
    private final ElementsCollection price = $$("[data-at='H3']");
    private final SelenideElement pageTitle = $("h1[data-at='H1'] span");

    @Step("Переключиться на окно оплаты")
    public PaymentPage switchToPaymentWindow(int index) {
        switchToWindow(index);
        return this;
    }

    @Step("Проверить заголовок страницы: {expectedTitle}")
    public PaymentPage checkPageTitle(String expectedTitle) {
        pageTitle.shouldHave(exactText(expectedTitle), Duration.ofSeconds(15));
        return this;
    }

    @Step("Проверить стоимость: {expectedPrice}")
    public PaymentPage checkPriceAmout(String expectedPrice) {
        price.get(0).shouldHave(text(expectedPrice));
        return this;
    }

}
