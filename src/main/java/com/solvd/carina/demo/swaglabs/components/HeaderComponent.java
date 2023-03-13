package com.solvd.carina.demo.swaglabs.components;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HeaderComponent extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "shopping_cart_container")
    private ExtendedWebElement cartButton;

    public HeaderComponent(WebDriver driver, SearchContext sc) {
        super(driver, sc);
    }

    public void clickCartButton() {
        LOGGER.info("Clicking cart button");
        cartButton.click();
    }
}
