package crossbrowsertest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class BaseTest {
	    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	    private String url;

	    @Parameters({"browser", "url"})
	    @BeforeMethod
	    public void setUp(@Optional("chrome") String browser, @Optional("https://righters.in/develop/ddcLives/index.php") String url) {
	        this.url = url;

	        if (browser.equalsIgnoreCase("chrome")) {
	        	 WebDriverManager.chromedriver().setup();
	                driver.set(new ChromeDriver());
	        } else if (browser.equalsIgnoreCase("firefox")) {
	            WebDriverManager.firefoxdriver().setup();
	            driver.set(new FirefoxDriver());

	        } else if (browser.equalsIgnoreCase("edge")) {
	        	WebDriverManager.edgedriver().setup();
                driver.set(new EdgeDriver());
	        } else {
	            throw new IllegalArgumentException("Invalid browser: " + browser);
	        }

	        getDriver().manage().window().maximize();
	        getDriver().get(url); // Open URL
	    }

	    protected WebDriver getDriver() {
	        return driver.get();
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver.get() != null) {
	            driver.get().quit();
	            driver.remove();
	        }
	    }

	    public String getUrl() {
	        return url;
	    }
	}


