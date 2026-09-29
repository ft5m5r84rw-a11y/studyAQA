package webshop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.Steps.AuthSteps;
import webshop.pages.WsCatalogPage;

public class CartTest extends TestBase {

    private final AuthSteps authSteps = new AuthSteps();

    @BeforeEach
    void beforeEach() {
        authSteps.registerNewUser();
    }

        @Test
        void addItemToCartTest () {
            String itemQuantity = "2";
            new WsCatalogPage()
                    .hoverComputers()
                    .openDesktops()
                    .openFirstProduct()
                    .selectProcessor(0)
                    .setQuantity(itemQuantity)
                    .addToCart()
                    .checkSuccessMessage()
                    .checkCartQuantity(itemQuantity)
                    .saveProductInfo()
                    .openCart()
                    .checkProductName()
                    .checkProductSubtotal(itemQuantity)
                    .checkQuantity(itemQuantity);



        }
    }


