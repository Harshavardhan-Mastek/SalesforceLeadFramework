package SFprojectPackage;

import StepDefinitionPackage.Hook;
import UtilsPackage.SeleniumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class LeadPage extends Hook {

    //Lead Convert

    @FindBy(xpath = "//button[@name='salutation']")
    private WebElement salutation;

    public WebElement getsalutationMethod() {
        return salutation;
    }

    @FindBy(xpath = "//input[@name='lastName']")
    private WebElement lastName;

    public WebElement getlastNameMethod() {
        return lastName;
    }

    @FindBy(xpath = "//input[@name='Company']")
    private WebElement companyName;

    public WebElement getcompanyMethod() {
        return companyName;
    }

    @FindBy(xpath = "//input[@name='MobilePhone']")
    private WebElement mobile;

    public WebElement getmobileMethod() {
        return mobile;
    }

    @FindBy(xpath = "//button[@name='SaveEdit' and contains(text(),'Save')]")
    private WebElement saveBtn;

    public WebElement getsaveMethod() {
        return saveBtn;
    }

    //After clicking the Convert button

    @FindBy(xpath = "//button[contains (text(),'Convert')]//parent::button[@type='button']")
    private WebElement convertBtn;

    public WebElement getconvertBtnMethod() {
        return convertBtn;
    }

    @FindBy(xpath = "//button[contains(text(),'Convert')]/parent::span")
    private WebElement popConvertBtn;
    public WebElement getpopConvertBtnMethod() {
        return popConvertBtn;
    }

    @FindBy(xpath = "//span[contains(text(),'Next')]")
    private WebElement recordNextBtn;

    public WebElement getRecordNextBtnMethod() {
        return recordNextBtn;
    }



    //Constructor
    public LeadPage(WebDriver driver) throws AWTException {

        PageFactory.initElements(driver, this);
    }

    public void LeadCreationMethod() throws Exception {

//Lead Convert

        SeleniumUtils.untilElementToBeClickable(recordNextBtn, driver);
        recordNextBtn.click();

        SeleniumUtils.untilElementToBeClickable(salutation, driver);
        salutation.click();

        SeleniumUtils.typeLoginCreds(lastName,SeleniumUtils.loginExcelData(1,0, 1));

        SeleniumUtils.typeLoginCreds(companyName,SeleniumUtils.loginExcelData(1,1, 1));


//        lastName.sendKeys("Harshavardhan");
//        companyName.sendKeys("Infy");


        SeleniumUtils.untilElementToBeClickable(saveBtn, driver);
        saveBtn.click();
    }

    public void LeadConvertMethod() throws InterruptedException {


        Thread.sleep(5000);
        SeleniumUtils.untilElementToBeClickable(convertBtn, driver);
        convertBtn.click();

        Thread.sleep(5000);
        SeleniumUtils.untilElementToBeClickable(popConvertBtn, driver);
        popConvertBtn.click();


    }


    }

