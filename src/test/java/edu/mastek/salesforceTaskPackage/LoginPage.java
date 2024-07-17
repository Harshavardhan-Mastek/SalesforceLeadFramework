package edu.mastek.salesforceTaskPackage;

import edu.mastek.stepdefinitionPackage.Hook;
import edu.mastek.utilsPackage.ConstantUtils;
import edu.mastek.utilsPackage.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;


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

//Screenshot for login page

        SeleniumUtils.captureScreenshot(driver, ConstantUtils.ssLoginPage);

    }

    //Entering the username in login page

    public void usernameMethod() throws Exception {

        SeleniumUtils.highLightBordor(driver, username);
        SeleniumUtils.sendkeyValue(username,SeleniumUtils.loginExcelData(0,0, 1));

    }

    //Entering the Password in the login page

    public void passwordMethod() throws Exception {

        SeleniumUtils.highLightBordor(driver, password);
        SeleniumUtils.sendkeyValue(password,SeleniumUtils.loginExcelData(0,1, 1));

    }

    //Clicking the login button

    public void loginMethod() throws Exception {

        login.click();
    }

}
