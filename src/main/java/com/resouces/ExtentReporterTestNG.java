package com.resouces;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ExtentReporterTestNG {
    public static ExtentReports getReportObject()  {
        //FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//reports//index.html");
        String path = System.getProperty("user.dir")+"//reports//index.html";
        ExtentSparkReporter reporter= new ExtentSparkReporter(String.valueOf(path));
        reporter.config().setReportName("Web Automation Result");
        reporter.config().setDocumentTitle("Test Results");
        ExtentReports ext= new ExtentReports();
        ext.attachReporter(reporter);
        ext.setSystemInfo("Tester","Jai");
        return ext;

    }
}
