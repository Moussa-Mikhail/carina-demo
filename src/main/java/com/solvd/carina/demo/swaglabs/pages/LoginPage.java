package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class LoginPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(id = "user-name")
    private ExtendedWebElement usernameField;
    @FindBy(id = "password")
    private ExtendedWebElement passwordField;
    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(loginButton);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public ProductsPage login(String username, String password) {
        LOGGER.info("logging in with username: {}, password: {}", username, password);
        enterUsername(username);
        enterPassword(password);
        return clickLoginButton();
    }

    public ProductsPage clickLoginButton() {
        loginButton.click();
        return new ProductsPage(driver);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    public void enterUsername(String username) {
        usernameField.type(username);
    }
}
