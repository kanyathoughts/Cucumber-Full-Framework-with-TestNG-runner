package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectsManager;
import stepDefinitions.Hooks;

public class TestContext {

	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectsManager pageObjectsManager;
	public GenericUtils genericUtils;
	public BaseTest baseTest;
	
	public TestContext() throws IOException {
		baseTest = new BaseTest();
		this.pageObjectsManager = new PageObjectsManager(baseTest.webDriverManager());
		this.genericUtils = new GenericUtils(baseTest.webDriverManager());
		driver = baseTest.webDriverManager();
	}
	
	
}
