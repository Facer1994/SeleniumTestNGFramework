//package com.Test;
//
//import com.Pages.Productaddtocart;
//import com.helpers.SeleniumMethods;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;
//
//import java.util.List;
//
//public  class LoginPage {
//
//   static WebDriver  driver;
//
//
//    public LoginPage(){
//        PageFactory.initElements(driver,this);
//
//    }
//
//
//
//
//    @FindBy(xpath = "//input[@type='text']")
//    WebElement userNametxtbox;
//
//    @FindBy(xpath = "//input[@type='password']")
//    WebElement passTxtBox;
//
//    @FindBy(xpath = "//input[@type='submit']")
//    WebElement loginBtn;
//
//    @FindBy(xpath = "//div[@class='inventory_item']/descendant::div[@class='inventory_item_name ']")
//    WebElement listofProdts;
//
//    @FindBy(xpath = "//button[text()='Add to cart']")
//    WebElement addToCartBtn;
//
//    @FindBy(xpath = "//div[@id='shopping_cart_container']")
//    WebElement cartbtn;
//
//
//
//    @Test(dataProvider = "getData")
//    public    void browserlaunch(String url, String Username, String pass) throws InterruptedException {
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(url);
//        PageFactory.initElements(driver,this);
//       // WebDriverWait wait = new WebDriverWait(driver, Duration.of(10));
//        Thread.sleep(1000);
//        userNametxtbox.sendKeys(Username);
//         passTxtBox.sendKeys(pass);
//         loginBtn.click();
//
//    }
//
//    @Test
//    public  void getlistofproducts( )
//    {
//        /*
//
//        Getting the list of products from the page..........................
//         */
//      String valproductname= "Sauce Labs Fleece Jacket";
//        WebElement productvisible = driver.findElement(By.xpath("(//div[@class='inventory_item']/descendant::div[@class='inventory_item_name '])[1]"));
//        SeleniumMethods.waitMethod(productvisible);
//        List<WebElement> product = driver.findElements(By.xpath("//div[@class='inventory_item']/descendant::div[@class='inventory_item_name ']"));
//        for(int i=0;i<product.size();i++)
//        {
//            System.out.println(product.get(i).getText());
//            if(product.get(i).getText().equalsIgnoreCase(valproductname))
//            {
//                List<WebElement> cartbtnClick = driver.findElements(By.xpath("//button[text()='Add to cart']"));
//                cartbtnClick.get(i).click();
//                break;
//
//            }
//        }
//        SeleniumMethods.waitMethod(cartbtn);
//        cartbtn.click();
//
//    }
//
//
//
//
//
//    @DataProvider
//    public Object[][] getData()
//    {
//        Object [][] obj = new Object[1][3];
//        obj[0][0]="https://www.saucedemo.com/";
//        obj[0][1]="standard_user";
//        obj[0][2]="secret_sauce";
//        return obj;
//
//    }
//
//
//
//
//    @Parameters({"URL"})
//    @Test
//    public void paramcheck(String url)
//    {
//      System.out.println(url);
//    }
//
//    @AfterTest
//    public void teardown()
//    {
//        driver.quit();
//    }
//}
