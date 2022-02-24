package TestAutomation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	 static WebDriver driver;
	
	public static WebDriver getWebDriver(String BrowserName) {
	if(BrowserName.equals("Firefox") ){
		
		String driverPath = "C:\\browserdriver\\geckodriver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver=new FirefoxDriver();
		
	}
	else if(BrowserName.equals("Chrome") ){
		String driverPath = "C:\\browserdriver\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new ChromeDriver();
		
	}
	else {
		System.out.println("I am in null");
		 driver=null;
	}
	return driver;
	}

}
