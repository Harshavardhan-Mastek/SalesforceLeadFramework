package edu.mastek.stepdefinitionPackage;

import edu.mastek.salesforceTaskPackage.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class LoginStepDefinition extends Hook {

    // Logger for Login step definition
    private static final Logger log = LogManager.getLogger(LoginStepDefinition.class);


    @Given("User should be able to enter the salesforce Url")
    public void user_should_be_able_to_enter_the_salesforce_url() throws Exception {

        //Object creation of login page
        LoginPage loginUrl = new LoginPage(driver);
        loginUrl.loginURL();
        log.info("URL Opened successfully");

    }

    @When("User should be able to enter the Username")
    public void user_should_be_able_to_enter_the_username() throws Exception {

        //Object creation of login page
        LoginPage loginUsername = new LoginPage(driver);
        loginUsername.usernameMethod();
        log.info("Username is entered successfully");


    }

    @Then("User should be able to enter password")
    public void user_should_be_able_to_enter_password() throws Exception {

        //Object creation of login page
        LoginPage loginPassword = new LoginPage(driver);
        loginPassword.passwordMethod();
        log.info("Password is entered successfully");
    }

    @Then("User should be able to click the login button")
    public void user_should_be_able_to_click_the_login_button() throws Exception {

        //Object creation of login page
        LoginPage loginButton = new LoginPage(driver);
        loginButton.loginMethod();
        log.info("login button is clicked successfully");

    }


}
