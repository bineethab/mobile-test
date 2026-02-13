package crossbrowsertesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

public class Mamocrossbrowser {
	
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

	driver.manage().window().maximize();
	driver.get("https://drjoysmedstore.com/mamoTestLive/");
	Thread.sleep(9000);
	driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button/span")).click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul/li[8]/a")).click();



	 driver.switchTo().frame("myIfr");
	 Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
	driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
	driver.findElement(By.name("password")).sendKeys("bini123");

	driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
	driver.quit();
	}
	}



