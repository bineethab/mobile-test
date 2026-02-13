package pom;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ValidLogin extends BaseTest {
@Test
public void login() {
	Page page=new Page(driver);
	page.enterUsername("tomsmith");
	page.enterPassword("SuperSecretPassword!");
	page.clickLogin();
	
	
	Assert.assertTrue(page.getMessage().contains("You logged into a secure area!"));	
}

@Test(dataProvider="invalidloginData")
public void InvalidLogin(String username,String Password,String ExpectedMsg) {
Page page=new Page(driver);
page.enterUsername(username);
page.enterPassword(Password);
page.clickLogin();

Assert.assertTrue(page.getMessage().contains(ExpectedMsg)
    );

}
@DataProvider(name = "invalidloginData")
public Object [][]invalidLoginData(){
	return new Object[][] {
		{"tomsmith","jk","Your username is invalid!"},
		{"pp","SuperSecretPassword!","Your password is invalid!"},
		{"","","Your username is invalid!"}
	
}
	;}}