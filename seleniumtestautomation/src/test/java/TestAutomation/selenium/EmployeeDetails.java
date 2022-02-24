package TestAutomation.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class EmployeeDetails {
	
	
	@Test
	public void testradioButton() {
		
		String driverPath = "C:\\browserdriver\\geckodriver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until( ExpectedConditions.presenceOfElementLocated( By.xpath("//span[contains(text(),'My Info')]"))).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='radiobutton-container']/li[1]/label")));
		WebElement radio2 = driver.findElement(By.xpath("//ul[@class='radiobutton-container']/li[2]/label"));
		radio2.click();
		driver.findElement(By.xpath("//label[@for=\"26Dairy-Free\"]")).click();
		driver.findElement(By.xpath("//label[@for=\"26Gluten-Free\"]")).click();


		
		
		
	}

}
