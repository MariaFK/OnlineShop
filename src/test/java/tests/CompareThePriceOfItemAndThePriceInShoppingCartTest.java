package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainStorePage;
import utils.RetryAnalyzer;

public class CompareThePriceOfItemAndThePriceInShoppingCartTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(CompareThePriceOfItemAndThePriceInShoppingCartTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("Compare the price of the item with it's price in the shopping cart")
    @Severity(SeverityLevel.TRIVIAL)
    public void compareThePriceOfItemAndThePriceInTheShoppingCartTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Attempt to add item to the shopping car");
        mainStorePage.addItemToCart().putExplicitWait().clickContinueShoppingButton();
        LOGGER.info("Check if the item price in the shopping cart is the same as it's price in the shop");
        Assert.assertEquals(mainStorePage.actualItemPriceInTheShoppingCart(), mainStorePage.expectedItemPrice());
    }
}
