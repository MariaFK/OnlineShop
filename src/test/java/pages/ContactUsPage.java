package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(ContactUsPage.class.getName());

    @FindBy(id = "id_contact")
    WebElement SUBJECT_HEADING_DROPDOWN;

    @FindBy(xpath = "//select[@id='id_contact']//option[@value='2']")
    WebElement CUSTOMER_SERVICE_OPTION;

    @FindBy(name = "id_order")
    WebElement ORDER_REFERENCE_DROPDOWN;

    @FindBy(xpath = "//select[@name='id_order']//option[@value='478735']")
    WebElement ORDER_OPTION;

    @FindBy(id = "478735_order_products")
    WebElement PRODUCT_DROPDOWN;

    @FindBy(xpath = "//select[@id='478735_order_products']//option[@value='1']")
    WebElement PRODUCT_OPTION;

    @FindBy(id = "message")
    WebElement MESSAGE_TEXTAREA;

    @FindBy(id = "submitMessage")
    WebElement SEND_MESSAGE_BUTTON;

    @FindBy(xpath = "//p[contains(@class,'alert-success')]")
    WebElement CONFIRMATION_MESSAGE;


    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in and send message")
    public void fillInAndSendTheMessage() {
        LOGGER.debug("Attempt to open subject heading dropdown");
        SUBJECT_HEADING_DROPDOWN.click();
        LOGGER.debug("Attempt to choose select Customer Service option");
        CUSTOMER_SERVICE_OPTION.click();
        LOGGER.debug("Attempt to open order reference dropdown");
        ORDER_REFERENCE_DROPDOWN.click();
        LOGGER.debug("Attempt to choose select order option");
        ORDER_OPTION.click();
        LOGGER.debug("Attempt to open product dropdown");
        PRODUCT_DROPDOWN.click();
        LOGGER.debug("Attempt to choose product option");
        PRODUCT_OPTION.click();
        LOGGER.debug("Attempt to write message");
        MESSAGE_TEXTAREA.sendKeys("Good morning! The item didn't fit me in size, can I return it?");
        LOGGER.debug("Attempt to click send message button");
        SEND_MESSAGE_BUTTON.click();
    }
    public boolean isConfirmationMessageDisplayed() {
        return CONFIRMATION_MESSAGE.isDisplayed();
    }
}
