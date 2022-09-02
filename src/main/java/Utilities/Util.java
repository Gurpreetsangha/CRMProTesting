package Utilities;

import Browser.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;

public class Util extends TestListenerAdapter {
    static WebDriver driver = Browser.driver;

    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final int IMPLICIT_WAIT = 10;

    public static void switchFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public void onTestFailure(ITestResult testResult) {
        String path = "src/main/java/Screenshots/";

        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(path + testResult.getName() + System.currentTimeMillis() + ".png");

        try {
            FileUtils.copyFile(screenShot, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}