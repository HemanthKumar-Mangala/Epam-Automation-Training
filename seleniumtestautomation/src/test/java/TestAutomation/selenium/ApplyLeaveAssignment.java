package TestAutomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ApplyLeaveAssignment {
	WebDriver driver;
	@BeforeTest
	@Parameters("BrowserName")
	public void setUp(String BrowserName) {
		driver=WebDriverFactory.getWebDriver(BrowserName);
	}
	@Test
	public void testApplyLeave() {
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
