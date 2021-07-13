package app.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

public class Extras extends BasePage {



    public void printElementSize(){
        WebElement rightSideDot = getWebElement(By.className("bounce1"));
        WebElement centralDot = getWebElement(By.className("bounce2"));
        WebElement leftSideDot = getWebElement(By.className("bounce3"));

        Dimension rightDotSize = rightSideDot.getSize();
        Dimension centralDotSize = centralDot.getSize();
        Dimension leftDotSize = leftSideDot.getSize();

        System.out.println("rightDotSize size: "+ rightDotSize);
        System.out.println("centralDotSize size: "+centralDotSize);
        System.out.println("leftDotSize size: "+leftDotSize);

    }

}
