package com.pages;

import com.helpers.SeleniumMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ValidateProduct extends SeleniumMethods {
    WebDriver driver;

    public ValidateProduct(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[contains(@class,'mb-3')]//child::div[@class='card-body']//descendant::b")
    List<WebElement> prodlist;

    By proddlist=By.xpath("//div[contains(@class,'mb-3')]//child::div[@class='card-body']//descendant::b");

    @FindBy(xpath = "//div[@class='card-body']//descendant::button[position()=2]")
    List<WebElement>cartbtn;

    @FindBy(xpath="//div[@id='toast-container']")
    WebElement successMsg;

    @FindBy(xpath = "//div[contains(@class,'ngx-spinner')]//child::div[contains(@class,'ng-star-inserted')][position()=2]")
    WebElement ngxspinner;



    public List<WebElement> validateprodlist()  {

//       WebElement ele= driver.findElement(By.xpath("(//div[contains(@class,'mb-3')]//child::div[@class='card-body']//descendant::b)[1]"));
////       SeleniumMethods.waitMethod3(ele);
       // Thread.sleep(1000);

        //List<WebElement> prodlist = driver.findElements(By.xpath("//div[contains(@class,'mb-3')]//child::div[@class='card-body']//descendant::b"));
         elementtobeAppear(proddlist);
         return prodlist;
    }

    public void productcompare(String prdName)
    {
        for (int i = 0; i < validateprodlist().size(); i++) {
            if (prodlist.get(i).getText().equalsIgnoreCase(prdName)) {
                //List<WebElement> cartbtn = driver.findElements(By.xpath("//div[@class='card-body']//descendant::button[position()=2]"));
                cartbtn.get(i).click();
            }
        }
    }

    public CartValidation successMsgValid()
    {
        if(waitMethod4(ngxspinner)==true) {
           System.out.println("Spinner is  Visible");
           if (waitMethod3(successMsg) == true) {
               System.out.println("Success Notification appeared successfully");
           }
       }
        return  new CartValidation(driver);


    }
}
