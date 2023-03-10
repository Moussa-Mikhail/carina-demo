package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class ProductsPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//span[text()='Products']")
    private ExtendedWebElement productsBanner;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement shoppingCartLink;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productsBanner);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void addItemToCart(String productName) {
        LOGGER.info("Adding product to cart: {}", productName);
        String addToCartButtonXpathFormat = "//div[@class='inventory_item']/*[descendant::div[text()='%s']]//button";
        String addToCartButtonXpath = String.format(addToCartButtonXpathFormat, productName);
        ExtendedWebElement addToCartButton = findExtendedWebElement(By.xpath(addToCartButtonXpath));
        addToCartButton.click();
    }

    public CartPage openCart() {
        LOGGER.info("Opening cart");
        shoppingCartLink.click();
        return new CartPage(driver);
    }
}
