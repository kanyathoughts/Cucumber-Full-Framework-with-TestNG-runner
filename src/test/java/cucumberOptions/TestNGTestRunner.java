package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		// glue will automatically check in src/test/java package as we defined this package in features attribute
		glue = "stepDefinitions",
		monochrome = true,
		tags = "@placeOrder or @searchProducts",
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"rerun:target/failed_scenarios.txt"}
		//dryRun = true
		)
public class TestNGTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
}
