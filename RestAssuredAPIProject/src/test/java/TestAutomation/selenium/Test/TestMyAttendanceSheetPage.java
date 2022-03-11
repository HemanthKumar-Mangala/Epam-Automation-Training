package TestAutomation.selenium.Test;

import static org.testng.Assert.*;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;


import com.paulhammant.ngwebdriver.NgWebDriver;

import org.testng.annotations.*;

import TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.LoginPage;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.MyAttendanceSheetPage;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.NavigationMenu;
import TestAutomation.selenium.OrangeHRM.PageObjectModel.PunchInOutPage;

public class TestMyAttendanceSheetPage {
	
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
		driver.manage().window().maximize();

		
	   Duration d=Duration.ofSeconds(15);
	    
//	js=(JavascriptExecutor) driver;
//	ngWebDriver = new NgWebDriver(js);
//	ngWebDriver .waitForAngularRequestsToFinish();

	}
	//id="txtUsername"
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
			 .deletePunchInPunchOutDetailsOfParticulardate("07 Mar")
			 .navigateToMenu()
			 .punchInOutButtonClick()
			 .enterDate("Mon, 07 Mar 2022")
			 .entertime("00:13")
			 .punchInSubmit()
			 .verifySavedSuccefully()
			 .navigateToMenu()
			 .punchInOutButtonClick()
			 .enterDate("Mon, 07 Mar 2022")
			 .entertime("03:03")
			 .punchOutSubmit()
			 .verifySavedSuccefully();
		     
		     
		
	}
	
	@Test(priority=2)
	public void testPunchInOutMoreThanOnce() 
	{
		menu=new NavigationMenu(driver);
		menu.punchInOutButtonClick().enterDate("Mon, 07 Mar 2022")
		 .entertime("03:30")
		 .punchInSubmit()
		 .verifySavedSuccefully()
		 .navigateToMenu()
		 .punchInOutButtonClick()
		 .enterDate("Mon, 07 Mar 2022")
		 .entertime("07:30")
		 .punchOutSubmit()
		 .verifySavedSuccefully();
		
		
		
		
		
		
	}
	
	@Test(priority=3)
	public void testOverLappingRecordswhilePunchingIn()
	{
		
		punchtime=new PunchInOutPage(driver);
		punchtime.enterDate("Mon, 07 Mar 2022")
		         .entertime("03:35")
		         .verifyOverlappingRecords();
		
	}
	
	@Test(priority=4)
	public void testPunchoutShouldbeLaterThanPunchIn() throws InterruptedException
	{
		punchtime.enterDate("Mon, 07 Mar 2022")
		         .entertime("07:35")
		         .punchInSubmit()
		         .verifySavedSuccefully()
		         .navigateToMenu()
				 .punchInOutButtonClick()
				 .enterDate("Mon, 07 Mar 2022")
				 .entertime("07:33")
				 .verifyPunchInLaterPunchOut()
				 .entertime("07:45")
				 .punchOutSubmit()
				 .verifySavedSuccefully();
		Thread.sleep(5000);
		  login
		 .navigateToMenu()
		 .myAttendanceSheetButtonClick();
		         
		         
	}
	
	
	
	@Test(priority=5)
	public void testDeleteParticularPunchInADay()
	{
		attendance=new MyAttendanceSheetPage(driver);
		
		attendance
		.clickOnParticularDateOnAttendanceSheet("07 Mar")
		.deleteParticularPunchInOut("07 Mar","Mon, 07 Mar 2022 00:13");
	}
	
	
	
	
	@Test(priority=6)
	public void testTotalHoursOfTheDay() throws InterruptedException
	{
		Thread.sleep(7000);
		String time=attendance.getCalculateTotalDaytime("07 Mar");
		String convertedTime =attendance.convertTime(time);
		System.out.println("Start :"+ convertedTime);
		
		
		menu.punchInOutButtonClick().enterDate("Mon, 07 Mar 2022")
		 .entertime("21:30")
		 .punchInSubmit()
		 .navigateToMenu()
		 .punchInOutButtonClick()
		 .enterDate("Mon, 07 Mar 2022")
		 .entertime("23:30")
		 .punchOutSubmit();
		
		Thread.sleep(5000);
		  login
		 .navigateToMenu()
		 .myAttendanceSheetButtonClick();
		  
		  String resultTime=attendance.getCalculateTotalDaytime("07 Mar");
			String ActualResultTime =attendance.convertTime(resultTime);
			System.out.println("Actual :"+ ActualResultTime);
			
			
			
			String ExpectedresultpunchInOut=attendance.addTwoTimes(convertedTime,"02:00" );
			System.out.println("Expected:"+ ExpectedresultpunchInOut);
			
			assertEquals( ActualResultTime ,ExpectedresultpunchInOut);
			
			
		
		
	}
	
	
	

}
