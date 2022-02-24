package TestAutomation.selenium.Listeners;

import static org.testng.Assert.assertTrue;

import java.io.File;
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

import TestAutomation.selenium.WebDriverFactory;
import TestAutomation.selenium.PageObjectModel.LoginPage;

@Listeners(IReporterClass.class)
public class ListenerTest {
 WebDriver driver;
 
 
 
	@BeforeTest
	//@Parameters("BrowserName")
	public void setup(ITestContext context) {
		driver=WebDriverFactory.getWebDriver("Chrome");
		 context.setAttribute("WebDriver", driver);
	}
	
	@Test
	public void testLoginFunctionality() {
	//	assertTrue(false);
		Reporter.log("Visting the website", true);;
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		
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
