package hr;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HR {
	//@Test
	public void Login() throws InterruptedException {

	System.setProperty("webdriver.chrome.driver","C:\\Users\\BINEETHA\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("Username");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("Password");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	driver.quit();

	}
	//@Test
	public void UserModule() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@href,'userlist')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/ul/li[2]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/ul/li[3]/a")).click();
	driver.quit() ;
	}
	//@Test
	public void Addstaff() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@href,'stafflist')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[1]/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[2]/input")).sendKeys("005");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[3]/input")).sendKeys("02-11-1990");


	Select a=new Select(driver.findElement(By.name("employee")));
	a.selectByVisibleText("Female");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[5]/input")).sendKeys("8605364231");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[6]/input")).sendKeys("2419371");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[7]/input")).sendKeys("raji@gmail.com");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[9]/input")).sendKeys("Anand");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[10]/input")).sendKeys("Rithik");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[3]/input")).sendKeys("kottiyam");

	Select b=new Select(driver.findElement(By.name("Country")));
	b.selectByVisibleText("India");
	Thread.sleep(1000);
	Select c=new Select(driver.findElement(By.name("State")));
	c.selectByVisibleText("Kerala");
	Thread.sleep(1000);
	Select d=new Select(driver.findElement(By.name("District")));
	d.selectByVisibleText("Kollam");
	Thread.sleep(1000);
	Select e=new Select(driver.findElement(By.name("Branch")));
	e.selectByVisibleText("DDC Kollam");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[8]/input")).sendKeys("695584");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[9]/button")).click();
	driver.quit();

	}
	//@Test
	public void EditStaff() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@href,'stafflist')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"chk80\"]/td[7]/i")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div[1]/div/div[2]/div/div/div[8]/textarea")).sendKeys("DDC STAFF NURSE");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div[2]/div/div/div/div/div[4]/input")).sendKeys("Gujarat");
	Thread.sleep(1000);
	WebElement element1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div[2]/div/div/div/div/div[2]/input"));
	element1.sendKeys(Keys.CONTROL + "a");
	element1.sendKeys(Keys.DELETE);

	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div[2]/div/div/div/div/div[2]/input")).sendKeys("RENUKA M");

	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div[5]/button")).click();
	driver.quit();
	}
	//@Test
	public void JobAdd() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@href,'joblist')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div[2]/div[1]/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/form/div/div/div/div[2]/div/div/div[1]/input")).sendKeys("Microbiology Technician");

	Select b=new Select(driver.findElement(By.name("employee")));
	b.selectByVisibleText("DDC Maradu");

	Select a=new Select(driver.findElement(By.name("status")));
	a.selectByVisibleText("Publish");

	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/form/div/div/div/div[2]/div/div/div[5]/textarea")).sendKeys("1.work involves collecting and analyzing samples, operating and maintaining lab equipment, reviewing microbiology publications and publishing reports on their findings."
	+ "2.keep work stations clean and organized, inform staff members about new safety procedures.");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/form/div/div/div/div[3]/button")).click();
	driver.quit();
	}
	//@Test
	public void JobEdit() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(@href,'joblist')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"chk76\"]/td[7]/a/i")).click();

	Thread.sleep(1000);
	WebElement element1 = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/form/div/div/div/div[2]/div/div/div[1]/input"));
	element1.sendKeys(Keys.CONTROL + "a");
	element1.sendKeys(Keys.DELETE);

	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/form/div/div/div/div[2]/div/div/div[1]/input")).sendKeys("HISTOLOGY TECHNICIAN");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/form/div/div/div/div[3]/button")).click();
	driver.quit();
	}

	//@Test
	public void AddBranch() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Regions & Branches')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[1]/input")).sendKeys("DDC VAZHUTHACAUD");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[2]/input")).sendKeys("DDC050");
	driver.findElement(By.xpath("//*[@id=\"user_pass\"]")).sendKeys("21030");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[4]/input")).sendKeys("04712419317");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[5]/input")).sendKeys("9891458546");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[1]/div/div[2]/div/div/div[6]/input")).sendKeys("ddclabs@gmail.com");
	Thread.sleep(1000);
	Select b=new Select(driver.findElement(By.name("Region")));
	b.selectByVisibleText("pattom");

	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[1]/textarea")).sendKeys("vazhuthacaud");
	Thread.sleep(1000);
	Select c=new Select(driver.findElement(By.name("Country")));
	c.selectByVisibleText("India");
	Thread.sleep(1000);
	Select d=new Select(driver.findElement(By.name("State")));
	d.selectByVisibleText("Kerala");
	Thread.sleep(1000);
	Select e=new Select(driver.findElement(By.name("District")));
	e.selectByVisibleText("Kollam");

	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[6]/input")).sendKeys("695584");

	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[7]/button")).click();
	driver.quit();
	}
	//@Test
	public void EditBranch() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Regions & Branches')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"chkundefined\"]/td[6]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[2]/textarea")).sendKeys("vazhuthacaud");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/form/div/div/div[2]/div/div/div/div/div[8]/button")).click();
	driver.quit();
	}
	//@Test
	public void RegionAdd() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Regions & Branches')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/ul/li[2]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[1]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div[1]/input")).sendKeys("015");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div[2]/input")).sendKeys("Ulloor");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	driver.quit();
	}
	//@Test
	public void RegionEdit() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Regions & Branches')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div[2]/ul/li[2]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"region\"]/div/div/div/div/table/tbody/tr[17]/td[4]/a/i")).click();

	Select e=new Select(driver.findElement(By.name("user_status")));
	e.selectByVisibleText("Active");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	driver.quit();
	}
	//@Test
	public void CalendarAdd() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"eventname\"]")).sendKeys("Good Friday");
	driver.findElement(By.xpath("//*[@id=\"fromdate\"]")).sendKeys("07-04-2023");
	driver.findElement(By.xpath("//*[@id=\"Calender\"]/div/div[2]/form/div/button")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"eventname\"]")).sendKeys("Inaugural Ceremony");
	driver.findElement(By.xpath("//*[@id=\"fromdate\"]")).sendKeys("15-01-2023");
	driver.findElement(By.xpath("//*[@id=\"Calender\"]/div/div[2]/form/div/div[4]/input")).click();
	Select e=new Select(driver.findElement(By.name("Branch")));
	e.selectByVisibleText("DDC Kollam");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"Calender\"]/div/div[2]/form/div/button")).click();
	driver.quit();
	}
	//@Test
	public void CalendarDelete() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"Calender\"]/div/div[1]/div/div/div[2]/div[6]/div[2]/div[2]/div[2]/div/div/div/div")).click();
	driver.findElement(By.xpath("/html/body/div[3]/h5/div/a/i")).click();

	Thread.sleep(2000);
	Alert alert=driver.switchTo().alert();
	   String alertMessage=driver.switchTo().alert().getText();
	System.out.println(alertMessage);
	alert.accept();
	driver.quit();
	}
	//@Test
	public void ShiftAdd() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/ul/li[1]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'SHIFT')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[3]/div/div[1]/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[1]/input")).sendKeys("test1");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[2]/input")).sendKeys("08.30");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[3]/input")).sendKeys("06.30");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	driver.quit();
	}
	//@Test
	public void ShiftEdit() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/ul/li[1]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'SHIFT')]")).click();
	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[@id=\"chkundefined\"]/td[4]/a/i")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[4]/textarea")).sendKeys("test1");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	driver.quit();
	}
	//@Test
	public void ShiftAssign() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/ul/li[1]/a")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'SHIFT')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"chkundefined\"]/td[5]/a/i")).click();
	Thread.sleep(2000);
	Select e=new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[2]/select")));
	e.selectByVisibleText("DDC KAZHAKOOTTAM");
	Thread.sleep(2000);
	Select f=new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[3]/select")));
	f.selectByVisibleText("REVATHY");
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[6]/input")).sendKeys("21-01-2023");
	    Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[7]/input")).sendKeys("24-01-2023");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	driver.quit();
	}
	//@Test
	public void ShiftSearch() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/ul/li[1]/a")).click();
	Thread.sleep(1000);

	Select e=new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[1]/form/div/div/select")));
	e.selectByVisibleText("DDC KAZHAKOOTTAM");
	driver.findElement(By.xpath("//*[@id=\"BranchWise\"]/form/div/button")).click();

	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"Attendence\"]/div/div/div/div/div/div/div[2]/div/ul/li[2]/a")).click();

	//driver.findElement(By.xpath("")).click();
	Thread.sleep(1000);
	Select f=new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/form/div/div[1]/select")));
	f.selectByVisibleText("DDC HEAD OFFICE");
	Thread.sleep(1000);
	Select g=new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[2]/form/div/div[2]/select")));
	g.selectByVisibleText("AAKASH");
	driver.findElement(By.xpath("//*[@id=\"StaffWise\"]/form/div/button")).click();
	driver.quit();
	}
	//@Test
	public void LeaveApplication() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("admin");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("admin@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Leave Application')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Applied leaves')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"chk2\"]/td[6]/center/i")).click();
	Thread.sleep(1000);
	Select g=new Select(driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[5]/select")));
	g.selectByVisibleText("In Process");

	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	driver.quit();
	}
	//@Test
	public void LeaveUser() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("user");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("user@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();

	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Leave Application')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'My applications')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"chk2\"]/td[5]/center/i")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[1]/textarea")).sendKeys("fever,");
	    driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	    Thread.sleep(1000);
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/div/div[2]/div[1]/div/button")).click();
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[1]/textarea")).sendKeys("I request you to grant weeks leave from 17th May to 20th May, due to my brother’s marriage. I will be leaving for my hometown on 16th May evening");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[2]/input")).sendKeys("17-05-2023");
	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[1]/div/div/div/div[3]/input")).sendKeys("20-05-2023");

	driver.findElement(By.xpath("/html/body/div[4]/div/div/div[2]/form/div[2]/button[1]")).click();
	}
	//@Test
	public void ShiftDelete() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("user");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("user@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	Thread.sleep(1000);

	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/ul/li[1]/a")).click();
	Thread.sleep(1000);
	Select e=new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[1]/form/div/div/select")));
	e.selectByVisibleText("DDC KAZHAKOOTTAM");
	driver.findElement(By.xpath("//*[@id=\"BranchWise\"]/form/div/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"Attendence\"]/div/div/div/div/div/div/div[1]/div/div[2]/div[5]/div[2]/div[2]/div/div/div/div/div")).click();
	    driver.findElement(By.xpath("/html/body/div[3]/h5/div/div/a[2]/i")).click();
	 
	    Thread.sleep(2000);
	Alert alert=driver.switchTo().alert();
	    String alertMessage=driver.switchTo().alert().getText();
	System.out.println(alertMessage);
	alert.accept();
	driver.quit();

	}
	//@Test
	public void ShiftView() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://192.168.2.11:3000");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[1]/input")).sendKeys("user");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/div[2]/input")).sendKeys("user@123");
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div/div/form/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[contains(text(),'Attendance')]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/div/div/ul/li[1]/a")).click();
	Thread.sleep(1000);
	Select e=new Select(driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section/div/div/div/div/div[2]/div/div/div/div/div/div/div[2]/div/div/div[1]/form/div/div/select")));
	e.selectByVisibleText("DDC HEAD OFFICE");
	driver.findElement(By.xpath("//*[@id=\"BranchWise\"]/form/div/button")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("/html/body/div[2]/div[3]/div/div/section/div/div/div/div/div[2]/div/div/div/div/div/div/div[1]/div/div[1]/span[3]/button[1]")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"Attendence\"]/div/div/div/div/div/div/div[1]/div/div[1]/span[3]/button[2]")).click();
	Thread.sleep(1000);
	driver.quit();
	}}








