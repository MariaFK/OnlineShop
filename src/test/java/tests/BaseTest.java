package tests;

import drivermanager.DriverFactory;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import io.qameta.allure.Attachment;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListeners;

@Listeners(TestListeners.class)
public class BaseTest {

    DriverManager driverManager;

    @BeforeMethod
    public void createManager() {
        DriverFactory factory = new DriverFactory();
        driverManager = factory.getManager(DriverType.CHROME);
    }
    @BeforeMethod
    public void setUp() {
        driverManager.createDriver();
        driverManager.startMaximize();
        driverManager.setTimeout();
    }
    public WebDriver getDriver() {
        return driverManager.getDriver();
    }

    @Attachment
    public String getBrowser() {
        Capabilities cap = ((RemoteWebDriver) driverManager.getDriver()).getCapabilities();
        String browserName = cap.getBrowserName().toLowerCase();
        String v = cap.getVersion();
        return browserName + " " + v;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
