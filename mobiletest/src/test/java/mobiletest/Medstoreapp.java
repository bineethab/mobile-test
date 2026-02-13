package mobiletest;

import java.net.MalformedURLException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.ElementOption;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;


import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import java.net.URL;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.Point;
import org.openqa.selenium.Dimension;
public class Medstoreapp {
	
	 private AndroidDriver driver;
	 
	 @BeforeClass
	    public void setUp() throws MalformedURLException {
		  
		  
		     DesiredCapabilities caps = new DesiredCapabilities();
		        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
		        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		        caps.setCapability(MobileCapabilityType.APP, "C:\\Users\\computer-2\\Downloads\\apk meedstore\\app-release.apk");

		        
		         driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), caps);

		       System.out.println("App launched successfully!");
}
	
@Test(priority=1)
@Description("check the correctness of intro pages and button actions ")
public void pagecorrectness() {
	
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	 
	 
	WebElement el1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.Button[@content-desc='Next']")));
	el1.click();


	WebElement Signup=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("SIGNUP WITH EMAIL")));

	if(Signup.isDisplayed()) {
		
	System.out.println("next button click is successful");
	Signup.click();
	}else {
		System.out.println("next button click is unsuccessful");
	}
	//title verification
		 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(15));
		WebElement contentElement =wait1.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Welcome Back\"]")));
		
		String actualContent = contentElement.getAttribute("content-desc");

		System.out.println("Actual Content: " + actualContent);
		String expectedContent = "Welcome Back";

		if (actualContent.equals(expectedContent)) {
		    System.out.println("CONTENT VERIFICATION PASSED: " + actualContent);
		} else {
		    System.out.println("CONTENT VERIFICATION FAILED: expected: " + expectedContent + " but found: " + actualContent);
		    
		}}
	
	
	 //@Test(priority=2)
	  
	 public void Signup() throws InterruptedException {
	 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		 
		 
			WebElement signup = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Sign up")));
			signup.click();

		 //content verification
			WebElement content= wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Create your account")));
			String actualContent=content.getAttribute("content-desc");
			
		 String Expectedcontent="Create your account";
		 
		if(actualContent.equals(Expectedcontent)) {
			System.out.println("content is correct:"+actualContent);
		}else {
			System.out.println("content is incorrect, expected:"+" "+ Expectedcontent +" "+ "but found:" +" "+ actualContent);
		}
	
		//blank credentials
		
		WebElement create = wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("CREATE ACCOUNT")));
		create.click();
		// Wait for error messages to appear
		WebElement phoneError = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Phone number can't be empty\"]")));
		WebElement emailError = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Email can't be empty\"]")));
		WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.view.View[@content-desc=\"Password can't be empty\"])[1]")));
		WebElement passwordError1= wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.view.View[@content-desc=\"Password can't be empty\"])[2]")));

		Assert.assertEquals(phoneError.getAttribute("content-desc"), "Phone number can't be empty");
		Assert.assertEquals(emailError.getAttribute("content-desc"), "Email can't be empty");
		Assert.assertEquals(passwordError.getAttribute("content-desc"), "Password can't be empty");
		Assert.assertEquals(passwordError1.getAttribute("content-desc"), "Password can't be empty");
		
		//invalid credentials
		
		WebElement el2 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		el2.click();
		el2.sendKeys("88912285");
		
		WebElement el = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
		el.click();
		el.sendKeys("beenabineethagmail.com");
		
		WebElement el4 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
		el4.click();
		el4.sendKeys("1234567");
		
		WebElement el5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
		el5.click();
		el5.sendKeys("1234567");
		
		WebElement el6 = driver.findElement(AppiumBy.accessibilityId("CREATE ACCOUNT"));
		el6.click();
		
		WebElement phonemsg=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Phone number is too short")));
		WebElement emailmsg=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Email is invalid")));
		
		String actualphonemsg=phonemsg.getAttribute("content-desc");
		String actualemailmsg=emailmsg.getAttribute("content-desc");
		
		String expectedphonemsg = "Phone number is too short";
		String expectedemailmsg = "Email is invalid";
		
		if(actualphonemsg.equals(expectedphonemsg)) {
			System.out.println("validation message shown is correct");
		}else {
			System.out.println("validation message shown is incorrect,expected:"+" "+expectedphonemsg+" "+"but found:"+actualphonemsg);
		
		}
		
		if(actualemailmsg.equals(expectedemailmsg)) {
			System.out.println("validation message shown is correct");
		}else {
			System.out.println("validation message shown is incorrect,expected:"+" "+expectedemailmsg+" "+"but found:"+actualemailmsg);
		
		}
		//already registered user credentials
		

		WebElement el21 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		el21.click();
		el21.sendKeys("8891228547");
		
		WebElement el1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
		el1.click();
		el1.sendKeys("beenabineetha@gmail.com");
		
		WebElement el41 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
		el41.click();
		el41.sendKeys("1234567");
		
		WebElement el51 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
		el51.click();
		el51.sendKeys("1234567");
		
		WebElement el61 = driver.findElement(AppiumBy.accessibilityId("CREATE ACCOUNT"));
		el61.click();
		Thread.sleep(4000);
		WebElement alertmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("User already exist")));
		if(alertmessage.isDisplayed()) {
			System.out.println("user already exists alert is present");
			
		}else {
			System.out.println("user already exists alert is not present");
		}
		
		//valid credentials
		WebElement signupp = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Sign up")));
		signupp.click();
		
	 WebElement num = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(0)"));
		num.click();
		num.sendKeys("9874521030");
		
		WebElement mail = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(1)"));
		mail.click();
		mail.sendKeys("biniwork1998@gmail.com");
		
		WebElement pass = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(2)"));
		pass.click();
		pass.sendKeys("1234567");
		
		WebElement password = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\").instance(3)"));
		password.click();
		password.sendKeys("1234567");
		
		WebElement createaccount = driver.findElement(AppiumBy.accessibilityId("CREATE ACCOUNT"));
		createaccount.click();
		
		/*
		 * WebElement
		 * loinmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy
		 * .accessibilityId("You have successfully logged in"))); if(alertmessage.isDisplayed()) {
		 * System.out.println("user already exists alert is present");
		 * 
		 * }else { System.out.println("user already exists alert is not present"); }
		 */}
@Test(priority=3)
@Description("check the correctness of signup page ")
@Feature("Check for field validations")
public void LoginValidations() throws InterruptedException {
	
//negative testing-invalid credentials	
	
	//no data
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(25));
	
	WebElement el1 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
	el1.sendKeys("");
	
	WebElement el2 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")));
	el2.sendKeys("");
	
	WebElement el3 = wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("LOGIN")));
	el3.click();
	
	// Wait for validation messages to appear
	
	WebElement phoneError = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Phone number can't be empty")));
	
	WebElement passwordError = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Password can't be empty")));
	
	String actualPhoneMsg= phoneError.getAttribute("content-desc");
	String actualPasswordMsg= passwordError.getAttribute("content-desc");
	
	String expectedPhoneMsg = "Phone number can't be empty";
	String expectedPasswordMsg = "Password can't be empty";
	
	// Validation
	if (actualPhoneMsg.equals(expectedPhoneMsg)) {
	    System.out.println("Phone validation message is correct: " + actualPhoneMsg);
	} else {
	    System.out.println("Phone validation message is incorrect. Expected: " + expectedPhoneMsg + " but got: " + actualPhoneMsg);
	}

	if (actualPasswordMsg.equals(expectedPasswordMsg)) {
	    System.out.println("Password validation message is correct: " + actualPasswordMsg);
	} else {
	    System.out.println("Password validation message is incorrect. Expected: " + expectedPasswordMsg + " but got: " + actualPasswordMsg);
	}    
	//invalid input credentials
	
	
	WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
	  phoneField.clear();
	  phoneField.click(); 
	phoneField.sendKeys("234567890");

    WebElement passwordField =wait.until(ExpectedConditions.visibilityOfElementLocated (AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")));
    passwordField.clear();
    passwordField.click(); 
    passwordField.sendKeys("wron");


    WebElement loginBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"LOGIN\"]"));
    loginBtn.click();
    
   
    
WebElement phoneError1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc='Phone number is too short']")));
	
	WebElement passwordError1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"Password is too short\"]"))); 
	
	String actualPhoneMsg1= phoneError1.getAttribute("content-desc");
	String actualPasswordMsg1= passwordError1.getAttribute("content-desc");
	
	String expectedPhoneMsg1 = "Phone number is too short";
	String expectedPasswordMsg1 = "Password is too short";
    
	// Validation
		if (actualPhoneMsg1.equals(expectedPhoneMsg1)) {
		    System.out.println("Phone validation message is correct: " + actualPhoneMsg1);
		} else {
		    System.out.println("Phone validation message is incorrect. Expected: " + expectedPhoneMsg1 + " but got: " + actualPhoneMsg1);
		}

		if (actualPasswordMsg1.equals(expectedPasswordMsg1)) {
		    System.out.println("Password validation message is correct: " + actualPasswordMsg1);
		} else {
		    System.out.println("Password validation message is incorrect. Expected: " + expectedPasswordMsg1 + " but got: " + actualPasswordMsg1);
		}    
		
  //valid input credentials
	
	
  	WebElement phoneField2 = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[1]")));
  	phoneField2.click();
  	phoneField2.clear();
  	phoneField2.sendKeys("8891228547");

      WebElement passwordField2 =wait.until(ExpectedConditions.visibilityOfElementLocated (AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.EditText[2]")));
    
    
        passwordField2.click();
    	passwordField2.clear();
      passwordField2.sendKeys("bbbbbb");


      WebElement loginBtn1 = driver.findElement(AppiumBy.accessibilityId("LOGIN"));
      loginBtn1.click();
      Thread.sleep(3500);
      //validation
      WebElement successmessage=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"You have successfully logged in\"]")));
    
      
      Assert.assertTrue(successmessage.isDisplayed(), "You have successfully logged in");
	    
	}

//@Test(priority=4)
@Description("check the functionality of search field")
@Step("verify the search results obtained")
public void Search() throws InterruptedException {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(25));
	
	WebElement search=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.EditText\")")));
	search.click();
	search.sendKeys("s");
	
	driver.pressKey(new KeyEvent(AndroidKey.BACK));//hide keyboard
	
	Thread.sleep(2000);
	
	List<WebElement>products=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.view.View//android.widget.ImageView[@content-desc]")));
	
	//verification
	boolean allprodctsstartwiths=true;
	
	System.out.println("no. of products:"+products.size());
	
	for(WebElement product:products) {
		
		String productname=product.getAttribute("content-desc").trim();
		System.out.println("product names:"+productname.split("\n")[0]);
		
		if(!productname.toLowerCase().startsWith("s")) {
			allprodctsstartwiths = false;
			
		break;
			
		}}
	
	Assert.assertTrue(allprodctsstartwiths, "Search results contain products that do not start with 's'.");
	}

//@Test(priority=5)
@Description("check the functionality of sliders in home page(deals & offers are only available now")
public void slider() {

	
WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
	
	WebElement initialdealslider=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Moov Pain Relief')]")));	

final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
var start = new Point(1046, 866);
var end = new Point (405, 845);
var swipe = new Sequence(finger, 1);
swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
    PointerInput.Origin.viewport(), start.getX(), start.getY()));
swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
    PointerInput.Origin.viewport(), end.getX(), end.getY()));
swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
driver.perform(Arrays.asList(swipe));


WebElement swipedsliderelement=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Rasayanam Kashmiri Mongra Saffron' )]")));
	
if(swipedsliderelement.isDisplayed())	{
	System.out.println("slider has moved successfully");
	
}else {
	System.out.println("no slider movements");
	
	
}

WebElement initialofferslider=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Accu-Chek Active Blood Glucometer Kit')]")));	

final var finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
var start1 = new Point(1067, 1642);
var end1 = new Point (419, 1646);
var swipe1 = new Sequence(finger1, 1);
swipe1.addAction(finger1.createPointerMove(Duration.ofMillis(0),
    PointerInput.Origin.viewport(), start1.getX(), start1.getY()));
swipe1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
swipe1.addAction(finger1.createPointerMove(Duration.ofMillis(1000),
    PointerInput.Origin.viewport(), end1.getX(), end1.getY()));
swipe1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
driver.perform(Arrays.asList(swipe1));

WebElement swipedofferslider=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Light Conditioner' )]")));

if(swipedofferslider.isDisplayed())	{
	System.out.println("slider has moved successfully");
	
}else {
	System.out.println("no slider movements");
}

final var finger11 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
var start11 = new Point(28, 1597);
var end11 = new Point (984, 1618);
var swipe11 = new Sequence(finger11, 1);
swipe11.addAction(finger11.createPointerMove(Duration.ofMillis(0),
    PointerInput.Origin.viewport(), start11.getX(), start11.getY()));
swipe11.addAction(finger11.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
swipe11.addAction(finger11.createPointerMove(Duration.ofMillis(1000),
    PointerInput.Origin.viewport(), end11.getX(), end11.getY()));
swipe11.addAction(finger11.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
driver.perform(Arrays.asList(swipe11));
  


WebElement backwardslidermvmnt=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Saffola Masala Oats' )]")));

if(swipedofferslider.isDisplayed())	{
	System.out.println("slider has moved backwards successfully");
	
}else {
	System.out.println("no slider movements");
}
}
@Test(priority=6)
@Description("check the functionality of featured brands products")
public void brands() {

	final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	var start = new Point(980, 1798);
	var end = new Point (984, 1132);
	var swipe = new Sequence(finger, 1);
	swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
	    PointerInput.Origin.viewport(), start.getX(), start.getY()));
	swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
	    PointerInput.Origin.viewport(), end.getX(), end.getY()));
	swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	driver.perform(Arrays.asList(swipe));
	  

    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));

	WebElement viewall=wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("View All")));	
	viewall.click();
	
	final var finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	var start1 = new Point(860, 1969);
	var end1 = new Point (846, 887);
	var swipe1 = new Sequence(finger1, 1);
	swipe1.addAction(finger1.createPointerMove(Duration.ofMillis(0),
	    PointerInput.Origin.viewport(), start1.getX(), start1.getY()));
	swipe1.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
	swipe1.addAction(finger1.createPointerMove(Duration.ofMillis(1000),
	    PointerInput.Origin.viewport(), end1.getX(), end1.getY()));
	swipe1.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
	driver.perform(Arrays.asList(swipe1));
	  
	// Scroll through all items and count
	List<WebElement> brandList = driver.findElements(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().className(\"android.widget.ImageView\"))"));

	System.out.println("Total Brands Found: " + brandList.size());


//product verification under corresponding brands

WebElement abbott=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//android.widget.ImageView[@content-desc=\"Abbott\"])[1]")));


if (abbott.isDisplayed()) {
	abbott.click();
	System.out.println("abbott brand is clicked");
}else {
	System.out.println("abbott brand is not clicked");
}

List<WebElement>abbottprods=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.view.View/android.view.View[@content-desc]")));
System.out.println("no of prods:"+abbottprods.size());

if(abbottprods.size()>2) {
	Assert.fail("more than 2 products are present");
}else if(abbottprods.size()==2) {
	System.out.println("correct number of products are present under abbott brand");
}
for(WebElement prods:abbottprods) {
	String productnames=prods.getAttribute("content-desc").trim();
	System.out.println("brandnames:"+productnames.split("\\n")[0]);
	
}}

@Test(priority=7)
@Description("check the correctness of product details page")
@Step("")

public void proddetails() {
	
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
	
	WebElement olly=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("OLLY Womens Multivitamin Gummy\n130num\n₹ 1090.00")));
			if(olly.isDisplayed()) {
				olly.click();
			}else {
				System.out.println("olly product is not present");
			}
	

final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
var start = new Point(569, 2211);
var end = new Point (592, 1486);
var swipe = new Sequence(finger, 1);
swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
    PointerInput.Origin.viewport(), start.getX(), start.getY()));
swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
    PointerInput.Origin.viewport(), end.getX(), end.getY()));
swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
driver.perform(Arrays.asList(swipe));
	//product specifications
	WebElement specifications=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Show Full Specifications")));
	specifications.click();
	
	WebElement title=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Product Description')]")));
	Assert.assertTrue(title.isDisplayed());
	
	WebElement content=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Go big with OLLY Women')]")));
	String contenttext=content.getAttribute("content-desc");
	System.out.println("description:"+contenttext);
	Assert.assertTrue(contenttext.contains("gluten free gummy vitamin"));
	
	//product warnings
	
	WebElement warnings=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Product Warnings')]")));
	warnings.click();
	
	WebElement warningtitle=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Product Warnings')]")));
	Assert.assertTrue(warningtitle.isDisplayed());
	
	WebElement contents=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[contains(@content-desc,'Products with electrical plugs')]")));
	String contentstext=contents.getAttribute("content-desc");
	System.out.println("warnings:"+contentstext);
	Assert.assertTrue(contentstext.contains("Outlets and voltage differ"));
	
	WebElement backButton = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Back\"]"));
	
	
}
@Test(priority=7)
@Description("check the functionality of add to cart buttons")
public void addtocartbutton() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
WebElement prod1=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc='True Elements No Added Sugar Muesli']")));
prod1.click();

WebElement qnty=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.view.View[@content-desc=\"2\"]/android.widget.Button[1]")));
qnty.click();


if(qnty.equals("2")) {
	System.out.println("quantity is increased successfully");
}
else {
	System.out.println("quantity is increased successfully");
}
	
WebElement cart=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.accessibilityId("Add to Cart")))	;
	cart.click();
	WebElement cartcount=wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\").instance(2)")));
	
	if(cartcount.equals("2")) {
		System.out.println("cartcount:"+cartcount.getText());
	}
}
}