package pages;

import constants.Credentials;
import io.qameta.allure.Step;
import models.SignInModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SignInPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SignInPage.class.getName());

    @FindBy(id = "email")
    WebElement EMAIL_INPUT;

    @FindBy(id = "passwd")
    WebElement PASSWORD_INPUT;

    @FindBy(id= "SubmitLogin")
    WebElement SIGN_IN_BUTTON;



    public SignInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Sign In")
    public AccountPage signInToStoreWithValidData() {
        LOGGER.debug("Attempt to send username");
        EMAIL_INPUT.sendKeys(Credentials.USERNAME);
        LOGGER.debug("Attempt to send password");
        PASSWORD_INPUT.sendKeys(Credentials.PASSWORD);
        LOGGER.debug(String.format("Attempt to click element: %s", SIGN_IN_BUTTON));
        SIGN_IN_BUTTON.click();
        return new AccountPage(driver);
    }

    @Step("Sign In")
    public AccountPage signInToStoreWithInvalidData(SignInModel signIn) {
        LOGGER.debug("Attempt to send username");
        EMAIL_INPUT.sendKeys(signIn.getEmail());
        LOGGER.debug("Attempt to send password");
        PASSWORD_INPUT.sendKeys(signIn.getPassword());
        LOGGER.debug(String.format("Attempt to click element: %s", SIGN_IN_BUTTON));
        SIGN_IN_BUTTON.click();
        return new AccountPage(driver);
    }
}
