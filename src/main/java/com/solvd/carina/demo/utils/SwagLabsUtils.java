package com.solvd.carina.demo.utils;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.swaglabs.pages.CartPage;
import com.solvd.carina.demo.swaglabs.pages.LoginPage;
import com.solvd.carina.demo.swaglabs.pages.ProductsPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.lang.invoke.MethodHandles;

public final class SwagLabsUtils implements ICustomTypePageFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public CartPage cartPage() {
        LOGGER.info("Open cart page");
        ProductsPage productsPage = login();
        return productsPage.openCart();
    }

    public CartPage cartPageWithProduct(String productName) {
        LOGGER.info("Open cart page with product: {}", productName);
        ProductsPage productsPage = login();
        productsPage.addItemToCart(productName);
        return productsPage.openCart();
    }

    public ProductsPage login() {
        LOGGER.info("Login to SwagLabs with standard user");
        LoginPage loginPage = new LoginPage(getDriver());
        loginPage.open();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened");
        String username = R.TESTDATA.get("username_");
        String password = R.TESTDATA.get("password");
        return loginPage.login(username, password);
    }
}
