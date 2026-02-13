package mammografia;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class mammo{
	
	 
	// @Test
	    public void login() throws MalformedURLException, InterruptedException {
		
				DesiredCapabilities Capabilities= new DesiredCapabilities();
					
				    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
					Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
					Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
					Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
					
					Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
					
					URL url= new URL("http://localhost:4723/wd/hub");
					WebDriver driver= new AndroidDriver(url,Capabilities);
					
			
					driver.get("https://drjoysmammografia.com");
			
					driver.findElement(By.xpath("//*[contains(@class,'navbar-toggler-icon')]")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[9]/a")).click();
					
					driver.switchTo().frame("myIfr");
					Thread.sleep(2000);
					
					driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
				
					//driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
					
					Thread.sleep(4000);
					driver.findElement(By.xpath("//*[@id=\"registerForm\"]/input[1]")).sendKeys("beenabineetha@gmail.com");
					driver.findElement(By.xpath("//*[@id=\"registerForm\"]/input[2]")).sendKeys("bini123");
		            Thread.sleep(2000);
					driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();

					
			}
	// @Test
	 public void Appointment() throws MalformedURLException, InterruptedException {
		 
		 DesiredCapabilities Capabilities= new DesiredCapabilities();
			
		    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
			
			Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
			
			URL url= new URL("http://localhost:4723/wd/hub");
			WebDriver driver= new AndroidDriver(url,Capabilities);
			
			driver.get("https://drjoysmammografia.com");
			Thread.sleep(6000);
			driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			driver.switchTo().frame("myIfr");
			driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
			driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
			driver.findElement(By.name("password")).sendKeys("bini123");

			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			WebElement l = driver.findElement(By.xpath("//*[@data-dismiss='modal']"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", l);

			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[starts-with(text(),'Appointment')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[2]/div/div/div/div[1]/span[2]/a")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"date\"]")).sendKeys("24-01-2023");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"time\"]")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"time\"]")).sendKeys("15:36");
			driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
			Thread.sleep(2000);
			Alert alert = driver.switchTo().alert();
			String alertMessage = driver.switchTo().alert().getText();
			System.out.println(alertMessage);
			alert.accept();
			driver.quit();

}
	 @Test
 public void AppointmentWithoutLogin() throws InterruptedException, MalformedURLException {
		 
		 DesiredCapabilities Capabilities= new DesiredCapabilities();
			
		    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
			
			Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
			
			URL url= new URL("http://localhost:4723/wd/hub");
			WebDriver driver= new AndroidDriver(url,Capabilities);
			
			driver.get("https://drjoysmammografia.com");
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[starts-with(text(),'Appointment')]")).click();
			Thread.sleep(1000);

			driver.quit();


}
	 @Test
	 public void PackageWithoutLogin() throws InterruptedException, MalformedURLException {	 

		 DesiredCapabilities Capabilities= new DesiredCapabilities();
			
		    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
			
			Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
			
			URL url= new URL("http://localhost:4723/wd/hub");
			WebDriver driver= new AndroidDriver(url,Capabilities);
			driver.get("https://drjoysmammografia.com");
		 driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul/li[3]/a")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[2]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div[1]/div/div[2]/div/button")).click();
			driver.quit();


}
	 @Test
	 public void AppDetailsWithoutLogin() throws InterruptedException, MalformedURLException {	 


	 DesiredCapabilities Capabilities= new DesiredCapabilities();
		
	    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
		Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
		Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
		
		Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
		
		URL url= new URL("http://localhost:4723/wd/hub");
		WebDriver driver= new AndroidDriver(url,Capabilities);
		
		driver.get("https://drjoysmammografia.com");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[starts-with(text(),'Appointment')]")).click();
		driver.quit();




}
	 @Test
	 public void AppointmentDetails() throws InterruptedException, MalformedURLException {
	 DesiredCapabilities Capabilities= new DesiredCapabilities();
		
	    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
		Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
		Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
		Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
		
		Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
		
		URL url= new URL("http://localhost:4723/wd/hub");
		WebDriver driver= new AndroidDriver(url,Capabilities);
	 
		driver.get("https://drjoysmammografia.com");
        Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("myIfr");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
		driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("bini123");

		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		WebElement l = driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/div/ul/li[2]")).click();

	 
	 
}
	@Test
	
	public void AccountEdit() throws InterruptedException, MalformedURLException {
	
	 DesiredCapabilities Capabilities= new DesiredCapabilities();
	
    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
	Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
	Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
	Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
	
	Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
	
	URL url= new URL("http://localhost:4723/wd/hub");
	WebDriver driver= new AndroidDriver(url,Capabilities);
 
	driver.get("https://drjoysmammografia.com");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();

	Thread.sleep(1000);

	driver.switchTo().frame("myIfr");
	driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
	driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
	driver.findElement(By.name("password")).sendKeys("bini123");

	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
	Thread.sleep(2000);
	driver.switchTo().defaultContent();

	WebElement l = driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
	JavascriptExecutor j = (JavascriptExecutor) driver;
	j.executeScript("arguments[0].click();", l);
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[2]/div/div[3]/div/h5/a")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"userForm\"]/div/div[3]/div[1]/div[4]/input")).sendKeys("12");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
	driver.quit();

	}

	 @Test
	public void PackageDetails() throws InterruptedException, MalformedURLException {

		 DesiredCapabilities Capabilities= new DesiredCapabilities();
			
		    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
			
			Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
			
			URL url= new URL("http://localhost:4723/wd/hub");
			WebDriver driver= new AndroidDriver(url,Capabilities);
		 
			driver.get("https://drjoysmammografia.com");
			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
			Thread.sleep(1000);
			driver.switchTo().frame("myIfr");

			driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
			driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
			driver.findElement(By.name("password")).sendKeys("bini123");

			driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
			Thread.sleep(2000);
			driver.switchTo().defaultContent();

			WebElement l = driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();", l);
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"packagedetails\"]")).click();









}
	 @Test
	 public void enquiry () throws InterruptedException, MalformedURLException {
		 
		 DesiredCapabilities Capabilities= new DesiredCapabilities();
			
		    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
			
			Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
			
			URL url= new URL("http://localhost:4723/wd/hub");
			WebDriver driver= new AndroidDriver(url,Capabilities);
		 
			
			Thread.sleep(1000);
			
			driver.get("https://drjoysmammografia.com");
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
			@Test
			public void Pageconfirmation() throws InterruptedException, MalformedURLException {

				 DesiredCapabilities Capabilities= new DesiredCapabilities();
					
				    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
					Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
					Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
					Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
					
					Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\114.0.5735.90\\chromedriver.exe");
					
					URL url= new URL("http://localhost:4723/wd/hub");
					WebDriver driver= new AndroidDriver(url,Capabilities);
				 
					
					Thread.sleep(1000);
					
					driver.get("https://drjoysmammografia.com");


					Actions action = new Actions(driver);
					WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[2]/a"));
					action.click(elementToClick).build().perform();
					Thread.sleep(2000);
					
					String url1 = driver.getCurrentUrl();
					Thread.sleep(1000);
					if (url1.contains("https://drjoysmammografia.com/About-Breast-Cancer.php")) {
						
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

			}}








































