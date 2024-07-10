package StepDefinitionPackage;

import SFprojectPackage.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class LoginStepDefinition extends Hook {

    private static final Logger log = LogManager.getLogger(LoginStepDefinition.class);

    @Given("User should be able to enter the salesforce Url")
    public void userShouldBeAbleToEnterTheSalesforceUrl() throws Exception{

        LoginPage loginUrl = new LoginPage(driver);
        loginUrl.loginURL();
        log.info("URL Opened successfully");

    }

    @When("User should be able to enter the Username")
    public void userShouldBeAbleToEnterTheUsername() throws Exception{

        LoginPage loginUsername = new LoginPage(driver);
        loginUsername.usernameMethod();
        log.info("Username is entered successfully");

    }

    @Then("User should be able to enter password")
    public void user_should_be_able_to_enter_password() throws Exception {

        LoginPage loginPassword = new LoginPage(driver);
        loginPassword.passwordMethod();
        log.info("Password is entered successfully");

    }

    @And("User should be able to click the login button")
    public void user_should_be_able_to_click_the_login_button() throws Exception
    {

        LoginPage loginButton = new LoginPage(driver);
        loginButton.loginMethod();
        log.info("login button is clicked successfully");

    }


}
