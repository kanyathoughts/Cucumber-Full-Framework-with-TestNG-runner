package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

	public WebDriver driver;
	
	public WebDriver webDriverManager() throws IOException {
		// System.getProperty("user.dir") it will give the project path
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src/test//resources//Global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		// Here we can pass global properties from command line so if we don't pass in command line 
		// then it will consider properties file values else it will consider value from command line.
		String propFileBrowser = prop.getProperty("browser");
		String systemBrowserFromMvnCommand = System.getProperty("browser");
		
		String browser = systemBrowserFromMvnCommand != null ? systemBrowserFromMvnCommand : propFileBrowser;
		
		if (driver == null) {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				driver = new FirefoxDriver();
			} else {
				driver = new EdgeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		return driver;
	}
}
