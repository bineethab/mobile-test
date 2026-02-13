package med;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mymedpassport {
	public static void main(String[] args) {
      
    	System.setProperty("webdriver.gecko.driver","C:\\Users\\computer-2\\.cache\\selenium\\chromedriver\\win32\\112.0.5615.49\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
    	
        String baseUrl = "https://mymedicalpassport.in/";
        String expectedTitle = "MyMedical Passport";
        String actualTitle = "";

       
        driver.get(baseUrl);

       
        actualTitle = driver.getTitle();

      
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
       
        driver.close();
    }}

