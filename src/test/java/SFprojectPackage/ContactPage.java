package SFprojectPackage;

import StepDefinitionPackage.Hook;
import UtilsPackage.SeleniumUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.awt.*;
import java.io.IOException;

import static UtilsPackage.SeleniumUtils.clkMethod;
import static org.junit.Assert.assertEquals;

public class ContactPage extends Hook {

    public ContactPage(WebDriver driver) throws AWTException {

        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='primaryField truncate']//a)[1]")
    private WebElement contactLink;
    public WebElement getContactLink() {
        return contactLink;
    }

    @FindBy(xpath = "//div[text()='Upload Files']")
    private WebElement uploadfilesButton;

    public WebElement getUploadfilesButton() {

        return uploadfilesButton;
    }

    @FindBy(xpath = "//span[contains(text(),'Done')]") //span[text()='Done']
    private WebElement doneButton;

    public WebElement getDoneButton() {
        return doneButton;
    }

    @FindBy(xpath = "//span[@title='CertificateOfCompletion']")
    private WebElement certiClick;

    public WebElement getCertiClick() {
        return certiClick;
    }

    @FindBy(xpath = "//span[text()='Download']")
    private WebElement downloadButton;

    public WebElement getDownloadButton() {
        return downloadButton;
    }

    @FindBy(xpath = "//h3[contains(text(),'Contact')]")
    private WebElement contactHighlight;

    public WebElement getcontactHighlight() {
        return contactHighlight;
    }



    public void ContactMethod() throws Exception {

        Thread.sleep(3000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style','background: green; border: 2px solid black;');", contactHighlight);

        SeleniumUtils.untilElementToBeClickable(contactLink, driver);
        contactLink.click();
    }

    public void uploadFilesMethod() throws Exception{

        //SeleniumUtils.actionMethod();
        Thread.sleep(5000);
        Actions act = new Actions(driver);
        Thread.sleep(5000);
        act.keyDown(Keys.END).perform();
        act.keyUp(Keys.END).perform();

        Thread.sleep(5000);
        SeleniumUtils.untilElementToBeClickable(uploadfilesButton, driver);
        uploadfilesButton.click();

        //Pdf location copy
        Thread.sleep(5000);
        SeleniumUtils.copyMethod();
        Thread.sleep(5000);
        SeleniumUtils.robotMethod();

        Thread.sleep(9000);
        SeleniumUtils.untilElementToBeClickable(doneButton, driver);
        doneButton.click();

        Thread.sleep(3000);
        SeleniumUtils.untilElementToBeClickable(certiClick, driver);
        certiClick.click();
        Thread.sleep(3000);
        SeleniumUtils.untilElementToBeClickable(downloadButton, driver);
        downloadButton.click();
        Thread.sleep(3000);


        //Getting the title
        String actualTitle = driver.getTitle();
        String expectedTitle = "harsh | Contact | Salesforce";
        assertEquals(expectedTitle,actualTitle);
        System.out.println(actualTitle);

        //Email sent
       // SeleniumUtils.emailSend();

        //SeleniumUtils.PDFMethod();
    }



}

