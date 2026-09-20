package webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WsCartPage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement productSubtotal = $("span.product-subtotal");
    private final SelenideElement quantity = $("input.qty-input");

    private final String itemName;
    private final String itemPrice;

    public WsCartPage(String itemName, String itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    public WsCartPage checkProductName() {
        productName.shouldHave(text(itemName));
        return this;
    }

    public WsCartPage checkProductSubtotal(String itemQuantity) {
        productSubtotal.shouldHave(text(String.valueOf(
                Float.parseFloat(itemPrice) * Float.parseFloat(itemQuantity))));
        return this;
    }

    public WsCartPage checkQuantity(String itemQuantity) {
        String itemQuantityInCart = quantity.getAttribute("value");
        assertEquals(itemQuantity, itemQuantityInCart);
        return this;
    }
}

/*
Смысл очень простой:
        new WsCartPage(itemName, itemPrice)
передаёт название и цену →
public WsCartPage(String itemName, String itemPrice)
их принимает →
        this.itemName = itemName;
this.itemPrice = itemPrice;
сохраняет их внутри WsCartPage.*/
