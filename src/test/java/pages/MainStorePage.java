package pages;

import constants.Credentials;
import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainStorePage extends BasePage{

    private static final Logger LOGGER = LogManager.getLogger(MainStorePage.class.getName());

    @FindBy(xpath = "//a[@class='login']")
    WebElement signInLink;

    public MainStorePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open Store page")
    public SignInPage openSignInPage() {
        LOGGER.debug(String.format("Attempt to open URl: %s", Urls.SHOP_URL));
        driver.get(Urls.SHOP_URL);
        LOGGER.debug("Attempt to open sign in page");
        signInLink.click();
        return new SignInPage(driver);
    }
}
