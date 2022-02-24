package TestAutomation.selenium;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class OrangeHRMlive {
	@Test
	public void loadWebDriver() throws InterruptedException {

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
		//Thread.sleep(35000);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[9]/i"))
				.click();
		// AdminRole=driver.findElement(By.className("filter-option-inner-inner"));
		Thread.sleep(3000);
		//WebDriverWait wait=new WebDriverWait(driver,30);
		driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button/i[2]"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/div/div/ul/li[3]/a"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[9]/i"))
				.click();
		//WebDriverWait wait2=new WebDriverWait(driver,30);
		Thread.sleep(30000);
		boolean verify_GlobalAdmin = driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/button/div/div/div"))
				.isDisplayed();
		assertEquals(verify_GlobalAdmin, true);
		driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[2]/div/button/i[2]"))
				.click();
		driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/div/div/ul/li[1]/a/span"))
				.click();
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/button[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath(
				"/html/body/div[1]/div/div/div[2]/section/div[2]/ui-view/div/div/crud-panel/div/div/list/table/tbody/tr[6]/td[9]/i"))
				.click();
		Thread.sleep(20000);
		boolean verify1_select= driver.findElement(By.xpath(
				"/html/body/div[3]/div/div/div/div[2]/form/oxd-decorator[3]/div/div[1]/div/div[1]/button/div/div/div"))
				.isDisplayed();
		assertEquals(verify1_select, true);
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]/button[2]")).click();
		Thread.sleep(10000);
		driver.findElement(By.id("user-dropdown")).click();
		driver.findElement(By.id("logoutLink")).click();

	}

}
