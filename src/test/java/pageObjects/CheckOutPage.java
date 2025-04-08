package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {

	public WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By applyButton = By.xpath("//button[text()='Apply']");
	By placeOrderButton = By.xpath("//button[text()='Place Order']");
	By productName = By.xpath("//td//p[@class='product-name']");
	
	public WebElement getApplyButton() {
		return driver.findElement(applyButton);
	}
	
	public WebElement getPlaceOrderButton() {
		return driver.findElement(placeOrderButton);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText().trim();
	}
}
