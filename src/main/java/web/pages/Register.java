package web.pages;

import app.base.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.Hashtable;

public class Register extends BasePage {

    private final String email;
    private final String password;
    private final Hashtable<String, String> assertionCheck = new Hashtable<>();


    public Register(String email, String password) {
        this.email = email;
        this.password = password;

    }



    public void registerPage(){
        clickElement(By.className("text-link"));
    }

    public void register(){

        enterCredentials();
        pressRegister();
        assertFields();
    }



    private void enterCredentials(){
        sendKeysToElement(By.xpath("//input[@placeholder=\"שם פרטי\"]"), "ayham");
        sendKeysToElement(By.xpath("//input[@placeholder=\"מייל\"]"), this.email);
        sendKeysToElement(By.xpath("//input[@placeholder=\"סיסמה\"]"), this.password);
        sendKeysToElement(By.xpath("//input[@placeholder=\"אימות סיסמה\"]"), this.password);
    }


    private void pressRegister(){
        getTextFromFields();
        clickElement(By.className("bm-btn"));
    }

    private void assertFields(){
        Assert.assertEquals(assertionCheck.get("name"), "ayham");
        Assert.assertEquals(assertionCheck.get("email"), this.email);
        Assert.assertEquals(assertionCheck.get("password"), this.password);
        Assert.assertEquals(assertionCheck.get("repeatedPassword"), this.password);

    }

    private void getTextFromFields() {
        assertionCheck.put("name",getKeysFromElement(By.xpath("//input[@placeholder=\"שם פרטי\"]")));
        assertionCheck.put("email",getKeysFromElement(By.xpath("//input[@placeholder=\"מייל\"]")));
        assertionCheck.put("password",getKeysFromElement(By.xpath("//input[@placeholder=\"סיסמה\"]")));
        assertionCheck.put("repeatedPassword",getKeysFromElement(By.xpath("//input[@placeholder=\"אימות סיסמה\"]")));
    }

}
