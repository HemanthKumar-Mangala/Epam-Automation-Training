package TestAutomation.selenium;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.*;

import static org.testng.Assert.assertTrue;

import java.awt.Desktop.Action;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

//@Test
public class TestWinowHandling {
	public void LoadWebDriver() {
		String driverPath = "C:\\browserdriver\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/delete_customer.php");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[2]/td[2]/input")).sendKeys("3434");
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		driver.switchTo().alert().dismiss();
		driver.findElement(By.xpath("/html/body/form/table/tbody/tr[3]/td[2]/input[1]")).click();
		driver.switchTo().alert().accept();

	}

	// @Test
	 
		public void LoadWebDriver1() {
			String driverPath = "C:\\browserdriver\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/popup.php");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("/html/body/p/a")).click();
			String MainWindow = driver.getWindowHandle();
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();
			while (i1.hasNext()) {
				String childWindow = i1.next();
				if (!MainWindow.equalsIgnoreCase(childWindow)) {
					driver.switchTo().window(childWindow);
					driver.findElement(By.xpath("//input[@name=\"emailid\"]")).sendKeys("ADCDE");
				}
			}

		}

	

	// @Test
	
		public void Load() throws InterruptedException {
			String driverPath = "C:\\browserdriver\\chromedriver\\chromedriver.exe";
			System.setProperty("webdriver.chrome.driver", driverPath);
			WebDriver driver = new ChromeDriver();
			driver.get("https://demo.guru99.com/test/drag_drop.html");
			driver.manage().window().maximize();
			// Thread.sleep(30000);
			Actions action = new Actions(driver);
			action.dragAndDrop(driver.findElement(By.xpath("//*[@id=\"credit2\"]")),
					driver.findElement(By.xpath("//*[@id=\"bank\"]/li"))).perform();
			
		

		}

		
		@Test
			public void Testjs() {
				String driverPath = "C:\\browserdriver\\chromedriver\\chromedriver.exe";
				System.setProperty("webdriver.chrome.driver", driverPath);
				WebDriver driver = new ChromeDriver();
				driver.get("https://prasoonr-trials73.orangehrmlive.com/");
				
				String usernameScript = "document.getElementById('txtUsername').value=\"Admin\"";
				String PasswordScript = "document.getElementById('txtPassword').value='U@qBLVtm09'";
				String SubmitScript = "document.querySelector('button[type=submit]').click()";

				driver.manage().window().maximize();
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript(usernameScript);
				js.executeScript(PasswordScript);
				js.executeScript(SubmitScript);
				
				// String leaveoption="document.querySelector('span[value=Leave]ij9o').click()";

				
			
		}
	

}
