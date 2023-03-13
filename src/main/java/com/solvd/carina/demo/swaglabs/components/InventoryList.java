package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class InventoryList extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='inventory_item']")
    private List<InventoryItem> inventoryItems;

    public InventoryList(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public void addItemToCart(String productName) {
        LOGGER.info("Adding product to cart: {}", productName);
        for (InventoryItem item : inventoryItems) {
            if (item.getProductName().equals(productName)) {
                item.clickAddToCartButton();
                break;
            }
        }
    }
}
