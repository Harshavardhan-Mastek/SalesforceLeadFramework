package SFprojectPackage;

import StepDefinitionPackage.Hook;
import UtilsPackage.ConstantUtils;
import UtilsPackage.SeleniumUtils;
import cucumber.runtime.io.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Hook {


    @FindBy(id = "username")
    private  WebElement username;
    public WebElement getUsername() {
        return username;
    }

    @FindBy(id = "password")
    private  WebElement password;
    public WebElement getPassword() {
        return password;
    }

    @FindBy(id = "Login")
    private  WebElement login;
    public WebElement getLogin() {
        return login;
    }

    //Constructor
    public LoginPage(WebDriver driver) {

        PageFactory.initElements(Hook.driver, this);
    }

    public void loginURL() throws Exception {

        Hook.setup();

        driver.get(ConstantUtils.urlPath);

//Screenshot

        SeleniumUtils.captureScreenshot(driver, ConstantUtils.ssLoginPage);

    }
    public void usernameMethod() throws Exception {

        SeleniumUtils.highLightBordor(driver, username);

        SeleniumUtils.sendkeyValue(username,SeleniumUtils.loginExcelData(0,0, 1));


    }
    public void passwordMethod() throws Exception {

        SeleniumUtils.highLightBordor(driver, password);
        SeleniumUtils.sendkeyValue(password,SeleniumUtils.loginExcelData(0,1, 1));

    }
    public void loginMethod() throws Exception {

        login.click();
    }

}
