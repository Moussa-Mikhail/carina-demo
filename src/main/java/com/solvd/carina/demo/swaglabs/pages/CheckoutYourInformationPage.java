package com.solvd.carina.demo.swaglabs.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class CheckoutYourInformationPage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(xpath = "//span[text()='Checkout: Your Information']")
    private ExtendedWebElement banner;
    @FindBy(xpath = "//input[@name='continue']")
    private ExtendedWebElement continueButton;
    @FindBy(id = "first-name")
    private ExtendedWebElement firstNameField;
    @FindBy(id = "last-name")
    private ExtendedWebElement lastNameField;
    @FindBy(id = "postal-code")
    private ExtendedWebElement postalCodeField;

    public CheckoutYourInformationPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(banner);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
    }

    public void enterInformation(String firstName, String lastName, String postalCode) {
        LOGGER.info("Entering information: ");
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostalCode(postalCode);
    }

    public void enterFirstName(String firstName) {
        LOGGER.info("Entering first name: {}", firstName);
        firstNameField.type(firstName);
    }

    public void enterLastName(String lastName) {
        LOGGER.info("Entering last name: {}", lastName);
        lastNameField.type(lastName);
    }

    public void enterPostalCode(String postalCode) {
        LOGGER.info("Entering postal code: {}", postalCode);
        postalCodeField.type(postalCode);
    }

    public CheckoutOverviewPage clickContinueButton() {
        LOGGER.info("Clicking continue button");
        continueButton.click();
        return new CheckoutOverviewPage(driver);
    }
}
