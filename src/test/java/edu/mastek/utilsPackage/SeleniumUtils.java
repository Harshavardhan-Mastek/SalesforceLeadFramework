package edu.mastek.utilsPackage;

import io.cucumber.java.Scenario;
import org.apache.commons.mail.*;
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
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TakesScreenshot;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import static edu.mastek.salesforceTaskPackage.MentorPage.scenario;


public class SeleniumUtils {

    protected static WebDriver driver;



//Explicit wait
    public static void untilElementToBeClickable(WebElement element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20) );
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void sendkeyValue(WebElement element, String value) {

        element.sendKeys(value);

    }

    public static void clkMethod(WebElement element, WebDriver driver) {
        element.click();
    }


    static String path = ConstantUtils.excelPath;

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


    public static void highLightBordor(WebDriver driver, WebElement element) throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style','background: white; border: 2px solid green;');", element);

    }

    public static void highLightBackground(WebDriver driver, WebElement element) throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style','background: yellow; border: 2px solid red;');", element);

    }

    public static void highLightBackgroundNewLead(WebDriver driver, WebElement element) throws Exception {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].setAttribute('style','background: blue; border: 2px solid black;');", element);

    }

    public void clkMethod(WebElement element) {

        element.click();

    }

    public static void emailSend() throws EmailException, InterruptedException {


        // Create the attachment

        String username = ConstantUtils.usernameForMail;
        String password = ConstantUtils.passwordForMail;
        String fromMail = ConstantUtils.fromMailID;
        String toMail = ConstantUtils.toMailID;


        Properties prop = new Properties();
        prop.put("mail.smtp.auth","true");
        prop.put("mail.smtp.starttls.enable","true");
        prop.put("mail.smtp.host","smtp.gmail.com");
        prop.put("mail.smtp.port","587");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username , password );
            }
        });

        MimeMessage message = new MimeMessage(session);
        try {
                                                                                                                                                                                                                                                               Thread.sleep(3000);
            message.setFrom(new InternetAddress(fromMail));
            message.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(toMail)));
            message.setSubject(ConstantUtils.subjectMail);

            Multipart multipart = new MimeMultipart();


            MimeBodyPart textArea = new MimeBodyPart();
            textArea.setText(ConstantUtils.textAreaMail);

            MimeBodyPart reportZipFile = new MimeBodyPart();
            reportZipFile.attachFile(ConstantUtils.zipFile);


            multipart.addBodyPart(textArea);
            multipart.addBodyPart(reportZipFile);


            message.setContent(multipart);

            Transport.send(message);

        }
        catch (MessagingException | IOException e)
        {

            throw new RuntimeException(e);
        }

    }

    public static void captureScreenshot(WebDriver driver,String screenshotName)
    {

        try
        {
            TakesScreenshot ts=(TakesScreenshot)driver;

            File source=ts.getScreenshotAs(OutputType.FILE);

            FileHandler.copy(source, new File(ConstantUtils.screenshotPath +screenshotName+ ConstantUtils.screenshotExtension));

        }
        catch (Exception e)
        {

            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }

        }


