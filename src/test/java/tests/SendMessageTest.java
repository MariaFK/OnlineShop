package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.ContactUsPage;
import pages.MainStorePage;
import utils.RetryAnalyzer;

public class SendMessageTest extends BaseTest{

    private static final Logger LOGGER = LogManager.getLogger(SendMessageTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User tries to send message about oder")
    @Severity(SeverityLevel.CRITICAL)
    public void sendMessageTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Open sign in page, enter email and password");
        mainStorePage.openSignInPage()
                .signInToStoreWithValidData();
        LOGGER.info(String.format("Page %s initialized", AccountPage.class.getName()));
        LOGGER.info(String.format("Open %s page", AccountPage.class.getName()));
        AccountPage accountPage = new AccountPage(driverManager.getDriver());
        LOGGER.info("Open contact us page");
        accountPage.followContactUsPage();
        LOGGER.info(String.format("Page %s initialized", ContactUsPage.class.getName()));
        LOGGER.info(String.format("Open %s page", ContactUsPage.class.getName()));
        ContactUsPage contactUsPage = new ContactUsPage(driverManager.getDriver());
        LOGGER.info("Fill in the message and send it");
        contactUsPage.fillInAndSendTheMessage();
        LOGGER.info("Check if the message is sent");
        Assert.assertTrue(contactUsPage.isConfirmationMessageDisplayed());
    }
}
