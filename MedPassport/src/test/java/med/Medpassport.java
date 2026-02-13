package med;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Medpassport {
	//@Test
	public void Register() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mymedicalpassport.in/");
		
		driver.findElement(By.xpath("/html/body/header/ul/li[6]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/form/p[1]/input")).sendKeys("smitha");
		driver.findElement(By.xpath("/html/body/div[1]/form/p[2]/input")).sendKeys("smitha@gmail.com");
		driver.findElement(By.name("phone")).sendKeys("9874123650");
		driver.findElement(By.name("password")).sendKeys("Smitha@123");
		
		driver.findElement(By.id("//*[@id=\"reg-btn\"]")).click();
		driver.quit();
}
	//@Test
	public void Login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mymedicalpassport.in/");
		driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bini@123");
		driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();

		driver.quit();
		
}
	//@Test
	public void Invalidlogin() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mymedicalpassport.in/");
		driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bini@12");
		driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();
		
	}
	//@Test
	public void ProfileEdit() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mymedicalpassport.in/");
		
		driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bini@123");
		driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/ul/li[3]/a")).click();
		
		Thread.sleep(2000);
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.name("//*[@id=\"editUserForm\"]/div[6]/textarea")).sendKeys("kottayam");
		driver.findElement(By.xpath("//*[@id=\"editUserForm\"]/div[17]/button")).click();
		
		driver.quit();
}
// @Test 

 
 public void AddMembers() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mymedicalpassport.in/");
		
		driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Bini@123");
		driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click();
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/ul/li[3]/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[1]/div[2]/div[2]/div/div/div/button[2]")).click();
		Thread.sleep(2000);
		
		String title= driver.getTitle();
		System.out.println(title);
		   Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[2]/input")).sendKeys("ammu");
        
        Thread.sleep(2000);
        
       
        
        driver.findElement(By.xpath("//*[@id=\"loginusername\"]")).sendKeys("ammuz");
        driver.findElement(By.name("memb_password")).sendKeys("Ammu@123");
        Thread.sleep(2000);
        Select a=new Select(driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[6]/select")));
        a.selectByVisibleText("Female");
        
        driver.findElement(By.xpath("//*[@id=\"addMemberForm\"]/div[7]/input")).sendKeys("17-04-1998");
        Thread.sleep(1000);
        
        Select b=new Select(driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[8]/select")));
        b.selectByVisibleText("Cousins");
        
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/form/div[11]/input")).sendKeys("ammu@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"addressfillcheck\"]")).click();
       
        driver.findElement(By.xpath("//*[@id=\"subcountry\"]")).sendKeys("in");
    	Thread.sleep(2000);
     
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
    	Thread.sleep(2000);
    	By option = By.xpath("//*[@id=\"countryuladd\"]/li[2]");
    	wait.until(ExpectedConditions.elementToBeClickable(option));
    	driver.findElement(option).click();
        
        
      driver.findElement(By.xpath("//*[@id=\"addMemberForm\"]/div[22]/button")).click();
        
}
 
//@Test
public void Profilephoto() throws InterruptedException{
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://mymedicalpassport.in/");


driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
driver.findElement(By.name("password")).sendKeys("Bini@123");
driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click();


driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/ul/li[3]/a")).click();
Thread.sleep(2000);

JavascriptExecutor jse = (JavascriptExecutor)driver;
jse.executeScript("window.scrollBy(0,250)");
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[1]/div[1]/div/div/div[2]/div/a")).click();

}
//@Test
public void DDCBookOnline() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.manage().window().maximize();
driver.get("https://mymedicalpassport.in/");

driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
driver.findElement(By.name("password")).sendKeys("Bini@123");
driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[1]/div[1]/div/div[1]/a/div/div[2]")).click();

driver.findElement(By.id("addmemberbtn")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"layout-menu\"]/ul")).click();
driver.findElement(By.xpath("//*[@id=\"layout-menu\"]/ul")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"layout-menu\"]/div[1]/a[2]/i")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"layout-menu\"]/ul/li/a[4]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"modalEditUserLastName\"]")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"locationMapModel\"]/div/form/div[1]/button")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@name='appodate']")).sendKeys("25-05-2023");

Thread.sleep(1000);

 driver.findElement(By.xpath("//*[@name='appotime']")).sendKeys("09:30");
 Thread.sleep(1000);
 driver.findElement(By.xpath("//*[@id=\"select2-hospitaldropdownid-container\"]")).click();
 Thread.sleep(1000);
 driver.findElement(By.xpath("/html/body/span/span/span[1]/input")).sendKeys("a");
 Thread.sleep(4000);
 
 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
 Thread.sleep(2000);
 By option = By.xpath("//*[text()='A G N HOSPITAL']");
wait.until(ExpectedConditions.elementToBeClickable(option));
driver.findElement(option).click();
 Select b=new Select(driver.findElement(By.id("ddcbranch")));
 b.selectByVisibleText("DDC Pettah");
driver.findElement(By.xpath("//*[@id=\"navs-justified-home\"]/div/div/div[14]/p")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"poppackage\"]/div[1]/div/div/div/h5")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"navs-justified-profile\"]/div/div/div[5]/p")).click();
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"slotbook\"]")).click();
driver.quit();
}
@Test
public void Barcode() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://mymedicalpassport.in/");
	
	driver.findElement(By.xpath("/html/body/header/ul/li[7]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("beenabineetha@gmail.com");
	driver.findElement(By.name("password")).sendKeys("Bini@123");
	driver.findElement(By.xpath("/html/body/div[1]/form[1]/p[4]/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/ul/li[3]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click();
	Thread.sleep(1000);
	
	Select a = new Select(driver.findElement(By.xpath("//*[@id=\"userlist\"]")));
	a.selectByVisibleText("sarika");
    

	Thread.sleep(1000);
	  driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click(); 
	  Thread.sleep(1000);
	 
	driver.findElement(By.xpath("//*[contains(text(),'View Barcode')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"qrcode\"]/div/div/div/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/a/div/img")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/ul/li[3]/ul/li[8]/a")).click();
}}
