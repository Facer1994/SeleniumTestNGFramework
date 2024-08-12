package com.testcomponents;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pages.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseTest {
 WebDriver driver;

    public LandingPage lp;
    public WebDriver initialization() throws IOException {
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//com//resouces//Globaldata.properties");
        Properties prop = new Properties();
        prop.load(fis);
        String browserName=System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();

        }
        driver.manage().window().maximize();
        return driver;

    }

    public List<HashMap<String, String>> getjsonData(String filepath) throws IOException {
        //Read JSON to String
        String jsonContent= FileUtils.readFileToString(new File(filepath), StandardCharsets.UTF_8);
        //String to HashMap
        ObjectMapper om = new ObjectMapper();
        List<HashMap<String,String>>data=om.readValue(jsonContent, new TypeReference<List<HashMap<String,String>>>() {
        });
        return data;
    }

    @BeforeMethod(alwaysRun = true)
    public LandingPage launchApplication() throws IOException {
        driver=initialization();
        lp = new LandingPage(driver);
        lp.goTo();
        return lp;
    }
    @AfterMethod(alwaysRun = true)
    public void teardown()
    {
        driver.close();
    }


    public String getScreenshot(String testcasename) throws IOException {
        TakesScreenshot ts=  (TakesScreenshot)driver;
        File fl= new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
        File source=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(source,fl);
        return System.getProperty("user.dir")+"//reports//"+testcasename+".png";


    }
}
