package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Text {
public static void main(String args[]) {
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	
	driver.get("https://www.selenium.dev/selenium/web/web-form.html");
	WebElement text=driver.findElement(By.id("my-text-id"));
	text.sendKeys("selenium");
	
	
	//button with css class(css=tag.class name)
	
	WebElement button=driver.findElement(By.cssSelector("button.btn.btn-outline-primary.mt-3"));
	button.click();
}
}
