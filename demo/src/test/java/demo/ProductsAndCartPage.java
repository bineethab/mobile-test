package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsAndCartPage {

	WebDriver driver;
	WebDriverWait wait;
	
	
	//productspage
	By addToCartBtn=By.id("add-to-cart-sauce-labs-backpack");
	By cartCount=By.className("shopping_cart_badge");
	By cartIcon=By.id("shopping_cart_container");
	
	//cartpage
	By productName=By.className("inventory_item_name");
	By removeBtn=By.id("remove-sauce-labs-backpack");
	
	public ProductsAndCartPage(WebDriver driver) {
		this.driver=driver;
		this.wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	public void addtocart() {
		wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn)).click();
		
	}
	
	public String getcartCount() {
		try {
		return wait.until(ExpectedConditions.elementToBeClickable(cartCount)).getText();
		}catch(Exception e) {
		return "0";
	}}
	
	
	public void carticonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(cartIcon)).click();
	}
	
	public String getproductName() {
		return wait.until(ExpectedConditions.elementToBeClickable(productName)).getText();
	}
	public void Removebtn() {
		wait.until(ExpectedConditions.elementToBeClickable(removeBtn)).click();
	}	
	
}
