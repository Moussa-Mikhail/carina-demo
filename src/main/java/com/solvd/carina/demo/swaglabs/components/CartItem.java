package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartItem extends AbstractUIObject {
    @FindBy(id = "remove-sauce-labs-backpack")
    private ExtendedWebElement removeButton;

    public CartItem(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }


}
