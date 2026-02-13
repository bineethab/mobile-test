package pommethod;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
WebDriver driver;

public HomePage(WebDriver driver) {
	this.driver=driver;
	
}
By signupbutton=By.xpath("//a[contains(text(),'Signup / Login')]");


// Action method

public void clickbutton() {
	driver.findElement(signupbutton).click();
}

}