package mobiletest;

import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.jline.internal.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

public class medstore {
	
	    WebDriver driver;

	    @BeforeMethod
	    public void setup() throws Exception {
	    	UiAutomator2Options options = new UiAutomator2Options();
	        options.setCapability("platformName", "Android");
	        options.setCapability("platformVersion", "14");
	        options.setCapability("deviceName", "Galaxy A13");
	        options.setCapability("browserName", "chrome");
	        options.setCapability("chromedriverExecutable", "C:\\Users\\computer-2\\Downloads\\chromedriver-win64\\chromedriver.exe");
	        options.setCapability("newCommandTimeout", 300);

	        // Initialize RemoteWebDriver with Appium server URL and options
	        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), options);
	        // Navigate to the specified URL
	        driver.get("https://drjoysmedstore.com/medlive/");
	    }

	@Step("Test the URL ")
	@Feature("URL verification")
	@Description("Verify URL is correct")
	public void URLverification() {
		String currentURL = driver.getCurrentUrl();

		String expectedURL = "https://drjoysmedstore.com/medlive/";

		Assert.assertEquals(driver.getCurrentUrl(), "https://drjoysmedstore.com/medlive/");
	}

	@Test(priority=2)
	@Step("Test the login functionality")
	@Feature("login functionality")
	@Description("verify Login functionality is working properly")
	public void account() {

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement signinbutton = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("account__box")));

		if (signinbutton.isDisplayed()) {
			System.out.println("hello signin button is displayed");
			signinbutton.click();
		} else {
			System.out.println("hello sigin button is not displayed");
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		try {
			// invalid credentials
			WebElement phonenumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
			if (phonenumber.isDisplayed()) {
				System.out.println("phonenumber field is displayed");
				phonenumber.sendKeys("889kl28547");
				Log.info("phonenumber is entered");
				WebElement createAccountButton = driver.findElement(By.id("submitid"));
				createAccountButton.click();

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
						phonenumber);

				if (validationMessage != null && !validationMessage.isEmpty()) {
					System.out.println("Validation message for phone number: " + validationMessage);
				} else {
					System.out.println("No validation message found for phone number.");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Phone number field is not displayed");
		}
		{
			try {
				WebElement password = driver.findElement(By.name("password"));
				if (password.isDisplayed()) {
					System.out.println("password field is displayed");
					password.sendKeys("bbbb");

					Log.info("password is entered");
					WebElement loginButton = driver.findElement(By.id("submitid"));
					loginButton.click();
				}

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
						password);

				if (validationMessage != null && !validationMessage.isEmpty()) {
					System.out.println("Validation message for password: " + validationMessage);
				} else {
					System.out.println("No validation message found for password.");
				}
			} catch (NoSuchElementException e) {
				System.out.println("password field is not displayed");
				Alert alert=driver.switchTo().alert();
				alert.accept();
				
			}
			{
				// valid credentials
				try {
					WebElement phonenumber = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
					if (phonenumber.isDisplayed()) {
						System.out.println("Entering valid phone number.");
						phonenumber.clear();
						phonenumber.sendKeys("8891228547");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Phone number field is not found.");
				}

				try {
					WebElement password = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
					if (password.isDisplayed()) {
						System.out.println("Entering valid password.");
						password.clear();
						password.sendKeys("bbbbbb");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Password field is not found.");
				}

				try {
					WebElement loginButton = driver.findElement(By.id("submitid"));
					if (loginButton.isDisplayed()) {
						loginButton.click();
						System.out.println("Clicked the login button with valid data.");
						WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(5));
						wait11.until(ExpectedConditions.alertIsPresent());

						Alert alert = driver.switchTo().alert();

						String alertMessage = alert.getText();
						System.out.println("Alert message: " + alertMessage);

						alert.accept();
						System.out.println("Alert accepted.");

					} else {
						System.out.println("Login button is not displayed.");
					}
				} catch (NoSuchElementException e) {
					System.out.println("not registered");
				}
//VALIDATE BLANK FIELDS
				try {
					WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
					phone.clear();
					phone.sendKeys("");

					WebElement password = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
					password.clear();
					password.sendKeys("");

					WebElement loginbutton = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitid")));
					if (loginbutton.isDisplayed()) {
						loginbutton.click();
						System.out.println("login button is displayed and clicked");

						JavascriptExecutor js = (JavascriptExecutor) driver;
						String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
								phone);

						if (validationMessage != null && !validationMessage.isEmpty()) {
							System.out.println("Validation message for blank fields: " + validationMessage);
						} else {
							System.out.println("No validation message is shown.");
						}
					}
				} catch (NoSuchElementException e) {
					System.out.println("Element not found: " + e.getMessage());
				}
			}
		}
		

	}
	@Test(priority = 3)
	@Description("check the functionality of create account ")
	@Feature("create account")

	public void createaccount() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

		WebElement signinbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("account__box")));

		if (signinbutton.isDisplayed()) {
			System.out.println("hello signin button is displayed");
			signinbutton.click();
		} else {
			System.out.println("hello sigin button is not displayed");
		}

		WebElement SignUp = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("register-link")));
		if (SignUp.isDisplayed()) {
			SignUp.click();
			Log.info("signup button is displayed and clicked");
		} else {
			Log.info("signup button not displayed");
		}


		try {
			WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			if (email.isDisplayed()) {
				System.out.println("email field is displayed");
				email.sendKeys("beenabineethagmail.com");
				Log.info("email is entered");
				WebElement createAccountButton = driver.findElement(By.id("submitid"));
				createAccountButton.click();

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
						email);

				if (validationMessage != null && !validationMessage.isEmpty()) {
					System.out.println("Validation message for email: " + validationMessage);
					email.clear();
				} else {
					System.out.println("No validation message found for email.");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("email field is not displayed");
		}
		
	
		
		try {
			WebElement phonenumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
			if (phonenumber.isDisplayed()) {
				System.out.println("phonenumber field is displayed");
				phonenumber.sendKeys("889kl28547");
				Log.info("phonenumber is entered");
				WebElement createAccountButton = driver.findElement(By.id("submitid"));
				createAccountButton.click();

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
						phonenumber);

				if (validationMessage != null && !validationMessage.isEmpty()) {
					System.out.println("Validation message for phone number: " + validationMessage);
				} else {
					System.out.println("No validation message found for phone number.");
				}
			}
		} catch (NoSuchElementException e) {
			System.out.println("Phone number field is not displayed");
		}
		{
			try {
				WebElement password = driver.findElement(By.name("password"));
				if (password.isDisplayed()) {
					System.out.println("password field is displayed");
					password.sendKeys("bbbb");

					Log.info("password is entered");
					WebElement createaccountButton = driver.findElement(By.id("submitid"));
					createaccountButton.click();
				}

				JavascriptExecutor js = (JavascriptExecutor) driver;
				String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;",
						password);

				if (validationMessage != null && !validationMessage.isEmpty()) {
					System.out.println("Validation message for password: " + validationMessage);
				} else {
					System.out.println("No validation message found for password.");
				}
			} catch (NoSuchElementException e) {
				System.out.println("password field is not displayed");
			}
			{
				// already registered user
				try {
					WebElement phonenumber = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
					if (phonenumber.isDisplayed()) {
						System.out.println("Entering valid email.");
						phonenumber.clear();
						phonenumber.sendKeys("beenabineetha@gmail.com");
					}
				} catch (NoSuchElementException e) {
					System.out.println("email field is not found.");
				}

				try {
					WebElement phonenumber = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
					if (phonenumber.isDisplayed()) {
						System.out.println("Entering valid phone number.");
						phonenumber.clear();
						phonenumber.sendKeys("8891228547");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Phone number field is not found.");
				}

				try {
					WebElement password = wait
							.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
					if (password.isDisplayed()) {
						System.out.println("Entering valid password.");
						password.clear();
						password.sendKeys("bbbbbb");
					}
				} catch (NoSuchElementException e) {
					System.out.println("Password field is not found.");
				}

				try {
					WebElement createaccountButton = driver.findElement(By.id("submitid"));
					if (createaccountButton.isDisplayed()) {
						createaccountButton.click();
						System.out.println("Clicked the createaccount button with valid data.");
					
						  WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(5));
						  wait11.until(ExpectedConditions.alertIsPresent());
						  
						 Alert alert = driver.switchTo().alert();
						 
						  String alertMessage = alert.getText(); 
						  System.out.println("Alert message: " +  alertMessage);
						 
						  alert.accept(); System.out.println("Alert accepted.");
					

					} else {
						System.out.println("createaccount button is not displayed.");
					}
				} catch (NoSuchElementException e) {
					System.out.println("already registered users can register again");
				}
			}
		}
		try {
			// valid credentials
			WebElement phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
			phone.clear();
			phone.sendKeys("8891297450");
			Log.info("phone number is entered");

			WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
			password.clear();
			password.sendKeys("Pumap");
			Log.info("password is entered correctly");

			WebElement loginbutton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("submitid")));
			if (loginbutton.isDisplayed()) {
				loginbutton.click();
				Log.info("create account button is clicked");

				WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
				wait2.until(ExpectedConditions.alertIsPresent());
				Alert alert = driver.switchTo().alert();
				String alertmessage = alert.getText();
				Log.info("alertmessage:" + alertmessage);

				alert.accept();
			} else {
				Log.info("create account button is not clicked");
			}
		} catch (NoSuchElementException e) {
			Log.info("registration failed");
		}
	}

	@Test(priority = 4)
	@Description("Verify the correctness of multiple page directing from homepage headers")
	@Feature("page redirection")

	public void MultiplePageDirecting() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		WebElement Logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@class,'main__logo--link')]")));
		if (Logo.isDisplayed()) {
			Log.info("logo is visible");
			Logo.click();
		} else {
			Log.info("logo is not visible");
		}

		String CurrentUrl = driver.getCurrentUrl();
		String ExpectedUrl = "https://drjoysmedstore.com/medlive/";
		if (CurrentUrl.equals(ExpectedUrl)) {
			Log.info("directed to homepage");
		}
		try {

			WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));

			WebElement offers = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='header__account--items']")));
			offers.click();
			Log.info("offer icon is clicked");

			String CurrentUrl1 = driver.getCurrentUrl();
			String ExpectedUrl1 = "https://drjoysmedstore.com/medlive/Top-Offers.php";
			Assert.assertEquals(CurrentUrl1, "https://drjoysmedstore.com/medlive/Top-Offers.php");

		} catch (NoSuchElementException e) {
			Log.info("offer icon is not clicked");
		}
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(5));
		try {

			WebElement cart = wait2.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//*[@class='header__account--btn minicart__open--btn']")));
			Log.info("cart icon is visible");
			cart.click();

			// verification
			WebElement addtocart = wait2.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='View cart']")));
			Assert.assertTrue(addtocart.isDisplayed(), " page is correctly loaded");
			Log.info("cart page is verified successfully");

		} catch (NoSuchElementException e) {
			Log.info("cart icon is not visible");
		} finally {
			Log.info("Redirection check completed for the cart page");

		}
	}

	@Test(priority = 5)
	@Description("verify the functionality of search option")
	@Feature("Search option")
	public void SearchOption() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		try {
			WebElement search = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(.,'Search')]")));
			search.sendKeys("e");
			Log.info("data is entered in searchbar");

			List<WebElement> searchResults = wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//ul[@class='autocomplete-items']/li//p")));

			// check products start with'e'

			boolean allproductsstartwithS = false;
			Log.info("Number of products found: " + searchResults.size());
			for (WebElement result : searchResults) {

				String ProductName = result.getText().trim();
				if (!ProductName.toLowerCase().startsWith("e")) {
					allproductsstartwithS = true;
					Log.info("Found product that does not start with 'e':" + ProductName);
				}

			}
			Assert.assertTrue(allproductsstartwithS, "search result contain products that do not start with e");
		} catch (NoSuchElementException e) {
			Log.error("Search element not found: " + e.getMessage());
		} catch (Exception e) {
			Log.error("An error occurred: " + e.getMessage());
		}
	}
	@Test(priority = 6)
	@Description("Verify whether dropdownlist of categories are shown or not")
	@Feature("category list")
	public void category() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		String[] menuitems = { "Prescription Drug", "Unani", "Homeo", "Covid Essentials", "Beauty Products",
				"Allopathy", "Personal Care", "Wellness Supplements", "Health Condition", "Veterinary", "Baby Care" };

		String[][] submenunames = { { "Diabetic Care","Pain Relief" }, { "Unani Medicines" }, { "Homeo Medicines" },
				{ "Covid-19 Essential Elements" }, { "Makeup Products" }, {},
				{ "Hair Care", "Skin Care", "Oral Care", "Men Care" }, { "Vitamins & Nutrients", "Diet  & Nutrition" },
				{ "Derma Care", "Eye Care", }, { "Pet Food", "Veterinary Medicine" }, { "Baby & Infant Food" } };

		Actions actions = new Actions(driver);
		// mainmenu
		for (int i = 0; i < menuitems.length; i++) {
	        String menuitem = menuitems[i];

	        // Locate the main menu item dynamically before each iteration
	        WebElement menuelement = wait
	                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + menuitem + "']")));

	        // Hover over the main menu item
	        actions.moveToElement(menuelement).perform();
	        menuelement.click();

	        // Handle submenus if present
	        if (submenunames[i].length > 0) {
	            for (int j = 0; j < submenunames[i].length; j++) {
	                String submenu = submenunames[i][j];

	                // Locate submenu dynamically
	                WebElement submenuelement = wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + submenu + "']")));

	                // Hover over the submenu and click
	                actions.moveToElement(submenuelement).perform();
	                submenuelement.click();

	                // Capture the URL after navigation
	                String currentUrl = driver.getCurrentUrl();
	                System.out.println("Navigated to: " + currentUrl);

	                // Navigate back to the previous page
	                driver.navigate().back();

	                // Re-locate the main menu element after navigating back
	                menuelement = wait.until(
	                        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='" + menuitem + "']")));
	                actions.moveToElement(menuelement).perform();
	            }
	        }
	    }
	}
@AfterMethod
 public void tearDown() {
    if (driver != null) {
        driver.quit();
    }}}

