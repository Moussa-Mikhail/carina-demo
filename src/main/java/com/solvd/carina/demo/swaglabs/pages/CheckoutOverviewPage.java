package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.carina.demo.swaglabs.components.CartList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutOverviewPage extends SwagLabsAbstractBasePage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Checkout: Overview']")
    private ExtendedWebElement banner;

    @FindBy(xpath = "//button[@name='finish']")
    private ExtendedWebElement finishButton;

    @FindBy(xpath = "//div[@class='cart_list']")
    private CartList cartItems;

    public CheckoutOverviewPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public boolean isItemInCart(String productName) {
        return cartItems.isItemInCart(productName);
    }

    public CheckoutCompletePage clickFinishButton() {
        LOGGER.info("Clicking finish button");
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }
}
