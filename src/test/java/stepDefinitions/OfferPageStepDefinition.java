package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContext;

public class OfferPageStepDefinition {

	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	public TestContext testContext;
	public OfferPage offerPage;
	public LandingPage landingPage;
	
	// Constructor Dependency by picocontainer
	public OfferPageStepDefinition(TestContext utils) {
		this.testContext = utils;
	}

	@Then("^User searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shotname_in_offers_page_to_check_if_product_exists(String shortName) {
	    switchToOffersPage();
	    offerPage.searchProduct(shortName);
	    offersPageProductName = offerPage.getProductName();
	}
	
	@And("validate product name in offers page with landing page")
	public void validate_Product_Name_In_Offers_Page_With_Landing_Page() {
		Assert.assertEquals(offersPageProductName, testContext.landingPageProductName, "Product is not matched");
	}
	
	// Here we will repeat this method in another method also
	public void switchToOffersPage() {
		offerPage = testContext.pageObjectsManager.getOfferPage();
		landingPage = testContext.pageObjectsManager.getLandingPage();
		landingPage.clickOnTopDealsLink();
		testContext.genericUtils.switchWindowToChild();
	}
}
