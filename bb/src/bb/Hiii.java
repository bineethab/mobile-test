package bb;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Hiii {
 
	WebDriver driver;
	@BeforeMethod
	public void setup() {
		
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");

		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://drjoysmedstore.com/drugstore/login.php");

		}

@DataProvider(name="test")
public Object[][] test(){
	return new Object[][]{
		{"priya","dundu"},
		{"priya","dund"},
	};
}
@Test(dataProvider="test")
public void login(String username,String password) {
	try {
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

	        WebElement Username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));
	        WebElement Password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

	        Username.clear();
	        Username.sendKeys(username);

	        Password.clear();
	        Password.sendKeys(password);

	        WebElement login=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));
	        login.click();
	        
	}catch(Exception e)
	{
}	
}}