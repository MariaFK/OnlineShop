package pages;


import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//a[@class='logout']")
    WebElement SIGN_OUT_BUTTON;

    @FindBy (xpath = "//a[@title='Addresses']")
    WebElement MY_ADDRESSES_BUTTON;


    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Check if user is signed in")
    public boolean userSignedIn() {
        return SIGN_OUT_BUTTON.isDisplayed();
    }

    @Step("Follow addresses page")
    public void followAddressesPage(){
        MY_ADDRESSES_BUTTON.click();
    }
}
