package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.solvd.carina.demo.swaglabs.components.InventoryList;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends SwagLabsAbstractBasePage {
    @FindBy(xpath = "//span[text()='Products']")
    private ExtendedWebElement productsBanner;

    @FindBy(xpath = "//div[@class='inventory_list']")
    private InventoryList inventoryList;

    public ProductsPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(productsBanner);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void addItemToCart(String productName) {
        inventoryList.addItemToCart(productName);
    }
}
