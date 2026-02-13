package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Codes {

	public static void main(String args[]) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ddcpharmacy.com/medlive/");
		
		System.out.println("directed to url successfully");
		
		String ExpectedTitle="DDC Pharmacy";
		String CurrentTitle=driver.getTitle();
		System.out.println("title:"+CurrentTitle);
		
		if(ExpectedTitle.contains(CurrentTitle)) {
			System.out.println("current and expected title is same");
			driver.quit();
		}
		
	}
}
