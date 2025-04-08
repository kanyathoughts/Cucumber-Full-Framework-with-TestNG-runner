package stepDefinitions;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckOutPage;
import utils.TestContext;

public class CheckoutPageStepDefinition {

	public WebDriver driver;
	public TestContext testContext;
	public CheckOutPage checkoutPage;
	
	// Dependency Injection by cucumber picoContainer
	public CheckoutPageStepDefinition(TestContext testContext) {
		this.testContext = testContext;
		checkoutPage = testContext.pageObjectsManager.getCheckoutPage();
	}
	
	@Then("Check if Product Name which has been extracted from GreenKart page is visible in Checkout Page")
	public void check_if_product_name_which_has_been_extracted_from_green_kart_page_is_visible_in_checkout_page() throws InterruptedException {
	    Thread.sleep(4000);
	    String checkOutPageproductName = checkoutPage.getProductName().split("-")[0].trim();
	    Assert.assertEquals(checkOutPageproductName, testContext.landingPageProductName);
	}
	
	@Then("Apply and PlaceOrder buttons also visible.")
	public void apply_and_place_order_buttons_also_visible() {
		Assert.assertTrue(checkoutPage.getApplyButton().isDisplayed());
		Assert.assertTrue(checkoutPage.getPlaceOrderButton().isDisplayed());
	}
	
	
}
