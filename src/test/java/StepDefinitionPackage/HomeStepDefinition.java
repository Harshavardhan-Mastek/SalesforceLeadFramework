package StepDefinitionPackage;

import SFprojectPackage.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HomeStepDefinition extends Hook {


    private static final Logger log = LogManager.getLogger(HomeStepDefinition.class);

    @Given("User should be able to click on app launcher and enter Lead")
    public void user_should_be_able_to_click_on_app_launcher_and_enter_lead() throws Exception {

        HomePage appLauncher = new HomePage(driver);
        appLauncher.homeMethod();
        log.info("applaunch clicked successfully");

    }

    @Then("User should be able to click new button and navigate to next page")
    public void userShouldBeAbleToClickNewButtonAndNavigateToNextPage() throws Exception {

        HomePage homeNewButton = new HomePage(driver);
        homeNewButton.homeLeadNavigateMethod();
        log.info("New button clicked successfully");

    }
}
