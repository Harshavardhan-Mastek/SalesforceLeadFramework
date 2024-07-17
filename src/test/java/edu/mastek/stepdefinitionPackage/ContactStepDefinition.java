package edu.mastek.stepdefinitionPackage;

import edu.mastek.salesforceTaskPackage.ContactPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;


public class ContactStepDefinition extends Hook
{
    // Logger for Contact step definition
    private static final Logger log = LogManager.getLogger(ContactStepDefinition.class);


    @Given("User should be able to click contact hyperlink")
    public void userShouldBeAbleToClickContactHyperlink() throws Exception {

        //Object creation of Contact page
        ContactPage contactLink = new ContactPage(driver);
        contactLink.contactMethod();
        log.info("Hyperlink clicked successfully");
    }

    @When("User should be able to click of upload files and attach the PDF document in notes and attachment")
    public void userShouldBeAbleToClickOfUploadFilesAndAttachThePDFDocumentInNotesAndAttachment() throws Exception {

        //Object creation of Contact page
        ContactPage uploadPdfVerification = new ContactPage(driver);
        uploadPdfVerification.uploadFilesMethod();
        log.info("upload the files successfully");

    }


}
