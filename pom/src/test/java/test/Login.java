package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {

	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver=driver;
		pageFactory.initElements(driver,this);
	}

	@FindBy(id="username")
	WebElement usernameField;

	@FindBy(id="password")
	WebElement passwodField;

	@FindBy(id="login")
	WebElement loginButton;

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}
	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}
	public void clicklogin() {
		loginButton.click();
	}



	}
