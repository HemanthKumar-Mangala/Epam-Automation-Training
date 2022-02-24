package TestAutomation.selenium.OrangeHRM;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.LoginPage;

public class TestSystemUser {

	WebDriver driver;
	String url;
	String username;
	String password;
	LoginPage login;
	String platformName;

	// @BeforeClass
	@BeforeTest
	public void setup(ITestContext context) throws MalformedURLException {
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformName = context.getCurrentXmlTest().getParameter("OrangeHRmTestExecutionPlatfrom");
		url = context.getCurrentXmlTest().getParameter("url");
		username = context.getCurrentXmlTest().getParameter("username");
		password = context.getCurrentXmlTest().getParameter("password");
		driver = WebDriverFactoryOfFactory.getWebDriverfactory(platformName).getWebDriver(browserName);
		driver.get(url);

	}
	
	@Test
	public void testSystemUser() {
		
		login = new LoginPage(driver);
		login.enterUserName(username).enterPassword(password).clickLoginButton()
			 .navigateToMenu().AdminBtnClick()
			 .userManagementBtnClick().usersBtnClick().amandaEditClick()
			 .adminroleDropDownClick().globalAdminClick().savebtnClick()
			 .amandaEditClick().verifyGlobalButtonDisplay().adminroleDropDownClick()
			 .selectclick().savebtnClick().amandaEditClick()
			 .verifySelectDisplay().savebtnClick().navigateToMenu().logout();
			 
			 
	}

}
