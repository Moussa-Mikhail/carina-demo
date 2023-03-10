package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutCompletePage extends AbstractPage  {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Checkout: Complete!']")
    private ExtendedWebElement banner;

    @FindBy(xpath = "//button[@name='back-to-products']")
    private ExtendedWebElement backHomeButton;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public ProductsPage clickBackHomeButton() {
        LOGGER.info("Clicking back home button");
        backHomeButton.click();
        return new ProductsPage(driver);
    }
}
