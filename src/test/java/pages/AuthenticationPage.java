package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'alert')]//li")
    WebElement alertMessage;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public String actualMessage() {
       return alertMessage.getText();
    }

    public String expectedMessage() {
       return "Authentication failed.";
    }

}
