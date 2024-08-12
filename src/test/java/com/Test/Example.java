package com.Test;

import com.helpers.SeleniumMethods;
import com.testcomponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//package com.Test;
//
//import com.helpers.SeleniumMethods;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
//
//import java.util.List;
//
public class Example extends BaseTest {


     WebDriver driver;


    @FindBy(xpath = "//div[@class='form-group']/child::input")
     WebElement userNametxt;

    @FindBy(xpath = "//input[@id='userPassword']")
     WebElement passtxt;

    @FindBy(xpath="//input[@name='login']")
    WebElement logbtn;

    @FindBy(xpath="//div[@id='toast-container']")
    WebElement successMsg;

    @FindBy(xpath = "//div[contains(@class,'ngx-spinner')]//child::div[contains(@class,'ng-star-inserted')][position()=2]")
    WebElement ngxspinner;

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


//    public String cartbtn(int val)
//    {
//        return "(//i[@class='fa fa-shopping-cart']/parent::button)['"+val+"']";
//    }

    @FindBy(xpath="//i[@class='fa fa-shopping-cart']//parent::button")
    WebElement addcartbtn;

   @Test
   public  void login()
   {
    lp.login("test","1234");
//       List<WebElement>ele= driver.findElements(By.cssSelector(".mb-3"));
//       WebElement pd =ele.stream().filter(prods->prods.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//       pd.findElement(By.cssSelector(".card-body button:last-of-type")).click();


   }



//   @Test(priority = 5 )
//   public void teardown() throws InterruptedException {
//       Thread.sleep(20);
//       driver.close();
//   }

}
