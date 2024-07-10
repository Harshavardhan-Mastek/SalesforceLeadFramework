package SFprojectPackage;

import StepDefinitionPackage.Hook;
import UtilsPackage.ConstantUtils;
import UtilsPackage.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;

public class LeadPage extends Hook {


    @FindBy(xpath = "//button[@name='salutation']")
    private WebElement salutation;

    public WebElement getsalutationMethod() {
        return salutation;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    private WebElement firstName;
    public WebElement getfirstName() {
        return firstName;
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

    @FindBy(xpath = "//input[@name='Email']")
    private WebElement emailName;
    public WebElement getemailName() {
        return emailName;
    }

    @FindBy(xpath = "//input[@name='Website']")
    private WebElement websiteName;
    public WebElement getwebsiteName() {
        return websiteName;
    }


    @FindBy(xpath = "//input[@name='Title']")
    private WebElement titleName;
    public WebElement gettitleName() {
        return titleName;
    }

    @FindBy(xpath = "//input[@name='Converting__c']")
    private WebElement convertingName;
    public WebElement getconvertingName() {
        return convertingName;
    }

    @FindBy(xpath = "//input[@name='SICCode__c']")
    private WebElement sicCodeName;
    public WebElement getsicCodeName() {
        return sicCodeName;
    }

    @FindBy(xpath = "//input[@name='CurrentGenerators__c']")
    private WebElement currentGenName;
    public WebElement getcurrentGenName() { return currentGenName;
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

    @FindBy(xpath = "//span[contains(text(),'Open - Not Contacted')]")
    private WebElement leadStatus;
    public WebElement getLeadStatus() {
        return leadStatus;
    }


    public WebElement getRecordNextBtnMethod() {
        return recordNextBtn;
    }


    //Constructor
    public LeadPage(WebDriver driver) throws AWTException {

        PageFactory.initElements(driver, this);
    }

    public void leadCreationMethod() throws Exception {

//Lead Creation

        SeleniumUtils.untilElementToBeClickable(recordNextBtn, driver);
        recordNextBtn.click();

        SeleniumUtils.untilElementToBeClickable(salutation, driver);
        salutation.click();

        SeleniumUtils.highLightBackground(driver,firstName);
        SeleniumUtils.sendkeyValue(firstName,SeleniumUtils.loginExcelData(1,0, 1));

        SeleniumUtils.highLightBackground(driver,lastName);
        SeleniumUtils.sendkeyValue(lastName,SeleniumUtils.loginExcelData(1,1, 1));

        SeleniumUtils.highLightBackground(driver,companyName);
        SeleniumUtils.sendkeyValue(companyName,SeleniumUtils.loginExcelData(1,2, 1));

        SeleniumUtils.highLightBackground(driver,leadStatus);

        SeleniumUtils.highLightBackground(driver,emailName);
        SeleniumUtils.sendkeyValue(emailName,SeleniumUtils.loginExcelData(1,3, 1));

        SeleniumUtils.highLightBackground(driver,websiteName);
        SeleniumUtils.sendkeyValue(websiteName,SeleniumUtils.loginExcelData(1,4, 1));

        SeleniumUtils.highLightBackground(driver,titleName);
        SeleniumUtils.sendkeyValue(titleName,SeleniumUtils.loginExcelData(1,5, 1));

        SeleniumUtils.highLightBackground(driver,convertingName);
        SeleniumUtils.sendkeyValue(convertingName,SeleniumUtils.loginExcelData(1,6, 1));

        SeleniumUtils.highLightBackground(driver,sicCodeName);
        SeleniumUtils.sendkeyValue(sicCodeName,SeleniumUtils.loginExcelData(1,7, 1));

        SeleniumUtils.highLightBackground(driver,currentGenName);
        SeleniumUtils.sendkeyValue(currentGenName,SeleniumUtils.loginExcelData(1,8, 1));


        SeleniumUtils.captureScreenshot(driver, ConstantUtils.ssLeadPage);

        SeleniumUtils.untilElementToBeClickable(saveBtn, driver);
        saveBtn.click();
    }

    public void leadConvertMethod() throws Exception {


        Thread.sleep(5000);
        SeleniumUtils.untilElementToBeClickable(convertBtn, driver);
        convertBtn.click();

        Thread.sleep(5000);
        SeleniumUtils.untilElementToBeClickable(popConvertBtn, driver);
        popConvertBtn.click();

        Thread.sleep(5000);

        WebElement convertLead = driver.findElement(By.xpath(("//h2[text()='Your lead has been converted']")));
        SeleniumUtils.highLightBackground(driver,convertLead);

        //Assertion for Converted lead message
        Assert.assertEquals(ConstantUtils.leadConvertedTitle,convertLead.getText());
        System.out.println(ConstantUtils.successConvertedMsg +convertLead.getText());

    }


    }

