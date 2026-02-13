import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junittest.Dashboard;
import junittest.Login;

public class LoginTest {
	 WebDriver driver;
	    Login login;
	    Dashboard dashboard;

	    @Before
	    public void setup() {
	    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://drjoysmedstore.com/drugstore/login.php");
	        login = new Login(driver);
	        dashboard = new Dashboard(driver);
	    }

	    @Test
	    public void validLogin() {
	        login.enterUsername("priya");
	        login.enterPassword("dundu");
	        login.clickLogin();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(dashboard.welcomeMessage));

	        assertTrue("Welcome message not displayed", dashboard.isWelcomeMessageDisplayed());
	    }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }
}






	

