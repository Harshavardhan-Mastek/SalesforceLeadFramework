package SFprojectPackage;

import StepDefinitionPackage.Hook;
import UtilsPackage.SeleniumUtils;
import org.openqa.selenium.JavascriptExecutor;
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


//Constructor

    public HomePage(WebDriver driver) {

        PageFactory.initElements(driver, this);
    }
    public void homeMethod() throws Exception {
//Homepage


        Thread.sleep(7000);

        SeleniumUtils.untilElementToBeClickable(applauncher, driver);
        applauncher.click();

        Thread.sleep(3000);
        enterLead.sendKeys("Leads");

        SeleniumUtils.untilElementToBeClickable(navigateLead, driver);
        navigateLead.click();
    }
    public void  homeLeadNavigateMethod(){

        SeleniumUtils.untilElementToBeClickable(newButton, driver);
        newButton.click();

    }
}
