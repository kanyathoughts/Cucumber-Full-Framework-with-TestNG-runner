package cucumberOptions;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "@target/failed_scenarios.txt",
		// glue will automatically check in src/test/java package as we defined this package in features attribute
		glue = "stepDefinitions",
		monochrome = true,
		plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				}
		//dryRun = true
		)
public class FailedTestNGTestRunner extends AbstractTestNGCucumberTests{

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		
		return super.scenarios();
	}
}
