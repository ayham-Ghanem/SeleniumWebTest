package web.pages;

import app.base.BasePage;
import app.base.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class GiftCardSelect extends BasePage {
    private final WebDriver driver;


    public GiftCardSelect(WebDriver driver) {
        this.driver = DriverSingleton.getDriverInstance();
    }




    public void selectBusinessAndPrice(){
        clickElement(By.xpath("//*[@id=\"ember1640\"]"));
        clickElement(By.id("ember1827"));
    }

    public void urlCheck(){

        String expectedUrl = "https://buyme.co.il/search?budget=3&category=21&region=9";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);


    }

}
