package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainStorePage;
import pages.ShoppingCartPage;
import utils.RetryAnalyzer;

public class DeleteItemFromTheShoppingCartTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(SignInWithValidDataTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User tries to delete item from the shopping cart")
    @Severity(SeverityLevel.MINOR)
    public void signInWithInvalidDataTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Attempt to add item to the shopping car");
        LOGGER.info(String.format("Open %s page", ShoppingCartPage.class.getName()));
        mainStorePage.addItemToCart()
                .clickContinueShoppingButton()
                .clickShoppingCartButton();
        LOGGER.info(String.format("Page %s initialized", ShoppingCartPage.class.getName()));
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driverManager.getDriver());
        shoppingCartPage.deleteItemFromTheCart();
        shoppingCartPage.putExplicitWait();
        LOGGER.info("Check if the item was deleted from the shopping cart");
        Assert.assertEquals(shoppingCartPage.informationMessage(), shoppingCartPage.expectedMessageAboutCartStatus());
    }
}
