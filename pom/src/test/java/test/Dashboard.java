package test;

import org.openqa.selenium.WebDriver;

public class Dashboard {
	WebDriver driver;

	public void Dashboard(WebDriver,driver) {
		this.driver=driver;
	PageFactory.initElements(driver,this)	;

	}
	@FindBy(xpath="/html/body/div/div[1]/section/div/div/div/div/div/div/h3")
	WebElement welcomeMessage;
	if(welcomeMessage.isDisplayed()) {
		System.out.println("login successful");
		
	}else {
		System.out.println("login unsuccessful");
	}
	}
