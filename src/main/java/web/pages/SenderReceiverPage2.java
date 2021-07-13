package web.pages;

import app.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Hashtable;

public class SenderReceiverPage2 extends BasePage {

    private final Hashtable<String, String> assertionCheck = new Hashtable<>();

    public void fillRequirements(){
        fillEmail();
        assertionPrep();
//        senderName();
        pressPay();
        assertCheck();

    }
    //*[@id="ember2125"]/div[2]/div[1]/svg
    private void fillEmail(){

        clickElement(By.cssSelector("svg[data-ember-action=\"2127\"]"));
        waitForElementVisibility(By.xpath("//input[@name=\"email\"]"),2);
        sendKeysToElement(By.xpath("//input[@name=\"email\"]"),"ayham.ghanem.2000@gmail.com");
    }
    //no need because the site insert it automatically
    private void senderName(){
        sendKeysToElement(By.xpath("//input[@maxlength=\"25\"]"),"ayham");
    }


    private void assertionPrep() {
        assertionCheck.put("sender", getKeysFromElement(By.xpath("//input[@maxlength=\"25\"]")));
        assertionCheck.put("receiver", SenderReceiverPage1.getReceiver());
    }


    private void pressPay(){
        clickElement(By.id("ember2146"));
    }


    private void assertCheck(){

        Assert.assertEquals(assertionCheck.get("sender"),"ayham ");
        Assert.assertEquals(assertionCheck.get("receiver"),"daniel");


    }




}
