package bb;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;


public class Demotest {
WebDriver driver;

@BeforeMethod
public void setup() {
System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://drjoysmedstore.com/drugstore/login.php");

}
@Test(priority=1)
public void screenshot() throws IOException {
	
	TakesScreenshot ts=(TakesScreenshot)driver;
    File source=ts.getScreenshotAs(OutputType.FILE);
	File destination=new File("C:\\Users\\computer-2\\Pictures\\Saved Pictures\\screenshot.png");
	FileUtils.copyFile(source,destination);
	System.out.println("ss taken successfully");
	
	String parentWindow=driver.getWindowHandle();
	Set<String>allWindows=driver.getWindowHandles();
	for(String window:allWindows) {
		if (!window.equals(parentWindow)) {
		    driver.switchTo().window(window);
		
		}
		
	}}
	@DataProvider(name="loginData")
	public Object[][] logintest(){
	return new Object[][] {
		{"priya","dundu"},
		{"priya","dund"},
		{"priy","dundu"},
		{"",""},
	};	
	}
@Test(dataProvider="loginData")	
	public void loginscenarios(String username,String password)	{
	  try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
	        WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

	        Username.clear();
	        Username.sendKeys(username);

	        Password.clear();
	        Password.sendKeys(password);

	        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
	        login.click();
	        if(username.equals("priya")&& password.equals("dundu")) {
	        	System.out.println("login success");
	        }else {
	        	System.out.println("Invalid login attempt ");
	            
	        }
	    } catch(Exception e) {
	        System.err.println("exception occured while logging in"+e.getMessage());
	        
	      
	    }
	}
@AfterMethod
public void teardown() {
	driver.close();
}

}