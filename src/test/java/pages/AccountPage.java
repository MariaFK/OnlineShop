package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends BasePage{

    @FindBy(xpath = "//a[@class='logout']")
    WebElement signOutButton;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public boolean userSignedIn() {
        return signOutButton.isDisplayed();
    }
}
