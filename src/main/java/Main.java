import app.base.DriverSingleton;
import app.base.Extras;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import web.pages.*;

import java.io.File;
import java.io.IOException;


public class Main {
    private static WebDriver driver;
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    //extras object
    private final Extras extras = new Extras();
    //javascript executor
    private final JavascriptExecutor js = (JavascriptExecutor)driver;

    @BeforeClass
    public static void beforeClass() throws Exception {
        String cwd = System.getProperty("user.dir");
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
        // attach reporter
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // name your test and add description
        test = extent.createTest("MyFirstTest", "Sample description");
        test.log(Status.INFO, "Initializing before class");

        try {
            driver = DriverSingleton.getDriverInstance();
            test.log(Status.PASS, "Driver established successfully");
        } catch (Exception e) {
            e.printStackTrace();
            test.log(Status.FAIL, "Driver connection failed! " + e.getMessage());
            throw new Exception("Driver failed");
        }

    }



    @Test(priority = 1)
    public void registerPageFinder(){
        driver.navigate().refresh();
        ((JavascriptExecutor)driver).executeScript("window.stop();");
        js.executeScript("return window.stop()");

        extras.printElementSize();

//        try{
//            Homepage homepage = new Homepage();
//            homepage.loginPage();
//            test.pass("Located register page successfully");
//        }catch (NoSuchElementException e) {
//            e.printStackTrace();
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.log(Status.FAIL, "Element not found " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//        }
    }
//
//    @Test(priority = 2)
//    public void register(){
//        try{
//            Register register = new Register("zew7@yhy.com","Ayham123456789");
//            register.registerPage();
//            register.register();
//            test.pass("Registered successfully");
//        }catch (NoSuchElementException e){
//            e.printStackTrace();
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.log(Status.FAIL, "Element not found " + e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//        }
//    }
//
//
//
//
//    @Test(priority = 3)
//    public void dropDownSelectAndSearch(){
//
//        Homepage homepage =new Homepage();
//        try {
//            homepage.selectAndSearch();
//            test.pass("Filled price, area , category and clicked on search successfully");
//        }catch (NoSuchElementException e){
//            e.printStackTrace();
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.log(Status.FAIL, "Element not found " + e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//        }
//
//
//    }
//
//
//    @Test(priority = 4)
//    public void cardsPage(){
//        GiftCardSelect giftCard = new GiftCardSelect(driver);
//        giftCard.urlCheck();
//        test.pass("Url check passed");
//        try{
//            giftCard.selectBusinessAndPrice();
//        }catch (NoSuchElementException e){
//            e.printStackTrace();
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.log(Status.FAIL, "Element not found " + e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//
//        }
//
//    }
//
//    @Test(priority = 5)
//    public void senderInfo(){
//        SenderReceiverPage1 page1 = new SenderReceiverPage1();
//        try{
//            page1.fillPage();
//        }catch (NoSuchElementException e){
//            e.printStackTrace();
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.log(Status.FAIL, "Element not found " + e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//
//        }
//    }
//
//    @Test(priority = 6)
//    public void howToSendPage(){
//        SenderReceiverPage2 page2 = new SenderReceiverPage2();
//        try{
//            page2.fillRequirements();
//        }catch (NoSuchElementException e){
//            e.printStackTrace();
//            String timeNow = String.valueOf(System.currentTimeMillis());
//            test.log(Status.FAIL, "Element not found " + e.getMessage(),MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
//
//        }
//
//
//
//    }
//
//
//
//
//    @AfterClass
//    public static void tearDown() {
//        test.log(Status.INFO, "@After test " + "After test method");
//        // build and flush report
//        extent.flush();
//        driver.quit();
//    }


    @NotNull
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File screenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File(ImagesPath + ".png");
        try {
            FileUtils.copyFile(screenShotFile, destinationFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return ImagesPath + ".png";
    }

}
