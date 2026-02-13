package packages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class Page {
WebDriver driver;

By username = By.id("username");   
By password = By.id("password");   
By loginBtn = By.cssSelector("button.radius");  
By message = By.id("flash");

public Page (WebDriver driver) {
	this.driver=driver;
}
	public void enterUsername(String user) {
		driver.findElement(username).sendKeys(user);
	}

public void enterPassword(String pass) {
    driver.findElement(password).sendKeys(pass);
}
public void clickLogin() {
	driver.findElement(loginBtn).click();
}

public String getMessage() {
	return driver.findElement(message).getText();
		
	}



}




