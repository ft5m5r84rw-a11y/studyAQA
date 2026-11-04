package webshop.pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$$;

public class WsCatalogPage extends BasePage {
    private final ElementsCollection products = $$("div.product-grid h2 a");

    @Step("Открыть страницу товара «{name}»")
    public WsProductPage openProduct(String name) {
        products.findBy(exactText(name)).click();
        return new WsProductPage();

    }
}
