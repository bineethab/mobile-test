package ddcparallel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
	
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.*;


	public abstract class BaseTest {
	    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	    private String url;

	    @Parameters({"browser", "url"}) // Get browser type from TestNG XML
	    @BeforeMethod
	    public void setUp(@Optional("chrome") String browser, String url) {
	        this.url = url;
	        setupDriver(browser);
	        getDriver().manage().window().maximize();
	        getDriver().get(url);
	    }

	    private void setupDriver(String browser) {
	        switch (browser.toLowerCase()) {
	            case "firefox":
	                WebDriverManager.firefoxdriver().setup();
	                driver.set(new FirefoxDriver());
	                break;
	            case "edge":
	                WebDriverManager.edgedriver().setup();
	                driver.set(new EdgeDriver());
	                break;
	            case "chrome":
	            default:
	                WebDriverManager.chromedriver().setup();
	                driver.set(new ChromeDriver());
	                break;
	        }
	    }

	    @AfterMethod
	    public void tearDown() {
	        if (driver.get() != null) {
	            try {
	                WebDriver webDriver = driver.get();
	                if (webDriver != null) {
	                    webDriver.quit(); // Ensures all tabs & browser windows close
	                }
	            } catch (Exception e) {
	                System.out.println("Error while closing browser: " + e.getMessage());
	            } finally {
	                driver.remove(); // Prevent memory leaks
	            }
	        }
	    }

	    protected WebDriver getDriver() {
	        return driver.get();
	    }

	    public String getUrl() {
	        return url;
	    }
	}
