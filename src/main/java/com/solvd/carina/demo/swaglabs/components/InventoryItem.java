package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryItem extends AbstractUIObject {
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = "//button[text()='Add to cart']")
    private ExtendedWebElement addToCartButton;

    public InventoryItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}
