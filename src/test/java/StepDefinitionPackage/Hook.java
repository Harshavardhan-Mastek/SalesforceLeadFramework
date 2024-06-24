package StepDefinitionPackage;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Hook {

public static WebDriver driver;

    @Before
    public static void setup() throws Exception
    {
         //HeadLess browser
//        ChromeOptions opt = new ChromeOptions();
//        opt.addArguments("window-size=1400,800");
//        opt.addArguments("headless");


        WebDriverManager.chromedriver ( ).setup ( );
        driver = new ChromeDriver();

        driver.manage().window().maximize();

    }

    //Cross browser Testing
//    @Parameters("Browser")
//    @Test
//    public static void crossBrowserTest(@Optional("browser execution") String browser){
//
//
//        if(browser.equalsIgnoreCase("Chrome") || browser.equalsIgnoreCase("CH") || browser.equalsIgnoreCase("Google Chrome"))
//        {
//            WebDriverManager.chromedriver ( ).setup ( );
//            driver = new ChromeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://login.salesforce.com/?locale=in");
//        }
//        else if (browser.equalsIgnoreCase("Edge") || browser.equalsIgnoreCase("E") || browser.equalsIgnoreCase("Mozilla"))
//        {
//            WebDriverManager.edgedriver ( ).setup ( );
//            driver = new EdgeDriver();
//            driver.manage().window().maximize();
//            driver.get("https://login.salesforce.com/?locale=in");
//        }
//
//    }



//    @After
//    public void close()
//    {
//        driver.close();
//    }
}
