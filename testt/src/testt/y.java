package testt;

public class y {
	System.setProperty("webdriver.chrome.driver","chromedriver");
	WebDriver driver=new ChromeDriver();

	driver.manage().window().maximize();
	driver.get("https://www.w3schools.com/html/html_tables.asp");
	WebElement table = driver.findElement(By.id("customers"));

	        // Fetch all rows inside the table
	        List<WebElement> rows = table.findElements(By.tagName("tr"));
	boolean isislandtradingfound=false;
	Log.info("Number of rows found: " + rows.size());
}
