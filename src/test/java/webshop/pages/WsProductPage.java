package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

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


    public WsProductPage selectProcessor(String processor) {
        attributeOptions("Processor")
                .findBy(text(processor))
                .$("input")
                .click();
        return this;
    }


    public WsProductPage setQuantity(String itemQuantity) {
        quantity.setValue(itemQuantity);
        return this;

    }

    public WsProductPage addToCart() {
        addButton.click();
        return this;

    }

    public WsProductPage checkSuccessMessage() {
        successMessage.shouldBe(visible).shouldHave(text("The product has been added to your shopping cart"));
        return this;
    }

}
