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

    @Given("User should be able to enter the salesforce URL")
    public void userShouldBeAbleToEnterTheSalesforceURL() throws Exception{

        log.info("URL Opened successfully");

        System.out.println("checking");

        LoginPage loginUrl = new LoginPage(driver);


        loginUrl.loginCredentials();

    }

    @When("User should be able to enter the Username")
    public void userShouldBeAbleToEnterTheUsername() throws Exception{

        log.info("Username is entered successfully");

        LoginPage loginUsername = new LoginPage(driver);

        loginUsername.UsernameMethod();

    }

    @Then("User should be able to enter password")
    public void user_should_be_able_to_enter_password() throws Exception {

        log.info("Password is entered successfully");

        LoginPage loginPassword = new LoginPage(driver);
        loginPassword.PasswordMethod();

    }

    @And("User should be able to click the login button")
    public void user_should_be_able_to_click_the_login_button() throws Exception
    {

        log.info("login button is clicked successfully");
        LoginPage loginButton = new LoginPage(driver);

        loginButton.LoginMethod();

    }


}
