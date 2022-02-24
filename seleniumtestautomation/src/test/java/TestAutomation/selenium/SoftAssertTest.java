package TestAutomation.selenium;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import TestAutomation.selenium.PageObjectModel.LoginPage;

public class SoftAssertTest {
	WebDriver driver;
	LoginPage loginpage ;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(@Optional("Chrome") String BrowserName) {
		driver=WebDriverFactory.getWebDriver( BrowserName);
		driver.manage().window().maximize();
		loginpage=new LoginPage(driver);
		}
	
	
	@Test(priority=1)
	public void testLoginPage()
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
		         .enterPassword("U@qBLVtm09")
		         .clickLoginButton();
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(false);
		System.out.println("After Test Soft Assert Fail");
		
		softAssert.assertAll();
		
			
	}
	
}
