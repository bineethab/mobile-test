package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover {
	

	public static void main(String args[]) {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu");
		

        WebElement mainItem = driver.findElement(By.xpath("//a[contains(text(),'Main Item 2')]"));
        
	
		 Actions actions=new Actions(driver); 
		 actions.moveToElement(mainItem).build().perform();
		// <a href="#" xpath="1">Main Item 2</a>
		
		
}}

