package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
	
	public WebDriver driver;
	public LandingPage landingPage;
	public OfferPage offerPage;
	public CheckOutPage checkoutPage;
	
	public PageObjectsManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OfferPage getOfferPage() {
		offerPage = new OfferPage(driver);
		return offerPage;
	}
	
	public CheckOutPage getCheckoutPage() {
		checkoutPage = new CheckOutPage(driver);
		return checkoutPage;
	}
}
