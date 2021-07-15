package app.base;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.sun.activation.registries.LogSupport;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.reporters.jq.Main;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BasePage {

    private static ExtentTest test = ReporterSingleton.getTestInstance();


    public void clickElement(By locator) { getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {getWebElement(locator).sendKeys(text); }

    public String getKeysFromElement(By locator){return getWebElement(locator).getAttribute("value");}


    protected WebElement getWebElement(By locator) {
        try {
            return DriverSingleton.getDriverInstance().findElement(locator);
        }catch (NoSuchElementException e){
            e.printStackTrace();
            String timeNow = String.valueOf(System.currentTimeMillis());
            test.log(Status.FAIL, "Element not found " + e.getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(takeScreenShot(timeNow)).build());
            return null;
        }
    }

    public void waitForElementInvisibility(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementVisibility(By locator, int seconds){
        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeClickable(By locator, int time){

        WebDriverWait wait = new WebDriverWait(DriverSingleton.getDriverInstance(), Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void javascriptClick(By locator){
        JavascriptExecutor executor = (JavascriptExecutor)DriverSingleton.getDriverInstance();
        executor.executeScript("arguments[0].click();", getWebElement(locator));
    }

    public void clearTxtField(By locator){getWebElement(locator).clear();}

    @NotNull
    private static String takeScreenShot(String ImagesPath) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverSingleton.getDriverInstance();
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
