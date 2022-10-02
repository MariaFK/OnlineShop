package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ShoppingCartPage.class.getName());

    @FindBy(xpath = "//a[@title='Delete']")
    WebElement DELETE_ITEM_FROM_THE_SHOPPING_CART_BUTTON;

    @FindBy(xpath = "//div[@id='center_column']//p[contains(@class,'alert-warning')]")
    WebElement INFORMATION_MESSAGE_ABOUT_CART_STATUS;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Delete the item from the shopping cart")
    public void deleteItemFromTheCart() {
        LOGGER.debug("Attempt to delete the item from the shopping cart");
        DELETE_ITEM_FROM_THE_SHOPPING_CART_BUTTON.click();
    }

    public void putExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(INFORMATION_MESSAGE_ABOUT_CART_STATUS));
    }

    public String informationMessage() {
        return INFORMATION_MESSAGE_ABOUT_CART_STATUS.getText();
    }

    public String expectedMessageAboutCartStatus() {
        return "Your shopping cart is empty.";
    }

}
