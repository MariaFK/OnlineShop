package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainStorePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(MainStorePage.class.getName());

    @FindBy(xpath = "//a[@class='login']")
    WebElement SIGN_IN_LINK;

    @FindBy(xpath = "(//a[contains(@class,'product-name')][contains(@title,'Blouse')])[1]")
    WebElement BLOUSE_BLOCK;

    @FindBy(xpath = "(//a[contains(@class,'product-name')][contains(@title,'Blouse')])[1]/parent::h5/following-sibling::div[@class='button-container']//a[@title='Add to cart']")
    WebElement ADD_BLOUSE_TO_CART;

//    @FindBy(xpath = "//div[@class='shopping_cart']//span[@class='ajax_cart_quantity']")
//    WebElement ITEM_QUANTITY_IN_SHOPPING_CART;

    @FindBy(xpath = "//i[@class='icon-ok']")
    WebElement CONFIRM_MESSAGE;

    @FindBy(xpath = "//div[@class='button-container']//span[contains(@class,'continue')]")
    WebElement CONTINUE_SHOPPING_BUTTON;

    @FindBy(xpath = "//div[@class='shopping_cart']//a[@title='View my shopping cart']")
    WebElement SHOPPING_CART_BUTTON;

    @FindBy(xpath = "//span[@class='remove_link']//a[@rel='nofollow']")
    WebElement DELETE_ITEM_FROM_SHOPPING_CART_BUTTON;

    public MainStorePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open sign in page")
    public SignInPage openSignInPage() {
        LOGGER.debug(String.format("Attempt to open URl: %s", Urls.SHOP_URL));
        driver.get(Urls.SHOP_URL);
        LOGGER.debug("Attempt to open sign in page");
        SIGN_IN_LINK.click();
        return new SignInPage(driver);
    }

    @Step("Add item to the shopping cart")
    public MainStorePage addItemToCart() {
        LOGGER.debug(String.format("Attempt to open URl: %s", Urls.SHOP_URL));
        driver.get(Urls.SHOP_URL);
        LOGGER.debug("Attempt to add item to the shopping cart");
        String javaScript = "var evObj = document.createEvent('MouseEvents');" +
                "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
                "arguments[0].dispatchEvent(evObj);";
        ((JavascriptExecutor)driver).executeScript(javaScript, ADD_BLOUSE_TO_CART);
        ADD_BLOUSE_TO_CART.click();
        return this;
    }

    public void putExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(CONFIRM_MESSAGE));
    }

    public boolean itemIsAdded() {
        return CONFIRM_MESSAGE.isDisplayed();
    }

    @Step("Click Continue Shopping button")
    public MainStorePage clickContinueShoppingButton() {
        LOGGER.debug("Attempt to click Continue Shopping button");
        CONTINUE_SHOPPING_BUTTON.click();
        return this;
    }

    @Step("Click Shopping Cart button")
    public ShoppingCartPage clickShoppingCartButton(){
        LOGGER.debug("Attempt to click Shopping cart button");
        SHOPPING_CART_BUTTON.click();
        return new ShoppingCartPage(driver);
    }
}
