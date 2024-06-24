package SFprojectPackage;

import StepDefinitionPackage.Hook;
import UtilsPackage.SeleniumUtils;
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

    public void loginCredentials() throws Exception {

        Hook.setup();

        driver.get("https://login.salesforce.com/?locale=in");

    }
    public void UsernameMethod() throws Exception {



        SeleniumUtils.typeLoginCreds(username,SeleniumUtils.loginExcelData(0,0, 1));

    }
    public void PasswordMethod() throws Exception {


        SeleniumUtils.typeLoginCreds(password,SeleniumUtils.loginExcelData(0,1, 1));

    }
    public void LoginMethod() throws Exception {

        login.click();
    }

}
