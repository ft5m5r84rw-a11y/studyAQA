package webshop.pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class WsCatalogPage extends BasePage {
    private final ElementsCollection products = $$("div.product-grid h2 a");

    public WsProductPage openProduct(String name) {
        products.findBy(exactText(name)).click();
        return new WsProductPage();

    }
}
