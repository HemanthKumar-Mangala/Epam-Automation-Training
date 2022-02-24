package TestAutomation.selenium.PageObjectModel;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class TestOrangeHRMLoginPage {
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver=WebDriverFactory.getWebDriver(BrowserName);
	}
	//@Test
	public void testLoginFunctionality() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
		         .enterPassword("U@qBLVtm09")
		         .clickLoginButton();
	}
	//@Test
	public void testfindlements() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
        .enterPassword("U@qBLVtm09")
        .clickLoginButton();
		
	}
	
	
	//@Test
	public void testfindlementsforIncorrectLogin() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
        .enterPassword("U@qBLVtm0")
        .clickLoginButton();
        //.printElementInputfields();
        //.clickLoginButton()
		//.printElementInputfields();
		
		assertTrue(driver.getCurrentUrl().endsWith("securityAuthentication/retryLogin"));
		
	}
	@Test(priority=1)
	public void testemployeedetails() throws InterruptedException {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
        .enterPassword("U@qBLVtm09")
        .clickLoginButton();
       // .navigatetoUrl();
		
	}
	@Test(priority=2)
	public void testradiobutton() throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickRadioButton();
	}
	@Test(priority=3)
	public void testcheckBoxex() throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.clickCheckBoxes();
	}
	//@Test(priority=4)
	public void testclose() throws InterruptedException {
		LoginPage loginpage=new LoginPage(driver);
		loginpage.quitemployee();
	}
}
