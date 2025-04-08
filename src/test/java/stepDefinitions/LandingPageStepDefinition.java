package stepDefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.PageObjectsManager;
import utils.BaseTest;
import utils.TestContext;

public class LandingPageStepDefinition extends BaseTest{

	public WebDriver driver;
	public String landingPageProductName;
	public TestContext testContext;
	public LandingPage landingPage;
	
	// Constructor Dependency by picocontainer
	public LandingPageStepDefinition(TestContext utils) {
		this.testContext = utils;
		driver = this.testContext.driver;
	}
	

	@Given("User is be on GreenKart landing page")
	public void user_is_be_on_green_kart_landing_page() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(driver.getTitle().contains("GreenKart"));
	}
	
	@When("^User searched with shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		// Here we have got driver instance in pageObjectsManager class and inside this class we are creating page object classes objects using methods.
		landingPage = testContext.pageObjectsManager.getLandingPage();
		
		landingPage.searchProduct(shortName);
	    Thread.sleep(2000);
	    testContext.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println("Product Name is extracted from home page: " + testContext.landingPageProductName);
	}
	
	@Then("{string} product is visible")
	public void product_Is_Visible(String name) {
		Assert.assertEquals(testContext.landingPageProductName, name);
	}
	
	@Then("Add the product {int} times")
	public void add_the_product_times(Integer times) {
		for (int i = 0; i < times - 1 ; i ++) {
			landingPage.getincrementSymbol(testContext.landingPageProductName).click();
		}
	}
	@Then("Clik on ADD to Cart button")
	public void clik_on_add_to_cart_button() {
	    landingPage.clickOnAddToCartButton();
	}
	@Then("Click on cart icon on top right corner")
	public void click_on_cart_icon_on_top_right_corner() {
	    landingPage.clickOnCartIcon();
	}
	@Then("Click on Proceed to checkout button")
	public void click_on_proceed_to_checkout_button() {
	    landingPage.clickOnProceedToCheckOutButton();
	}
}
