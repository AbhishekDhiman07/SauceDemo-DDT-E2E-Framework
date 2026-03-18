package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    public static void initReport() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter("reports/ExtentReport.html");
            extent.attachReporter(spark);
        }
    }

    public static void createTest(String name) { test.set(extent.createTest(name)); }
    public static ExtentTest getTest() { return test.get(); }
    public static void flushReport() { if (extent != null) extent.flush(); }
}