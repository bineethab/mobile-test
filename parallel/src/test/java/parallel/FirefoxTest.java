package parallel;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirefoxTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() {

		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get("http://192.168.2.11/medstore/login.php");
		driver.manage().window().maximize();
	}

	// @Test(priority = 1)
	public void ManufacturerAdd() throws Exception {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Manufacturers')]"));
		action1.click(elementToClick1).build().perform();

		driver.findElement(By.xpath("//*[@id=\"newmanufactur\"]")).click();
		Thread.sleep(2000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('newname').setAttribute('value', 'Divi's Laboratories');"
				+ "document.getElementById('manaddress').setAttribute('value', '1-72/23(P)/DIVIS/303, Divi Towers,Cyber Hills, Gachibowli, Hyderabad,Telangana, India – 500 032');"
				+ "document.getElementById('regno').setAttribute('value', '11854');"
				+ "document.getElementById('manemail').setAttribute('value', 'mail@divislaboratories');"
				+ "document.getElementById('manweb').setAttribute('value','https://www.divislabs.com/');"
				+ "document.getElementById('manphone').setAttribute('value','8891228547');"
				+ "document.getElementById('contactname').setAttribute('value','MADHUSUDANA RAO DIVI');"
				+ "document.getElementById('conaddress').setAttribute('value','Lingojigudem Village,Choutuppal Mandal,Yadadri Bhuvanagiri Dist,Telangana – 508 252');"
				+ "document.getElementById('connumber').setAttribute('value','918694257006');"
				+ "document.getElementById('conemail').setAttribute('value', 'mail@divislaboratories.com')");

		Thread.sleep(1000);

		driver.findElement(By.id("newsave")).click();

		try {

			if (driver.findElement(By.id("newsave")).isDisplayed() == true) {

				System.out.println("clicked correctly");
			}

		} catch (Exception e) {

			System.out.println("U Clicked Button1 text is not displayed. so failing or throwing again to fail test");
			throw new Exception(e.getMessage());
		}

	}

	// @Test(priority = 2)

	public void BrandAdd() throws InterruptedException {
		try {

			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();
			Thread.sleep(1000);
			Actions action = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
			action.click(elementToClick).build().perform();
			Thread.sleep(1000);

			Actions action1 = new Actions(driver);
			WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Brands')]"));
			action1.click(elementToClick1).build().perform();

			driver.findElement(By.xpath("//*[@id=\"quick_add\"]")).sendKeys("ABZORB");
			Thread.sleep(2000);
			Select a = new Select(driver.findElement(By.name("employee")));
			a.selectByVisibleText("Cadila Pharmaceuticals Ltd");

			driver.findElement(By.xpath("//*[@id=\"quickadd\"]")).click();

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	@Test(priority = 3)
	public void BrandEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Brands')]"));
		action1.click(elementToClick1).build().perform();

		driver.findElement(By.xpath("//*[@id=\"display_brand\"]/tr[7]/td[5]/span")).click();

		WebElement Choosefile = driver.findElement(By.name("brandlog"));
		Choosefile.sendKeys("C:\\Users\\computer-2\\Downloads\\med images\\ee.jpg");

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"editbr\"]/div[1]/div/div/div/div/div[5]/div/div[3]/div[2]")).sendKeys(
				"Cadila Pharmaceuticals is an Indian multinational pharmaceutical company based in Ahmedabad, Gujarat, India.");
		Thread.sleep(1000);

		WebElement element = driver.findElement(
				By.xpath("/html/body/div[1]/section/div/div/div/div/div[3]/div[2]/div/div/div[2]/form/div[2]/button"));
		element.click();
	}

	// @Test(priority = 4)
	public void ManufacturerEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Manufacturers')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"editman\"]")).click();

		Thread.sleep(2000);
		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"editcontemail\"]"));
		element2.sendKeys(Keys.CONTROL + "a");
		element2.sendKeys(Keys.DELETE);

		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"editcontemail\"]"));
		element.sendKeys("info@lupin.com");

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"manupdate\"]"));
		element1.click();

	}

	// @Test(priority = 5)
	public void InvalidBrandLogo() throws InterruptedException {

		try {

			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();

			Actions action = new Actions(driver);
			WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
			action.click(elementToClick).build().perform();
			Thread.sleep(1000);

			Actions action1 = new Actions(driver);
			WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Brands')]"));
			action1.click(elementToClick1).build().perform();

			driver.findElement(By.xpath("//*[@id=\"display_brand\"]/tr[3]/td[5]/span")).click();
			Thread.sleep(2000);

			WebElement Choosefile = driver.findElement(By.name("brandlog"));
			Choosefile.sendKeys("C:\\Users\\BINEETHA\\Desktop\\New folder\\word.docx");
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[@id=\"update\"]")).click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// @Test(priority = 6)
	public void DistributorAdd() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Distributors')]"));
		action1.click(elementToClick1).build().perform();

		driver.navigate().refresh();

		driver.findElement(By.xpath("/html/body/div/section/div/div/div/div/div[2]/button")).click();
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('dis_name').setAttribute('value', 'DEY'S MEDICAL STORES');"
				+ "document.getElementById('dis_address').setAttribute('value', '62, Bondel Road ,Kolkata - 700 019');"
				+ "document.getElementById('dis_address').setAttribute('value', '17847');"
				+ "document.getElementById('dis_reg').setAttribute('value', 'info@deysmedical.com');"
				+ "document.getElementById('dis_email').setAttribute('value','https://www.deysmedical.com/');"
				+ "document.getElementById('dis_web').setAttribute('value','https://www.deysmedical.com/');"
				+ "document.getElementById(dis_phone'').setAttribute('value',' 9332287138');"
				+ "document.getElementById('dis_cname').setAttribute('value','GAUTAM ');"
				+ "document.getElementById('dis_tin').setAttribute('value','U51217WB1949PTC017847 ');"
				+ "document.getElementById('dis_caddress').setAttribute('value', '1B, DEODAR STREET KOLKATA Kolkata WB 700019 IN')");

		driver.findElement(By.xpath("//*[@id=\"addistri\"]/div/div[3]/div[3]/div/div/span/span[1]/span/ul/li/input"))
				.click();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Thread.sleep(2000);
		By option = By.xpath("//*[text()='Abbott']");
		wait.until(ExpectedConditions.elementToBeClickable(option));
		driver.findElement(option).click();

		driver.findElement(By.xpath("//*[@id=\"addnewmodal\"]")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"addistri\"]/div/div[3]/div[5]/div/div/span/span[1]")).click();
		Thread.sleep(2000);
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(40));
		Thread.sleep(2000);
		By option1 = By.xpath("//*[contains(.,'S & J Sales Corporation')]");
		wait1.until(ExpectedConditions.elementToBeClickable(option1));
		driver.findElement(option1).click();

		WebElement element = driver.findElement(By.xpath("//*[contains(@name,'saveadd')]"));
		element.click();

	}

	// @Test(priority = 7)
	public void DistributorEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();

		WebElement element1 = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		element1.click();
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//*[contains(text(),'Distributors')]"));
		element2.click();

		driver.findElement(By.xpath("//*[@id=\"display_distri\"]/tr[1]/td[5]/span")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"dis_editgst\"]"));
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"dis_editgst\"]")).sendKeys("6AAFFA4523K1ZM");

		WebElement element4 = driver.findElement(By.xpath("//*[@id=\"update\"]"));
		element4.click();

	}

	// @Test(priority = 8)
	public void DeliveryQuickAdd() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Delivery Areas')]"));
		action1.click(elementToClick1).build().perform();

		WebElement element = driver.findElement(By.xpath("//*[@id=\"quick_del_location\"]"));
		element.sendKeys("Attukal");

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"quick_del_pincode\"]"));
		element1.sendKeys("695009");

		driver.findElement(By.xpath("//*[@id=\"quickadd_del\"]")).click();
	}

	// @Test(priority = 9)
	public void DeliveryAdd() throws InterruptedException {

		try {

			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();
			Thread.sleep(1000);
			
			
			driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Delivery Areas')]")).click();

			Thread.sleep(2000);
			driver.findElement(
					By.xpath("/html/body/div/div[1]/section/div/div/div[1]/div/div/div/form/div/div[4]/button"))
					.click();

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.getElementById('add_area_lctn').setAttribute('value', 'Beemapally');"
					+ "document.getElementById('add_area_pin').setAttribute('value', '695008')");

			Select a = new Select(driver.findElement(By.xpath("//*[@id=\"add_area_cntry\"]")));
			a.selectByVisibleText("India");

			Select b = new Select(driver.findElement(By.xpath("//*[@id=\"add_area_state\"]")));
			b.selectByVisibleText("Kerala");
			Thread.sleep(1000);

			WebElement element = driver.findElement(By.xpath("//*[@id=\\\"add_area_dis\\\"]"));
			element.click();

			WebElement element4 = driver.findElement(By.xpath("//*[text()='Kollam (Quilon)']"));
			element4.click();

			driver.findElement(By.xpath("//*[@id=\"add_area\"]")).click();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	// @Test(priority = 10)
	public void DeliveryEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();

		Actions action1 = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action1.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Delivery Areas')]"));
		action.click(element).build().perform();

		driver.findElement(By.xpath("//*[@id=\"ed_store\"]")).click();
		Thread.sleep(1000);

		WebElement element2 = driver
				.findElement(By.xpath("//*[@id=\"form_updatedel\"]/div/div/div[1]/div[7]/div[2]/div/div[3]/div[2]"));
		element2.sendKeys("alappuzha");

		driver.findElement(By.xpath("//*[@id=\"updatedeli\"]")).click();
	}

	// @Test(priority = 11)
	public void DeliveryInlineEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Delivery Areas')]")).click();

		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"tables_delivery\"]/tr[1]/td[1]"));
		element2.sendKeys("alappuzha");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"tabledata1_filter\"]"));
		element.click();

	}

//	@Test(priority = 12)
	public void PackingTypes() throws InterruptedException {

		
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Product Settings')]")).click();

		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[1]/section/section/section/div/div/div/div[1]/div[2]/div[3]/div/div/div[2]/button/i"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"packingtype\"]")).sendKeys("");

		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"musicinfo\"]/div[2]/button"));
		element2.click();

	}

	// @Test(priority = 13)
	public void MeasuringUnits() throws InterruptedException {

		driver.get("http://192.168.2.11/medstore/login.php");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		
		Actions action1 = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
		action1.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Product Settings')]"));
		action.click(element).build().perform();

		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[1]/section/section/section/div/div/div/div[1]/div[2]/div[4]/div/div/div[2]/button/i"))
				.click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"measureunit\"]")).click();
		Thread.sleep(2000);

		WebElement element5 = driver.findElement(By.xpath("//*[@id=\"measureunit\"]"));
		element5.sendKeys("Gallon");

		WebElement element6 = driver.findElement(By.xpath("//*[@id=\"shortname\"]"));
		element6.sendKeys("gal");

		driver.findElement(By.xpath(
				"/html/body/div[1]/div[1]/div[1]/section/section/section/div/div/div/div[5]/div/div/div[2]/form/div/div/div/div[3]/button"))
				.click();
		Thread.sleep(1000);
	}

	// @Test(priority = 14)
	public void ProductClassification() throws InterruptedException {

		driver.get("http://192.168.2.11/medstore/login.php");
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Actions action1 = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
		action1.click(elementToClick).build().perform();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Product Settings')]"));
		action.click(element).build().perform();

		driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[1]/section/section/section/div/div/div/div[1]/div[2]/div[1]/div/div/div[2]/button")).click();
		Thread.sleep(1000);

		WebElement element5 = driver.findElement(By.xpath(
				"/html/body/div/div[1]/div[1]/section/section/section/div/div/div/div[1]/div[2]/div[1]/div/div/div[2]/button"));element5.sendKeys("Skin Care");

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"serial\"]")).sendKeys("4");
		Thread.sleep(1000);

		WebElement element2 = driver.findElement(By.xpath("//*[@id=\"musicinfo\"]/div[3]/button"));
		element2.click();

	}

	// @AfterTest
	public void tearDown() {
		driver.close();
	}
}
