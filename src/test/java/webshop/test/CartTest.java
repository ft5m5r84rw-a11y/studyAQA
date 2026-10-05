package webshop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.WsCartPage;
import webshop.pages.WsProductPage;
import webshop.pages.WsWelcomePage;
import webshop.steps.AuthSteps;

import java.util.Locale;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static webshop.config.Config.WEB_SHOP_URL;

public class CartTest extends TestBase {

    private final AuthSteps authSteps = new AuthSteps();
    private static final String PRODUCT_NAME = "Build your own cheap computer";

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

    @Test
    void addItemToCartTest() {
        String processor = "Fast";
        String itemQuantity = "2";
        WsProductPage productPage = open(WEB_SHOP_URL, WsWelcomePage.class) //страница товара сохранена в переменную
                .hoverComputers()
                .openDesktops()
                .openProduct(PRODUCT_NAME);
        String itemPrice = productPage.getItemPrice(); //получаем с этой страницы цену товара
        float expectedUnitPrice = Float.parseFloat(itemPrice) + processorSurcharge(processor); //считает ожидаемую цену одной единицы товара с учётом выбранного процессора

        WsCartPage cartPage = productPage
                .selectProcessor(processor)
                .setQuantity(itemQuantity)
                .addToCart()
                .checkSuccessMessage()
                .checkCartQuantity(itemQuantity)
                .openCart();
        String expectedUnitPriceText = String.format(Locale.US, "%.2f", expectedUnitPrice);
        String expectedSubtotalText = String.format(Locale.US, "%.2f", expectedUnitPrice * Float.parseFloat(itemQuantity));

        assertAll(
                () -> assertEquals(PRODUCT_NAME, cartPage.getItemName()), //(ожидаемое и фактическое)
                () -> assertEquals(itemQuantity, cartPage.getQuantity()),
                () -> assertEquals(expectedUnitPriceText, cartPage.getUnitPrice()),
                () -> assertEquals(expectedSubtotalText, cartPage.getSubtotal())
        );
    }

    private float processorSurcharge(String processor) {
        return switch (processor) {
            case "Slow" -> 0f;
            case "Medium" -> 15f;
            case "Fast" -> 100f;
            default -> throw new IllegalArgumentException("Unknown processor: " + processor);
        };

    }
}



