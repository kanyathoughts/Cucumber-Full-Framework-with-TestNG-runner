package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContext;

public class Hooks {
	
	public TestContext testContext;
	
	// PicoContainer TestContext dependency injection
	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}

	@After
	public void afterScenario() {
		testContext.driver.quit();
	}
	
	@AfterStep
	public void attachScreenShots(Scenario scenario) throws IOException {
		WebDriver driver = testContext.baseTest.webDriverManager();
		if (scenario.isFailed()) {
			File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			byte[] fileToByteArray = FileUtils.readFileToByteArray(sourceFile);
			scenario.attach(fileToByteArray, "image/png", "image");
		}
	}
}
