package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BasePage {

    private final ElementsCollection topMenu = $$("ul.top-menu li a");
    private final SelenideElement desktopsButton = $("a[href='/desktops']");
    private final SelenideElement cartQuantity = $("span.cart-qty");
    private final SelenideElement cart = $("a.ico-cart");

    public BasePage hoverComputers() {
        topMenu.get(1).hover();
        return this;
    }

    public WsCatalogPage openDesktops() {
        desktopsButton.click();
        return new WsCatalogPage();
    }

    public BasePage checkCartQuantity(String itemQuantity) {
        cartQuantity.shouldHave(exactText("(" + itemQuantity + ")"));
        return this;
    }

    public WsCartPage openCart() {
        cart.click();
        return new WsCartPage();
    }
}
