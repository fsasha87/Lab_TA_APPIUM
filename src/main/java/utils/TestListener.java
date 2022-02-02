package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {


    public void printScreenshot() {
        Date dateNow = new Date();
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd__HH-mm-ss");
        String fileName = format1.format(dateNow) + ".png";
        File screenshot = ((TakesScreenshot) AndroidDriverSingleton.getDriver()).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("D:\\Screenshots\\" + fileName));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public void onStart(ITestContext testContext) {

    }

    @Override
    public void onFinish(ITestContext testContext) {

    }


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult result) {
        printScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


}