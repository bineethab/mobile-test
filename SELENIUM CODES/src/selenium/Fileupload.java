package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Fileupload {

	public static void  main (String args[]) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		WebElement fileupload=driver.findElement(By.id("file-upload"));
		fileupload.sendKeys("C:\\Users\\computer-2\\Pictures\\Saved Pictures\\deeee.png");
		System.out.println("file selected");
		
		driver.findElement(By.id("file-submit")).click();
		
	}
}
