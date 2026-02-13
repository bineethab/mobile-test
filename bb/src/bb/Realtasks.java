package bb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Realtasks {
WebDriver driver;
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://automationexercise.com/");
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
}
@Test
public void test() throws InterruptedException {
	WebElement signup=driver.findElement(By.xpath("//a[@href='/login']"));
	signup.click();
	//verify page title
	
	
	String ExpectedUrl="https://automationexercise.com/login";
	String CurrentUrl=driver.getCurrentUrl();
	Assert.assertEquals("https://automationexercise.com/login",CurrentUrl );
	
	//login
	WebElement username=driver.findElement(By.name("email"));
	WebElement password=driver.findElement(By.name("password"));
	
	username.sendKeys("ee1@gmail.com");
	password.sendKeys("bini");
	WebElement Login=driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
	Login.click();
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement logoutbutton=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Logout']")));
	if(logoutbutton.isDisplayed()) {
		System.out.println("login success");
	}else {
		System.out.println("login fails");
	}
	
   WebElement productsbutton=driver.findElement(By.xpath("//a[@href='/products']")) ;
   productsbutton.click();
    //page verification
   WebElement pagewords=driver.findElement(By.xpath("//h2[contains(.,'All Products')]"));
   Assert.assertTrue(pagewords.isDisplayed(), "'All Products' words are not present");
   
 //search
   
    WebElement search=driver.findElement(By.id("search_product"));
    search.sendKeys("b");
    WebElement searchicon=driver.findElement(By.id("submit_search"));
   searchicon.click();
   
   List<WebElement>searchresults=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='features_items']//div[@class='col-sm-4']")));
   System.out.println("products found:"+searchresults.size());
   if(searchresults.size()==10) {
	   System.out.println("products count are correct");
   }else {
	   System.out.println("products count are incorrect");
   }
   
   for (WebElement result : searchresults) {
	    try {
	        WebElement nameElement = result.findElement(By.tagName("p"));
	        String productName = nameElement.getText();
	        System.out.println("Product Name: " + productName);
	    } catch (Exception e) {
	        System.out.println("Product name not found for one item.");
	    }
	}
   //addtocart
   WebElement addtocart=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn btn-default add-to-cart'][1]"))) ; 
   JavascriptExecutor js=(JavascriptExecutor)driver;
   
   js.executeScript("arguments[0].scrollIntoView(true);", addtocart);
   js.executeScript("arguments[0].click();", addtocart);
		  
		  WebElement continueshopping=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Continue Shopping')]")));
		 
		if(continueshopping.isDisplayed()) {
			 System.out.println("product is added to cart successfully ");
			 continueshopping.click();
		}else {
			 System.out.println("product is not added to cart successfully ");
		}
		
		//product page
		
		WebElement prodpage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'View Product')]")));
		prodpage.click();
		
		WebElement qnty=wait.until(ExpectedConditions.elementToBeClickable(By.id("quantity")));
		qnty.clear();
		qnty.sendKeys("2");
		
		System.out.println("qnty is increased to 2");
		
		WebElement button=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Add to cart')]")));
		button.click();
		
		WebElement viewbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'/view_cart')]")));
		viewbutton.click();
		
		//verify
		
		WebElement cartcount=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_quantity']/button")));
		String count=cartcount.getText().trim();
		System.out.println("Actual cart count: " + count);
	if(count.equals("3")) {
		System.out.println("count is increased to 3");
	}else {
		System.out.println("count is not increased to 3");
		 }
double total=0.0;	
try {
	WebElement pricerate =wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_price']")));
    String price=pricerate.getText();
    price=price.replace("Rs.","").replace(",","").trim();
    double pricevalue=Double.parseDouble(price);
    System.out.println("Price value: " + pricevalue);
    
    WebElement qnty1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='cart_quantity']/button")));
    String quantity=qnty1.getText();
    double qntyvalue=Double.parseDouble(quantity);
    System.out.println("qntyvalue: " + qntyvalue);
    
    total=pricevalue * qntyvalue;
    if(total==1500)
    System.out.println("Total: " + total);

    WebElement checkout=driver.findElement(By.xpath("//a[contains(.,'Proceed To Checkout')]"));
    checkout.click();
    
    String Expectedtitle="Automation Exercise - Checkout";
    String Currenttitle=driver.getTitle();
    Assert.assertEquals("Automation Exercise - Checkout", Currenttitle);
    
    WebElement placeorder=driver.findElement(By.xpath("//a[normalize-space()='Place Order']"));
    placeorder.click();
    
    
}catch(Exception e){
	e.printStackTrace();
    Assert.fail("Exception occurred: " + e.getMessage());
	
}
}

@AfterMethod
public void close() {
	//driver.close();
}
}
