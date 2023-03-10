package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {
    @FindBy(id = "remove-sauce-labs-backpack")
    private ExtendedWebElement removeButton;
    @FindBy(xpath = "//div[@class='inventory_item_name']")
    private ExtendedWebElement productName;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getProductName() {
        return productName.getText();
    }

    public void clickRemoveButton() {
        removeButton.click();
    }
}
