package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class WsProductPage extends BasePage {
    private final SelenideElement quantity = $("input.qty-input");
    private final SelenideElement addButton = $("input.add-to-cart-button");
    private final SelenideElement successMessage = $("div.bar-notification.success");
    private final SelenideElement productPrice = $("[itemprop=price]");
    private final SelenideElement attributes = $("div.attributes");

    private ElementsCollection attributeOptions(String groupTitle) {
        return attributes.$$("dl dt")
                .findBy(text(groupTitle))
                .sibling(0)
                .$$("li");
    }


    public String getItemPrice() {
        return productPrice.getText();
    }

    @Step("Выбрать процессор «{processor}»")
    public WsProductPage selectProcessor(String processor) {
        attributeOptions("Processor")
                .findBy(text(processor))
                .$("input")
                .click();
        return this;
    }

    @Step("Установить количество товара: {itemQuantity}")
    public WsProductPage setQuantity(String itemQuantity) {
        quantity.setValue(itemQuantity);
        return this;

    }

    @Step("Добавить товар в корзину")
    public WsProductPage addToCart() {
        addButton.click();
        return this;

    }

    @Step("Проверить сообщение об успешном добавлении товара в корзину")
    public WsProductPage checkSuccessMessage() {
        successMessage.shouldBe(visible).shouldHave(text("The product has been added to your shopping cart"));
        return this;
    }

}
