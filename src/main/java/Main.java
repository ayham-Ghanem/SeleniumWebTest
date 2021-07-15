import app.base.DriverSingleton;
import app.base.Extras;
import app.base.ReporterSingleton;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
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

    private final Extras extras = new Extras();
    //javascript executor
    private final JavascriptExecutor js = (JavascriptExecutor)driver;

    private static ExtentReports extent = ReporterSingleton.getExtentInstance();

    private static ExtentTest test = ReporterSingleton.getTestInstance();

    @BeforeClass
    public static void beforeClass() throws Exception {
        test.log(Status.INFO, "Initializing before class");
        driver = DriverSingleton.getDriverInstance();
        test.log(Status.PASS, "Driver established successfully");
    }




    @Test(priority = 1)
    public void registerPageFinder(){

        Homepage homepage = new Homepage();
        homepage.loginPage();
        test.pass("Located register page successfully");

    }

    @Test(priority = 2)
    public void register(){

        Register register = new Register("zew7@yhy.com","Ayham123456789");
        register.registerPage();
        register.register();
        test.pass("Registered successfully");

    }




    @Test(priority = 3)
    public void dropDownSelectAndSearch(){

        Homepage homepage =new Homepage();
        homepage.selectAndSearch();
        test.pass("Filled price, area , category and clicked on search successfully");
    }


    @Test(priority = 4)
    public void cardsPage(){
        GiftCardSelect giftCard = new GiftCardSelect(driver);
        giftCard.urlCheck();
        test.pass("Url check passed");
        giftCard.selectBusinessAndPrice();

    }

    @Test(priority = 5)
    public void senderInfo(){
        SenderReceiverPage1 page1 = new SenderReceiverPage1();
        page1.fillPage();

    }

    @Test(priority = 6)
    public void howToSendPage(){
        SenderReceiverPage2 page2 = new SenderReceiverPage2();
        page2.fillRequirements();

    }




    @AfterClass
    public static void tearDown() {
        test.log(Status.INFO, "@After test " + "After test method");
        // build and flush report
        extent.flush();
        driver.quit();
    }


}
