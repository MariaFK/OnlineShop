package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainStorePage;
import pages.SearchPage;

public class SearchItemTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(SearchItemTest.class.getName());

    @Test
    @Description("User tries to search for item")
    @Severity(SeverityLevel.NORMAL)
    public void addItemToTheShoppingCartTest() {
        MainStorePage mainStorePage = new MainStorePage(driver);
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Attempt to search for Blouse");
        mainStorePage.searchItem();
        LOGGER.info(String.format("Page %s initialized", SearchPage.class.getName()));
        LOGGER.info(String.format("Open %s page", SearchPage.class.getName()));
        SearchPage searchPage = new SearchPage(driver);
        LOGGER.info("Check if the item was found");
        Assert.assertTrue(searchPage.searchResultIsShown());
    }
}
