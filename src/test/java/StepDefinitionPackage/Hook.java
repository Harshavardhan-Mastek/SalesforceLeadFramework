package StepDefinitionPackage;


import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


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



//    @After
//    public void close()
//    {
    //Email sent

    // SeleniumUtils.emailSend();
//        driver.close();
//    }
}
