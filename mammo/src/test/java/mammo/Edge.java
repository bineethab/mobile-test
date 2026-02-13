package mammo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edge {
	WebDriver driver;

	@BeforeTest
	public void setUp() throws InterruptedException {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://drjoysmammografia.com/");
		driver.manage().window().maximize();
		
	
	}
	

	// @Test(priority = 1)
	public void Appointment() throws InterruptedException {
		

		Thread.sleep(5000);
		Alert alert = driver.switchTo().alert();
		alert.accept();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[9]/a")).click();

		Thread.sleep(2000);

		driver.switchTo().frame("myIfr");

		Actions action = new Actions(driver);
		WebElement option = driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]"));
		action.click(option).build().perform();

		Thread.sleep(1000);

	
		driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("bini123");

		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		WebElement l = driver.findElement(By.xpath("//*[@data-dismiss='modal']"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[starts-with(text(),'Appointment')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[2]/div/div/div/div[1]/span[2]/a")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"date\"]")).sendKeys("24-01-2023");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"time\"]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"time\"]")).sendKeys("15:36");
		driver.findElement(By.xpath("//*[@id=\"save\"]")).click();
		Thread.sleep(2000);
		
		Alert alert1 = driver.switchTo().alert();
		String alertMessage1 = driver.switchTo().alert().getText();
		System.out.println(alertMessage1);
		alert1.accept();
		driver.quit();
	}
// @Test

	public void Register() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.navigate().refresh();
		
		
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul/li[8]/a")).click();
		Thread.sleep(1000);

		driver.switchTo().frame("myIfr");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[1]")).click();

		Thread.sleep(1000);

		
		driver.findElement(By.name("name")).sendKeys("Radhika k");
		driver.findElement(By.name("email")).sendKeys("radhu123@gmail.com");
		driver.findElement(By.name("Phonenumber")).sendKeys("9909453870");
		driver.findElement(By.name("password")).sendKeys("radhu");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"registerForm\"]/input[5]")).click();
		Thread.sleep(5000);
		Alert alert1 = driver.switchTo().alert();
		String alertMessage1 = driver.switchTo().alert().getText();
		System.out.println(alertMessage1);
		alert1.accept();
		driver.quit();
	}

	// @Test
	public void AppointmentWithoutLogin() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[starts-with(text(),'Appointment')]")).click();
		Thread.sleep(1000);

		driver.quit();
	}

	// @Test
	public void PackageWithoutLogin() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/header/div/div/div/div[2]/ul/li[3]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[3]/div/a[2]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div[2]/div[1]/div/div[2]/div/button")).click();
		driver.quit();
	}

	// @Test
	public void AppDetailsWithoutLogin() throws InterruptedException {
		
		
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[starts-with(text(),'Appointment')]")).click();
		driver.quit();

	}

	// @Test
	public void AppointmentDetails() throws InterruptedException {
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("myIfr");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
		driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("bini123");

		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		WebElement l = driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[1]/div/ul/li[2]")).click();

	}

	// @Test
	public void AccountEdit() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();

		Thread.sleep(1000);

		driver.switchTo().frame("myIfr");
		driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
		driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("bini123");

		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		WebElement l = driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/section/div[2]/div/div/div[2]/div/div[3]/div/h5/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"userForm\"]/div/div[3]/div[1]/div[4]/input")).sendKeys("12");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		driver.quit();
	}

	// @Test
	public void PackageDetails() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"counterform\"]/div/div/div[1]/button")).click();
		Thread.sleep(1000);
		driver.switchTo().frame("myIfr");

		driver.findElement(By.xpath("//*[contains(text(),'Register')]")).click();

		Thread.sleep(1000);

		driver.findElement(By.xpath("//*[@id=\"home\"]/div[1]/div[2]/div[1]/div/div/button[2]")).click();
		driver.findElement(By.name("name")).sendKeys("beenabineetha@gmail.com");
		driver.findElement(By.name("password")).sendKeys("bini123");

		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div/div/form/input[3]")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();

		WebElement l = driver.findElement(By.xpath("//*[contains(@data-dismiss,'modal')]"));
		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();", l);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"packagedetails\"]")).click();

	}

}

		
