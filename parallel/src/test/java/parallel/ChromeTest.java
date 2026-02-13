package parallel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeTest {
	WebDriver driver;

	@BeforeTest
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://192.168.2.11/medstore/login.php");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)

	public void IngredientsAdd() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Ingredients')]")).click();

		driver.findElement(
				By.xpath("/html/body/div/div[1]/div[1]/section/section/div[1]/div/div/div[2]/div[1]/div[4]/button"))
				.click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ingredientname\"]"));
		element.sendKeys("Potassium Bicarbonate");

		Thread.sleep(1000);

		Select a = new Select(driver.findElement(By.name("ingredienttype")));
		a.selectByVisibleText("Chemicals");

		driver.findElement(By.xpath("//*[@id=\"ingredientstatus\"]")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToType = driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[4]/div/div[3]/div[2]"));
		action.sendKeys(elementToType,
				"Potassium bicarbonate, KHCO3, appears as a white powder or as colorless solid crystal and has a salty taste. It is also known as potash. It is a carbonate salt often used in pharmaceutical applications as a buffering agent for medications to maintain a certain pH")
				.build().perform();

		WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[5]/button"));
		action.click(elementToClick).build().perform();
		Thread.sleep(3000);

	}

	@Test(priority = 2)

	public void IngredientsEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Ingredients')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"display_ingredients\"]/tr[8]/td[4]/a/span")).click();
		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"ingredientstatus2\"]"));
		action.click(elementToClick).build().perform();

		driver.findElement(By.xpath("//*[@id=\"ingupdate\"]")).click();
		driver.quit();

	}

//	@Test(priority = 3)
	public void IngredientsSearch() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Ingredients')]")).click();
		Thread.sleep(2000);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"example1_filter\"]/label/input"));
		element.sendKeys("Dolo");

		driver.quit();
	}

	// @Test(priority = 4)
	public void GenericMedicineAdd() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[contains(text(),'Generic Medicines')]")).click();
		Thread.sleep(2000);

		driver.findElement(
				By.xpath("/html/body/div/div[1]/div[1]/section/section/div[1]/div/div/div[2]/div[1]/div[3]/button"))
				.click();
		Thread.sleep(1000);

		WebElement element = driver.findElement(By.xpath("//*[@id=\"genmed_name\"]"));
		element.sendKeys("Leucovorin");

		Thread.sleep(1000);
		Actions action = new Actions(driver);
		WebElement elementToType = driver
				.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div/div[1]/div[3]/div/div[3]/div[2]"));
		action.sendKeys(elementToType,
				"Leucovorin is a form of folic acid. Folic acid helps your body produce and maintain new cells, and also helps prevent changes to DNA that may lead to cancer")
				.build().perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div/div[1]/div[4]/div/div[3]/div[2]")).sendKeys(
				"Follow all directions on your prescription label. Do not take this medicine in larger or smaller amounts or for longer than recommended.When treating an accidental overdose, leucovorin should be started as soon as possible for the best effect.");

		Thread.sleep(1000);

		WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div/div[2]/button"));
		action.click(elementToClick).build().perform();

		driver.quit();

	}

	// @Test(priority = 5)
	public void genericEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Products')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(2000);

		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Generic Medicines')]"));
		action.click(elementToClick1).build().perform();

		driver.findElement(By.xpath("//*[@id=\"display_genericmedicine\"]/tr[1]/td[3]/a/span")).click();
		Thread.sleep(2000);

		WebElement element = driver
				.findElement(By.xpath("//*[@id=\"frmeditgeneric\"]/div/div/div[1]/div[7]/div/div[3]/div[2]"));
		element.sendKeys(
				"Remember, keep this and all other medicines out of the reach of children, never share your medicines with others, and use acetaminophen only for the indication prescribed");
		Thread.sleep(1000);

		WebElement elementToClick2 = driver.findElement(By.xpath("//*[@id=\"genmedupdate\"]"));
		action.click(elementToClick2).build().perform();

		System.out.println("update button clicked");
		driver.quit();
	}

	// @Test(priority = 6)
	public void DealerAdd() throws InterruptedException, AWTException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Dealers')]"));
		action1.click(elementToClick1).build().perform();

		Thread.sleep(2000);

		driver.findElement(By.xpath("/html/body/div/div[1]/section/div[1]/div/div/div[2]/button")).click();
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('deal_name').setAttribute('value', 'B R Distributors');"
				+ "document.getElementById('deal_Address').setAttribute('value', '2,Bhagwat Market, Film Colony, Jaipur, Rajasthan');"
				+ "document.getElementById('deal_regno').setAttribute('value', '4213');"
				+ "document.getElementById('deal_email').setAttribute('value', 'brdistributors@gmail.com');"
				+ "document.getElementById('deal_url').setAttribute('value', 'https://www.dawabazar.in/b_r_distributors_jaipur/21892/dealer_profile');"
				+ "document.getElementById('deal_phone').setAttribute('value', '1412316052')");

		WebElement element = driver.findElement(By.xpath("//*[@id=\"deal_contno\"]"));
		element.sendKeys("7034732676");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"add_deal\"]/div/div/div[5]/div/div/span/span[1]/span/ul/li/input"))
				.sendKeys("Alenn");
		Thread.sleep(4000);

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);

		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		element1.sendKeys("a");

		driver.findElement(By.xpath("//*[@id=\"add_deal\"]/div/div/div[6]/div[1]/div[2]/button")).click();

		driver.findElement(By.name("deal_productchkkk[]")).click();
		robot.keyPress(KeyEvent.VK_ENTER);
		driver.quit();
	}

	// @Test(priority = 7)
	public void DealerEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Dealers')]"));
		action1.click(elementToClick1).build().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"display_dealers\"]/tr[1]/td[5]/span")).click();

		Thread.sleep(1000);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"deal_editdealgst\"]"));
		element1.sendKeys("06AFMPA4170N1ZB");

		driver.findElement(By.xpath("//*[@id=\"updatedealer\"]")).click();
		driver.quit();
	}

	// @Test(priority = 8)
	public void StockistAdd() throws InterruptedException, AWTException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Stockist')]")).click();

		driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div[1]/div/div/div/div[2]/div[1]/button"))
				.click();
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('stockname').setAttribute('value', 'Harsh Pharma');"
				+ "document.getElementById('stockaddress').setAttribute('value', 'G-28, Mayur Tower, Film Colony, Jaipur, Rajasthan - 302003');"
				+ "document.getElementById('stockreg').setAttribute('value', '8956');"
				+ "document.getElementById('stockemail').setAttribute('value', 'harshpharm@gmail.com');"
				+ "document.getElementById('stockurl').setAttribute('value', 'dawabazar.in/harsh_pharma_jaipur/21717/dealer_profile');"
				+ "document.getElementById('stockphone').setAttribute('value', '9414076958');"
				+ "document.getElementById('stockperson').setAttribute('value', 'harsh');"
				+ "document.getElementById('stocknumber').setAttribute('value', '8891228547')");

		driver.findElement(By.xpath("//*[@id=\"adstock\"]/div/div/div[3]/div[3]/div/div/span/span[1]/span/ul/li/input"))
				.click();
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Thread.sleep(2000);
		By option = By.xpath("//*[text()='Accure Labs Pvt']");
		wait.until(ExpectedConditions.elementToBeClickable(option));
		driver.findElement(option).click();

		WebElement element = driver.findElement(
				By.xpath("//*[@id=\"adstock\"]/div/div/div[3]/div[4]/div/div/span/span[1]/span/ul/li/input"));
		element.click();

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"btnadstock\"]"));
		element1.click();
		driver.quit();
	}

	// @Test(priority = 9)
	public void StockistEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Stockists')]"));
		action1.click(elementToClick1).build().perform();
		Thread.sleep(1000);

		Actions action2 = new Actions(driver);
		WebElement elementToClick2 = driver.findElement(By.xpath("//*[@id=\"editstokist\"]"));
		action1.click(elementToClick2).build().perform();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"edit_stockistemail\"]")).sendKeys("abthameds@gmail.com");

		Thread.sleep(2000);
		WebElement element1 = driver.findElement(By.xpath("//*[@id=\"stokiupdate\"]"));
		element1.click();
		driver.quit();

	}

	// @Test(priority = 10)
	public void StoreAdd() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[contains(text(),'Stores')]")).click();

		driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div/div[1]/div/div/div[2]/button")).click();

		WebElement inputField = driver.findElement(By.xpath("//*[@id=\"storename\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value='Metro Medicals';", inputField);

		Thread.sleep(1000);
		Select a = new Select(driver.findElement(By.name("storetype")));
		a.selectByVisibleText("Shop");

		WebElement text = driver.findElement(By.id("storeaddress"));
		text.click();
		text.sendKeys("Metro Medicals, Ayathil, Kollam - 691021");

		WebElement text1 = driver.findElement(By.id("mnfrom"));
		text1.click();
		text1.sendKeys("09:30");

		WebElement inputField1 = driver.findElement(By.xpath("//*[@id=\"mnto\"]"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].value='07:30';", inputField1);

		driver.findElement(By.xpath("//*[@id=\"checkedbox\"]")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"storeconname\"]")).sendKeys("Ajithakumar");
		driver.findElement(By.xpath("//*[@id=\"storeconphone\"]")).sendKeys("9656931233");

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[@id=\"storeadd\"]"));
		action.click(elementToClick).build().perform();

		driver.quit();
	}

	// @Test(priority = 11)
	public void StoreEdit() throws InterruptedException {

		try {

			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();

			driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[contains(text(),'Stores')]")).click();

			driver.findElement(By.xpath("//*[@id=\"ed_store\"]")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[@id=\"ed_storeaddress\"]"))
					.sendKeys("Aswas Life Care Pvt Ltd KrishnaGeetham,Near Railway gate,Balaramapuram,");

			WebElement inputField = driver.findElement(By.xpath("//*[@id=\"ed_mnto1\"]"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].value='21:00';", inputField);

			driver.findElement(By.xpath("//*[@id=\"ed_storeedit\"]")).click();
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//	@Test(priority = 12)
	public void VendorAdd() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Vendor supplies')]"));
		action1.click(elementToClick1).build().perform();

		Thread.sleep(2000);

		Select a = new Select(driver.findElement(By.name("su_type")));
		a.selectByVisibleText("Dealer");

		Select f = new Select(driver.findElement(By.name("name_su")));
		f.selectByVisibleText("Alenn");

		driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div[1]/div[1]/div/div/div[3]/div[3]/button"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"addnewclear\"]")).click();
		Thread.sleep(1000);

		Select d = new Select(driver.findElement(By.name("orderproduct")));
		d.selectByVisibleText("Pro Nan");

		Select b = new Select(driver.findElement(By.name("orderpacking")));
		b.selectByVisibleText("Ampules");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('min_qt').setAttribute('value', '5');"
				+ "document.getElementById('max_qt').setAttribute('value', '8');"
				+ "document.getElementById('eoq_ven').setAttribute('value', '1');"
				+ "document.getElementById('price_vend').setAttribute('value', '380');"
				+ "document.getElementById('delivery_vend').setAttribute('value', '5');"
				+ "document.getElementById('not_vendor').setAttribute('value', 'available')");
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"vend_add_table\"]")).click();
		Thread.sleep(2000);

		WebElement button = driver.findElement(By.id("addvend"));
		button.click();

	}

	// @Test(priority = 13)
	public void VendorEdit() throws InterruptedException {

		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("login")).click();
		Thread.sleep(1000);

		Actions action = new Actions(driver);
		WebElement elementToClick = driver.findElement(By.xpath("//*[contains(text(),'Inventory')]"));
		action.click(elementToClick).build().perform();
		Thread.sleep(2000);

		Actions action1 = new Actions(driver);
		WebElement elementToClick1 = driver.findElement(By.xpath("//*[contains(text(),'Vendor supplies')]"));
		action1.click(elementToClick1).build().perform();

		Thread.sleep(2000);
		Select a = new Select(driver.findElement(By.name("su_type")));
		a.selectByVisibleText("Dealer");

		Select f = new Select(driver.findElement(By.name("name_su")));
		f.selectByVisibleText("Alenn");

		driver.findElement(By.xpath("/html/body/div/div[1]/section/div/div/div[1]/div[1]/div/div/div[3]/div[3]/button"))
				.click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"vendor_tabledisplay\"]/tr[1]/td[2]/a")).click();

		Thread.sleep(1000);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"ed_delivery_vend\"]"));
		element.sendKeys(Keys.CONTROL + "a");
		element.sendKeys(Keys.DELETE);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"ed_delivery_vend\"]")).sendKeys("9");

		WebElement button = driver.findElement(By.id("update_vendorsup"));
		button.click();
	}

	// @Test(priority = 14)
	public void VendorDelete() throws InterruptedException {

		try {
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("login")).click();
			Thread.sleep(1000);

			driver.findElement(By.xpath("//*[contains(text(),'Inventory')]")).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath("//*[contains(text(),'Vendor Supplies')]")).click();
			Thread.sleep(2000);

			Select a = new Select(driver.findElement(By.name("su_type")));
			a.selectByVisibleText("Dealer");

			Select f = new Select(driver.findElement(By.name("name_su")));
			f.selectByVisibleText("Alenn");

			driver.findElement(
					By.xpath("/html/body/div/div[1]/section/div/div/div[1]/div[1]/div/div/div[3]/div[3]/button"))
					.click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//*[@id=\"vendor_tabledisplay\"]/tr[1]/td[2]/a")).click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//*[@id=\"delete_vendbt\"]")).click();
			driver.findElement(By.xpath("//*[@id=\"toast-container\"]/div/div[2]/button[1]")).click();
			driver.quit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
