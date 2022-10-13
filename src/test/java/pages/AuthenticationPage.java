package pages;

import constants.ExpectedResults;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'alert')]//li")
    WebElement ALERT_MESSAGE;

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public String actualMessage() {
       return ALERT_MESSAGE.getText();
    }

    public String expectedMessage() {
        return ExpectedResults.AUTHENTICATION_MESSAGE;
    }
}
