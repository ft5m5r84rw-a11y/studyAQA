package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class WsCatalogPage {
    private final ElementsCollection topMenu = $$("ul.top-menu li a");
    private final SelenideElement desktopsButton = $("a[href='/desktops']");
    private final ElementsCollection products = $$("div.product-grid h2 a");

    public WsCatalogPage hoverComputers() {
        topMenu.get(1).hover();
        return this;

    }  public WsCatalogPage openDesktops() {
        desktopsButton.click();
        return this;

    }
    public WsProductPage openFirstProduct() {
        products.get(0).click();
        return new WsProductPage();

    }
}
