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
import testdata.PrepareNewAddressData;
import utils.RetryAnalyzer;

public class AddAddressTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(AddAddressTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User tries to add delivery address")
    @Severity(SeverityLevel.TRIVIAL)
    public void addAddressTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Open sign in page, enter email and password");
        mainStorePage.openSignInPage()
                .signInToStoreWithValidData();
        LOGGER.info(String.format("Page %s initialized", AccountPage.class.getName()));
        LOGGER.info(String.format("Open %s page", AccountPage.class.getName()));
        AccountPage accountPage = new AccountPage(driverManager.getDriver());
        accountPage.followAddressesPage();
        LOGGER.info(String.format("Page %s initialized", NewAddressPage.class.getName()));
        LOGGER.info(String.format("Open %s page", NewAddressPage.class.getName()));
        NewAddressPage newAddressPage = new NewAddressPage(driverManager.getDriver());
        LOGGER.info(String.format("Model %s initialized", NewAddressModel.class.getName()));
        NewAddressModel addressModel = PrepareNewAddressData.getValidData();
        LOGGER.info("Open new address model, fill in address form");
        newAddressPage.fillInAddressForm(addressModel);
        LOGGER.info("Check if address is created");
        String expectedAddressTitle = addressModel.getAddressTitle();
        Assert.assertEquals(newAddressPage.realAddressTitle(), expectedAddressTitle, "Address isn't created");
    }
}
