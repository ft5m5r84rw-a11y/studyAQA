package webshop.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.Steps.AuthSteps;
import webshop.pages.WsCatalogPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class CartTest {

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


