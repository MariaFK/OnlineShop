package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(SearchResultPage.class.getName());


    @FindBy(className = "heading-counter")
    WebElement SEARCH_RESULTS;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    public boolean searchResultIsShown(){
        return SEARCH_RESULTS.isDisplayed();
    }
}
