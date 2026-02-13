package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	
	public static void main (String args[]) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://the-internet.herokuapp.com/windows");
		
		String parentWindow=driver.getWindowHandle();
		
		driver.findElement(By.linkText("Click Here")).click();
		   // Get all window handles
		Set<String>allwindows=driver.getWindowHandles();
		  // Switch to new window
		
		for(String window:allwindows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
				
			}
		}
		
		
	}
}
