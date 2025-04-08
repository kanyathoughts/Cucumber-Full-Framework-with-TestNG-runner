package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	// Web driver
	public WebDriver driver;
	
	By searchBar = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By topDealsLink = By.xpath("//a[.='Top Deals']");
	By addToCartButton = By.xpath("//button[text()='ADD TO CART']");
	By cartIcon = By.xpath("//img[@alt='Cart']");
	By proceedToCheckOutButton = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	String incrementSymbol = "//h4[contains(.,'productName')]/ancestor::div[@class='product']/descendant::a[@class='increment']";
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchProduct(String name) {
		driver.findElement(searchBar).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText().trim();
	}
	
	public void clickOnTopDealsLink() {
		driver.findElement(topDealsLink).click();
	}
	
	public WebElement getincrementSymbol(String productName) {
		String xpath = incrementSymbol.replace("productName", productName);
		return driver.findElement(By.xpath(xpath));
	}
	
	public void clickOnAddToCartButton() {
		driver.findElement(addToCartButton).click();
	}
	
	public void clickOnCartIcon() {
		driver.findElement(cartIcon).click();
	}
	
	public void clickOnProceedToCheckOutButton() {
		driver.findElement(proceedToCheckOutButton).click();
	}
}
