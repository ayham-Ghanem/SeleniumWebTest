package app.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public void clickElement(By locator) { getWebElement(locator).click();
    }

    public void sendKeysToElement(By locator, String text) {getWebElement(locator).sendKeys(text); }

    public String getKeysFromElement(By locator){return getWebElement(locator).getAttribute("value");}


    protected WebElement getWebElement(By locator) {
        return DriverSingleton.getDriverInstance().findElement(locator);
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


}
