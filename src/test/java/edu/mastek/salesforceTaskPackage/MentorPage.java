package edu.mastek.salesforceTaskPackage;

import cucumber.api.Scenario;
import edu.mastek.stepdefinitionPackage.Hook;
import edu.mastek.utilsPackage.ConstantUtils;
import edu.mastek.utilsPackage.SeleniumUtils;
import org.apache.commons.mail.EmailException;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MentorPage extends Hook {

    public MentorPage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[text()='Mentors'])[1]")
    private WebElement mentorObject;



    public WebElement getmentorObject() {
        return mentorObject;
    }

    @FindBy(xpath = "//div[contains(text(),'New')]")
    private WebElement newButton;

    public WebElement getnewButton() {
        return newButton;
    }

    @FindBy(xpath = "//input[@name='Name']")
    private WebElement mentorName;

    public WebElement getmentorName() {
        return mentorName;
    }

    @FindBy(xpath = "//div[contains(text(),'Complete this field.')]")
    private WebElement errorValue;

    public WebElement geterrorValue() {
        return errorValue;
    }

    @FindBy(xpath = "(//label[text()='phone number']/following::input)[1]")
    private WebElement phoneNumber;

    public WebElement getphoneNumber() {
        return phoneNumber;
    }

    @FindBy(xpath = "(//label[text()='Currency']/following::input)[1]")
    private WebElement currency;

    public WebElement getcurrency() {
        return currency;
    }

    @FindBy(xpath = "//textarea[@class='slds-textarea']")
    private WebElement descriptionText;

    public WebElement getdescriptionText() {
        return descriptionText;
    }

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton;

    public WebElement getsaveButton() {
        return saveButton;
    }

    public static Scenario scenario;

    public void mentorRecordMethod() throws Exception {

        //SeleniumUtils.jsExecutor(mentorObject);
        //mentorObject.click();
        JavascriptExecutor jsclick = (JavascriptExecutor) driver;
        jsclick.executeScript("arguments[0].click()", mentorObject);

        Thread.sleep(3000);
        SeleniumUtils.untilElementToBeClickable(newButton, driver);
        newButton.click();

        SeleniumUtils.untilElementToBeClickable(phoneNumber, driver);
        phoneNumber.sendKeys(ConstantUtils.PhnNumber);

        Thread.sleep(3000);
        //Assertion
        Assert.assertEquals(ConstantUtils.assertErrorMessage, errorValue.getText());

        SeleniumUtils.untilElementToBeClickable(descriptionText, driver);
        descriptionText.sendKeys(ConstantUtils.descText);

        SeleniumUtils.untilElementToBeClickable(currency, driver);
        currency.sendKeys(ConstantUtils.currValue);

        SeleniumUtils.highLightBackground(driver, saveButton);

        //       To show the error message of Mentor name

            SeleniumUtils.untilElementToBeClickable(mentorName, driver);
            mentorName.sendKeys(ConstantUtils.mentor);


        SeleniumUtils.captureScreenshot(driver, ConstantUtils.ssmentornegative);

        Hook.mailReport();


                    
            }
        }





