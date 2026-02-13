package bb;

import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class Screenshot {
WebDriver driver;
@BeforeMethod
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	
}
	
	//@Test(priority=16)
	
	public void testfail() throws IOException {
		driver.get("https://demoqa.com/");
		String title=driver.getTitle();
		System.out.println("Page title: " + title);
		 // Failing the test intentionally
	    Assert.fail("Failing test intentionally. Title was: " + title);
        	
	}
//@Test
public void checkbox() throws IOException {
	driver.get("https://the-internet.herokuapp.com/checkboxes");
	
	WebElement checkbox=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
	if(checkbox.isDisplayed()) {
		checkbox.click();
		System.out.println("checkbox is present");
	}else {
		System.out.println("checkbox is not present");
	}	
}
@Test
public void tableAdd() throws IOException {
	driver.get("https://demoqa.com/webtables");
	
	WebElement add=driver.findElement(By.id("addNewRecordButton"));
	add.click();
	
	WebElement FirstName=driver.findElement(By.id("firstName"));
	WebElement LastName=driver.findElement(By.id("lastName"));
	WebElement Email=driver.findElement(By.id("userEmail"));
	WebElement Age=driver.findElement(By.id("age"));
	WebElement Salary=driver.findElement(By.id("salary"));
	WebElement Department=driver.findElement(By.id("department"));
	
	FirstName.sendKeys("b");
	LastName.sendKeys("bb");
	Email.sendKeys("bb@gmail.com");
	Age.sendKeys("25");
	Salary.sendKeys("25000");
	Department.sendKeys("accounts");
	
	WebElement Submit=driver.findElement(By.id("submit"));
	Submit.click();
	
	List<WebElement>rows=driver.findElements(By.xpath("//div[@class='rt-table']"));
	boolean personadded=false;
	for(WebElement row:rows) {
		if(row.getText().contains("b")) {
			personadded=true;
		}else {
			 System.out.println("New person not found in the table.");
		}
		
		
		WebElement Edit=driver.findElement(By.id("edit-record-4"));
		Edit.click();
		
		WebElement Salary1=driver.findElement(By.id("salary"));
		Salary1.clear();
		Salary1.sendKeys("50000");

		WebElement Submit1=driver.findElement(By.id("submit"));
		Submit1.click();
		List<WebElement>rows1 =driver.findElements(By.xpath("//div[@class='rt-table']"));	
		
	}
	
	
}
	
@AfterMethod
public void tearDown(ITestResult result) {
	/*
	 * // If test fails, take a screenshot if (ITestResult.FAILURE ==
	 * result.getStatus()) { TakesScreenshot ts = (TakesScreenshot) driver; File
	 * source = ts.getScreenshotAs(OutputType.FILE); File destination = new
	 * File("C:\\Users\\computer-2\\Pictures\\Saved Pictures\\screenshot.png"); try
	 * { FileUtils.copyFile(source, destination);
	 * System.out.println("Screenshot captured due to failure!"); } catch
	 * (IOException e) { System.out.println("Exception while taking screenshot: " +
	 * e.getMessage()); }}
	 */
	/*
	 * if(driver!=null) { //driver.close(); }
	 */
}}
