package paralleltest;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class Medstore {
	
	WebDriver driver;
	@Test
    @Parameters("browser")
	
	
	public void mamografia(String browserName)throws InterruptedException{
	if (browserName.equalsIgnoreCase("chrome"))
	{
	System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
	}
	else if (browserName.equalsIgnoreCase("firefox"))
	{
	System.setProperty("webdriver.gecko.driver","C:\\Users\\computer-2\\Downloads\\geckodriver-v0.33.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
	}
	else if (browserName.equalsIgnoreCase("edge"))
	{
	System.setProperty("webdriver.edge.driver","C:\\Users\\computer-2\\Downloads\\edgedriver_win64 (1)\\msedgedriver.exe");
	driver=new EdgeDriver();
	}
		
	driver.get("http://192.168.2.11/medstore/manufacturer.php");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"editman\"]")).click();

	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("//*[@id=\"editcontemail\"]"));
	element.sendKeys(Keys.CONTROL + "a");
	element.sendKeys(Keys.DELETE);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"editcontemail\"]")).sendKeys("info@lupin.com");
	driver.findElement(By.xpath("//*[@id=\"manupdate\"]")).click();
	}
}
