package TestAutomation.selenium.SeleniumSAUCE;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumSauceDriver {
	public WebDriver driver;
	
	@BeforeTest
	public void setup() throws MalformedURLException {
	// setting up SAUCE properties/credenials
	MutableCapabilities sauceOptions = new MutableCapabilities();
	
	sauceOptions.setCapability("username", "oauth-hemanthraina1999-565e3");
	
	//sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
	
	sauceOptions.setCapability("accessKey", "0ffd0c28-86bb-4d20-92c1-14eeb546d9dc");
	
	sauceOptions.setCapability("browserVersion", "latest");
	
	
	ChromeOptions options = new ChromeOptions();
	
	options.setCapability("sauce:options", sauceOptions);
	
	URL url = new URL("https://oauth-hemanthraina1999-565e3:0ffd0c28-86bb-4d20-92c1-14eeb546d9dc@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	driver = new RemoteWebDriver(url, options);


	}
	
	@Test(priority=1)
	public void testLoginPage()
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
		         .enterPassword("U@qBLVtm09")
		         .clickLoginButton();
	}
	
}
