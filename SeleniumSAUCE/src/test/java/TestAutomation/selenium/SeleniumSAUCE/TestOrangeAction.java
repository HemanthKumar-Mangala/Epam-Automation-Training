package TestAutomation.selenium.SeleniumSAUCE;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class TestOrangeAction {
	
    WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver=WebDriverFactory.getWebDriver(BrowserName);
	}
	@Test
	public void testLoginFunctionalityofuserName() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPageAction loginpageaction=new LoginPageAction(driver);
		loginpageaction.enterUserName("Admin")
		.enterPassword("U@qBLVtm09")
		.clickLoginButton();
	}
	
	

}
