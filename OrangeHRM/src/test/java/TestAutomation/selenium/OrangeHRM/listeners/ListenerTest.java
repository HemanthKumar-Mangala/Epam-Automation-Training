package TestAutomation.selenium.OrangeHRM.listeners;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.net.MalformedURLException;

import org.testng.Reporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import  TestAutomation.selenium.OrangeHRM.PageObjectModel.*;
//@Listeners(IReporterClass.class)
public class ListenerTest {
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
		context.setAttribute("WebDriver", driver);

	}

	@Test
	public void testLoginFunctionality() {
	//	assertTrue(false);
		Reporter.log("Visting the website", true);;
		LoginPage loginpage=new LoginPage(driver);
		driver.findElement(By.xpath("/Abc"));
		loginpage.enterUserName("Admin")
		         .enterPassword("U@qBLVtm09")
		         .clickLoginButton();
}
	@Test
	public void Passedmethod() {
		
			assertTrue(true);
			
	}
}
