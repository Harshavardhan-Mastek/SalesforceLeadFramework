package edu.mastek.stepdefinitionPackage;

import edu.mastek.salesforceTaskPackage.LeadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LeadStepDefinition extends Hook {

    private static final Logger log = LogManager.getLogger(LeadStepDefinition.class);


    @Given("User should be able to create a lead record")
    public void userShouldBeAbleToCreateALeadRecord() throws Exception {


        LeadPage beforeConvertMethod = new LeadPage(driver);
        beforeConvertMethod.leadCreationMethod();
        log.info("Created a lead record successfully");

    }

    @Then("User should be able to convert the lead record")
    public void userShouldBeAbleToConvertTheLeadRecord() throws Exception {


        LeadPage leadConversion = new LeadPage(driver);
        leadConversion.leadConvertMethod();
        log.info("Converted a lead record successfully");

    }

}
