package TestAutomation.selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Explicitwait {
	@Test
	public void testExpilict() throws InterruptedException {
		String driverPath = "C:\\browserdriver\\geckodriver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		WebDriver driver = new FirefoxDriver();
		driver.get("https://prasoonr-trials73.orangehrmlive.com/");
		driver.manage().window().maximize();
		// driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("U@qBLVtm09");
		driver.findElement(By.xpath("/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")).click();
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		driver.findElement(By.id("menu_admin_UserManagement")).click();
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//td/ng-include[span='amanda']/parent::td/parent::tr//i['ohrm_edit']"))).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@id=\"modal-holder\"]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button")).click();
		driver.findElement(By.id("bs-select-3-2")).click();
		driver.findElement(By.id("modal-save-button")).click();
		
	}

}
