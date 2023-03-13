package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.swaglabs.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public abstract class SwagLabsAbstractBasePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[@class='header_container']")
    private HeaderComponent headerComponent;

    protected SwagLabsAbstractBasePage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickCartButton() {
        LOGGER.info("Clicking cart button");
        headerComponent.clickCartButton();
        return new CartPage(driver);
    }
}
