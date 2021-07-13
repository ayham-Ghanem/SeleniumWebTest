package web.pages;

import app.base.BasePage;
import org.openqa.selenium.By;


public class SenderReceiverPage1 extends BasePage {
    private static String receiver;



    public static String getReceiver() {
        return receiver;
    }

    public SenderReceiverPage1() {
        SenderReceiverPage1.receiver = "daniel";
    }




    public void fillPage(){
        pressRadio();
        enterSenderReceiver();
        writeMessage();
        uploadPhoto();
        clickNextPage();


    }

    private void pressRadio(){
        clickElement(By.cssSelector("div[gtm=\"למישהו אחר\"]"));

    }

    private void enterSenderReceiver(){
        //writes the receiver name

        sendKeysToElement(By.cssSelector("input[maxlength=\"25\"]"),receiver);
        //clicks on "for what event"
        clickElement(By.className("selected-name"));

        //because i get "element has zero size error"
        waitForElementVisibility(By.xpath("//li[@value=10]"),2);
        //clicks on birthday
        clickElement(By.id("ember2077"));


    }


    private void writeMessage(){

        clearTxtField(By.cssSelector("textarea[rows=\"4\"]"));
        sendKeysToElement(By.cssSelector("textarea[rows=\"4\"]"),"Happy birthday!!");
    }

    private void uploadPhoto(){
        sendKeysToElement(By.xpath("//input[@type=\"file\"]"),"C:\\Users\\ayham\\Desktop\\Java\\SeleniumHandsOn\\java-selenium.png");

    }


    private void clickNextPage(){
//        waitForElementInvisibility(By.className("fade-in"),15);
        clickElement(By.xpath("//button[@type=\"submit\"]"));
    }



}
