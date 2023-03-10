package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartList extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public CartList(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public boolean isItemInCart(String productName) {
        LOGGER.info("Checking if {} is in cart", productName);
        String cartItemNameXpathFormat = "//div[@class='inventory_item_name' and text()='%s']";
        String cartItemNameXpath = String.format(cartItemNameXpathFormat, productName);
        ExtendedWebElement cartItemName = findExtendedWebElement(By.xpath(cartItemNameXpath));
        if (cartItemName != null && cartItemName.isPresent()) {
            LOGGER.info("{} is in cart", productName);
            return true;
        }

        LOGGER.info("{} is not in cart", productName);
        return false;
    }

    public void removeItemFromCart(String productName) {
        LOGGER.info("Removing {} from cart", productName);
        String cartItemRemoveButtonXpathFormat = "//div[@class='cart_item']/*[descendant::div[text()='%s']]//button[text()='Remove']";
        String cartItemRemoveButtonXpath = String.format(cartItemRemoveButtonXpathFormat, productName);
        ExtendedWebElement cartItemRemoveButton = findExtendedWebElement(By.xpath(cartItemRemoveButtonXpath));
        if (cartItemRemoveButton != null && cartItemRemoveButton.isPresent()) {
            LOGGER.info("Clicking remove button for {}", productName);
            cartItemRemoveButton.click();
        } else {
            LOGGER.info("Remove button for {} is not present", productName);
        }
    }

//    public CartItem getCartItem(String productName) {
//        LOGGER.info("Getting cart item for {}", productName);
//        String cartItemXpathFormat = "//div[@class='cart_item']/*[descendant::div[text()='%s']]";
//        String cartItemXpath = String.format(cartItemXpathFormat, productName);
//        ExtendedWebElement cartItem = findExtendedWebElement(By.xpath(cartItemXpath));
//        if (cartItem != null && cartItem.isPresent()) {
//            LOGGER.info("Cart item for {} is present", productName);
//            return (CartItem) cartItem;
//        } else {
//            LOGGER.info("Cart item for {} is not present", productName);
//            return null;
//        }
//    }
}
