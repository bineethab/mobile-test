package pages;

import org.testng.annotations.Test;

public class HomepageTest extends BaseTest {

	
@Test
public void signupnavigation() {
	
	homepage.clickbutton();
	signuppage.enterName("test");
	signuppage.enterEmail("test2012@gmail.com");
    signuppage.clickSignup();
    
    if(signuppage.isEmailAlreadyRegistered()) {
        System.out.println("Email already registered. Retrying with new email...");
        String newEmail=signuppage.generateEmail();
        signuppage.enterEmail(newEmail);
        signuppage.clickSignup();
    }
	
}
	
	
	
	
	
	
}
