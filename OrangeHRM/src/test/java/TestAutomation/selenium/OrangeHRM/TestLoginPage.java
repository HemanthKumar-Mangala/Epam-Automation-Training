package TestAutomation.selenium.OrangeHRM;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.LoginPage;

public class TestLoginPage {
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
	public void testlogin() {
		
		login = new LoginPage(driver);
		login.enterUserName(username).enterPassword(password).clickLoginButton().navigateToMenu().logout();
	}

	@Test
	public void testLoginWithProxy() {
		
		login = new LoginPage(driver);
		login.enterUserNamewithFindElement(username).enterPassword(password).clickLoginButton().navigateToMenu().logout();
	}

	@Test
	public void testLoginUsingJavascript() throws InterruptedException {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUserName(username).enterPassword(password).clickLoginButtonUsingJavascript().logout();
	}

	@AfterMethod
	public void setStatus(ITestResult result) {
		if (platformName.equalsIgnoreCase("Saucedriver")) {
			String resultFortest = result.isSuccess() ? "passed" : "failed";
			((RemoteWebDriver) driver).executeScript("sauce:job-result=" + resultFortest);
		}
	}

	@AfterClass
	public void close() {
		driver.close();
		driver.quit();
	}

}
