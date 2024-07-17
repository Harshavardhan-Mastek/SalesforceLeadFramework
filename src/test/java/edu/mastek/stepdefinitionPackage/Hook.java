package edu.mastek.stepdefinitionPackage;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import edu.mastek.utilsPackage.SeleniumUtils;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.mail.EmailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Hook {

    //Initializing the Webdriver
    public static WebDriver driver;

    @Before
    public static void setup( ) throws Exception {

        //HeadLess browser
//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("window-size=1400,800");
//        opt.addArguments("headless");


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    @After
    public static void closeBrowser() throws EmailException, InterruptedException {

//Email sending

        SeleniumUtils.emailSend();

        //driver.quit();

    }

}





