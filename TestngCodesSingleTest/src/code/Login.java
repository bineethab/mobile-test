package code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Login {

	@Test
	public void Login() {
		
		WebDriver driver=new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver.get("https://the-internet.herokuapp.com/login");
		
		WebElement username=driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("SuperSecretPassword");
		
		WebElement LOGINBTN=driver.findElement(By.id(""));
		LOGINBTN.click();
		
		
		
	}
}
