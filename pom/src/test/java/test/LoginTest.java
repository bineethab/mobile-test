package test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {
	WebDriver driver;
	Login Login;
	Dashboard Dashboard;


	@BeforeClass

	public void setup(){
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://drjoysmedstore.com/drugstore/login.php");
	Login=new Login(driver);
	Dashboard=new Dashboard(driver);
	}
	@Test
	public void validlogin() {
		login.enterUserName("priya");
		login.enterPassword("dundu");
		login.clicklogin();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(Dashboard.welcomeMessage));

	    assert dashboard.isWelcomeMessageDisplayed() : "Welcome message not displayed";
	}

	@AfterClass
	public void tearDown() {
	    driver.quit();
	}
	}
