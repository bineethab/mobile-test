package mamotest;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AGENTLOGIN {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://drjoysmedstore.com/AgentLogin/login.php");
	}

	// @Test
	public void Login() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		Thread.sleep(1000);
		String actualTitle = driver.getTitle();
		String expectedTitle = "Agent Login - Dashboard";
		assertEquals(expectedTitle, actualTitle);

		driver.close();
	}

	// @Test
	public void RolesAdd() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a")).click();
		Robot robot = new Robot();
		Thread.sleep(2000);

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(6000);

		driver.findElement(By.tagName("button")).click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"role\"]"));
		element.sendKeys("admin");

		Actions action1 = new Actions(driver);
		WebElement option1 = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div/div/div[2]/ul/li[1]/input"));
		action1.click(option1).build().perform();

		Robot robot1 = new Robot();

		Thread.sleep(2000);
		robot1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot1.keyPress(KeyEvent.VK_TAB);

		driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div/div/div[2]/ul/li[2]/input")).click();

		Actions action2 = new Actions(driver);
		WebElement option2 = driver.findElement(By.xpath("//*[@id=\"submitbutn\"]"));
		action2.click(option2).build().perform();

		driver.switchTo().alert().accept();
	}

//@Test
	public void addusers() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a/span")).click();

		Robot robot = new Robot();

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		driver.findElement(By.xpath("//*[contains(text(),'User Access')]")).click();
		
    try {
			Thread.sleep(2000);
			WebElement element = driver.findElement(By.xpath("/html/body/main/div[1]/form/button"));

			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {
			
				JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("document.getElementById('username').setAttribute('value', 'sangeetha ');"
					+"document.getElementById('user_pass').setAttribute('value', ' sangeetha')");

			driver.findElement(By.xpath("//*[@id=\"display\"]")).sendKeys("sangeetha");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("sangeetha@gmail.com");
			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("9656931233");
			
			Thread.sleep(4000);
			
			Select c = new Select(driver.findElement(By.xpath("/html/body/main/div/div/form/div[3]/select")));
			c.selectByVisibleText("Admin");
			
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//*[@id=\"submitbutn\"]")).click();
		//	driver.switchTo().alert().accept();

		}
	}

//@Test
	public void agentadd() throws AWTException, InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		Thread.sleep((2000));
		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a/span")).click();

		Robot robot = new Robot();

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[3]/a")).click();
		Thread.sleep(3000);

		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[contains(text(),'Agent Details')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("button")).click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('name').setAttribute('value','anu');"
				+ "document.getElementById('display').setAttribute('value', 'anu');"
				+ "document.getElementById('dob').setAttribute('value', '17-04-1963');"
				+ "document.getElementById('email').setAttribute('value', 'anumol@gmail.com');"
				+ "document.getElementById('contact').setAttribute('value', '9654123078');"
				+ "document.getElementById('commision').setAttribute('value', '850');"
				+ "document.getElementById('acname').setAttribute('value', 'anu');"
				+ "document.getElementById('acno').setAttribute('value', '10531010103210');"
				+ "document.getElementById('bank').setAttribute('value', 'canara');"
				+ "document.getElementById('branch').setAttribute('value', 'airooppara');"
				+ "document.getElementById('ifsc').setAttribute('value', 'CNRB0003497')");

		Select b = new Select(driver.findElement(By.name("gender")));
		b.selectByVisibleText("Female");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[1]/div/div[8]/div/div/div"));
		element.click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Submit')]")).click();

		driver.switchTo().alert().accept();

		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://drjoysmedstore.com/AgentLogin/agents.php");

	}

//@Test
	public void USEREDIT() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a/span")).click();

		Robot robot = new Robot();

		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"projectlist\"]/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[5]/td[5]/div/a/i")).click();

		try {

			Thread.sleep(1000);
			WebElement element = driver
					.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[5]/td[5]/div/ul/li[1]/a"));

			if (element.isDisplayed() && element.isEnabled()) {
				element.click();
			}
		} catch (Exception e) {

			WebElement element2 = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[9]/textarea"));
			element2.clear();
			Thread.sleep(1000);

			for (int i = 0; i < 1; i++) {
				element2.sendKeys(Keys.BACK_SPACE);
				element2.sendKeys("test1");

			}
		}

	}

//@Test
	public void countryAdd() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("/html/body/aside/ul/li[2]/ul/li[3]/a"));
		element.click();
		Thread.sleep(2000);

		Boolean isPresent = driver.findElements(By.xpath("//*[@id=\"frmAdd\"]/button")).size() > 0;
		System.out.println("element is present");

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"frmAdd\"]/button"));

		if (element1.isDisplayed() && element1.isEnabled()) {
			element1.click();
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('country').setAttribute('value','Egypt');"
				+ "document.getElementById('code').setAttribute('value', 'EG');"
				+ "document.getElementById('phone').setAttribute('value', '20');"
				+ "document.getElementById('currency').setAttribute('value', 'EGP')");

		driver.findElement(By.xpath("//*[@id=\"submitbutn\"]")).click();
		driver.switchTo().alert().accept();
	}

//@Test
	public void countryEdit() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("/html/body/aside/ul/li[2]/ul/li[3]/a"));
		element.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[5]/td[6]/div/a")).click();
		Thread.sleep(2000);

		Robot robot = new Robot();

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);

		driver.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[5]/td[6]/div/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.name("currency")).clear();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"currency\"]"));
		element1.sendKeys("EGP");

		driver.findElement(By.xpath("//*[@id=\"submitbutn\"]")).click();
		Thread.sleep(1000);
		driver.switchTo().alert().accept();

	}

//@Test
	public void countryDelete() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("/html/body/aside/ul/li[2]/ul/li[3]/a"));
		element.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[5]/td[6]/div/a")).click();
		Robot robot = new Robot();

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);

	}

// @Test
	public void Agentedit() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[3]/a")).click();

		Thread.sleep(1000);
		driver.findElement(By.linkText("Create Agent")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[7]/td[7]/div/a[2]")).click();

		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"frmtable\"]/table/tbody/tr[7]/td[7]/div/ul/li[1]/a"));
		element.click();

		driver.findElement(By.xpath("//*[@id=\"commision\"]")).clear();

		driver.findElement(By.xpath("//*[@id=\"commision\"]")).sendKeys("1200");
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[2]/div/div[16]/textarea")).clear();

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"frmdefault\"]/div[2]/div/div[16]/textarea"));
		element1.sendKeys("kollam");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"submitbutn\"]")).click();
	}

//@Test
	public void clientdetails() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[4]/a")).click();

		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
		Thread.sleep(1000);
//driver.findElements(By.xpath("//*[@id=\"tdprid21\"]/button")).get(0).click();

		List<WebElement> noofrows = driver.findElements(By.xpath("//*[@id=\"getData\"]"));
		int rowcount = noofrows.size();

		WebElement lastrow = noofrows.get(noofrows.size() - 1);
		Thread.sleep(1000);
		WebElement editbtn = lastrow.findElement(By.xpath("//*[@id=\"tdprid21\"]/button"));
		editbtn.click();

	}

//@Test
	public void multipleclients() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[4]/a")).click();

		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(5000);

		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(5000);

		robot.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
		Thread.sleep(1000);

		driver.findElement(By.id("myPromo17")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"btncommision\"]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"sendnow\"]")).click();

		driver.switchTo().alert().accept();
	}

//@Test
	public void packagedetailsview() throws InterruptedException, AWTException {

		driver.findElement(By.xpath("//*[@id=\"yourUsername\"]")).sendKeys("user");
		driver.findElement(By.xpath("//*[@id=\"yourPassword\"]")).sendKeys("user");

		Actions action = new Actions(driver);
		WebElement option = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		action.click(option).build().perform();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[4]/a")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/aside/ul/li[4]/ul/li/a/span")).click();

		driver.findElement(By.xpath("//*[@id=\"search\"]")).click();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//*[contains(@id,'getProfile')]"));
		Thread.sleep(1000);

		if (element1.isDisplayed() && element1.isEnabled()) {
			element1.click();
		}
		driver.findElement(By.xpath("/html/body/main/div[4]/div/div/div[1]/button")).click();

	}

//@Test
	public void Agentslogin() throws InterruptedException, AWTException {

		WebElement username = driver.findElement(By.id("yourUsername"));
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("yourPassword"));
		Thread.sleep(1000);
		WebElement login = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		username.sendKeys("arya");
		password.sendKeys("arya");
		login.click();

		Thread.sleep(1000);
		String actualUrl = "https://drjoysmedstore.com/AgentLogin/dashboard.php";
		String expectedUrl = driver.getCurrentUrl();
		Assert.assertEquals(expectedUrl, actualUrl);

	}

//@Test
	public void profile() throws InterruptedException, AWTException {

		WebElement username = driver.findElement(By.id("yourUsername"));
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("yourPassword"));
		Thread.sleep(1000);
		WebElement login = driver
				.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		username.sendKeys("arya");
		password.sendKeys("arya");
		login.click();

		Actions action = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a"));
		action.click(option).build().perform();
		Thread.sleep(1000);

		Actions actions = new Actions(driver);
		WebElement options = driver.findElement(By.xpath("//*[@id=\"projectlist\"]/a/span"));
		actions.click(options).build().perform();

		Thread.sleep(1000);
		driver.findElement(By.name("branch")).clear();
		Thread.sleep(1000);

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"branch\"]"));
		element1.sendKeys("Thattamala");

		Actions action1 = new Actions(driver);
		WebElement option1 = driver.findElement(By.xpath("//*[@id=\"submitbutn\"]"));
		action1.click(option1).build().perform();

		driver.switchTo().alert().accept();

		Assert.assertEquals("My Profile", driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/h4")).getText());
	}

	//@Test
	public void PayoutDetails() throws InterruptedException, AWTException {

		WebElement username = driver.findElement(By.id("yourUsername"));
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("yourPassword"));
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		username.sendKeys("bini");
		password.sendKeys("bini");
		login.click();

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a")).click();

		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[3]/a")).click();
		
		Thread.sleep(2000);

		
		Actions act = new Actions(driver);
		act.doubleClick(driver.findElement(By.xpath("//*[starts-with(text(),' Payout Details')]"))).build().perform();
		
		driver.findElement(By.xpath("//*[@id=\"fromdate\"]")).sendKeys("01-09-2023");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"fromdate\"]")).sendKeys("14-09-2023");
		
		WebElement element=driver.findElement(By.xpath("//*[@id=\"search\"]"));
		element.click();

	}
	

	//@Test
	public void Packagedetailsview() throws InterruptedException, AWTException {

		WebElement username = driver.findElement(By.id("yourUsername"));
		Thread.sleep(1000);
		WebElement password = driver.findElement(By.id("yourPassword"));
		Thread.sleep(1000);
		WebElement login = driver.findElement(By.xpath("/html/body/main/div/section/div/div/div/div[2]/div/form/div[4]/button"));
		username.sendKeys("bini");
		password.sendKeys("bini");
		login.click();
	
		driver.findElement(By.xpath("//*[@id=\"sidebar-nav\"]/li[2]/a")).click();

		Robot robot = new Robot();
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);

		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_ENTER);

	WebElement element= driver.findElement(By.xpath(""));
		element.click();
	
	}
	

	//@AfterTest
	public void closeBrowser() {
		// driver.close();
		//System.out.println("The driver has been closed.");
	}
}
