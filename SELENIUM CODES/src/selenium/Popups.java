package selenium;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Popups {
	public static void main(String args[]) {
	
	System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	
	WebElement alert1=driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
	alert1.click();
	
	Alert alert=driver.switchTo().alert();
	alert.accept();
	
	System.out.println("alert1 clicked successfully");
	
	
	WebElement alert2=driver.findElement(By.cssSelector("button[onclick='jsPrompt()']"));
	alert2.click();
	
	Alert alert11=driver.switchTo().alert();
	
	alert11.sendKeys("ok");
	alert11.accept();
	
	
	//screenshot
	
	File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(screenshot,new File("C:\\Users\\computer-2\\Pictures\\Saved Pictures\\screenshot.png"));
		
	}catch(IOException e) {
		e.printStackTrace();
	}
	
	
}}
