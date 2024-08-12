package com.testcomponents;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
//import com.resouces.ExtentReporter;
import com.resouces.ExtentReporterTestNG;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Listeners extends BaseTest implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterTestNG.getReportObject();
    ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
    String filepath= null;

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
       extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
        extenttest.set(test);// unique thread id
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extenttest.get().fail(result.getThrowable());
        try {
            driver= (WebDriver)result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
           filepath=getScreenshot(result.getMethod().getMethodName());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        extenttest.get().addScreenCaptureFromPath(filepath,result.getMethod().getMethodName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extenttest.get().log(Status.PASS,"Test Passed");
    }
}
