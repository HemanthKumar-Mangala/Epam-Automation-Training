package TestAutomation.Selenium.Factories;


	import java.io.File;
import java.net.MalformedURLException;
	import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

//import javax.print.DocFlavor.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.remote.DesiredCapabilities;
	import org.openqa.selenium.remote.RemoteWebDriver;



	public class WebGridFactory extends DriverFactory {

	private static final String hubURL = "http://192.168.29.144:4444/wd/hub";

	public RemoteWebDriver getWebDriver(String BrowserName)throws MalformedURLException {
	RemoteWebDriver driver = null;
	DesiredCapabilities capabilities = new DesiredCapabilities();
	capabilities.setPlatform(Platform.WIN10);

	if(BrowserName.equalsIgnoreCase("CHROME")) {

	capabilities.setBrowserName("chrome");

	driver = new RemoteWebDriver((new URL(hubURL)),capabilities);
	

	}else if (BrowserName.equalsIgnoreCase("FIREFOX")) {


	capabilities.setBrowserName("firefox");

	driver = new RemoteWebDriver((new URL(hubURL)),capabilities);
	}else {
	System.out.println("Browser not found");
	driver=null;
	}
	return driver;
	}
	
	

	

	}


	

