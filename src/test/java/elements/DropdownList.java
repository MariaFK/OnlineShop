package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropdownList {

    @FindBy(id = "id_state")
    WebElement STATE_DROPDOWN;
    private static final String LIST_XPATH = "//div[contains(@class, 'modal-body')]//span[text()='%s']//parent::span//following-sibling::div//a";
    private static final String OPTION_XPATH = "//div[contains(@class, 'visible')]//a[@title='%s']";
    private WebDriver driver;
    private String labelText;

    public DropdownList(WebDriver driver, String labelText){
        this.driver = driver;
        this.labelText = labelText;
    }

    public  void selectOptionInList(String option){
        String listFinalXpath = String.format(LIST_XPATH, labelText);
        driver.findElement(By.xpath(listFinalXpath)).click();
        String optionFinalXpath = String.format(OPTION_XPATH, option);
        driver.findElement(By.xpath(optionFinalXpath)).click();
    }
}
