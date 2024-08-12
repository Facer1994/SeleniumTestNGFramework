package com.pages;

import com.helpers.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends SeleniumMethods {
    WebDriver driver;

    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//div[@class='form-group']/child::input")
    WebElement userNametxt;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement passtxt;

    @FindBy(xpath="//input[@name='login']")
    WebElement logbtn;

    public ValidateProduct login(String email, String pass)
    {
        userNametxt.sendKeys(email);
        passtxt.sendKeys(pass);
        logbtn.click();
        ValidateProduct vp= new ValidateProduct(driver);
        return vp;
    }

    public void goTo()
    {
        driver.get("https://rahulshettyacademy.com/client");
    }

}
