package app.base;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReporterSingleton {
    // create ExtentReports and attach reporter(s)
    private static ExtentReports extent;
    // creates a toggle for the given test, adds all log events under it
    private static ExtentTest test;
    //extras object


    public static ExtentTest getTestInstance() {


        if (test == null) {
            getExtentInstance();
            // name your test and add description
            test = extent.createTest("MyFirstTest", "Sample description");
            return test;
        }
        return test;

    }

    public static ExtentReports getExtentInstance(){

        if(extent == null){
            String cwd = System.getProperty("user.dir");
            ExtentSparkReporter htmlReporter = new ExtentSparkReporter(cwd + "\\extent.html");
            // attach reporter
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            return extent;
        }

        return extent;
    }
}
