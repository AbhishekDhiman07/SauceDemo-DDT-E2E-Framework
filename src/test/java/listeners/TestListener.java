package listeners;

import base.BaseTest;
import base.ExtentManager;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.File;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    // Helper method to handle screenshot logic for both PASS and FAIL
    private String getScreenshot(WebDriver driver, String name) {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String fileName = name + "_" + dateName + ".png";
        String directory = System.getProperty("user.dir") + "/screenshots/";
        File folder = new File(directory);
        if (!folder.exists()) folder.mkdirs();
        
        String path = directory + fileName;
        try {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(source.toPath(), new File(path).toPath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "../screenshots/" + fileName; // Relative path for ExtentReport
    }

    @Override
    public synchronized void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName() + " (" + result.getParameters()[0] + ")";
        ExtentManager.createTest(testName);
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        String screenshotPath = getScreenshot(driver, result.getName() + "_PASS");
        
        // Attach screenshot to the success log
        ExtentManager.getTest().log(Status.PASS, "Test Passed Successfully", 
            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        WebDriver driver = ((BaseTest) result.getInstance()).getDriver();
        String screenshotPath = getScreenshot(driver, result.getName() + "_FAIL");
        
        ExtentManager.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable(), 
            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public void onStart(org.testng.ITestContext context) {
        ExtentManager.initReport();
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        ExtentManager.flushReport();
    }
}