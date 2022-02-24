 package TestAutomation.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Testdriver {
	WebDriver driver;
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		//System.out.println("Firefox  "+BrowserName);
		 driver = WebDriverFactory.getWebDriver(BrowserName);
		// System.out.println("Firefox  "+ BrowserName);
	}
	@Test
	public void testdriver() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}

}
