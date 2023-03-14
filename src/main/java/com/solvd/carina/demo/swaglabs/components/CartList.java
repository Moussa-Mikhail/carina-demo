package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class CartList extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='cart_item']")
    private List<CartItem> cartItems;

    public CartList(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public boolean isItemInCart(String productName) {
        LOGGER.info("Checking if {} is in cart", productName);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProductName().equals(productName)) {
                LOGGER.info("{} is in cart", productName);
                return true;
            }
        }

        LOGGER.info("{} is not in cart", productName);
        return false;
    }

    public void removeItemFromCart(String productName) {
        LOGGER.info("Removing {} from cart", productName);
        for (CartItem cartItem : cartItems) {
            if (cartItem.getProductName().equals(productName)) {
                cartItem.clickRemoveButton();
                return;
            }
        }

        LOGGER.info("{} was not in cart", productName);
    }
}
