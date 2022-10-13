package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainStorePage;
import pages.SearchResultPage;
import utils.RetryAnalyzer;

public class SearchItemByNameTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SearchItemByNameTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User tries to search for item by name")
    @Severity(SeverityLevel.NORMAL)
    public void searchItemByNameTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Attempt to search for Blouse");
        mainStorePage.searchItemByName();
        LOGGER.info(String.format("Page %s initialized", SearchResultPage.class.getName()));
        LOGGER.info(String.format("Open %s page", SearchResultPage.class.getName()));
        SearchResultPage searchPage = new SearchResultPage(driverManager.getDriver());
        LOGGER.info("Check if the item was found");
        Assert.assertTrue(searchPage.searchResultIsShown());
    }
}
