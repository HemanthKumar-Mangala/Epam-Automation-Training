package TestAutomation.selenium.SeleniumSAUCE;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import TestAutomation.selenium.WebDriverFactory;

public class ApplyLeaveTest {
WebDriver driver;
LoginPage loginpage;
NavigationMenu menu;
LeaveList leavelist;
ApplyLeave leave;
	
	@BeforeTest
	@Parameters("BrowserName")
	public void setup(String BrowserName) {
		driver=WebDriverFactory.getWebDriver( BrowserName);
		driver.manage().window().maximize();
		loginpage=new LoginPage(driver);
		menu=new NavigationMenu (driver);
		leavelist=new LeaveList(driver);
        leave=new ApplyLeave(driver);
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
	
	@Test(priority=2)
	public void testDateErrorAndColorAndApplyLeave()
	{
		 menu.selectLeaveOptionFromLeftMenu();
         menu.selectApplyOptionFromLeftMenu();
         
         leave.clickOnTypeOfLeaveDropDown()
         .selectSickLeave()
         .fromDate("Fri, 15 Jul 2022")
         .toDate( "Wed, 13 Jul 2022")
         .assertErrorMessageAndColor()
         .fromDate("Wed, 13 Jul 2022")
         .toDate("Fri, 15 Jul 2022")
         .enterComments("Leave")
		 .submitLeave()
		 .verifyPopupmessageandClose()
	     .clickOnCheckLeaveBalance()
	     .verifyZeroLeavesAndClose();
	 menu.Leavelistclick();;
		         
	
	}
	
	
	
	@Test(priority=3)
	public void testLeaveList()
	{
		leavelist.enterFromDate("Wed, 13 Jul 2022")
			.selectSubUnit()
			.selectArchitecture()
			.selectAll()
			.searchClick()
			.searchClick()
			.searchClick()
			.verifyRecordsNotFound();
		
	}
}
