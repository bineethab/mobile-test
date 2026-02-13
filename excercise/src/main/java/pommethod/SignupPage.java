package pommethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage {
WebDriver driver;
WebDriverWait wait;
public SignupPage(WebDriver driver) {
	
	this.driver=driver;
	wait=new WebDriverWait(driver,Duration.ofSeconds(10));
}

//signup fields
By namefield=By.name("name");
By emailfield=By.cssSelector("input[data-qa='signup-email']");
By SignUpfield=By.xpath("//button[normalize-space()='Signup']");
By emailExistsalert=By.xpath("//p[normalize-space()='Email Address already exist!']");

//Account creation

By gender=By.id("title");
By password=By.id("password");
By daysDropdown = By.id("days");
By monthsDropdown = By.id("months");
By yearsDropdown = By.id("years");
By firstName = By.id("first_name");
By lastName = By.id("last_name");
By address1 = By.id("address1");
By countryDropdown = By.id("country");
By state = By.id("state");
By city = By.id("city");
By zipcode = By.id("zipcode");
By mobileNumber = By.id("mobile_number");
By createAccountButton = By.xpath("//button[@data-qa='create-account']");


//Action methods

public void enterName(String name) {
	driver.findElement(namefield).sendKeys(name);
}
	public void enterEmail(String email) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		driver.findElement(emailfield).sendKeys(email);
	}
	
	public void clickSignup() {
		driver.findElement(SignUpfield).click();
}
	
public String getEmailValidationMessage() {
	JavascriptExecutor js=(JavascriptExecutor) driver;
	return (String) js.executeScript("return document.getElementById('email').validationMessage;");
	}
	
	public boolean isEmailAlreadyRegistered() {
		try {
			WebElement alert=wait.until(ExpectedConditions.visibilityOfElementLocated(emailExistsalert));
			return alert.isDisplayed();
			
		}catch(TimeoutException e) {
			return false;
		}}
		public String generateEmail() {
			return "test" +System.currentTimeMillis()+"@gmail.com";
		}
		
		  public void fillAccountDetails(String password, String day, String month, String year,
                  String fName, String lName, String addr,
                  String country, String stateText, String cityText,
                  String zip, String mobile) {

driver.findElement(gender).click();
driver.findElement(password).sendKeys(password);

new Select(driver.findElement(daysDropdown)).selectByVisibleText(day);
new Select(driver.findElement(monthsDropdown)).selectByVisibleText(month);
new Select(driver.findElement(yearsDropdown)).selectByVisibleText(year);

driver.findElement(firstName).sendKeys(fName);
driver.findElement(lastName).sendKeys(lName);
driver.findElement(address1).sendKeys(addr);
new Select(driver.findElement(countryDropdown)).selectByVisibleText(country);
driver.findElement(state).sendKeys(stateText);
driver.findElement(city).sendKeys(cityText);
driver.findElement(zipcode).sendKeys(zip);
driver.findElement(mobileNumber).sendKeys(mobile);

driver.findElement(createAccountButton).click();




}











