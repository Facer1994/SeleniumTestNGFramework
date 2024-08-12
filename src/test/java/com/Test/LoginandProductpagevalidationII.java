package com.Test;

import com.pages.CartValidation;
import com.pages.ValidateProduct;
import com.testcomponents.BaseTest;
import com.testcomponents.Retry;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginandProductpagevalidationII extends BaseTest {
    WebDriver driver;


    @FindBy(xpath = "//div[@class='form-group']/child::input")
    WebElement userNametxt;

    @FindBy(xpath = "//input[@id='userPassword']")
    WebElement passtxt;

    @FindBy(xpath = "//input[@name='login']")
    WebElement logbtn;

    @FindBy(xpath = "//div[@id='toast-container']")
    WebElement successMsg;

    @FindBy(xpath = "//div[contains(@class,'ngx-spinner')]//child::div[contains(@class,'ng-star-inserted')][position()=2]")
    WebElement ngxspinner;

    @FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
    WebElement CartBtnHeader;

    @FindBy(xpath = "//button[text()='Checkout']")
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

    @FindBy(xpath = "//i[@class='fa fa-shopping-cart']//parent::button")
    WebElement addcartbtn;

    @Test(dataProvider = "getData",retryAnalyzer = Retry.class)
    public void submitorder(HashMap<String, String> input) throws IOException {


        //PageFactory.initElements(driver,this);
        System.out.println(input.get("UserName"));
        ValidateProduct vp = lp.login(input.get("UserName"), input.get("passWord"));
        List<WebElement> pdlist = vp.validateprodlist();
        vp.productcompare(input.get("prodName"));
        CartValidation cv = vp.successMsgValid();
        cv.cartvalidation();


        //SeleniumMethods.waitMethod(userNametxt);

//       List<WebElement>ele= driver.findElements(By.cssSelector(".mb-3"));
//       WebElement pd =ele.stream().filter(prods->prods.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
//       pd.findElement(By.cssSelector(".card-body button:last-of-type")).click();


    }

    @DataProvider
    public Object[][] getData() throws IOException {
    List<HashMap<String,String>> dt=getjsonData(System.getProperty("user.dir")+"//src//test//java//com//data//testData.json");
    return new  Object[][]{{dt.get(0)},{dt.get(1)}};
    }
//
//    public String getScreenshot(String testcasename) throws IOException {
//       TakesScreenshot ts=  (TakesScreenshot)driver;
//       File fl= new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
//       File source=ts.getScreenshotAs(OutputType.FILE);
//        FileUtils.copyFile(source,fl);
//        return System.getProperty("user.dir")+"//reports//"+testcasename+".png";
//
//
//    }
//    @DataProvider
//    public Object[][] getData() {
//        HashMap<String, String> data= new HashMap<String, String>();
//        data.put("UserName","krish@test.com");
//        data.put("passWord","Test@1234");
//        data.put("prodName","IPHONE 13 PRO");
//        return new Object[][]{{data}};
//    }
//    @DataProvider
//    public Object[][] getData() {
//
//        return new Object[][]{{"Test123","1234"}};
//    }

//   @Test
//   public void invalidcredentials(){
//       ValidateProduct vp=lp.login("krish@test1.com","Test@11234");
//    }
////   @Test(priority = 2)
////   public void validateprodlist() throws InterruptedException {
////
//////       WebElement ele= driver.findElement(By.xpath("(//div[contains(@class,'mb-3')]//child::div[@class='card-body']//descendant::b)[1]"));
////////       SeleniumMethods.waitMethod3(ele);
////       Thread.sleep(1000);
//// List<WebElement> prodlist=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]//child::div[@class='card-body']//descendant::b"));
//// for(int i=0;i<prodlist.size();i++)
//// {
////     if(prodlist.get(i).getText().equalsIgnoreCase("IPHONE 13 PRO")){
////         List<WebElement> cartbtn= driver.findElements(By.xpath("//div[@class='card-body']//descendant::button[position()=2]"));
////         cartbtn.get(i).click();
////     }
//// }
//
//
//
//   }
//   @Test(priority = 3)
//   public void successmsgvalidation()
//   {
//       if(SeleniumMethods.waitMethod4(ngxspinner)==true) {
//           System.out.println("Spinner is  Visible");
//           if (SeleniumMethods.waitMethod3(successMsg) == true) {
//               System.out.println("Success Notification appeared successfully");
//           }
//       }
//   }

//   @Test(priority = 4)
//   public void cartvalidation()
//   {
//       SeleniumMethods.waitMethod3(CartBtnHeader);
//       Actions ac = new Actions(driver);
//       ac.moveToElement(CartBtnHeader).build().perform();
//        CartBtnHeader.click();
//        SeleniumMethods.waitMethod3(checkBtn);
//        checkBtn.click();
//       SeleniumMethods.waitMethod3(autosuggestiveTxtbox);
//       autosuggestiveTxtbox.sendKeys("INDIA");
//       SeleniumMethods.waitMethod3(autosuggestlistselect);
//       autosuggestlistselect.click();
//       System.out.println("Clicking on the place order button");
//       placeOrderbtn.click();
//   }


//   @Test(priority = 5 )
//   public void teardown() throws InterruptedException {
//       Thread.sleep(20);
//       driver.close();
//   }

}

