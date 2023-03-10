package com.solvd.carina.demo.utils;

import com.solvd.carina.demo.swaglabs.pages.CartPage;
import com.solvd.carina.demo.swaglabs.pages.ProductsPage;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public final class SwagLabsCartPageUtils implements ICustomTypePageFactory {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private static final SwagLabsLoginUtils LOGIN_UTILS = new SwagLabsLoginUtils();

    public CartPage getCartPage() {
        return getCartPageWithProduct(null);
    }

    /**
     * @param productName - name of product to add to cart, if null don't add any product
     * @return CartPage with product
     */
    public CartPage getCartPageWithProduct(String productName) {
        LOGGER.info("Open cart page with product: {}", productName);
        ProductsPage productsPage = LOGIN_UTILS.login();
        if (productName != null) {
            productsPage.addItemToCart(productName);
        }
        return productsPage.openCart();
    }
}
