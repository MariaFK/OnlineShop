package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainStorePage extends BasePage{

    private static final Logger LOGGER = LogManager.getLogger(MainStorePage.class.getName());

    @FindBy(xpath = "//a[@class='login']")
    WebElement SIGN_IN_LINK;

    @FindBy(xpath = "(//a[contains(@class,'product-name')][contains(@title,'Blouse')])[1]")
    WebElement BLOUSE_BLOCK;

    @FindBy(xpath = "(//a[contains(@class,'product-name')][contains(@title,'Blouse')])[1]/parent::h5/following-sibling::div[@class='button-container']//a[@title='Add to cart']")
    WebElement ADD_BLOUSE_TO_CART;

//    @FindBy(xpath = "//div[@class='shopping_cart']//span[@class='ajax_cart_quantity']")
//    WebElement ITEM_QUANTITY_IN_SHOPPING_CART;

    @FindBy (xpath = "//i[@class='icon-ok']")
    WebElement CONFIRM_MESSAGE;


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
    public void addItemToCart(){
        LOGGER.debug(String.format("Attempt to open URl: %s", Urls.SHOP_URL));
        driver.get(Urls.SHOP_URL);
        LOGGER.debug("Attempt to add item to the shopping cart");
        Actions actions = new Actions(driver);
        actions.moveToElement(BLOUSE_BLOCK).build().perform();
        ADD_BLOUSE_TO_CART.click();
    }

    public void putExplicitWait() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(CONFIRM_MESSAGE));
    }
    public boolean itemIsAdded(){
        return CONFIRM_MESSAGE.isDisplayed();
    }
}
