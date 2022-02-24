package TestAutomation.selenium;

import static org.testng.Assert.assertTrue;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import TestAutomation.selenium.PageObjectModel.ApplyLeave;
import TestAutomation.selenium.PageObjectModel.LeaveList;
import TestAutomation.selenium.PageObjectModel.LoginPage;
import TestAutomation.selenium.PageObjectModel.NavigationMenu;

public class TestExtentReport {
WebDriver driver;
LoginPage loginpage ;
ExtentReports report;
ExtentTest test;



	@BeforeTest
	@Parameters("BrowserName")
	public void setup(@Optional("Chrome") String BrowserName) {
		driver=WebDriverFactory.getWebDriver( BrowserName);
		driver.manage().window().maximize();
		loginpage=new LoginPage(driver);
		
		String filePath = ".//src/main/resources//ExtentReportResults.html";
		report = new ExtentReports(filePath);
		test = report.startTest("ExtentReportTest");
		
	}
	
	@Test(priority=1)
	public void testLoginPage() throws Exception
	{
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName("Admin")
		         .enterPassword("U@qBLVtm09")
		         .clickLoginButton();
		if(driver.getTitle().equals("OrangeHRM1"))
		{
			test.log(LogStatus.PASS,"Navigated to the specified URL");
		}
		else
		{
			String screenshotPath=takeScreenShot(driver);
			test.log(LogStatus.FAIL,"Did not navigated to the specified URL",test.addScreenCapture(screenshotPath));
		}
		
			
	}
	public String takeScreenShot(WebDriver driver) throws Exception{

	     

	     TakesScreenshot scrShot =((TakesScreenshot)driver);

	     

	             File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	         

	             File DestFile=new File("./src/main/resources/img.png");

	             FileUtils.copyFile(SrcFile, DestFile);
	             
	             return "img.png";
	 }
	
	@AfterClass
	public void close()
	{
		driver.close();
		driver.quit();
		report.endTest(test);
		report.flush();
	}
	
}
