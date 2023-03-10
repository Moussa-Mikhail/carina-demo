package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.solvd.carina.demo.swaglabs.components.CartList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CartPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//span[text()='Your Cart']")
    private ExtendedWebElement banner;
    @FindBy(xpath = "//button[@name='continue-shopping']")
    private ExtendedWebElement continueShoppingButton;
    @FindBy(xpath = "//div[@class='cart_list']")
    private CartList cartItems;
    @FindBy(xpath = "//button[@name='checkout']")
    private ExtendedWebElement checkoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public boolean isItemInCart(String productName) {
        return cartItems.isItemInCart(productName);
    }

    public void removeItemFromCart(String productName) {
        cartItems.removeItemFromCart(productName);
    }

    public ProductsPage clickContinueShoppingButton() {
        LOGGER.info("Clicking continue shopping button");
        continueShoppingButton.click();
        return new ProductsPage(driver);
    }

    public CheckoutYourInformationPage clickCheckoutButton() {
        LOGGER.info("Clicking checkout button");
        checkoutButton.click();
        return new CheckoutYourInformationPage(driver);
    }
}
