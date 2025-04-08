package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	// Web driver
	public WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		this.driver = driver;
	}

	By searchBar = By.xpath("//input[@type='search']");
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchProduct(String name) {
		driver.findElement(searchBar).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText().trim();
	}
	
}
