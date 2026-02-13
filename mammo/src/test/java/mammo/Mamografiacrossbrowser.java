package mammo;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mamografiacrossbrowser {
	WebDriver driver;

//	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://drjoysmammografia.com/");
		driver.manage().window().maximize();
	}

	//@Test(priority = 1)

	public void Login() throws InterruptedException {
		
	

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[9]/a")).click();

		Thread.sleep(2000);

		driver.switchTo().frame("myIfr");

		Actions action = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]"));
		action.click(option).build().perform();

		Thread.sleep(1000);

		 
		
		 driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
		 driver.findElement(By.name("password")).sendKeys("bini123");
		
		 driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
		 driver.close();
	}

	//@Test 
	
	public void Gallery() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://drjoysmedstore.com/mamoTestLive");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Thread.sleep(6000);
		 driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		 Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/main/section/div/div/div/div[3]/a")).click();
		

		driver.close();
	}
		//@Test	
		public void Package() throws InterruptedException {
		

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Thread.sleep(6000);
			 driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();
			
			 
			
			  driver.switchTo().frame("myIfr");
			  Thread.sleep(1000);
			 
			 driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
			 Thread.sleep(1000);
			 driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
			 Thread.sleep(1000);
			 driver.findElement(By.name("password")).sendKeys("bini123");
			 Thread.sleep(1000);
			 driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();

			 Thread.sleep(1000);
			 
			 driver.switchTo().defaultContent();
			 WebElement l =driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
			 JavascriptExecutor j = (JavascriptExecutor) driver;
			  j.executeScript("arguments[0].click();", l);
	       
			  Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[2]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[starts-with(text(),'Buy Now')]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"check1\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"packageform\"]/div/div/div[7]/div/button[1]")).click();
	        driver.close()	;	
	}
	
		//@Test
		public void Pageconfirmation() throws InterruptedException {
			
			Actions action = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a"));
			action.click(elementToClick).build().perform();
			Thread.sleep(2000);
			
			String url = driver.getCurrentUrl();
			Thread.sleep(1000);
			if (url.contains("https://drjoysmammografia.com/About-Breast-Cancer.php")) {
				
				System.out.println("correct page opened");

			} else {

				System.out.println("incorrect page");
			}

			WebElement element = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[5]/a"));
			element.click();
			
			if(element.isSelected())
					{

				  System.out.println("gallery page opens");
				   }
				   else {
				   System.out.println("incorrect page");

				}
			Thread.sleep(1000);
			 driver.findElement(By.xpath("//*[starts-with(text(),'Blog')]")).click();
			
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://drjoysmammografia.com/Blog.php" );
			System.out.println("URL matching --> Part executed");
			
			driver.close()	;	
	}
		
		//@Test
		public void Blogpage() throws InterruptedException {
			
			
			try {
				Thread.sleep(1000);
				WebElement element = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[6]/a"));

				if (element.isDisplayed() && element.isEnabled()) {
					element.click();
				}

			
			} catch (Exception e) {

			driver.findElement(By.xpath("//*[contains(text(),'Breast cancer')]")).click();
			
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://drjoysmammografia.com/Blog-details.php" );
			
            driver.close();
			
			
			}}
		
		//@Test
		public void quicklinks () throws InterruptedException {
			
			
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,2000)");
			
			driver.findElement(By.xpath("/html/body/footer/div/div/div/div/div[2]/div/ul/li[2]/a")).click();
			
			String URL = driver.getCurrentUrl();
			Assert.assertEquals(URL, "https://drjoysmammografia.com/package.php" );
			System.out.println("URL matching --> Part executed");
			

		    jse.executeScript("window.scrollBy(0,500)");
			
		    Thread.sleep(2000);
		    
		    Actions action = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Contact us')]"));
			action.click(elementToClick).build().perform();
			
			Thread.sleep(2000);
			String URL1 = driver.getCurrentUrl();
			Assert.assertEquals(URL1, "https://drjoysmammografia.com/Contact.php");
			System.out.println("URL matching ");
			
	
			driver.close()	;	
}
//@Test
public void enquiry () throws InterruptedException {
	
	
	
	try {
		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("/html/body/a[1]/span"));

		if (element.isDisplayed() && element.isEnabled()) {
			element.click();
		}

	
	} catch (Exception e) {
Thread.sleep(1000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('name').setAttribute('value', 'bb');"
				+ "document.getElementById('phone').setAttribute('value', '6254187923');"
				+ "document.getElementById('email').setAttribute('value', 'bb1234@gmail.com');"
				+ "document.getElementById('notes').setAttribute('value', 'test')");
	Thread.sleep(2000);
	
		 Actions action = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.id("save"));
			action.click(elementToClick).build().perform();
			
			
			driver.close();
}}

//@Test
public void getintouchpage() throws InterruptedException {
;
	
	JavascriptExecutor jse = (JavascriptExecutor)driver;
	jse.executeScript("window.scrollBy(0,2000)");
	
	
	 Actions action = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//*[contains(text(),'contact@drjoysmammographia.com')]"));
		action.click(option).build().perform();
		
	
	boolean displayStatus = option.isDisplayed();
	if (displayStatus) {
		System.out.println("mail page opened");
	} else {
		System.out.println("mail page closed");
	}
	
	

}

	//@Test	
	public void companylinks() throws InterruptedException {
		
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,2000)");
		
		driver.findElement(By.xpath("/html/body/footer/div/div/div/div/div[3]/div/ul/li[1]/a")).click();
		
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://drjoysmammografia.com/terms-conditions.php" );
		System.out.println("URL matching --> Part executed");
		

	    jse.executeScript("window.scrollBy(0,1000)");
		
	    jse.executeScript("window.scrollBy(0,500)");
		
	    Thread.sleep(2000);
	    
	    Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("/html/body/footer/div/div/div/div/div[3]/div/ul/li[2]/a"));
		action.click(elementToClick).build().perform();
		
		Thread.sleep(2000);
		String URL1 = driver.getCurrentUrl();
		Assert.assertEquals(URL1, "https://drjoysmammografia.com/Privacy-Policy.php");
		System.out.println("URL matching ");
		
		driver.close();
	}

//@Test
public void logo() throws InterruptedException {
	

	Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("//*[contains(@src,'assets/img/joyslogs.png')]"));
	element.click();
	
	boolean displayStatus = element.isDisplayed();
	if (displayStatus) {
		System.out.println("redirects to homepage");
	} else {
		System.out.println("wrong page");
	}
	
	
	driver.close();
	
	}


//@Test
public void subscribe() throws InterruptedException {
	
	
	
    Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[7]/a"));
	element.click();

	Thread.sleep(2000);
	 Actions action = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//*[contains(text(),'contact@drjoysmammographia.com')]"));
		action.click(option).build().perform();
	
	
	String actualTitle = driver.getTitle();
	String expectedTitle = "Dr.Joy's Mamografia- Digital Mamography Center";
	
	Assert.assertEquals(expectedTitle,actualTitle);

}

//@Test
public void CCAvenue() throws InterruptedException, AWTException {
	
	
	
	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[9]/a")).click();

	Thread.sleep(2000);

	driver.switchTo().frame("myIfr");

	Actions action = new Actions(driver);
	WebElement option = driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]"));
	action.click(option).build().perform();

	Thread.sleep(1000);

	driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
	driver.findElement(By.name("password")).sendKeys("bini123");

	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();

	Thread.sleep(2000);

	Actions action1 = new Actions(driver);
	WebElement option1 = driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul/li[7]/a"));
	action1.click(option1).build().perform();

	driver.findElement(By.xpath("//*[@id=\"customers-testimonials\"]/div[1]/div/div[3]/div/button ")).click();
	
	WebElement radioElement = driver.findElement(By.xpath("//*[@id=\"check1\"]"));
	radioElement.click();
		
		
		
}


		
		
		
}
