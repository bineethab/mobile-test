package mobiletesting;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
public class Mamografia {
	//@Test
	
	public void setup() throws MalformedURLException, InterruptedException {
	
		DesiredCapabilities Capabilities= new DesiredCapabilities();
			
		    Capabilities.setCapability(MobileCapabilityType.BROWSER_NAME,"CHROME");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
			Capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
			Capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"GalaxyA13");
			
			Capabilities.setCapability("chromedriverExecutable","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win64\\117.0.5938.92\\chromedriver.exe");
			
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

			
	}}
	