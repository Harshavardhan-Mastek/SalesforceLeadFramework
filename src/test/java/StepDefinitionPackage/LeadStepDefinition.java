package StepDefinitionPackage;

import SFprojectPackage.LeadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class LeadStepDefinition extends Hook {

    private static final Logger log = LogManager.getLogger(LeadStepDefinition.class);

    public LeadStepDefinition() throws AWTException {
    }


    @Given("User should be able to create a lead record")
    public void userShouldBeAbleToCreateALeadRecord() throws Exception {

        log.info("Created a lead record successfully");
        LeadPage beforeConvertMethod = new LeadPage(driver);
        beforeConvertMethod.LeadCreationMethod();

    }

    @Then("User should be able to convert the lead record")
    public void userShouldBeAbleToConvertTheLeadRecord() throws InterruptedException, AWTException {

        log.info("Converted a lead record successfully");
        LeadPage leadConversion = new LeadPage(driver);
        leadConversion.LeadConvertMethod();

    }

}
