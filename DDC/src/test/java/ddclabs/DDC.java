package ddclabs;

import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.time.temporal.TemporalAmount;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.NoSuchElementException;

import org.python.modules.thread.thread;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.webdriver.WebDriverBrowser;

public class DDC {
	static WebDriver driver;

@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (8)\\chromedriver-win64\\chromedriver.exe");
		
		WebDriverManager.chromedriver().driverVersion("126.0.6478.115").setup();
	    driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("https://righters.in/develop/ddclabsn/admin");
		
		driver.findElement(By.name("loginid")).sendKeys("ADMIN");
		driver.findElement(By.name("password")).sendKeys("DD0ANAN@4N");
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/button")).click();
}
@Test
public void Dashboard() throws Exception {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement dashboard=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mobile\"]")));
	dashboard.sendKeys("8891228547");
	
	
WebElement element =driver.findElement(By.id("mobile"));
element .sendKeys("9744177000");

Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id=\"addservice\"]")).click();



}

@DataProvider(name = "LoginData")
public Object[][] logintest() {
    return new Object[][] {
        {"admin", "dd0anan@4n"},
        {"admin", "dd0anan@4"},
        {"admi", "dd0anan@4n"},
        {" ", " "},
    };
}

@Test(dataProvider = "LoginData")
public void loginScenarios(String username, String password) {
  try {
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10)); 
    WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(By.name("loginid")));
    
    WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));

    usernameField.clear();
    usernameField.sendKeys(username);
    passwordField.clear();
    passwordField.sendKeys(password);

 
    WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div/div/div/div[2]/form/fieldset/button")));
    loginButton.click();
  
   
} catch (Exception e) {
    System.err.println("Exception occurred while logging in: " + e.getMessage());
    if (username.equals("admin") && password.equals("dd0anan@4n")) {
        System.out.println("Login success  " + username + " This is expected.");
    } else {
        System.out.println("Invalid login attempt " + username + " This is expected.");
    
}}}
    


@AfterTest
public void tearDown() {
driver.quit();
}




@Test
public void directors() throws Exception {
	
	Actions action = new Actions(driver);
	WebElement option = driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[2]"));
	action.click(option).build().perform();
	
    Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"dropdown-element\"]/div/ul/li[1]/a")).click();
			

	Thread.sleep(2000);
	WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
element.click();
	
	
	Thread.sleep(2000);
	WebElement directorname=driver.findElement(By.xpath("//*[@id=\"mname\"]"));
	directorname.sendKeys("Sam s");
	
	Thread.sleep(2000);
	
	WebElement designation= driver.findElement(By.xpath("//*[@id=\"position\"]"));
	designation.sendKeys("Staff Nurse");

	Thread.sleep(2000);
	WebElement Brief= driver.findElement(By.xpath("//*[@id=\"mbrief\"]"));
	Brief.sendKeys("Staff,Nurse");
	
	Thread.sleep(2000);
	WebElement memberdetails =driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div[1]/div/div[6]"));
	memberdetails.sendKeys("test");
	
	
	
	  Actions action1= new Actions(driver); 
	  WebElement option1 = driver.findElement(By.xpath("//*[@id=\"addservice\"]"));
	  action1.click(option1).build().perform();
	 
  
}
@Test
public void EditDirectors() throws Exception {
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[2]")));
    button.click();
    Thread.sleep(2000);
    
     driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[2]/div/div/ul/li[1]/a")).click();
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[7]/button/i")).click();
    	
	
	WebElement Choosefile = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[2]/div/div[1]/input[1]"));
	Choosefile.sendKeys("C:\\Users\\computer-2\\Pictures\\viber.jpg");
	
	File f = new File("C:\\Users\\computer-2\\Pictures\\viber.jpg");
	if(f.exists()){
	    System.out.println("success");
	}
	else{
	    System.out.println("fail");
	}
    driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div[1]/div/div[6]")).clear();
	driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div[1]/div/div[6]")).sendKeys("test1");
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"editservice\"]")).click();

}
@Test
public void Doctors() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[2]")));
    button.click();
   
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"dropdown-element\"]/div/ul/li[2]/a")).click();   
    
    Thread.sleep(2000);
    WebElement element= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
    element.click();
    Thread.sleep(2000);
    JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','reema');"
			        +"document.getElementById('position').setAttribute('value','doctor')");
			      
driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[1]/div[2]/textarea")).sendKeys("MBBS");
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"mbrief\"]")).sendKeys("doctor");

WebElement chkBx = driver.findElement(By.name("mstatus"));
boolean flag2 = chkBx.isSelected();
System.out.println(flag2);
if(flag2)     
{
	System.out.println("checkbox is already selected");  
}
else 
{
	  System.out.println("select checkbox");
	  chkBx.click();
	  try {
		    boolean btnPresence = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[3]/div[2]/button")).isDisplayed();
		 
		    if (btnPresence ==true )
		    {
		  // click on the search button
		      WebElement btn = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[3]/div[2]/button"));
		      btn .click();
		     }}
		   catch (org.openqa.selenium.NoSuchElementException e){
		            return;
		      
		  }}}


@Test
public void DoctorsEdit() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[2]")));
    button.click();
   
    Thread.sleep(3000);
    driver.findElement(By.xpath("//*[@id=\"dropdown-element\"]/div/ul/li[2]/a")).click();   
    Thread.sleep(1000);
    driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[1]/td[7]/button/i")).click();
    
    WebElement Choosefile = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[2]/div/div[1]/input[1]"));
	Choosefile.sendKeys("C:\\Users\\computer-2\\Pictures\\viber.jpg");
	
	File f = new File("C:\\Users\\computer-2\\Pictures\\viber.jpg");
	if(f.exists()){
	    System.out.println("success");
	}
	else{
	    System.out.println("fail");
    
	}
	
	driver.findElement(By.xpath("//*[@id=\"editservice\"]")).click();
}

@Test
public void AddPackages() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[3]/a")));
    button.click();
   
    Thread.sleep(2000);
    Actions action1 = new Actions(driver);
	WebElement elementToClick = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
	action1.click(elementToClick).build().perform(); 
    
	WebElement text = driver.findElement(By.id("mname"));
	text.click();
	text.sendKeys("SPECIAL OFFER PACK");
	
	WebElement text1 =driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[1]/div[2]/div/div[6]"));
	text1.sendKeys("Physician Consultation "
			+ "10% Discount");
	
	WebElement text2 =driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div[1]/div/div[6]"));
	text2.sendKeys("D DIMER "
		+ "FERRTIN"
		+ "CRP");
	
	driver.findElement(By.xpath("//*[@id=\"addservice\"]")).click();
	
	
}

@Test
public void PackagesEdit() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[3]/a")));
	button.click();

	driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0_filter\"]/label/input")).sendKeys("SPECIAL OFFER PACK");

	Thread.sleep(2000);
	Actions action1 = new Actions(driver);
	WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[6]/button"));
	action1.click(elementToClick).build().perform();

	WebElement Choosefile = driver.findElement(By.xpath("//*[@id=\"tfile\"]"));
	Choosefile.sendKeys("C:\\Users\\computer-2\\Pictures\\bb.jpg");
	
	File f = new File("C:\\Users\\computer-2\\Pictures\\bb.jpg");
	if(f.exists()){
	    System.out.println("success");
	}
	else{
	    System.out.println("fail");
    
	}

	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/span/span[1]/span/ul/li/input")).click();
	Thread.sleep(2000);

	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
	Thread.sleep(2000);
	By option = By.xpath("//*[text()='TRANSFERRIN']");
	wait1.until(ExpectedConditions.elementToBeClickable(option));
	driver.findElement(option).click();

	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div[2]/div[1]/div/div/div[1]/div/span/span[1]/span/ul/li/input")).click();
	Thread.sleep(2000);

	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(40));
	Thread.sleep(2000);
	By option2 = By.xpath("//*[text()='ASO (LATEX)']");
	wait2.until(ExpectedConditions.elementToBeClickable(option));
	driver.findElement(option2).click();
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"testt\"]/tr[1]/td[1]/input")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"testt\"]/tr[1]/td[1]/input")).isSelected(), true);
	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"testt\"]/tr[2]/td[1]/input")).click();
	Assert.assertEquals(driver.findElement(By.xpath("//*[@id=\"testt\"]/tr[2]/td[1]/input")).isSelected(), true);
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"addtestt\"]")).click();
	Thread.sleep(3000);
	Alert alert = driver.switchTo().alert();
	alert.accept();
	
	driver.findElement(By.xpath("//*[@id=\"editservice\"]")).click();
}
@Test
public void AddServices() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();

	driver.findElement(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/div/div/ul/li[1]/a")).click();

	if (driver.findElements(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button")).size() != 0) {
	    System.out.println("Element is present");
	} else {
	    System.out.println("Element is absent");
	}

driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button")).click();

Thread.sleep(1000);
driver.findElement(By.id("mname")).sendKeys("Urology");
Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id=\"select2-mtype-container\"]")).click();
Thread.sleep(2000);

WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
Thread.sleep(2000);
By option = By.xpath("//*[text()='Radiology Diagnosis']");
wait1.until(ExpectedConditions.elementToBeClickable(option));
driver.findElement(option).click();

Thread.sleep(3000);
driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/form/div[1]/div[3]/textarea")).sendKeys("offer");
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div[1]/div/div[6]")).sendKeys("offer");

Actions action1 = new Actions(driver);
WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"addservice\"]"));
action1.click(elementToClick).build().perform();

}

@Test
public  void EditServices() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();

	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[1]/a")).click();



driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[8]/td[6]/button/i")).click();
Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[1]/div[4]/div/div[1]/input")).click();



Actions action1 = new Actions(driver);
WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"editservice\"]"));
action1.click(elementToClick).build().perform();
}


@Test
public  void AddAssociates() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	Thread.sleep(2000);
	
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[2]/a")).click();
	Thread.sleep(1000);
	
	Actions action1 = new Actions(driver);
	WebElement elementToClick = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
	action1.click(elementToClick).build().perform();
	
Thread.sleep(1000);
JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','Dr. Joys Mammografia');"
                    +"document.getElementById('mbrief').setAttribute('value','early detection of breast cancer');"
			        +"document.getElementById('website').setAttribute('value','https://drjoysmammografia.com/')");

	WebElement button1 = driver.findElement(By.id("addassociate")); 
     button1.click();
Thread.sleep(3000);

  WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10) );
  boolean button1Clicked =
  waits.until(ExpectedConditions.stalenessOf(button1));
  
  
  if (button1Clicked) { System.out.println("The button has been clicked.");
 
  } else { System.out.println("The button was not clicked "); }
 
	
	
}
@Test
public void EditAssociates() throws Exception {
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'icon fa fa-table')]")));
button.click();
Thread.sleep(2000);
driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[2]/a")).click();
Thread.sleep(1000);

WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
String searchQuery = "drjoysmedstore";
searchField.sendKeys(searchQuery);
searchField.sendKeys(Keys.RETURN);

try {
    Thread.sleep(5000);
} catch (InterruptedException e) {
    e.printStackTrace();
}

try {
    WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20)); 
    WebElement edit = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[6]/button/i")));
    edit.click();

    WebElement Choosefile = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[2]/div/div[1]/input[1]"));
    Choosefile.sendKeys("C:\\Users\\computer-2\\Pictures\\bn.jpg");

    File f = new File("C:\\Users\\computer-2\\Pictures\\bn.jpg");
    if (f.exists()) {
        System.out.println("File upload success");
    } else {
        System.out.println("File upload failed");
    }

    Thread.sleep(2000);
    driver.findElement(By.xpath("//*[@id=\"editassociate\"]")).click();
} catch (org.openqa.selenium.TimeoutException e) {
    System.out.println("Element not found within the specified time.");
    e.printStackTrace();
} }
@Test
public  void AddDepartments() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[3]/a")).click();
	Thread.sleep(1000);
	
	Actions action1 = new Actions(driver);
	WebElement elementToClick = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
	action1.click(elementToClick).build().perform();

	Thread.sleep(1000);

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','SCANS');"
                    +"document.getElementById('mbrief').setAttribute('value',' scanning')");
			     
	
	
	Actions action11 = new Actions(driver);
	WebElement elementToClick1 = driver.findElement(By.xpath("//*[@id=\"addservice\"]"));
	action11.click(elementToClick1).build().perform();
	
}
@Test
public  void EditDepartments() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[3]/a")).click();
	Thread.sleep(1000);

driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[5]/td[4]/button/i")).click();
Thread.sleep(1000);
driver.findElement(By.id("mbrief")).sendKeys("scanning");

}
@Test
public void AddBranches() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[4]/a")).click();
	Thread.sleep(1000);
	
	Actions action1 = new Actions(driver);
	WebElement elementToClick1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
	action1.click(elementToClick1).build().perform();
	
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','DDC KOLLAM');"
			        +"document.getElementById('mbrief').setAttribute('value','DDC KOLLAM ');"
                    +"document.getElementById('phones').setAttribute('value','8891228547 ');"
                    +"document.getElementById('mobile').setAttribute('value',' 9656931233');"
                    +"document.getElementById('email').setAttribute('value','DDCKOLLAM@gmail.com ');"
                    +"document.getElementById('coords').setAttribute('value','9.953460, 76.341926 ')");
			     
	driver.findElement(By.xpath("//*[@id=\"addservice\"]")).click();
	
	
	
	
}

@Test
public void editBranches() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[4]/a")).click();
	Thread.sleep(1000);

	WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));

	String searchQuery = "ddc kollam";
	searchField.sendKeys(searchQuery);

	searchField.sendKeys(Keys.RETURN);

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[5]/button/i")).click();

	Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[1]/div[4]/div/div[6]"));
	element.sendKeys("bloodtest,scanning,Xray");
	
	driver.findElement(By.xpath("//*[@id=\"editservice\"]")).click();

}

@Test
public void NoticeAdd() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	Thread.sleep(2000);

	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[5]/a")).click();
	Thread.sleep(1000);
	
	driver.findElement(By.cssSelector("button[value='ADD']")).click();

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','offers upto 40%');"
                    +"document.getElementById('mbrief').setAttribute('value','offers upto 40%')");
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"addservice\"]")).click();

}

@Test
public void NoticesEdit() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[5]/a")).click();
	Thread.sleep(1000);
	WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));

	String searchQuery = "offers upto 40%";
	searchField.sendKeys(searchQuery);

	searchField.sendKeys(Keys.RETURN);

	try {
		Thread.sleep(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}

	driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[5]/button/i")).click();

	Thread.sleep(1000);
	WebElement element = driver.findElement(By.xpath("//*[@id=\"mbrief\"]"));
	element.sendKeys("ddc scanning");
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//button[@id='editservice']")).click();
	
}
@Test
public void TestimonialAdd() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[6]/a")).click();
	Thread.sleep(1000);

	
	Actions action1 = new Actions(driver);
	WebElement elementToClick1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button"));
	action1.click(elementToClick1).build().perform();

	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','REVIEWS');"
			+"document.getElementById('mauthor').setAttribute('value','ANANYA');"
			+"document.getElementById('mbrief').setAttribute('value','EVERYONE CAN TRUST DDC AS ACCURATE RESULTS ARE PROVIDED,QUICK RESULTS')");
			
        driver.findElement(By.xpath("//*[@id=\"addservice\"]")).click();

}
@Test
public void TestimonialEdit() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[6]/a")).click();
	Thread.sleep(1000);

	WebElement element = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/form/div/table/tbody/tr[2]/td[6]/button/i"));
      element.click();

Thread.sleep(1000);
WebElement Choosefile = driver.findElement(By.xpath("//*[@id=\"tfile\"]"));
Choosefile.sendKeys("C:\\Users\\computer-2\\Pictures\\viber.jpg");

File f = new File("C:\\Users\\computer-2\\Pictures\\viber.jpg");
if(f.exists()){
    System.out.println("success");
}
else{
    System.out.println("fail");

}
Actions action = new Actions(driver);
WebElement elementToType = driver.findElement(By.id("tbrief"));
action.sendKeys(elementToType, "EVERYONE CAN TRUST DDC AS ACCURATE RESULTS ARE PROVIDED,QUICK RESULTS").build().perform();

WebElement elements=driver.findElement(By.xpath("//*[@id=\"editservice\"]"));
elements.click();

String currentURL = driver.getCurrentUrl();

String expectedURL = "https://righters.in/develop/ddclabsn/admin/ad_testimonial.php"; 

if (currentURL.equals(expectedURL)) {
    System.out.println("Current URL is as expected");
} else {
    System.out.println("Current URL is not as expected");
}}

@Test
public void Appointmentsearch() throws Exception {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));


    WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//li[4]/a/span[1]")));
    button.click();
    Thread.sleep(2000);

    driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[7]/a")).click();
    Thread.sleep(1000);

    driver.findElement(By.id("date_from")).sendKeys("01-06-2024");
    Thread.sleep(1000);
    driver.findElement(By.id("date_to")).sendKeys("11-06-2024");

    
    WebElement branchDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("branch")));
    branchDropdown.click();
    By branchOption = By.xpath("//*[text()='DDC Chottanikkara']");
    wait.until(ExpectedConditions.elementToBeClickable(branchOption)).click();

    WebElement typeDropdown = driver.findElement(By.id("type"));
    typeDropdown.click();
    Select type = new Select(typeDropdown);
    type.selectByVisibleText("All");

    // Click the search button
    WebElement searchButton = driver.findElement(By.id("search"));
    searchButton.click();

   
    String expectedData = "bineetha";
    if(expectedData.contains(expectedData)) {
    	System.out.println("serach result conatin expected data");
    }else {
    	System.out.println("serach result does not conatin expected data");
   
    }}
//@Test
public void AppointmentFixing() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[7]/a")).click();
	Thread.sleep(1000);


	driver.findElement(By.xpath("//*[@id=\"date_from\"]")).sendKeys("01-10-2023");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"date_to\"]")).sendKeys("12-10-2023");
	
	
	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement ELEMENT = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div[3]/span/span[1]/span/span[1]")));
	ELEMENT.click();
	
	WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
	Thread.sleep(2000);
	By option = By.xpath("//*[text()='DDC Chottanikkara']");
	waits.until(ExpectedConditions.elementToBeClickable(option));
	driver.findElement(option).click();
	
	driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div[4]/div/span/span[1]/span/span[1]")).click();
	Thread.sleep(2000);
	
	WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
	Thread.sleep(2000);
	By option1 = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/div[1]/div[4]/div/select/option[3]");
	wait1.until(ExpectedConditions.elementToBeClickable(option1));
	driver.findElement(option1).click();
	
	Thread.sleep(2000);
	WebElement button1 = driver.findElement(By.id("search"));

      String initialButtonText = button1.getText(); 
      button1.click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[2]/div[2]/table/tbody/tr/td[6]/button/i")).click();

   try {
    WebElement elements = driver.findElement(By.id("appnmt_fixedfor"));
    elements.click();
} catch (Exception e) {
    
    System.out.println("An exception occurred");
    
} finally {
   
	WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button2 = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='appnmt_fixedfor']")));
	button2.sendKeys("12-10-2023");
	
	
Thread.sleep(1000);
driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
Thread.sleep(1000);
Alert alert = driver.switchTo().alert();
}}
@Test

public void PageContent() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[6]/a")));
	button.click();
Thread.sleep(1000);

Actions action=new Actions(driver);
WebElement element=driver.findElement(By.xpath("//*[@id=\"component-example\"]/div/ul/li/a"));
action.click(element).build().perform();

Thread.sleep(1000);
WebElement addbutton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/div[1]/div/div/form/button")); 
addbutton.click();

String expectedUrl = "https://righters.in/develop/ddclabsn/admin/ad_pages.php";
if (driver.getCurrentUrl().equals(expectedUrl)) {
    System.out.println("The URL matches the expected URL.");
} else {
    System.out.println("The URL does not match the expected URL.");
}

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("document.getElementById('mname').setAttribute('value','test');"
		+"document.getElementById('mlinkto').setAttribute('value','About Us');"
		+"document.getElementById('mbrief').setAttribute('value','tests')");

Actions actions=new Actions(driver);
WebElement elements=driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div/div[4]/button"));
action.click(elements).build().perform();
}

@Test

public void PageContentEdit() throws Exception{
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[8]/a")));
	button.click();
Thread.sleep(1000);

Actions action=new Actions(driver);
WebElement element=driver.findElement(By.xpath("//*[@id=\"component-example\"]/div/ul/li[1]/a"));
action.click(element).build().perform();

Thread.sleep(1000);
WebElement addbutton = driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[4]/td[5]/button")); 
addbutton.click();

WebElement brief=driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div/div[3]/div/div[6]"));
brief.sendKeys("testss");

WebElement button1 = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div/div[5]/button")); 
button1.click();
Thread.sleep(3000);

WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10) );
boolean button1Clicked =
waits.until(ExpectedConditions.stalenessOf(button1));


if (button1Clicked) { System.out.println("The button has been clicked.");

} else { System.out.println("The button was not clicked "); }

}

@Test
	public void Team() {

		/*
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * WebElement option =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
		 * "/html/body/div/div/div[1]/nav/div/ul/li[2]")));
		 * 
		 * 
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", option);
		 * 
		 * 
		 * if (option.isDisplayed() && option.isEnabled()) {
		 * 
		 * Actions action = new Actions(driver); action.click(option).build().perform();
		 * } else { System.out.println("Element is not visible or not enabled"); }
		 * 
		 * driver.findElement(By.xpath("//*[@id=\"dropdown-element\"]/div/ul/li[3]/a")).
		 * click();
		 */
	driver.get("https://righters.in/develop/ddclabsn/admin/ad_team.php");
	
    WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
    WebElement team = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("qAction")));
    team.click();
	
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.getElementById('mname').setAttribute('value','reshmi');"
	
		+"document.getElementById('position').setAttribute('value','marketing staff');"
			+"document.getElementById('mbrief').setAttribute('value','test');"
    	+"document.getElementById('summernote').setAttribute('value','test data')");
	
	WebElement addservice=driver.findElement(By.id("addservice"));
	addservice.click();
	
		
	}

@Test
public void teamedit(){
	
	driver.get("https://righters.in/develop/ddclabsn/admin/ad_team.php");
	
    WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(15));
    WebElement team = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'fa fa-lg fa-edit')]")));
    team.click();


    
   
    if(team.isSelected()) {
        String expectedURL = "https://righters.in/develop/ddclabsn/admin/ad_team.php";
        String currentURL = driver.getCurrentUrl(); 
        Assert.assertEquals(currentURL, expectedURL, "Incorrect URL");
    } else {
        System.out.println("Element not selected");
    }


WebElement brief=driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div[1]/div/div[6]"));
brief.sendKeys("testdata");

Actions action=new Actions(driver);
WebElement updatebtn=driver.findElement(By.id("editservice")) ;
action.click(updatebtn).perform();
}

@Test
public void Enquiry(){
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[4]/a/span[1]")));
	button.click();
	
	
	WebElement enquiry=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-table\"]/div/ul/li[8]/a")));
	enquiry.click();
	
String expectedUrl="https://righters.in/develop/ddclabsn/admin/ad_enquiry.php";
String currentUrl=driver.getCurrentUrl();

if(currentUrl.equals(expectedUrl)) {
  
	System.out.println("current and expected url are same") ;
	  
}else {
	System.out.println("both urls are different");
}

WebElement date=driver.findElement(By.id("date_from"));
date.sendKeys("22-05-2024");

Actions action=new Actions(driver);
WebElement searchbutton=driver.findElement(By.id("search"));
action.click(searchbutton).build().perform();

wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'bini')]")));

List<WebElement> searchResultItems = driver.findElements(By.xpath("//*[contains(text(),'bini')]"));


String expectedText = "bini";
boolean isDataPresent = false;

for (WebElement result : searchResultItems) {
    if (result.getText().contains(expectedText)) {
        isDataPresent = true;
        break;
    }
}

if (isDataPresent) {
    System.out.println("Search results contain the expected data: " + expectedText);
} else {
    System.out.println("Search results do not contain the expected data: " + expectedText);
}


assert !searchResultItems.isEmpty() : "No search results found";
}
@Test
public void Careers() {
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[6]/a")));
	button.click();
	

	WebElement vacancies=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-form\"]/div/ul/li[1]/a")));
	vacancies.click();
	
	
WebElement addbutton=driver.findElement(By.name("qAction"));
	if(addbutton.isDisplayed()) {
		addbutton.click();
	}else {
		System.out.println("add vacancy button is not present");	
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript(
	    "document.getElementById('refer').setAttribute('value', 'TECHNICIAN');" +
	    "document.getElementById('mname').setAttribute('value', 'lab technician');" +
	    "document.getElementById('lastdate').setAttribute('value', '07-08-2024');" +
	    "document.getElementById('applyto').setAttribute('value', 'HEAD OFFICE');" +
	    "document.getElementById('emailto').setAttribute('value', 'ddcjobs1989@gmail.com');" +
	    "document.getElementById('mbrief').setAttribute('value', 'To work towards the target.\\n" +
	    "Follow up & Coordination with Doctors and Corporate companies.\\n" +
	    "Conducting and organizing Various Promotional activities.\\n" +
	    "Making empanelment with doctors & corporate companies.\\n" +
	    "Conducting health talks and camps at corporate.');" +
	    "document.getElementById('qualification').setAttribute('value', 'test data');");
	
	Actions action=new Actions(driver);
	WebElement addbuttn=driver.findElement(By.id("addservice"));
	addbuttn.click();
	
}
@Test
public void VacanciesEdit() {
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[6]/a")));
	button.click();
	

	WebElement vacancies=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dropdown-form\"]/div/ul/li[1]/a")));
	vacancies.click();

    WebElement button1=driver.findElement(By.xpath("//*[@id=\"DataTables_Table_0\"]/tbody/tr[9]/td[6]/button/i"));
    button1.click();
	
	WebElement checkbox=driver.findElement(By.name("mstatus"));
	checkbox.click();
	
	Actions action=new Actions(driver);
	WebElement edit =driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[1]/div[7]/div/div[1]/input"));
	action.click(edit).build().perform();	
}

@Test
public void applications() {
	
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/nav/div/ul/li[6]/a")));
	button.click();
	

	WebElement vacancies=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(.,'Applications')]")));
	vacancies.click();

String currentTitle="DDC Administration";
String expectedTitle=driver.getTitle();

if(currentTitle.equals(expectedTitle)) {
	System.out.println("expected and current title are same");
}else {
System.out.println("expected and current title are not same");
}


WebElement cv = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("")));
cv.click();


}

@Test
public void articles() {
    try {
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement siteContentIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='icon fa fa-file-text-o']")));
        siteContentIcon.click();

       
        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//li[7]/a/span[2]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", menuButton);

  
        Actions action = new Actions(driver);
        WebElement addArticleButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("qAction")));
        action.click(addArticleButton).build().perform();

        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('mname').value='test';");
        js.executeScript("document.getElementById('mauthor').value='testdata';");
        js.executeScript("document.getElementById('mbrief').value='ddc labs';");

 
        WebElement articleTypeDropdown = wait.until(ExpectedConditions.elementToBeClickable(By.id("select2-mtype-ro-container")));
        articleTypeDropdown.click();

        WebElement articleTypeOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[text()='Article']")));
        articleTypeOption.click();

        
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("addservice"))); 
        submitButton.click();

        
        List<WebElement> articlesList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[contains(text(),'test')]")));
        boolean isArticlePresent = false;
        for (WebElement article : articlesList) {
            if (article.getText().contains("test")) {
                isArticlePresent = true;
                break;
            }
        }
        System.out.println("New article found in the list: " + isArticlePresent);
    } catch (Exception e) {
        e.printStackTrace();
    }}


@Test
public void gallery() {
   
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    try {
       
        WebElement siteContentTitle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@class,'icon fa fa-cubes')]")));
        siteContentTitle.click();
        System.out.println("sitecontent link found and clickable");
        
        WebElement vacancies = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"component-example\"]/div/ul/li[3]/a")));
        vacancies.click();
        System.out.println("Vacancies link found and clickable");
        
        WebElement gallerybutton=driver.findElement(By.name("qAction"));
        gallerybutton.click();
        
        WebElement caption=driver.findElement(By.name("mname"));
        WebElement brief=driver.findElement(By.name("mbrief"));
        
        Actions actions=new Actions(driver);
        actions.sendKeys(caption,"testdata" ).perform();
        actions.sendKeys(brief, "testing1").perform();
        
        WebElement dropdownContainer = driver.findElement(By.id("select2-mtype-container"));
        dropdownContainer.click();
      
        WebElement option = driver.findElement(By.id("select2-mtype-container"));
        option.click();
       
        
        WebElement Choosefile = driver.findElement(By.id("upload"));
    	Choosefile.sendKeys("C:\\Users\\computer-2\\Pictures\\viber.jpg");
    	
    	File f = new File("C:\\Users\\computer-2\\Pictures\\viber.jpg");
    	if(f.exists()){
    	    System.out.println("success");
    	}
    	else{
    	    System.out.println("fail");
        
    	}
    WebElement add=driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[3]/div/button"))	;
    add.click();
    
    } 
    
    catch (TimeoutException e) {
       
    	
    }}}














	