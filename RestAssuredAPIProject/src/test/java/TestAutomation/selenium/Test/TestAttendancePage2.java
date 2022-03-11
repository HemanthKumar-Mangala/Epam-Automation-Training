package TestAutomation.selenium.Test;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.paulhammant.ngwebdriver.NgWebDriver;

import TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.LoginPage;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.MyAttendanceSheetPage;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.NavigationMenu;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.PunchInOutPage;

public class TestAttendancePage2 {
	WebDriver driver;
	String url;
	String username;
	String password;
	LoginPage login;
	String platformName;
	MyAttendanceSheetPage attendance;
	public  NgWebDriver ngWebDriver;
	JavascriptExecutor js;
	PunchInOutPage punchtime;
	NavigationMenu menu;

	@BeforeTest
	public void setup(ITestContext context) throws MalformedURLException {
		String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformName = context.getCurrentXmlTest().getParameter("OrangeHRmTestExecutionPlatfrom");
		url = context.getCurrentXmlTest().getParameter("url");
		username = context.getCurrentXmlTest().getParameter("username");
		password = context.getCurrentXmlTest().getParameter("password");
		driver = WebDriverFactoryOfFactory.getWebDriverfactory(platformName).getWebDriver(browserName);
		driver.get(url);
		driver.manage().window().maximize();

		
	   Duration d=Duration.ofSeconds(15);
	}
	@Test(priority=1)
	public void testMyAttendancePagePunchInAndOut()
	{
		
		login = new LoginPage(driver);
		login.enterUserName(username)
		     .enterPassword(password)
		     .clickLoginButton()
			 .navigateToMenu()
			 .attendanceButtonClick()
			 .myAttendanceSheetButtonClick()
			 .clickOnParticularDateOnAttendanceSheet("07 Mar")
			 .editParticularPunchInOut("07 Mar", "Mon, 07 Mar 2022 03:30")
			 
			 .editPunchIn("04:30")
			 .editPunchout("04:35")
			 .editSaveClick();
		     
	}
	
}
