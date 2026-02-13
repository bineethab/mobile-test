package mamotest;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Admin {
	//@Test 
		public void AdminLogin() throws InterruptedException {
			
		WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
			driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
		
			WebElement message = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/h1"));
	        String value = message.getText();
	        assertEquals("Welcome Administrator", value);
			
	   
			}
		//@Test
		public void InvalidLogin() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			WebElement username = driver.findElement(By.xpath("//*[@id=\"yourUsername\"]"));
            username.sendKeys("user");
			
            WebElement password = driver.findElement(By.xpath("//*[@id=\"yourPassword\"]"));
            password.sendKeys("user1");
			

			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
			
			String title = driver.getTitle();
			if (title.contains("https://drjoysmedstore.com/mamoTestLive/admin/dashboard.php ")) {
				System.out.println("correct title");

			} else {

				System.out.println("incorrect title");
			}
		  
	}
		//@Test
		public void AppointmentAdmin(WebDriver driver) throws InterruptedException {
			try{
			WebDriverManager.chromedriver().setup();
			WebDriver driver1= new ChromeDriver();
			
			driver1.manage().window().maximize();
			driver1.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");
            driver1.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            WebElement username = driver1.findElement(By.xpath("//*[@id=\"yourUsername\"]"));
            username.sendKeys("user");
			
            WebElement password = driver1.findElement(By.xpath("//*[@id=\"yourPassword\"]"));
            password.sendKeys("user");
		
			driver1.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
			Thread.sleep(2000);
			
			driver1.findElement(By.xpath("/html/body/div[2]/div[1]/aside/div/nav/ul/li[2]/a")).click();
			Thread.sleep(1000);
			driver1.findElement(By.xpath("/html/body/div[2]/div[1]/aside/div/nav/ul/li[2]/ul/li[1]/a")).click();
			Thread.sleep(2000);
			driver1.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div/table/tbody/tr[1]/td[5]/span")).click();
			
			Thread.sleep(1000);
			
			driver1.findElement(By.xpath("//*[@id=\"appnmt_fixedfor\"]")).sendKeys("14-03-2023");
			

			} catch (Exception e) {
			//driver.findElement(By.xpath("//*[@id=\"update\"]")).click();
			Actions action1 = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"update\"]"));
			action1.click(elementToClick).build().perform();
			}

		}
			
	
		//@Test
		public void AppointmentFix() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
			driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/div[2]/div[1]/aside/div/nav/ul/li[2]/a")).click();
			Thread.sleep(1000);	

			driver.findElement(By.xpath("/html/body/div[2]/div[1]/aside/div/nav/ul/li[2]/ul/li[2]/a")).click();
			Thread.sleep(4000);
		
			driver.findElement(By.xpath("//*[@id=\"showat\"]/input")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[4]/input")).sendKeys("14-03-2023");
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
			
			 
			Thread.sleep(4000);

			driver.findElement(By.xpath("//*[@id=\"complete\"]/input")).click();
		
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div[2]/div/table/tbody/tr/td[5]/input")).sendKeys("14-03-2023");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"comp2\"]/button[1]")).click();
				
			driver.quit()	;
			}
		//@Test
		public void AddPackage() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
			driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
		
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[4]/a/p")).click();
			Thread.sleep(1000);	
			
			driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/div[1]/button")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('').setAttribute('value', 'option 4');"
					+ "document.getElementById('packagename').setAttribute('value', '10000');"
					+ "document.getElementById('packageprice').setAttribute('value', '12');"
					+ "document.getElementById('packageperiod').setAttribute('value', '');"
					+ "document.getElementById('PackageInstallments').setAttribute('value', '10');"
					+ "document.getElementById('package_topay').setAttribute('value', '3000');"
					+ "document.getElementById('package_further').setAttribute('value', '7000');"
					+ "document.getElementById('PackageVisits').setAttribute('value', '12');"
					+ "document.getElementById('PackageTerms').setAttribute('value', 'test')");
					
			
			driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[6]/div/div/div[3]/div[2]")).sendKeys("test");
			driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[7]/div/div/div[3]/div[2]")).sendKeys("Ultrasound & mammography(both breasts),Mammography(single breast),Mammography(both breasts)");
			
			driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[8]/button")).click();
			 Thread.sleep(2000);
				Alert alert=driver.switchTo().alert();
			    String alertMessage=driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				alert.accept();
				
		}
		
	//@Test
		
		public void EditPackage() throws InterruptedException {
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
			driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
			
			Actions action1 = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[4]/a"));
			action1.click(elementToClick).build().perform();
			Thread.sleep(1000);

			Actions action = new Actions(driver);
			WebElement element = driver.findElement(By.xpath("//*[contains(@class,'fas fa-edit')]"));
			action.click(element).build().perform();
			
		
			WebElement element1 = driver.findElement(By.xpath("//*[@id=\"package_terms\"]"));
			element1.sendKeys(Keys.CONTROL + "a");
			element1.sendKeys(Keys.DELETE);
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//*[@id=\"package_terms\"]")).sendKeys("1");
			Thread.sleep(1000);
			

			WebElement element4 = driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[9]/button"));
			element4.click();
			
			
		}
		
		//@Test

		public void Subscriber() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
			driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
			
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[5]/a")).click();
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('date_from').setAttribute('value', '01-02-2023 ');"
					       + "document.getElementById('date_to').setAttribute('value', '28-02-2023')");
					
		    Thread.sleep(1000);
	
			driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
	       
	}

		//@Test
		
		public void Payment() throws InterruptedException {
			
			WebDriverManager.chromedriver().setup();
			WebDriver driver= new ChromeDriver();
			driver.manage().window().maximize();
			
			driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			
			driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
			driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[6]/a")).click();
			driver.findElement(By.xpath("//*[@id=\"complete\"]/input")).click();
			Thread.sleep(1000);
			   Select a=new Select(driver.findElement(By.xpath("//*[@id=\"status\"]")));
				a.selectByVisibleText("Verified");
			
			
			
			}
			// @Test

			public void MedicalRecords() throws InterruptedException {

				WebDriverManager.chromedriver().setup();
				WebDriver driver = new ChromeDriver();
				driver.manage().window().maximize();

				driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

				driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
				driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

				Thread.sleep(2000);
				driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
				Thread.sleep(2000);

				driver.findElement(By.xpath("//*[@id=\"test\"]/a/p")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"test\"]/ul/li[2]/a/p")).click();
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[@id=\"2\"]/td[5]/button")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/div[1]/button")).click();
				Thread.sleep(1000);

				Select a = new Select(driver.findElement(By.name("type")));
				a.selectByVisibleText("Mammogram");

				driver.findElement(By.xpath("//*[@id=\"date\"]")).sendKeys("04-04-2023");
				driver.findElement(By.xpath("//*[@id=\"time\"]")).sendKeys("09:30");
				Thread.sleep(1000);

				driver.findElement(By.xpath("//*[contains(text(),'Files Upload')]")).click();

				driver.findElement(By.xpath("//*[@id='files']"))
						.sendKeys("C:\\Users\\BINEETHA\\Desktop\\New folder\\io.jpg");
				Thread.sleep(1000);
				driver.findElement(By.xpath("//*[@id=\"submitfile\"]")).click();

				Alert alert = driver.switchTo().alert();
				String alertMessage = driver.switchTo().alert().getText();
				System.out.println(alertMessage);
				alert.accept();
				driver.quit();

			}
	//@Test

	public void UserAdd() throws InterruptedException{
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
		
		driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[1]/ul/li/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[2]/div/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		

        WebElement username = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        username.sendKeys("anu");
	
		Thread.sleep(1000);
		 WebElement password = driver.findElement(By.xpath("//*[@id=\"displayname\"]"));
	        password.sendKeys("anu");
		
		
		driver.findElement(By.xpath("//*[@id=\"displayname\"]")).sendKeys("Anu");
		Select a=new Select(driver.findElement(By.name("role")));
			a.selectByVisibleText("Staff");
		
			Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("9656931233");
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("anu56@gmail.com");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[5]/button")).click();
		driver.quit();
		
		
		
	}
	//@Test

	public void UserEdit() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://drjoysmedstore.com/mamoTestLive/admin/login.php");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		
		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");
		driver.findElement(By.xpath("/html/body/div/div[2]/div/form/div[3]/div/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"sidebar\"]/nav/ul/li[1]/ul/li/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"example2\"]/tbody/tr[3]/td[4]/span")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[5]/div/div/div[3]/div[2]")).sendKeys("admin");
		
	    Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"status\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[6]/button")).click();
		
		Thread.sleep(2000); 
		  Alert alert=driver.switchTo().alert(); 
		  String alertMessage=driver.switchTo().alert().getText();
		  System.out.println(alertMessage);
		  alert.accept();
		  driver.quit();

		
	}
}
