import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
WebDriver driver;

public void Dashboard(WebDriver,driver) {
	WebDriver driver;

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "/html/body/div/div[1]/section/div/div/div/div/div/div/h3") 
    public WebElement welcomeMessage;

    public boolean isWelcomeMessageDisplayed() {
        return welcomeMessage.isDisplayed();
    }
}