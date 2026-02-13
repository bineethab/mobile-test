package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Paralleltest {
	@Test
	public void ProductsSearchByCategory()throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://192.168.2.11/medstore/manufacturer.php");
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/aside/div/nav/ul/li[1]/a")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("/html/body/div[1]/aside/div/nav/ul/li[1]/ul/li[1]/a")).click();
       
		Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"categoryfilter\"]")).sendKeys("pain relief");
		
        Thread.sleep(2000);
        
        driver.findElement(By.xpath("//*[@id=\"frmaddcategoryfilter\"]/div/div[2]/button")).click();
        driver.quit();
      
}}
