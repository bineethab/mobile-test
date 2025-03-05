package crossbrowsertest;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.python.jline.internal.Log;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

public class Chrome extends BaseTest {
	@Test(priority=1)
	@Description("This test verifies whether the user is directed to right URL or not")
	@Step("Test the correctness of the URL ")
	@Feature("verifying URL ")
	
	public void URLverification() {
		WebDriver driver = getDriver();
		String currentURL = driver.getCurrentUrl();

		String expectedURL = "https://righters.in/develop/ddcLives/index.php"; 

		if (currentURL.equals(expectedURL)) {
		    System.out.println("Current URL is as expected");
		} else {
		    System.out.println("Current URL is not as expected");
		}}

	//@Test(priority=2)
	@Description("This test verifies user interaction with the slider component")
	@Step("Test the functionality of slider ")
	@Feature("verifying slider functionality")
	public void Slider() throws InterruptedException {
		WebDriver driver = getDriver();
		WebElement slider = driver.findElement(By.xpath("/html/body/main/div[2]/div[2]"));
		
		  int desiredValue = 50; 
		  int range = 100; 
		  int xOffset = (desiredValue * slider.getSize().getWidth()) / range;
		  
		  Actions actions = new Actions(driver);
		  actions.clickAndHold(slider).moveByOffset(xOffset, 0).release().build().perform();
		 
	  
	    Thread.sleep(3000);
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].value = arguments[1];", slider, desiredValue);


	    String sliderValue = slider.getAttribute("value");
	    if (sliderValue.equals(String.valueOf(desiredValue))) {
	        System.out.println("Slider set to " + desiredValue);
	    } else {
	        System.out.println("Slider not set as expected.");
	    }
	}
	@Test(priority=3)
	@Description("this test verifies user is able to take appointments")
	@Step("Test the functionality of appointment ")
	@Feature("appointment booking verification")

	public void GetAnAppointment() throws InterruptedException, AWTException {
		
		WebDriver driver = getDriver();
		    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		 
		    WebElement bookButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'BOOK YOUR APPOINTMENT NOW')]")));

		    // Scroll into view
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true);", bookButton);
		    Thread.sleep(1000); // Allow time for scrolling

		    // Click using JavaScript (forces click)
		    js.executeScript("arguments[0].click();", bookButton);

		    // Check if modal appeared
		    try {
		        WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'modal')]")));
		        if (modal.isDisplayed()) {
		            System.out.println("Modal appeared successfully.");
		        }
		    } catch (TimeoutException e) {
		        System.out.println("Modal did not appear.");
		    }
		}


	@Test(priority=4)
	@Description("this test verifies user is able to view details of popular packages")
	@Step("Test the functionality of popular packages ")
	@Feature("verifying popularpackages booking ")
	public void PopularPackages() throws InterruptedException, Throwable, IOException {
		WebDriver driver = getDriver();
		final Logger logger = Logger.getLogger(getClass().getName());

		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
		logger.addHandler(consoleHandler);
		FileHandler fileHandler = new FileHandler("application.log");
		logger.addHandler(fileHandler);
		
		JavascriptExecutor js= (JavascriptExecutor)driver;
		
	    js.executeScript("window.scrollBy(0,1000)");
	    
		try {
			Thread.sleep(1000); 
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement activeSlideBefore = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[contains(text(),'Wellness')]/span[contains(text(),'Package')]")));
		String beforeSlideText = activeSlideBefore.getText(); 
		
		if(activeSlideBefore.isDisplayed()) {
			System.out.println("slider element is present");
		}else {
			System.out.println("slider element is not present");

		}}catch(Exception e){
			System.out.println("First slider element not found, moving to the next step.");
		}

		Thread.sleep(2000);
		// Check new active slide
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement activeSlideAfter =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='package-details.php?id=5']")));
		String afterSlideText = activeSlideAfter.getText();

	driver.navigate().refresh();

	js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		
		 WebDriverWait wait11 = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement knowMoreButton = wait11.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@href,'package-details.php?id=20')]")));
		js.executeScript("arguments[0].scrollIntoView(true);",knowMoreButton);

		Thread.sleep(500); // Ensure it is in view
		js.executeScript("arguments[0].click();", knowMoreButton);
		
		
		//verify page
		
		String expectedUrl="https://righters.in/develop/ddcLives/package-details.php?id=20";
		String currentUrl=driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://righters.in/develop/ddcLives/package-details.php?id=20");
		
		WebElement paratext=wait11.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Experience the transformative power')]")));
		System.out.println(paratext.getText());
		
		
		}
		


	//@Test(priority=5)
	@Description("this test verifies user is able to book packages")
	@Step("Test the functionality of BookNow ")
	@Feature("verifying booknow functionality ")
	public void BookNow() throws InterruptedException {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 1800);"); 
	   
	   Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section[2]/div/div[2]/div[1]/div/div/div[6]/div/a")));
			button.click();

			WebElement booknow = driver.findElement(By.xpath("//*[@id=\"nav-home\"]/div/div[2]/div/a"));
	        booknow.click();

	        String expectedURL = "https://righters.in/develop/ddclabsn/Package-Details.php?id=8";
	        if (driver.getCurrentUrl().equals(expectedURL)) {
	            System.out.println("Button click validation: Passed");
	        } else {
	            System.out.println("Button click validation: Failed");
	        }

	    	try {
				driver.findElement(By.xpath("//*[@id=\"enq_submit\"]")).click();
			}catch(Exception e) {
				System.out.println("please fill out this field");
			}
			finally {
		
	         
				js.executeScript("var elements = document.getElementsByName('name');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = 'bini';" +
		                "}");		
				
				js.executeScript("var elements = document.getElementsByName('email');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = 'beenabineetha@gmail.com';" +
		                "}");	
				
				js.executeScript("var elements = document.getElementsByName('phone');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = '9656931233';" +
		                "}");		
				
				
				js.executeScript("var elements = document.getElementsByName('state');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = 'kerala';" +
		                "}");		
				
				
				js.executeScript("var elements = document.getElementsByName('city');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = 'kollam';" +
		                "}");		
				
				js.executeScript("var elements = document.getElementsByName('address');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = 'kollam';" +
		                "}");		
				
				js.executeScript("var elements = document.getElementsByName('notes');" +
		                "for (var i = 0; i < elements.length; i++) {" +
		                "   elements[i].value = 'test';" +
		                "}");		
				
				
				 Thread.sleep(2000); 
				 driver.findElement(By.id("enq_submit")).click();
				 
				  Thread.sleep(3000);
				  Alert alert = driver.switchTo().alert(); 
				  alert.accept();
				 
	         }}

	//@Test(priority=6)

	public void Promotions() throws InterruptedException {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,2000);"); 
	   Thread.sleep(2000);
	   
	driver.findElement(By.xpath("/html/body/main/section[3]/div/div[2]/div/div/div/div[1]/a/div/div/div/p")).click();

	String expectedURL = "https://righters.in/develop/ddclabsn/Promotions.php";
	if (driver.getCurrentUrl().equals(expectedURL)) {
	    System.out.println("Button click validation: Passed");
	} else {
	    System.out.println("Button click validation: Failed");
	}

	Actions action=new Actions(driver);
	WebElement element=driver.findElement(By.xpath("/html/body/main/section[2]/div/div/div/div/div[1]/div[2]/p/a"));
	action.click(element).build().perform();

	Thread.sleep(2000);



	WebElement data = driver.findElement(By.linkText("HOME"));

	if (data.isDisplayed()) {
	    System.out.println("data is present and displayed.");
	} else {
	    System.out.println("data is not present or not displayed.");
	}
	}
	//@Test(priority=7)
	@Description("this test verifies links given at footer diects to corresponding pages or not")
	@Step("Test the functionality of links in the footer ")
	@Feature("verifying linkdirecting pages ")
	public void LINKDIRECTING() throws InterruptedException {
		WebDriver driver = getDriver();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000);");


		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement aboutus = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li/a[contains(@href, 'about-profile.php')]")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", aboutus);
		Thread.sleep(1000);  // Let the page settle
		try {
		    aboutus.click();
		    System.out.println("button clicked successfully!");
		} catch (Exception e) {
		    // Fallback to JavaScript click
		    js.executeScript("arguments[0].click();", aboutus);
		    System.out.println("About Us clicked successfully!");
		}


		String expectedURL = "https://righters.in/develop/ddcLives/about-profile.php";
		
		if (driver.getCurrentUrl().equals(expectedURL)) {
			System.out.println("Button click validation: Passed");
		} else {
			System.out.println("Button click validation: Failed");
		}
		Thread.sleep(2000);
		js.executeScript("window.scrollBy(0,5000);");

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement departments = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li/a[contains(@href, 'our-departments.php')]")));
		departments.click();

		String expectedURLdoc = "https://righters.in/develop/ddcLives/our-departments.php";

		if (driver.getCurrentUrl().equals(expectedURLdoc)) {
			System.out.println("Button click validation: Passed");
		} else {
			System.out.println("Button click validation: Failed");
		}

		js.executeScript("window.scrollBy(0,5000);");
		Thread.sleep(2000);

		WebElement OurTeam = driver.findElement(By.xpath("//a[contains(@href,'team.php')]"));
		OurTeam.click();
		String expectedURLteam = "https://righters.in/develop/ddclabsn/About-us.php#team";

		if (driver.getCurrentUrl().equals(expectedURLteam)) {
			System.out.println("Button click validation: Passed");
		} else {
			System.out.println("Button click validation: Failed");
		}
		js.executeScript("window.scrollBy(0,5000);");
		Thread.sleep(2000);

		WebElement services = driver.findElement(By.xpath("//*[contains(@href,'services-card.php')]"));
		services.click();
		String expectedURLpack = "https://righters.in/develop/ddclabsn/Packages.php";
		if (driver.getCurrentUrl().equals(expectedURLpack)) {
			System.out.println("Button click validation: Passed");
		} else {
			System.out.println("Button click validation: Failed");
		}

		js.executeScript("window.scrollBy(0,5000);");
		Thread.sleep(2000);
		WebElement medicine = driver.findElement(By.xpath("//a[contains(.,'Nuclear Medicine')]"));
		medicine.click();

		String expectedURLradio = "https://righters.in/develop/ddcLives/nuclear-medicine.php";
		if (driver.getCurrentUrl().equals(expectedURL)) {
			System.out.println("Button click validation: Passed");
		} else {
			System.out.println("Button click validation: Failed");
		}}
	
	//@Test(priority=8)
	@Description("this test verifies phoneno&email are given proper validations")
	@Step("Test the behavior of invalid phone number and email input ")
	@Feature("verifying validations ")
	public void phonenumberAndemailvalidation() throws InterruptedException {
		WebDriver driver = getDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0, 550);");
		  Thread.sleep(2000);
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/section[1]/div/div/div/div/a"))); 
		  element.click();

			
		     WebElement calendarDate = driver.findElement(By.xpath("//*[@id=\"datepicker\"]/div/table/tbody/tr[2]/td[7]")); 

				JavascriptExecutor jss = (JavascriptExecutor) driver;
				jss.executeScript("arguments[0].click();", calendarDate);

				WebElement phoneNumberInput = driver.findElement(By.id("contact"));
				phoneNumberInput.sendKeys("1234567890");

				String enteredPhoneNumber = phoneNumberInput.getAttribute("value");

				Pattern phonePattern = Pattern.compile("\\d{10}");

				Matcher phoneMatcher = phonePattern.matcher(enteredPhoneNumber);

				if (phoneMatcher.matches()) {
					System.out.println("Phone number is valid.");
				} else {
					System.out.println("Phone number is not valid.");
				}

				WebElement emailInput = driver.findElement(By.name("email"));
				emailInput.sendKeys("beenabineetha@gmail.com"); 

			
				String enteredEmail = emailInput.getAttribute("value");

				Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

		
				Matcher emailMatcher = emailPattern.matcher(enteredEmail);

				if (emailMatcher.matches()) {
				    System.out.println("Email address is valid.");
				} else {
				    System.out.println("Email address is not valid.");
				}


	}

	@Test(priority=9)
	@Description("this test verifies user is able to view about details")
	@Feature("verifying about page  ")

	public void ABOUT() throws InterruptedException {
	profile();
	management();
	doctors();
	team();
	}

	@Step("Test the correctness of profile page")
	public void profile() {
		WebDriver driver = getDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][normalize-space()='About Us']")));
		  element.click();

		  WebElement profile=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Our Profile']")));
	profile.click();
	String expectedURL ="https://righters.in/develop/ddcLives/about-profile.php";
	String currentURL=driver.getCurrentUrl();
	Assert.assertEquals(currentURL,"https://righters.in/develop/ddcLives/about-profile.php" );
	if(expectedURL.equals(currentURL)) {
		Log.info("directed to profile page");
	}
	}
	@Step("Test the correctness of management page")
	public void management() {
		WebDriver driver = getDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][normalize-space()='About Us']")));
		  element.click();
		  
		  WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement mngmnt = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Our Management']")));
		  mngmnt.click();
		  
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1100);" );
		  
		
		  WebElement director=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Eric Joseph')]")));
		  
		  if(director.isDisplayed()) {
			  System.out.println("director name is present");
		  }else
		  {
			  System.out.println("director name is not present");  
			  
		  }
	}
	@Step("Test the correctness of doctors page")
	public void doctors() {
		WebDriver driver = getDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][normalize-space()='About Us']")));
		  element.click();
		  
		  WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement doctors = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='doctors.php']")));
		  doctors.click();
		
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1100);" );
		
	  WebElement doctorname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Dr Ranjit Grover')]")));
		  
		  if(doctorname.isDisplayed()) {
			  System.out.println("doctor name is present");
		  }else
		  {
			  System.out.println("doctor name is not present");  
			  
		  }
		
	}
	@Step("Test the correctness of team page")
	public void team() {
		WebDriver driver = getDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='#'][normalize-space()='About Us']")));
		  element.click();
		  
		  WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement team = waits.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='team.php']")));
		  team.click();
		
		  JavascriptExecutor js=(JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1100);" );
		
	WebElement doctorname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Ms. Sarala P.R')]")));
		  
		  if(doctorname.isDisplayed()) {
			  System.out.println("team member name is present");
		  }else
		  {
			  System.out.println("team member name is not present");  
			  
		  } 
		  
	}
	@Test(priority=10)
	@Description("this test verifies user is able to view provided services")
	@Feature("verifying services page ")
	public void services() throws InterruptedException {
		service();
		clinicaltests();
		imaging();
		nuclearmedicine();
	}
	@Step("Test the correctness of services page")
		public void service() {
		WebDriver driver = getDriver();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Services')]]")));
		  element.click();
		  
		 
		  WebElement team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Services')]]/ul/li/a")));
		  team.click();
		
		  JavascriptExecutor js= (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,1300);");
		  
		  WebElement readmore=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(normalize-space(),'Read More')]")));
		  readmore.click();
		  
		  String expectedURL="https://righters.in/develop/ddcLives/services-card-details.php?id=11";
		  String actualURL=driver.getCurrentUrl();
		  
		  if(expectedURL.equals(actualURL)) {
			  System.out.println("url is correct");
			  Assert.assertEquals(actualURL, "https://righters.in/develop/ddcLives/services-card-details.php?id=11");
		  }else {
			  
			  System.out.println("url is not correct");
		  }
		  
	}
	@Step("Test the correctness of clinical tests page")
		public void clinicaltests() {
		WebDriver driver = getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Services')]]")));
			  element.click();
			  
			 
			  WebElement team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Clinical Tests']")));
			  team.click();
			
			
		}
	@Step("Test the correctness of imaging page")
		public void imaging() {
		WebDriver driver = getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Services')]]")));
			  element.click();
			  
			 
			  WebElement team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Imaging']")));
			  team.click();
			
			  WebElement text=wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Imaging")));
			 if(text.isDisplayed()) {
				 System.out.println("imaging detail is present");
			 }else {
				 System.out.println("imaging detail is present"); 
			 }
			
		}
	@Step("Test the correctness of nuclear medicine page")
		public void nuclearmedicine() {
		WebDriver driver = getDriver();
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Services')]]")));
			  element.click();
			  
			 
			  WebElement team = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Nuclear Medicine']")));
			  team.click();
		
			String expectedURL="https://righters.in/develop/ddcLives/nuclear-medicine.php";
			String currentURL=driver.getCurrentUrl();
			
			Assert.assertEquals(currentURL, "https://righters.in/develop/ddcLives/nuclear-medicine.php");
			  
			  System.out.println("expected URL is same as current URL");
		}
		
	@Test(priority=11)
	@Description("this test verifies user is able to view all options under facility option")
	@Feature("verifying the correctness of facility options  ")

	public void facility() throws InterruptedException {
		facilities();
		Departments();
		gallery();
	}
	@Step("test the correctness of facility page")
	public void facilities() {
		WebDriver driver = getDriver();
		
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Facilities')]]")));
		  element.click();
		  
		 
		  WebElement  facilities = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'facilities.php')]")));
		  facilities.click();
		  
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500);");
		
		String expectedURL="https://righters.in/develop/ddcLives/facilities.php";
		String currentUrl =driver.getCurrentUrl();
		
		Assert.assertEquals(currentUrl, "https://righters.in/develop/ddcLives/facilities.php");
		System.out.println("expected and current URLs are same");
	}
	@Step("test the correctness of departments page")
	public void Departments() {
		WebDriver driver = getDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Facilities')]]")));
	element.click();


	WebElement  facilities = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(normalize-space(),'Departments')]")));
	facilities.click();

	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,500);");

	List<WebElement>departments=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class=\"packages-card-body\"]/h4")));
	System.out.println("number of departments found:"+departments.size());

	for (WebElement dept : departments) {
		 js.executeScript("arguments[0].scrollIntoView(true);", dept);  // Scroll to each department
	    System.out.println(dept.getText()); 
	}}

	@Step("test the correctness of gallery page")
	public void gallery() throws InterruptedException {
		WebDriver driver = getDriver();
		  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		  
		  WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[a[contains(text(), 'Facilities')]]")));
		  element.click();

		  WebElement  facilities = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href,'gallery.php')]")));
		  facilities.click();
		  

	String expectedURLprofile = "https://righters.in/develop/ddcLives/gallery.php";
	if (driver.getCurrentUrl().equals(expectedURLprofile)) {
	    System.out.println("URL CORRECT");
	} else {
	    System.out.println("INCORRECT URL");
	}
	List<WebElement>gallery=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class,'row d-flex')]")));

	for(WebElement image:gallery) {
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", image);
		 Thread.sleep(500);
		System.out.println(image.getText());
		
		boolean clicked = false;
	    for (int i = 0; i < 3; i++) {
	        try {
	            WebElement branchImage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='lightbox_img_wrap']//a/img")));
	            branchImage.click();
	            System.out.println("Gallery image clicked");
	            clicked = true;
	            break; // Exit retry loop if click is successful
	        } catch (StaleElementReferenceException e) {
	            System.out.println("Element became stale. Retrying... " + (i + 1));
	        }
	    }

	    // If the image was successfully clicked, proceed with next actions
	    if (clicked) {
	        WebElement galleryImage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='lightbox_img_wrap']/img[@data-imgsrc='gallery/g16983094470.JPG']")));
	        galleryImage.click();
	        System.out.println("Gallery image is clicked");

	        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='right']")));
	        nextButton.click();
	        System.out.println("Next button is clicked");
	    }
	}
	}

@Test(priority=12)
	@Description("this test verifies user is able to submit enquiries")
	@Step("Test the functionality of contact us page ")
	public void contactUsANDCustomers() throws InterruptedException {
		
		contact();
		branches();
		customerCare();
		Quality();
		Infrastructure();
	}
	public void contact() throws InterruptedException {
		WebDriver driver = getDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement contact=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Contact']")));
		contact.click();
		
		String ExpectedUrl="https://righters.in/develop/ddcLives/contact.php";
	String Currenturl=driver.getCurrentUrl();
	Assert.assertEquals(Currenturl, "https://righters.in/develop/ddcLives/contact.php");


	WebElement name=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("name")));
	name.sendKeys("sreeni");

	//invalid mob number

	WebElement mob=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
	if(mob.isDisplayed()) {
		System.out.println("mob field is present");
		mob.sendKeys("78451230");
		Log.info("phonenumber is entered");
		WebElement sendNowButton = driver.findElement(By.name("submit"));
		sendNowButton.click();

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", mob);

		if (!isValid) {
		    String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", mob);
		    System.out.println("Validation message for mob: " + validationMessage);
		} else {
		    System.out.println("No validation message found for mob.");
		}
	}
	//valid mobile number
	WebElement mobilenum=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("phone")));
	if(mobilenum.isDisplayed()) {
		System.out.println("mob field is present");
		mobilenum.clear();
		mobilenum.sendKeys("7845123011");
		Log.info("phonenumber is entered");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValid = (Boolean) js.executeScript("return arguments[0].checkValidity();", mob);

		
		if (!isValid) {
		    String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", mob);
		    System.out.println("Validation message for mob: " + validationMessage);
		} else {
		    System.out.println("No validation message found for mob.");
		}

	//invalid email
		
		WebElement email=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		if(email.isDisplayed()) {
			System.out.println("email field is present");
			mob.sendKeys("binigmailcom");
			Log.info("invalid email is entered");
			WebElement sendNowButton = driver.findElement(By.name("submit"));
			sendNowButton.click();

			
			//JavascriptExecutor js = (JavascriptExecutor) driver;
			Boolean isvalid = (Boolean) js.executeScript("return arguments[0].checkValidity();", email);

			if (!isvalid) {
			    String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", email);
			    System.out.println("Validation message for email: " + validationMessage);
			} else {
			    System.out.println("No validation message found for email.");
			}
			
		//VALID EMAIL
			
			WebElement validemail=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
			if(validemail.isDisplayed()) {
				System.out.println("email field is present");
				validemail.clear();
				validemail.sendKeys("bini@gmail.com");
				Log.info("email is entered");
				
				WebElement sendNowButton1 = driver.findElement(By.name("submit"));
				sendNowButton1.click();
				
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
				try {
				    Alert alert = wait1.until(ExpectedConditions.alertIsPresent());
				    System.out.println("Alert Text: " + alert.getText());
				    alert.accept(); 
				} catch (TimeoutException e) {
				    System.out.println("No alert appeared.");
				}}}
	}}
	public void branches() {
		WebDriver driver = getDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15));
		
		WebElement branches=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/a")));
		branches.click();
		
		String ExpectedUrl="https://righters.in/develop/ddcLives/list-of-our-branches.php";
		String CurrentUrl=driver.getCurrentUrl();
		Assert.assertEquals(CurrentUrl, "https://righters.in/develop/ddcLives/list-of-our-branches.php");
		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,800);");
		
		List<WebElement>branchlist=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(".//h4[starts-with(text(),'DDC ')]")));
		System.out.println("branchesname found:"+branchlist.size());
		for(WebElement branches1:branchlist) {
			js.executeScript("arguments[0].scrollIntoView(true);", branches1);
			   System.out.println(branches1.getText()); 
		}
	}
	public void customerCare() {
		WebDriver driver = getDriver();
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement customers=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Customers')]")));
		customers.click();	
		
		WebElement branches=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href,'customers.php')]")));
		branches.click();
		
		//content verification
		WebElement paragraph = driver.findElement(By.xpath("//*[contains(text(),'We strive to provide')]"));
		System.out.println(paragraph.getText());
		
	}
	public void Quality() {
		WebDriver driver = getDriver();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		
		WebElement customers=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Customers')]")));
		customers.click();	

		WebElement qualitycontrol=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='quality.php']")));
		qualitycontrol.click();
		
		//content verification
			WebElement paragraph = driver.findElement(By.xpath("//*[contains(text(),'To ensure the accuracy')]"));
			System.out.println(paragraph.getText());
	}
		
		public void Infrastructure() {
			WebDriver driver = getDriver();
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			
			WebElement customers=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Customers')]")));
			customers.click();	

			WebElement infrastructure=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@href,'infrastructure.php')]")));
			infrastructure.click();
			//url verification
				String expectedUrl="https://righters.in/develop/ddcLives/infrastructure.php";
				String currentUrl=driver.getCurrentUrl();
			Assert.assertEquals("https://righters.in/develop/ddcLives/infrastructure.php",currentUrl);
	}

	//@Test(priority = 13)
	@Description("this test verifies user is able to book packages")
	@Step("Test the functionality of package booking ")
	@Feature("verifying package booking functionality ")
		public void book() throws InterruptedException, IOException {
		WebDriver driver = getDriver();
			final Logger logger = Logger.getLogger(getClass().getName());

			logger.setLevel(Level.ALL);
			ConsoleHandler consoleHandler = new ConsoleHandler();
			consoleHandler.setLevel(Level.ALL);
			logger.addHandler(consoleHandler);
			FileHandler fileHandler = new FileHandler("application.log");
			logger.addHandler(fileHandler);

			
			logger.info("Before scrolling");
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0, 1900);");
			logger.info("After scrolling");
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		    wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

		   
		    String sliderHandleXPath = "/html/body/main/section[2]/div/div[2]/div[1]/div/div/div[5]/div/a";

		    
		    boolean isClicked = false;
		    int attempts = 0;

		    while (!isClicked && attempts < 5) {
		        try {
		           
		            WebElement sliderHandle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(sliderHandleXPath)));

		          
		            js.executeScript("arguments[0].scrollIntoView(true);", sliderHandle);

		            
		            Thread.sleep(1000);

		        
		            sliderHandle.click();

		            logger.info("Slider handle clicked successfully.");
		            isClicked = true;
		        } catch (Exception e) {
		            logger.warning("Attempt " + (attempts + 1) + " failed. Retrying...");
		            attempts++;
		            Thread.sleep(2000); 
		        }
		    }

		    if (!isClicked) {
		        throw new RuntimeException("Failed to click the slider handle after multiple attempts.");
		    }


			WebElement booknow = driver.findElement(By.xpath("//*[@id=\"nav-home\"]/div/div[2]/div/a"));
			booknow.click();
			logger.info("Button has been clicked.");
			Sheet sheet = null;

			FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\computer-2\\Desktop\\readexcel.xlsx"));
			Workbook workbook = new XSSFWorkbook(excelFile);
			sheet = workbook.getSheet("ddc");
			
			int rowcount = sheet.getLastRowNum();
			int colCount = sheet.getRow(1).getLastCellNum();
			
			System.out.println("rowcount :" + rowcount + "colCount :" + colCount);

			logger.info("Processing data from the Excel sheet.");
			for (int i = 1; i <= rowcount; i++) {
				XSSFRow celldata = (XSSFRow) sheet.getRow(i);
				String fieldName = celldata.getCell(0).getStringCellValue();
		       

		        String fieldData = "";
		        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        Cell cell = celldata.getCell(1);
		        if (cell != null) {
		            if (cell.getCellType() == CellType.STRING) {
		                fieldData = cell.getStringCellValue();
		            } else if (cell.getCellType() == CellType.NUMERIC) {
		                double numericValue = cell.getNumericCellValue();
		               
		                String formattedValue = new DecimalFormat("#").format(numericValue);
		                
		                fieldData = formattedValue;
		            }
		        }
	 
		       try { 
		       if ("name".equals(fieldName)) {
		        	WebElement nameInput = driver.findElement(By.name("name"));
		        	nameInput.clear();
		        	nameInput.sendKeys(fieldData);

		        	WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		        	wait2.until(ExpectedConditions.textToBePresentInElementValue(nameInput, fieldData));

			    	  
		            
		        } else if ("email".equals(fieldName)) {
		            WebElement emailInput = driver.findElement(By.name("email"));
		            emailInput.clear();
		            emailInput.sendKeys(fieldData);
		            wait1.until(ExpectedConditions.elementToBeClickable(emailInput));
		            logger.info("email is entered into the web form.");

		    	
		 	       
		        } else if ("phone".equals(fieldName)) {
		            WebElement phoneInput = driver.findElement(By.name("phone"));
		            phoneInput.clear();
		            phoneInput.sendKeys(fieldData);
		    		
		         } else if ("state".equals(fieldName)) {
		          WebElement stateInput = driver.findElement(By.name("state"));
		            stateInput.clear();
		            stateInput.sendKeys(fieldData);
		        } else if ("city".equals(fieldName)) {
		            WebElement cityInput = driver.findElement(By.name("city"));
		            cityInput.clear();
		            cityInput.sendKeys(fieldData);
		        } else if ("address".equals(fieldName)) {
		            WebElement addressInput = driver.findElement(By.name("address"));
		            addressInput.clear();            
		            addressInput.sendKeys(fieldData);
		         }
		       
		        logger.info("Completed filling form fields. Waiting before submitting...");

		        WebElement submitButton = driver.findElement(By.id("enq_submit"));
			     submitButton.click();
			     logger.info("Submit button clicked.");
			     
			 driver.switchTo().alert();
			 WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofSeconds(10));
		     waitAlert.until(ExpectedConditions.alertIsPresent()).accept();
				 
			 logger.info("Alert accepted.");
		       }catch(Exception e){
		    	   e.printStackTrace();
				 logger.info("Completed the 'book' method.");
		       }}}

	//@Test(priority=14)
	@Description("this test verifies whether socialmedialinks directs to corresponding pages")
	@Step("Test the correctness of socialmedia page links ")
	@Feature("verifying socialmedia links  ")
	public void SocialmediaLink() throws AWTException, InterruptedException {
		WebDriver driver = getDriver();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			  js.executeScript("window.scrollBy(0,5000);"); 

	Thread.sleep(1000);

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	WebElement fb = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@href='https://www.facebook.com/ddclaboratory']")));
	fb.click();

	Set<String> windowHandles = driver.getWindowHandles();


	ArrayList<String> windowsList = new ArrayList<String>(windowHandles);


	driver.switchTo().window(windowsList.get(1));


	String expectedUrl = "https://www.facebook.com/ddclaboratory";
	String actualUrl = driver.getCurrentUrl();


	Assert.assertEquals(actualUrl, expectedUrl, "URLs do not match");

	driver.switchTo().window(windowsList.get(0)); 
		  
		 
		    WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(15));
		    WebElement twitter = waits.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/footer/div/div/div/div[4]/div/div[2]/a[2]")));
	        twitter.click();
	        
	       
	        
	        driver.switchTo().window(windowsList.get(0));
	        
	        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		    WebElement instagram = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/footer/div/div/div/div[4]/div/div[2]/a[3]")));
	        instagram.click();
	        
	        String expectedinstaUrl = "https://www.instagram.com/ddc_laboratories/?igshid=c2MzMjNna243ZTFq";
	        String actualinstaUrl = driver.getCurrentUrl();


	        Assert.assertEquals(actualinstaUrl, expectedinstaUrl, "URLs do not match");  
	}


	@Test(priority=15)
	@Description("this test verifies whether user is able to apply to job vacancies")
	@Step("Test the functionality of applynow  ")
	@Feature("verifying career link  ")
	public void careers() throws InterruptedException, SecurityException, IOException {
		
		WebDriver driver = getDriver();
		final Logger logger = Logger.getLogger(getClass().getName());

		logger.setLevel(Level.ALL);
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.ALL);
		logger.addHandler(consoleHandler);
		FileHandler fileHandler = new FileHandler("application.log");
		logger.addHandler(fileHandler);

		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		  js.executeScript("window.scrollBy(0,5000);"); 
		  
	     Thread.sleep(1000);
		  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement careers=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@href='careers.php']")));
		careers.click();
		
		WebElement button=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Apply Now')]")));
		button.click();
		
		
		
		Sheet sheet = null;

		FileInputStream excelFile = new FileInputStream(new File("C:\\Users\\computer-2\\Desktop\\ddcreadexcel.xlsx"));
		Workbook workbook = new XSSFWorkbook(excelFile);
		sheet = workbook.getSheet("Sheet1");
		
		int rowcount = sheet.getLastRowNum();
		int colCount = sheet.getRow(1).getLastCellNum();
		
		System.out.println("rowcount :" + rowcount + "colCount :" + colCount);

		
			
			for (int i = 1; i <= rowcount; i++) {
			    XSSFRow celldata = (XSSFRow) sheet.getRow(i);
			    Cell fieldNameCell = celldata.getCell(0);
			    String fieldName ; 
			   
			    if (fieldNameCell.getCellType() == CellType.NUMERIC) {
			       
			        fieldName = String.valueOf((int) fieldNameCell.getNumericCellValue());
			    } else {
			        fieldName = fieldNameCell.getStringCellValue();
			    }
			    
			    logger.info("Processing data from the Excel sheet");
			    WebElement inputField = null;

			    
			    switch (fieldName) {
			        case "name":
			            inputField = driver.findElement(By.name("name"));
			            logger.info("name is entered");
			            break;
			        case "email":
			        	WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(10));
			            inputField = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			            logger.info("email is entered");
			            break;
			        case "phone":
			            inputField = driver.findElement(By.name("phone"));
			            logger.info("phone is entered");
			            break;
			        case "state":
			            inputField = driver.findElement(By.name("state"));
			            logger.info("state is entered");
			            break;
			        case "city":
			            inputField = driver.findElement(By.name("city"));
			            logger.info("city is entered");
			            break;
			            
			        case "address":
			            WebDriverWait waits = new WebDriverWait(driver, Duration.ofSeconds(10));
			            inputField = waits.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='requestForm1']/div[6]/textarea")));
			            logger.info("address is entered");
			            break;
			            
			        case "cv":
			        inputField=driver.findElement(By.xpath("/html/body/main/div/div/div/div/div[2]/form/div[6]/textarea"));
			        if ("cv".equals(fieldName)) {
			            String cvPath = inputField.getAttribute("value");
			            if (cvPath != null && !cvPath.isEmpty()) {
			                
			                System.out.println("CV path entered: " + cvPath);
			            } else {
			               
			                System.out.println("CV path not entered");
			                    } }
			        break;
			    }
			    Cell dataCell = celldata.getCell(1);
			    if (inputField != null && dataCell != null) {
			        String fieldData;
			       
			        if (dataCell.getCellType() == CellType.STRING) {
			            fieldData = dataCell.getStringCellValue();
			        } else if (dataCell.getCellType() == CellType.NUMERIC) {
			           
			            fieldData = String.valueOf((int) dataCell.getNumericCellValue());
			        } else {
			            // Handle other cell types if necessary
			            fieldData = "";
			        }
			  
			        inputField.clear();
			        inputField.sendKeys(fieldData);
			        
			        WebElement sendbutton= driver.findElement(By.xpath("//button[contains(.,'Apply Now')]"));
			        sendbutton.click();
			     
					  Thread.sleep(2000);
					  Alert alert = driver.switchTo().alert(); alert.getText();
					  alert.accept();
					 
			        
			    }}}}
			

