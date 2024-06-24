package UtilsPackage;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.time.Duration;



public class SeleniumUtils {

    protected static WebDriver driver;


//Explicit wait
    public static void untilElementToBeClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20) );
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void typeLoginCreds(WebElement element, String value) {

        element.sendKeys(value);

    }

    public static void clkMethod(WebElement element, WebDriver driver) {
        element.click();
    }


    static String path = "C:\\Users\\Harsh1501600\\IdeaProjects\\SalesforceProject\\src\\Excel\\UserDetails.xlsx";

    static XSSFWorkbook workbook;

    public static String loginExcelData(int a, int b, int c) throws Exception {

        workbook = new XSSFWorkbook(path);

        XSSFSheet sheet = workbook.getSheetAt(a);

        XSSFRow row = sheet.getRow(b);

        XSSFCell cell = row.getCell(c);

        String data = sheet.getRow(b).getCell(c).getStringCellValue();

        return data;

    }


    public void implicitWait() {

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    //ScreenShot

    public void screenShort(WebElement element, String args) throws Exception {

        TakesScreenshot ts = (TakesScreenshot)  driver;

        File ts2 = ts.getScreenshotAs(OutputType.FILE);

        File f = new File (args);

        FileHandler.copy(ts2, f);

    }
    public static void actionMethod() throws Exception {

        Actions act = new Actions(driver);

        act.keyDown(Keys.END).perform();
        act.keyUp(Keys.END).perform();
   }
    public static void robotMethod1() throws AWTException {

        Robot rob1 = new Robot();
        rob1.keyPress(KeyEvent.VK_PAGE_DOWN);
        //rob1.keyRelease(KeyEvent.VK_PAGE_DOWN);

    }


    public static void robotMethod() throws AWTException {
        Robot rob = new Robot();
        rob.keyPress(KeyEvent.VK_CONTROL);
        rob.keyPress(KeyEvent.VK_V);

        rob.keyPress(KeyEvent.VK_ENTER);
    }

    public static void copyMethod(){

    StringSelection stringFileToFormate = new StringSelection("C:\\Users\\Harsh1501600\\Desktop\\CertificateOfCompletion.pdf");
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringFileToFormate,null);
}

    public static void PDFMethod() throws IOException {

    String url = "https://mastek-15d-dev-ed.develop.lightning.force.com/lightning/r/Contact/0035i0000KEia8dAQB/view";

    URL pdf = new URL(url);
    InputStream ip = pdf.openStream();

    BufferedInputStream bis = new BufferedInputStream(ip);

    PDDocument doc = PDDocument.load(bis);

    PDFTextStripper strip = new PDFTextStripper();
    String text =  strip.getText(doc);
    System.out.println(text);
    Assert.assertTrue(text.contains("Harshavardhan Selvaraj"));
}

    public static void jsExecutor(WebElement element) {
        JavascriptExecutor jsclick = (JavascriptExecutor) driver;
        jsclick.executeScript("arguments[0].click()", element);
    }


    public static void highLights(WebElement args) throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid black;');", args);

    }
    public void clkMethod(WebElement element) {

        element.click();

    }

    public static void emailSend() throws EmailException {

        Email email = new SimpleEmail();
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("harshavardhan.selvaraj@mastek.com", "Virat@123"));
        email.setSSLOnConnect(true);
        email.setFrom("dhanalakshmi.rajamanickam@mastek.com");
        email.setSubject("Email Report");
        email.setMsg("The mail successfully to report");
        email.addTo("dhanalakshmi.rajamanickam@mastek.com");
        email.send();

    }

    public void quitBrowser() {

        driver.quit();
    }
}
