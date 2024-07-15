package edu.mastek.stepdefinitionPackage;

import edu.mastek.salesforceTaskPackage.MentorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.apache.commons.mail.EmailException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MentorStepDefinition extends Hook {

    private static final Logger log = LogManager.getLogger(MentorStepDefinition.class);


    @Given("User should be able to click mentor object and fill the mentor details except mentor name")
    public void userShouldBeAbleToClickMentorObjectAndFillTheMentorDetailsExceptMentorName() throws Exception {

        MentorPage mentor = new MentorPage(driver);

        mentor.mentorRecordMethod();
        log.info("Negative scenrio succesfully done");

    }
}
