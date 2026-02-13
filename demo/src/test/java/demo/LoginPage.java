package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
WebDriver driver;
WebDriverWait wait;

By username=By.id("user-name");
By password=By.id("password");
By loginbtn=By.id("login-button");
By productsTitle = By.className("title");
By errorMessage=By.cssSelector("h3[data-test='error']");

public LoginPage(WebDriver driver) {
	this.driver=driver;
	this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
}
public void enterUsername(String user) {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(username)) .sendKeys(user);
}
public void enterPassword(String pass) {
	 wait.until(ExpectedConditions.visibilityOfElementLocated(password)) .sendKeys(pass);
}
public void clickLogin() {
	 wait.until(ExpectedConditions.elementToBeClickable(loginbtn)).click();
}
public boolean isLoginSuccessful() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(productsTitle)).getText().equals("Products");
	
}
public String errorMsg() {
	return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
}
}
