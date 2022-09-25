package pages;

import constants.Credentials;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.FakerMessageGenerator;

public class SignInPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SignInPage.class.getName());

    @FindBy(id = "email")
    WebElement emailInput;

    @FindBy(id = "passwd")
    WebElement passwordInput;

    @FindBy(id= "SubmitLogin")
    WebElement signInButton;



    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sign In")
    public AccountPage signInToStoreWithValidData() {
        LOGGER.debug("Attempt to send username");
        emailInput.sendKeys(Credentials.USERNAME);
        LOGGER.debug("Attempt to send password");
        passwordInput.sendKeys(Credentials.PASSWORD);
        LOGGER.debug(String.format("Attempt to click element: %s", signInButton));
        signInButton.click();
        return new AccountPage(driver);
    }

    @Step("Sign In")
    public AccountPage signInToStoreWithInalidData() {
        LOGGER.debug("Attempt to send username");
        emailInput.sendKeys(FakerMessageGenerator.generateEmail());
        LOGGER.debug("Attempt to send password");
        passwordInput.sendKeys(FakerMessageGenerator.generatePassword());
        LOGGER.debug(String.format("Attempt to click element: %s", signInButton));
        signInButton.click();
        return new AccountPage(driver);
    }
}
