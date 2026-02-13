package demo;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Tests extends BaseTest{
@Test
public void VerifyaddtocartFlow() {
	LoginPage login=new LoginPage(driver);
	ProductsAndCartPage PdsPage=new ProductsAndCartPage(driver);
	
	
	//login
	login.enterUsername("standard_user");
	login.enterPassword("secret_sauce");
	login.clickLogin();
	Assert.assertTrue(login.isLoginSuccessful(),"LOGIN FAILED");
	
	//Add product
	PdsPage.addtocart();
	Assert.assertEquals(PdsPage.getcartCount(), "1");
	// Open cart and verify
	PdsPage.carticonClick();
	Assert.assertTrue(PdsPage.getproductName().contains("Sauce Labs Backpack"));
	
	//removeproduct
	PdsPage.Removebtn();
	Assert.assertEquals(PdsPage.getcartCount(), "0");
}
@Test(dataProvider="InvalidLoginDatas")
public void invalidLogin(String username,String password,String message) {
	LoginPage login=new LoginPage(driver);

	login.enterUsername(username);
	login.enterPassword(password);
	login.clickLogin();
	
	Assert.assertTrue(login.errorMsg().contains(message));
}
@DataProvider(name="InvalidLoginDatas")
public Object[][] InvalidLoginDatas(){
	return new Object[][] {
		{"locked_out_user","secret_sauce","Epic sadface: Sorry, this user has been locked out."},
		{"standard_user","wrong_pass","Epic sadface: Username and password do not match any user in this service"},
		{"","secret_sauce","Epic sadface: Username is required"},
	};
	
	
}}
