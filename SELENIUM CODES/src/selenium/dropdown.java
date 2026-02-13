package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class dropdown {
public static void main(String args[]) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	
	WebElement element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("my-select")));
	
	Select select=new Select(element);
	select.selectByVisibleText("One");
	
	select.selectByValue("2");
	
	
	
	
}
}
