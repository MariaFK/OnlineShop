package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AuthenticationPage;
import pages.MainStorePage;

public class SignInWithInvalidDataTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(SignInWithValidDataTest.class.getName());

    @Test
    @Description("User tries to sign in using invalid data")
    @Severity(SeverityLevel.MINOR)
    public void signInWithInvalidDataTest() {
        MainStorePage mainStorePage = new MainStorePage(driver);
        LOGGER.info(String.format("Page %s initialized", MainStorePage.class.getName()));
        LOGGER.info(String.format("Open %s page", MainStorePage.class.getName()));
        LOGGER.info("Open sign in page, enter email and password");
        mainStorePage.openSignInPage()
                .signInToStoreWithInvalidData();
        LOGGER.info(String.format("Page %s initialized", AuthenticationPage.class.getName()));
        AuthenticationPage authenticationPage = new AuthenticationPage(driver);
        LOGGER.info("Check if the user didn't manage to signed in");
        Assert.assertEquals(authenticationPage.actualMessage(), authenticationPage.expectedMessage());
    }
}
