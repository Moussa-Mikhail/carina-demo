package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.swaglabs.pages.*;
import com.solvd.carina.demo.utils.SwagLabsUtils;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebSwagLabsTest implements IAbstractTest {
    public static final String PRODUCT_NAME = "Sauce Labs Backpack";
    private static final SwagLabsUtils swagLabsUtils = new SwagLabsUtils();

    @Test(priority = 0)
    @MethodOwner(owner = "qpsdemo")
    public void testLogin() {
        ProductsPage productsPage = swagLabsUtils.login();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened");
    }

    @Test(priority = 1)
    @MethodOwner(owner = "qpsdemo")
    public void testContinueShopping() {
        CartPage cartPage = swagLabsUtils.cartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        ProductsPage productsPage = cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened");
    }

    @Test(priority = 1)
    @MethodOwner(owner = "qpsdemo")
    public void testAddItemToCart() {
        CartPage cartPage = swagLabsUtils.cartPageWithProduct(PRODUCT_NAME);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isItemInCart(PRODUCT_NAME), "Item was not added to cart");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "qpsdemo")
    public void testRemoveItemFromCart() {
        CartPage cartPage = swagLabsUtils.cartPageWithProduct(PRODUCT_NAME);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        cartPage.removeItemFromCart(PRODUCT_NAME);
        Assert.assertFalse(cartPage.isItemInCart(PRODUCT_NAME), "Item was not removed from cart");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "qpsdemo")
    public void testCheckout() {
        CartPage cartPage = swagLabsUtils.cartPageWithProduct(PRODUCT_NAME);

        CheckoutYourInformationPage checkoutYourInformationPage = cartPage.clickCheckoutButton();
        Assert.assertTrue(checkoutYourInformationPage.isPageOpened(), "Checkout Your Information page is not opened");
        checkoutYourInformationPage.enterInformation("Bob", "Jones", "12345");

        CheckoutOverviewPage checkoutOverviewPage = checkoutYourInformationPage.clickContinueButton();
        Assert.assertTrue(checkoutOverviewPage.isPageOpened(), "Checkout Overview page is not opened");
        Assert.assertTrue(checkoutOverviewPage.isItemInCart(PRODUCT_NAME), "Item was not added to cart");

        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isPageOpened(), "Checkout Complete page is not opened");

        ProductsPage productsPage = checkoutCompletePage.clickBackHomeButton();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened");
    }
}
