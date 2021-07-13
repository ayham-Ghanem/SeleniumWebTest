package app.base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance()  {
         String url = "";
         String type = "";

        if(driver == null){
            try {
                type = getData("browserType");
                url = getData("url");
            }catch (Exception e){
                e.printStackTrace();
            }

            if (type.equalsIgnoreCase("Chrome")){
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayham\\Desktop\\chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.setPageLoadStrategy(PageLoadStrategy.NONE);
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }else if (type.equalsIgnoreCase("firefox")){
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\ayham\\Desktop\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
                driver.manage().window().maximize();
            }




            driver.get(url);

        }

        return driver;
    }


    private static String getData (String keyName) throws Exception{
        ClassLoader classLoader = DriverSingleton.class.getClassLoader();
        String xmlFilePath = String.valueOf(new File(classLoader.getResource("data.xml").getFile()));
        File fXmlFile = new File(xmlFilePath);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(keyName).item(0).getTextContent();
    }

}
