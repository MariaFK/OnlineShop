package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ShoppingCartPage.class.getName());

    @FindBy(xpath = "//a[@title='Delete']")
    WebElement DELETE_ITEM_FROM_THE_SHOPPING_CART_BUTTON;

    @FindBy(xpath = "//div[@id='center_column']//p[contains(@class,'alert-warning')]")
    WebElement INFORMATION_MESSAGE_ABOUT_CART_STATUS;

    @FindBy(xpath = "//p//a[@title='Proceed to checkout']")
    WebElement PROCEED_TO_CHECKOUT_ADDRESS_BUTTON;

    @FindBy(xpath = "//button[@name='processAddress']")
    WebElement PROCEED_TO_CHECKOUT_SHIPPING_BUTTON;

    @FindBy(xpath = "//input[@type='checkbox']")
    WebElement AGREEMENT_TO_TERMS_OF_SERVICE_INPUT;

    @FindBy(xpath = "//button[@name='processCarrier']")
    WebElement PROCEED_TO_CHECKOUT_PAYMENT_BUTTON;

    @FindBy(xpath = "//a[@class='bankwire']")
    WebElement PAY_BY_BANK_WIRE_BUTTON;

    @FindBy(xpath = "//p[@id='cart_navigation']//button[@type='submit']")
    WebElement CONFIRM_ODER_BUTTON;

    @FindBy(xpath = "//p[@class='cheque-indent']//strong")
    WebElement CONFIRMATION_MESSAGE;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Delete the item from the shopping cart")
    public void deleteItemFromTheCart() {
        LOGGER.debug("Attempt to delete the item from the shopping cart");
        DELETE_ITEM_FROM_THE_SHOPPING_CART_BUTTON.click();
    }

    public void putExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(INFORMATION_MESSAGE_ABOUT_CART_STATUS));
    }

    public String informationMessage() {
        return INFORMATION_MESSAGE_ABOUT_CART_STATUS.getText();
    }

    public String expectedMessageAboutCartStatus() {
        return "Your shopping cart is empty.";
    }

    @Step("Confirm oder")
    public void confirmOder(){
        LOGGER.debug("Attempt to checkout summary");
        PROCEED_TO_CHECKOUT_ADDRESS_BUTTON.click();
        LOGGER.debug("Attempt to checkout address");
        PROCEED_TO_CHECKOUT_SHIPPING_BUTTON.click();
        LOGGER.debug("Attempt to agree to the terms of service");
        AGREEMENT_TO_TERMS_OF_SERVICE_INPUT.click();
        LOGGER.debug("Attempt to checkout shipping");
        PROCEED_TO_CHECKOUT_PAYMENT_BUTTON.click();
        LOGGER.debug("Attempt to choose payment by bank wire");
        PAY_BY_BANK_WIRE_BUTTON.click();
        LOGGER.debug("Attempt to confirm oder");
        CONFIRM_ODER_BUTTON.click();
    }
    public boolean isConfirmationMessageDisplayed(){
        return CONFIRMATION_MESSAGE.isDisplayed();
    }

}
