package webshop.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class WsCartPage extends BasePage {

    private final SelenideElement productName = $("a.product-name");
    private final SelenideElement productSubtotal = $("span.product-subtotal");
    private final SelenideElement quantity = $("input.qty-input");
    private final SelenideElement productUnitPrice = $(".product-unit-price");

    //WsCartPage: теперь он только находит элементы корзины и возвращает фактические значения
    public String getItemName() {
        return productName.getText();
    }

    public String getSubtotal() {
        return productSubtotal.getText();
    }

    public String getQuantity() {
        return quantity.getValue();
    }

    public String getUnitPrice() {
        return productUnitPrice.getText();
    }
}
