package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResultPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SearchResultPage.class.getName());


    @FindBy(className = "heading-counter")
    WebElement SEARCH_RESULTS;


    @FindBy(xpath = "//input[@class='color-option  '] [@rel='11_3']")
    WebElement BLACK_COLOR_CHECKBOX;

    @FindBy(xpath = "//input[@type='checkbox'] [@value='5_5']")
    WebElement COTTON_CHECKBOX;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    public boolean searchResultIsShown(){
        return SEARCH_RESULTS.isDisplayed();
    }

    @Step("Set criteria for the search")
    public void chooseTheCriteria() throws InterruptedException {
        LOGGER.debug("Attempt to click checkbox with black color");
        BLACK_COLOR_CHECKBOX.click();
        Thread.sleep(1000);
        LOGGER.debug("Attempt to click checkbox with cotton");
        COTTON_CHECKBOX.click();
        Thread.sleep(1000);
    }
}
