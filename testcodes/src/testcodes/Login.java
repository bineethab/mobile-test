package testcodes;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
	WebDriver driver;
@Before
public void setup() {
	
System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
 driver=new ChromeDriver();
driver.manage().window().maximize();
}
//@Test
public void loginfunction() {
	
	driver.get("https://the-internet.herokuapp.com/login");
	
	WebElement username=driver.findElement(By.id("username"));
	username.sendKeys("tomsmith");
	
	WebElement password=driver.findElement(By.id("password"));
	password.sendKeys("SuperSecretPassword!");
	
	WebElement Login=driver.findElement(By.xpath("//button[@type='submit']"));
	Login.click();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement successmessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
	if(successmessage.isDisplayed()) {
		System.out.println("login success");
		Assert.assertTrue(successmessage.getText().contains("You logged into a secure area!"));
	}else {
		System.out.println("login fail");
	}
}
	//@Test
	public void tables() {
		
		driver.get("https://www.w3schools.com/html/html_tables.asp");	
		
		
		WebElement row=driver.findElement(By.xpath("//td[contains(text(),'Giovanni Rovelli')]"));
		
		String company=row.findElement(By.xpath("//td[normalize-space()='Magazzini Alimentari Riuniti']")).getText();
		String country=row.findElement(By.xpath("//td[normalize-space()='Italy']")).getText();
		
		System.out.println("country name:"+ country);
		System.out.println("company name:"+ company);
		
		
	}
	
//	@Test
	public void links() {
		

		driver.get("https://www.selenium.dev/");	
	
		List<WebElement>links=driver.findElements(By.tagName("a"));
		System.out.println("links found"+ links.size());
		
		for(WebElement alllinks:links) {
			
		}}
		
		
	//@Test
	public void dropdown() {
		driver.get("https://demoqa.com/select-menu");	
		
	WebElement dropdown=driver.findElement(By.xpath("//*[contains(@class,'css-1hwfws3')]"));
	dropdown.click();
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'Group 1, option 1')]")));
    option.click();
	
    WebElement option1 = wait.until(ExpectedConditions.elementToBeClickable(By.id("selectOne")));
    option1.click();
    WebElement mrOption = driver.findElement(By.xpath("//div[text()='Mr.']"));
    mrOption.click();
    
	WebElement oldstyle=driver.findElement(By.id("oldSelectMenu"));
   Select option11=new Select(oldstyle);
	option11.selectByVisibleText("Blue");
	
	try {
	    WebElement dropdown1 = driver.findElement(By.xpath("//div[contains(@class,'css-1hwfws3')]"));
	    dropdown1.click();
	} catch (Exception e) {
	    // If normal click fails, use JavaScript click
	    WebElement dropdown1 = driver.findElement(By.xpath("//div[contains(@class,'css-1hwfws3')]"));
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", dropdown1);
	}

	// Select first option
	WebElement option111 = driver.findElement(By.xpath("//div[text()='Green']"));
	option111.click();

	
	WebElement option2 = driver.findElement(By.xpath("//div[text()='Blue']"));
	option2.click();
	}
	
	//@Test
	public void Alerts() {
		driver.get("https://demoqa.com/alerts");
		
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement clickbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
		clickbutton.click();
		
		Alert alert=driver.switchTo().alert();
	
		System.out.println("alertText:"+alert.getText());
		alert.accept();
		
		//2nd alert
		WebElement clickbutton2=wait.until(ExpectedConditions.elementToBeClickable(By.id("timerAlertButton")));
		clickbutton2.click();
		
		Alert delayedalert=wait.until(ExpectedConditions.alertIsPresent());
		System.out.println("delayedalertText:"+delayedalert.getText());
		delayedalert.accept();
	
		//3rd alert
		WebElement clickbutton3=wait.until(ExpectedConditions.elementToBeClickable(By.id("confirmButton")));
		clickbutton3.click();
		Alert confirmalert=wait.until(ExpectedConditions.alertIsPresent());
		confirmalert.dismiss();
		//4th alert
		
		WebElement clickbutton4=wait.until(ExpectedConditions.elementToBeClickable(By.id("promtButton")));
		clickbutton4.click();
		Alert promptalert=wait.until(ExpectedConditions.alertIsPresent());
		promptalert.sendKeys("bini");
		promptalert.accept();
	}
	
	@Test
	public void multiplewindow() {
		driver.get("https://demoqa.com/browser-windows");
		
		String parentWindow=driver.getWindowHandle();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		WebElement newbutton=wait.until(ExpectedConditions.elementToBeClickable(By.id("tabButton")));
		newbutton.click();
		//all window handles
		Set<String>allWindows=driver.getWindowHandles();
		 // Switch to the newly opened window
		for(String windowhandle:allWindows) {
			if(!windowhandle.equals(parentWindow)) {
				driver.switchTo().window(windowhandle);
				break;
			}
		}
		
		//verify heading
		WebElement heading=driver.findElement(By.id("sampleHeading"));
		System.out.println("Text in new window:"+heading.getText());
		
		driver.switchTo().window(parentWindow);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	@After
	public void close() {
	//	driver.close();
		}
	}
	
	