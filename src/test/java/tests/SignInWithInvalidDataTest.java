package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import models.SignInModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.MainStorePage;
import testdata.PrepareSignInData;
import utils.RetryAnalyzer;

public class SignInWithInvalidDataTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SignInWithValidDataTest.class.getName());

    @Test(retryAnalyzer = RetryAnalyzer.class)
    @Description("User tries to sign in using invalid data")
    @Severity(SeverityLevel.MINOR)
    public void signInWithInvalidDataTest() {
        MainStorePage mainStorePage = new MainStorePage(driverManager.getDriver());
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info(String.format("Model %s initialized", SignInModel.class.getName()));
        SignInModel signInModel = PrepareSignInData.getValidData();
        LOGGER.info("Open sign in page, enter email and password");
        mainStorePage.openSignInPage()
                .signInToStoreWithInvalidData(signInModel);
        LOGGER.info(String.format("Page %s initialized", AuthenticationPage.class.getName()));
        AuthenticationPage authenticationPage = new AuthenticationPage(driverManager.getDriver());
        LOGGER.info("Check if the user didn't manage to signed in");
        Assert.assertEquals(authenticationPage.actualMessage(), authenticationPage.expectedMessage());
    }
}
