package med;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class DrugStore {
	@Test
	public void IngredientsAdd() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	
     WebDriver driver= new ChromeDriver();
	
	driver.manage().window().maximize();
	 driver.get("http://192.168.2.11/medstore/manufacturer.php");
	 
	      Thread.sleep(9000);
	 driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[contains(text(),'Ingredients')]")).click();

	 driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/section/section/div[1]/div/div/div[2]/div[1]/div[4]/button")).click();
	 
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"ingredientname\"]")).sendKeys("Hyaluronic acid ");
	 Thread.sleep(1000);
	 Select a=new Select(driver.findElement(By.name("ingredienttype")));
	  a.selectByVisibleText("Fillers");
	 driver.findElement(By.xpath("//*[@id=\"ingredientstatus\"]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[4]/div/div[3]/div[2]")).sendKeys("a naturally occurring acid in your skin. It gives your skin volume and keeps it hydrated. With age, your body stops making hyaluronic acid. Results from HA injections usually last six months to a year.");
	   
	 driver.findElement(By.xpath("//*[@id=\"frmadd\"]/div/div[5]/button")).click();
	 driver.quit();
	}
	//@Test
	public void IngredientsEdit() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		
	 driver.get("http://192.168.2.11/medstore/manufacturer.php");
	 
	      Thread.sleep(2000);
	 driver.findElement(By.xpath("//*[contains(text(),'Products')]")).click();
	 Thread.sleep(1000);
	 driver.findElement(By.xpath("//*[contains(text(),'Ingredients')]")).click();
	Thread.sleep(2000)  ;
	driver.findElement(By.xpath("//*[@id=\"display_ingredients\"]/tr[8]/td[4]/a/span")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"ingredientstatus2\"]")).click();
	driver.findElement(By.xpath("//*[@id=\"ingupdate\"]")).click();
	driver.quit();

	}
}
