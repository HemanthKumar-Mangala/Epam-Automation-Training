package TestAutomation.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TestWebDriver {
	@Test
	public void LoadWebDriver() {
		String driverPath="C:\\browserdriver\\geckodriver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver",driverPath);
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.orangehrm.com/");
		driver.findElement(By.id("myText")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("linkadd")).click();
		driver.findElement(By.id("Form_submitForm_Name")).sendKeys("Harry");
		driver.findElement(By.id("Form_submitForm_Contact")).sendKeys("9876543210");
		Select countries=new Select(driver.findElement(By.id("Form_submitForm_Country")));
        countries.selectByVisibleText("India");
        Select state=new Select(driver.findElement(By.id("Form_submitForm_State")));
        state.selectByVisibleText("Telangana");
        //driver.findElement(By.id("Form_submitForm_action_request")).click();
		
		String driverPathChrome="C:\\browserdriver\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPathChrome);
		WebDriver chromeDriver=new ChromeDriver();
		chromeDriver.get("https://www.orangehrm.com/");
//driver.get("https://www.orangehrm.com/");

	}
	
	 

	
	
}
