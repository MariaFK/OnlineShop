package tests;

import drivermanager.DriverFactory;
import drivermanager.DriverManager;
import drivermanager.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.TestListeners;

import java.net.MalformedURLException;

@Listeners(TestListeners.class)
public class BaseTest {
    public WebDriver driver;
    public DriverManager driverManager;

    @BeforeMethod
    public void setUp() {
        DriverFactory driverFactory = new DriverFactory();
        driverManager = driverFactory.getManager(DriverType.CHROME);
        try {
            driverManager.createDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driverManager.setTimeout();
        driverManager.startMaximize();
        driver = driverManager.getDriver();
    }

    public WebDriver getDriver() {
        return driverManager.getDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driverManager.quitDriver();
    }
}
