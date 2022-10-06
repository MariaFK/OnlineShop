package pages;

import io.qameta.allure.Step;
import models.NewAddressModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewAddressPage extends BasePage{

    private static final Logger LOGGER = LogManager.getLogger(NewAddressPage.class.getName());

    @FindBy(xpath = "//a[@title='Add an address']")
    WebElement ADD_NEW_ADDRESS_BUTTON;

    @FindBy (id = "company")
    WebElement COMPANY_NAME_INPUT;

    @FindBy(id = "address1")
    WebElement ADDRESS_INPUT;

    @FindBy(id = "city")
    WebElement CITY_INPUT;

    @FindBy(id = "id_state")
    WebElement STATE_DROPDOWN;

    @FindBy (xpath = "//select[@id='id_state']//option[@value='9']")
    WebElement STATE_OPTION;

    @FindBy(id = "postcode")
    WebElement ZIPCODE_INPUT;

    @FindBy(id = "phone")
    WebElement HOME_PHONE_INPUT;

    @FindBy(id = "phone_mobile")
    WebElement MOBILE_PHONE_INPUT;

    @FindBy(id = "alias")
    WebElement ADDRESS_TITLE_INPUT;

    @FindBy(id = "submitAddress")
    WebElement SAVE_ADDRESS_BUTTON;

    @FindBy(xpath = "//ul[contains(@class,'last_item')]//h3")
    WebElement ADDRESS_TITLE;


    public NewAddressPage(WebDriver driver) {
        super(driver);
    }

    @Step("Fill in address form")
    public void fillInAddressForm(NewAddressModel newAddress){
        LOGGER.debug("Attempt to click add new address button");
        ADD_NEW_ADDRESS_BUTTON.click();
        LOGGER.debug(String.format("Attempt to send account name: %s", newAddress.getCompany()));
        COMPANY_NAME_INPUT.clear();
        COMPANY_NAME_INPUT.sendKeys(newAddress.getCompany());
        LOGGER.debug(String.format("Attempt to send address: %s", newAddress.getAddress()));
        ADDRESS_INPUT.sendKeys(newAddress.getAddress());
        LOGGER.debug(String.format("Attempt to send city: %s", newAddress.getCity()));
        CITY_INPUT.sendKeys(newAddress.getCity());
        LOGGER.debug(String.format("Attempt to send state: %s", newAddress.getState()));
        STATE_DROPDOWN.click();
        STATE_OPTION.click();
        LOGGER.debug(String.format("Attempt to send zipcode: %s", newAddress.getZipcode()));
        ZIPCODE_INPUT.sendKeys(newAddress.getZipcode());
        LOGGER.debug(String.format("Attempt to send home phone: %s", newAddress.getHomePhone()));
        HOME_PHONE_INPUT.sendKeys(newAddress.getHomePhone());
        LOGGER.debug(String.format("Attempt to send mobile phone: %s", newAddress.getMobilePhone()));
        MOBILE_PHONE_INPUT.sendKeys(newAddress.getMobilePhone());
        LOGGER.debug(String.format("Attempt to send address title: %s", newAddress.getAddressTitle()));
        ADDRESS_TITLE_INPUT.clear();
        ADDRESS_TITLE_INPUT.sendKeys(newAddress.getAddressTitle());
        LOGGER.debug(String.format("Attempt to click element: %s", SAVE_ADDRESS_BUTTON));
        SAVE_ADDRESS_BUTTON.click();
    }

    public String realAddressTitle(){
        String realName = ADDRESS_TITLE.getText();
        return realName;
    }

}
