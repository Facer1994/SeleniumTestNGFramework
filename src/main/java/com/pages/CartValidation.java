package com.pages;

import com.helpers.SeleniumMethods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartValidation extends SeleniumMethods {
    WebDriver driver;
    public CartValidation(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement CartBtnHeader;

    @FindBy(xpath="//button[text()='Checkout']")
    WebElement checkBtn;

    @FindBy(xpath = "//div[@class='form-group']//child::input")
    WebElement autosuggestiveTxtbox;

    @FindBy(xpath = "//button[@class='ta-item list-group-item ng-star-inserted'][position()=2]")
    WebElement autosuggestlistselect;

    @FindBy(xpath = "//a[contains(@class,'action__submit')]")
    WebElement placeOrderbtn;

       public void cartvalidation()
   {
       waitMethod3(CartBtnHeader);
        movetoElement(CartBtnHeader);
        CartBtnHeader.click();
        waitMethod3(checkBtn);
        checkBtn.click();
       waitMethod3(autosuggestiveTxtbox);
       autosuggestiveTxtbox.sendKeys("INDIA");
       waitMethod3(autosuggestlistselect);
       autosuggestlistselect.click();
       System.out.println("Clicking on the place order button");
       placeOrderbtn.click();
   }
}
