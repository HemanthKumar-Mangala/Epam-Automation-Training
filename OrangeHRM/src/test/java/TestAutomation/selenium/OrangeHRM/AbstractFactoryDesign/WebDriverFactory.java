package TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory extends DriverFactory {
	 static WebDriver driver;
	
	public WebDriver getWebDriver(String BrowserName) {
		WebDriver driver;
	if(BrowserName.equalsIgnoreCase("Firefox") ){
		
		String driverPath = "C:\\browserdriver\\geckodriver\\geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver=new WebDriverProxy(new FirefoxDriver());
		
	}
	else if(BrowserName.equalsIgnoreCase("Chrome") ){
		String driverPath = "C:\\browserdriver\\chromedriver\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver=new WebDriverProxy(new ChromeDriver());
	
		
	}
	else {
		System.out.println("I am in null");
		 driver=null;
	}
	return driver;
	}

}
