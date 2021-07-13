package web.pages;

import app.base.BasePage;
import org.openqa.selenium.By;

public class Homepage extends BasePage {

    public void loginPage(){
        clickElement(By.className("seperator-link"));
    }


    public void selectAndSearch(){

        selectOptions();
        pressFind();


    }

    private void pressFind() {

        clickElement(By.cssSelector("a[rel=\"nofollow\"]"));
    }

    private void selectOptions() {
        // i don't know why only 10 seconds worked for me
//        waitForElementInvisibility(By.className("\"inner\""),10);
//        try{Thread.sleep(500);}catch (Exception e){ e.printStackTrace();}
        // click and select price range
        clickElement(By.xpath("//*[@id=\"ember978_chosen\"]/a/span"));
        clickElement(By.cssSelector("li[data-option-array-index=\"3\"]"));

        // click and select Area
        clickElement(By.xpath("//*[@id=\"ember993_chosen\"]/a"));
        clickElement(By.cssSelector("li[data-option-array-index=\"3\"]"));



        // click and select category
        clickElement(By.xpath("//*[@id=\"ember1003_chosen\"]/a"));
        clickElement(By.cssSelector("li[data-option-array-index=\"11\"]"));



    }


}
