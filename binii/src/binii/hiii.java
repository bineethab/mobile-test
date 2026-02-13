package binii;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hiii {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	WebElement table = driver.findElement(By.id("customers"));

	        // Fetch all rows inside the table
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	boolean isislandtradingfound=false;
	Log.info("Number of rows found: " + rows.size());
}}
