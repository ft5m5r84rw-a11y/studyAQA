package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsProductPage {
    private final ElementsCollection processors = $$("dl dd ul").get(0).$$("li input");
    private final ElementsCollection processorLabels = $$("dl dd ul").get(0).$$("li label");
    private final SelenideElement quantity = $("input.qty-input");
    private final SelenideElement addButton = $("input.add-to-cart-button");
    private final SelenideElement successMessage = $("div.bar-notification.success");
    private final SelenideElement cartQuantity = $("span.cart-qty");
    private final SelenideElement cart = $("a.ico-cart");
    private final SelenideElement productName = $("[itemprop=name]");
    private final SelenideElement productPrice = $("[itemprop=price]");

    private String itemName;
    private String itemPrice;
    private float processorPrice;

    public WsProductPage selectProcessor(int index) {
        processors.get(index).click();

        if (index == 0) {
            processorPrice = 0;
        }

        if (index == 1) {
            processorPrice = 15;
        }

        if (index == 2) {
            processorPrice = 100;
        }

        return this;
    }
    public WsProductPage saveProductInfo() {
        itemName = productName.getText();
        itemPrice = String.valueOf(
                Float.parseFloat(productPrice.getText()) + processorPrice);
        return this;
    }

    /*Что тут происходит, по частям:
            productPrice.getText()
    получили "1200.00" как текст.
            Float.parseFloat(productPrice.getText())
    превратили текст "1200.00" в число 1200.
    Дальше:
            + processorPrice
    прибавили наши 15.
    Получили:
            1215
    И String.valueOf(...) снова превращает результат в текст, потому что itemPrice у тебя объявлен как:
    private String itemPrice;*/

    public WsProductPage setQuantity(String itemQuantity) {
        quantity.setValue(itemQuantity);
        return this;

    }

    public WsProductPage addToCart() {
        addButton.click();
        return this;

    }

    public WsProductPage checkSuccessMessage() {
        successMessage.shouldBe(visible);
        return this;

    }

    public WsProductPage checkCartQuantity(String itemQuantity) {
        cartQuantity.shouldHave(text("(" + itemQuantity + ")"));
        return this;

    }

    public WsCartPage openCart() {
        cart.click();
        return new WsCartPage(itemName, itemPrice);
    }


}
