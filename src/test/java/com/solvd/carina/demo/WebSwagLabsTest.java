package com.solvd.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.solvd.carina.demo.swaglabs.pages.*;
import com.solvd.carina.demo.utils.SwagLabsCartPageUtils;
import com.solvd.carina.demo.utils.SwagLabsLoginUtils;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebSwagLabsTest implements IAbstractTest {
    public static final String PRODUCT_NAME = "Sauce Labs Backpack";
    private static final SwagLabsLoginUtils LOGIN_UTILS = new SwagLabsLoginUtils();
    private static final SwagLabsCartPageUtils CART_UTILS = new SwagLabsCartPageUtils();

    @Test(priority = 0)
    @MethodOwner(owner = "qpsdemo")
    public void testLogin() {
        ProductsPage productsPage = LOGIN_UTILS.login();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened");
    }

    @Test(priority = 1)
    @MethodOwner(owner = "qpsdemo")
    public void testContinueShopping() {
        CartPage cartPage = CART_UTILS.getCartPage();
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        ProductsPage productsPage = cartPage.clickContinueShoppingButton();
        Assert.assertTrue(productsPage.isPageOpened(), "Products page is not opened");
    }

    @Test(priority = 1)
    @MethodOwner(owner = "qpsdemo")
    public void testAddItemToCart() {
        CartPage cartPage = CART_UTILS.getCartPageWithProduct(PRODUCT_NAME);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        Assert.assertTrue(cartPage.isItemInCart(PRODUCT_NAME), "Item was not added to cart");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "qpsdemo")
    public void testRemoveItemFromCart() {
        CartPage cartPage = CART_UTILS.getCartPageWithProduct(PRODUCT_NAME);
        Assert.assertTrue(cartPage.isPageOpened(), "Cart page is not opened");
        cartPage.removeItemFromCart(PRODUCT_NAME);
        Assert.assertFalse(cartPage.isItemInCart(PRODUCT_NAME), "Item was not removed from cart");
    }

    @Test(priority = 2)
    @MethodOwner(owner = "qpsdemo")
    public void testCheckout() {
        CartPage cartPage = CART_UTILS.getCartPageWithProduct(PRODUCT_NAME);

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
