package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pommethod.HomePage;
import pommethod.SignupPage;

public class BaseTest {
	 protected WebDriver driver;
	    protected HomePage homepage;
	    protected SignupPage signuppage;
	

	    @BeforeMethod
	    public void setup() {
	    	
	        System.setProperty("webdriver.chrome.driver", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64 (4)\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://automationexercise.com/");
	        homepage = new HomePage(driver);
	        signuppage = new SignupPage(driver);
	      
	    }

	    @AfterMethod
	    public void tearDown() {
	        driver.quit();
	    }
	}

