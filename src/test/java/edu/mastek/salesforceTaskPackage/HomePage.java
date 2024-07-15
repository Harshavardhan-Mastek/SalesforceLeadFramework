package edu.mastek.salesforceTaskPackage;

import edu.mastek.stepdefinitionPackage.Hook;
import edu.mastek.utilsPackage.ConstantUtils;
import edu.mastek.utilsPackage.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Hook {

    @FindBy(xpath = "(//button[@title='App Launcher']//div)[1]")
    private WebElement applauncher;
    public WebElement getapplauncher() {
        return applauncher;
    }

    @FindBy(xpath = "(//input[@type='search'])[3]")
    private WebElement enterLead;
    public WebElement getenterLead() {
        return enterLead;
    }

    @FindBy(xpath = "//b[contains(text(),'Leads')]")
    private WebElement navigateLead;
    public WebElement getnavigateLeadMethod() {
        return navigateLead;
    }

    @FindBy(xpath = "//div[contains(text(),'New')]")
    private WebElement newButton;
    public WebElement getnewButtonMethod() {
        return	newButton;
    }

    @FindBy(xpath = "//h2[contains(text(),'New Lead')]")
    private WebElement newLeadRecordType;
    public WebElement getNewLeadRecordType() {
        return	newLeadRecordType;
    }

    @FindBy(xpath = "//span[text()='NewLead']")
    private WebElement newLeadColor;
    public WebElement getnewLeadColor() {
        return	newLeadColor;
    }

//Constructor

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    public void homeMethod() throws Exception {
//Homepage


        Thread.sleep(3000);

        SeleniumUtils.captureScreenshot(driver, ConstantUtils.ssHomePage);

        SeleniumUtils.untilElementToBeClickable(applauncher, driver);
        applauncher.click();

        Thread.sleep(3000);
        enterLead.sendKeys("Leads");

        SeleniumUtils.untilElementToBeClickable(navigateLead, driver);
        navigateLead.click();

    }
    public void  homeLeadNavigateMethod() throws Exception {

        Thread.sleep(3000);
//Assertion for Lead page
        Assert.assertEquals("Sales",driver.findElement(By.xpath(("(//span[text()='Sales'])[3]"))).getText());
        System.out.println("Assertion value:- "+driver.findElement(By.xpath(("(//span[text()='Sales'])[3]"))).getText());


        SeleniumUtils.untilElementToBeClickable(newButton, driver);
        newButton.click();

        Thread.sleep(5000);
        SeleniumUtils.highLightBackgroundNewLead(driver, newLeadRecordType);

        SeleniumUtils.highLightBackground(driver,newLeadColor);

    }
}
