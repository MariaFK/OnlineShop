package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.NewAddressModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.MainStorePage;
import pages.NewAddressPage;
import pages.ShoppingCartPage;
import testdata.PrepareNewAddressDate;

public class ConfirmAnOderTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(ConfirmAnOderTest.class.getName());

    @Test
    @Description("User tries to confirm an oder")
    @Severity(SeverityLevel.TRIVIAL)
    public void confirmAnOderTest() {
        MainStorePage mainStorePage = new MainStorePage(driver);
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Open sign in page, enter email and password");
        mainStorePage.openSignInPage()
                .signInToStoreWithValidData();
        LOGGER.info(String.format("Page %s initialized", AccountPage.class.getName()));
        LOGGER.info(String.format("Open %s page", AccountPage.class.getName()));
        AccountPage accountPage = new AccountPage(driver);
        LOGGER.info("Open main store page");
        accountPage.followMainPage();
        LOGGER.info("Add item to the cart, click proceed to checkout button");
        mainStorePage.addItemToCart()
                .clickProceedToCheckoutButton();
        LOGGER.info(String.format("Page %s initialized", ShoppingCartPage.class.getName()));
        LOGGER.info(String.format("Open %s page", ShoppingCartPage.class.getName()));
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
        LOGGER.info("Confirm oder");
        shoppingCartPage.confirmOder();
        LOGGER.info("Check if oder is confirmed");
        Assert.assertTrue(shoppingCartPage.isConfirmMessageDisplayed());
    }
}
