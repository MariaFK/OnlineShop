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

public class AddItemToTheShoppingCartTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(AddItemToTheShoppingCartTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User tries to add item to the shopping cart")
    @Severity(SeverityLevel.TRIVIAL)
    public void addItemToTheShoppingCartTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Attempt to add item to the shopping car");
        mainStorePage.addItemToCart();
        LOGGER.info("Check if the item was added to the shopping cart");
        mainStorePage.putExplicitWait();
        Assert.assertTrue(mainStorePage.itemIsAdded());
    }
}
