package utils;

import org.openqa.selenium.WebDriver;

public class GenericUtils {

	public WebDriver driver;

	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchWindowToChild() {
		 Object[] arrayOfWindowHandles = driver.getWindowHandles().toArray();
		 driver.switchTo().window(arrayOfWindowHandles[1].toString());
	}
}
