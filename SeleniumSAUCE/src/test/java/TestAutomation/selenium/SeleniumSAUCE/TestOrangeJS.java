package TestAutomation.selenium.SeleniumSAUCE;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class TestOrangeJS {
	
WebDriver driver;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver=WebDriverFactory.getWebDriver(BrowserName);
	}
	//@Test
	public void testLoginFunctionalityofuserNamejs() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPageJS loginpageaction=new LoginPageJS(driver);
		loginpageaction.checkUserNameJS("\"Admin\"")
        .checkPasswordJS("\"U@qBLVtm09\"")
        .checkLoginButton();
	}
	@Test(enabled=false)
	public void testLoginFunctionalityscreenshot() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPageJS loginpage=new LoginPageJS(driver);
		loginpage.enterUserName("Admin")
		         .enterPassword("U@qBLVtm09")
		         .clickLoginButton()
		         .testscreenshot() ;
	}
	@Test
	public void testLogin() throws InterruptedException {
	driver.get("https://prasoonr-trials73.orangehrmlive.com/");
	LoginPageJS loginPage = new LoginPageJS(driver);
	loginPage.checkUserNameJS("\"Admin\"")
	.checkPasswordJS("\"U@qBLVtm09\"")
	.checkLoginButton();
	}

}
