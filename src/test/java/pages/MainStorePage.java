package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainStorePage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(MainStorePage.class.getName());

    @FindBy(xpath = "//a[@class='login']")
    WebElement SIGN_IN_LINK;

    @FindBy(xpath = "(//a[contains(@class,'product-name')][contains(@title,'Blouse')])[1]/parent::h5/following-sibling::div[@class='button-container']//a[@title='Add to cart']")
    WebElement ADD_BLOUSE_TO_CART;

    @FindBy(xpath = "//i[@class='icon-ok']")
    WebElement CONFIRM_MESSAGE;

    @FindBy(xpath = "//div[@class='button-container']//span[@title='Continue shopping']")
    WebElement CONTINUE_SHOPPING_BUTTON;

    @FindBy(xpath = "//div[@class='button-container']//a[@title='Proceed to checkout']")
    WebElement PROCEED_TO_CHECKOUT_BUTTON;

    @FindBy(xpath = "//div[@class='shopping_cart']//a[@title='View my shopping cart']")
    WebElement SHOPPING_CART_BUTTON;


    @FindBy(xpath = "//div[@class='shopping_cart']//span[@class='price']")
    WebElement ITEM_PRICE_IN_SHOPPING_CART;

    @FindBy(xpath = "(//a[contains(@class,'product-name')][contains(@title,'Blouse')])[1]/parent::h5/following-sibling::div[@class='content_price']//span[contains(@class,'price')]")
    WebElement ITEM_PRICE_IN_THE_SHOP;

    @FindBy(id = "search_query_top")
    WebElement SEARCH_INPUT;

    @FindBy(name = "submit_search")
    WebElement SEARCH_BY_NAME_BUTTON;

    @FindBy(xpath = "//a[@title='Women']")
    WebElement CRITERIA_SEARCH_BUTTON;

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
        hoverTheElement(ADD_BLOUSE_TO_CART);
        ADD_BLOUSE_TO_CART.click();
        return this;
    }

    public MainStorePage putExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(CONFIRM_MESSAGE));
        return this;
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

    @Step("Click Proceed to Checkout button")
    public MainStorePage clickProceedToCheckoutButton() {
        LOGGER.debug("Attempt to clickProceed to Checkout button");
        PROCEED_TO_CHECKOUT_BUTTON.click();
        return this;
    }

    @Step("Click Shopping Cart button")
    public ShoppingCartPage clickShoppingCartButton() {
        LOGGER.debug("Attempt to click Shopping cart button");
        SHOPPING_CART_BUTTON.click();
        return new ShoppingCartPage(driver);
    }

    @Step("Check the item's price in the shopping cart")
    public String actualItemPriceInTheShoppingCart() {
        LOGGER.debug("Get the item's price the shopping cart");
        hoverTheElement(SHOPPING_CART_BUTTON);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(ITEM_PRICE_IN_SHOPPING_CART));
        return ITEM_PRICE_IN_SHOPPING_CART.getText();
    }

    public String expectedItemPrice() {
        LOGGER.debug("Get the item's price the shop");
        return ITEM_PRICE_IN_THE_SHOP.getText();
    }

    @Step("Search for item by name")
    public SearchResultPage searchItemByName() {
        LOGGER.debug(String.format("Attempt to open URl: %s", Urls.SHOP_URL));
        driver.get(Urls.SHOP_URL);
        LOGGER.debug("Attempt to search item Blouse");
        SEARCH_INPUT.sendKeys("Blouse");
        SEARCH_BY_NAME_BUTTON.click();
        return new SearchResultPage(driver);
    }

    @Step("Go to search for item by criteria")
    public SearchResultPage searchItemByCriteria() {
        LOGGER.debug(String.format("Attempt to open URl: %s", Urls.SHOP_URL));
        driver.get(Urls.SHOP_URL);
        LOGGER.debug("Attempt to open search by criteria");
        CRITERIA_SEARCH_BUTTON.click();
        return new SearchResultPage(driver);
    }
}
