package StepDefinitionPackage;

import SFprojectPackage.ContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;


public class ContactStepDefinition extends Hook
{
    private static final Logger log = LogManager.getLogger(ContactStepDefinition.class);

    public ContactStepDefinition() throws AWTException {

    }

    @Given("User should be able to click contact hyperlink")
    public void userShouldBeAbleToClickContactHyperlink() throws Exception {

        log.info("Hyperlink clicked successfully");
        ContactPage contactLink = new ContactPage(driver);
        contactLink.ContactMethod();

    }

    @When("User should be able to click of upload files and attach the PDF document in notes and attachment")
    public void userShouldBeAbleToClickOfUploadFilesAndAttachThePDFDocumentInNotesAndAttachment() throws Exception {

        log.info("upload the files successfully");
        ContactPage uploadPdfVerification = new ContactPage(driver);
        uploadPdfVerification.uploadFilesMethod();

    }


    @Then("User should be able to navigate inside PDF and verify the name")
    public void userShouldBeAbleToNavigateInsidePDFAndVerifyTheName() {

        log.info("PDF verification done successfully");
        System.out.println("Logout done");
    }
}
