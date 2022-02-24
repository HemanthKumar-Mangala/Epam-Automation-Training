package TestAutomation.selenium;

import java.net.MalformedURLException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

import TestAutomation.selenium.PageObjectModel.LoginPage;

public class SeleniumGrid {
	RemoteWebDriver driver;

	@BeforeClass
	//@Parameters("BrowserName")
	public void setup(@Optional("CHROME") String BrowserName) throws MalformedURLException {
	driver = WebGridFactory.getWebDriver(BrowserName);
	driver.get("https://prasoonr-trials73.orangehrmlive.com/");
	}

	@Test(priority=1)
	public void testLoginFunctionality() throws InterruptedException {

	driver.get("https://prasoonr-trials73.orangehrmlive.com/");

	LoginPage loginPage = new LoginPage(driver);

	loginPage.enterUserName("Admin")
	.enterUserName("U@qBLVtm09")
	.clickLoginButton();
	}

	


}
