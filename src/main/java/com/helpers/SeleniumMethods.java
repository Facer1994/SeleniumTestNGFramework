package com.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumMethods {

    WebDriver driver;

    public SeleniumMethods(WebDriver driver)
    {
      this.driver=driver;
    }

    public  void waitMethod(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(d->ele.isDisplayed());
    }

    public  void waitMethod2(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(ele))));
    }
    public void elementtobeAppear(By FindBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(FindBy));
    }
    public  boolean waitMethod3(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.visibilityOf(ele));
        return true;
    }
    public  boolean waitMethod4(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        wait.until(ExpectedConditions.invisibilityOf(ele));
        return true;
    }
    public  void elementtobeClickable(WebElement ele)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
    }

    public void movetoElement(WebElement ele)
    {
        Actions ac = new Actions(driver);
        ac.moveToElement(ele).build().perform();
    }
}
