package TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign;



import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebSaucedDriverFactory extends DriverFactory{
	private static final String hubURL="http://localhost:4444/wd/hub";
	public RemoteWebDriver getWebDriver(String BrowserName) throws MalformedURLException {
		RemoteWebDriver driver= null;
		// setting up SAUCE properties/credenials
		MutableCapabilities sauceOptions = new MutableCapabilities();
		sauceOptions.setCapability("username", "oauth-hemanthraina1999-565e3");
		//sauceOptions.setCapability("password", "oauth-prasoon.rana-5c24c"); // in case of password as credentials
		sauceOptions.setCapability("accessKey", "0ffd0c28-86bb-4d20-92c1-14eeb546d9dc");
		sauceOptions.setCapability("browserVersion", "latest");
		ChromeOptions options = new ChromeOptions();
		options.setCapability("sauce:options", sauceOptions);
		URL url = new URL("https://oauth-hemanthraina1999-565e3:0ffd0c28-86bb-4d20-92c1-14eeb546d9dc@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	//	driver = new RemoteWebDriver(url, options);
	if(BrowserName.equalsIgnoreCase("Chrome")) {
		ChromeOptions options1 = new ChromeOptions();
		options1.setCapability("sauce:options", sauceOptions);
		driver=new WebDriverProxy(new RemoteWebDriver(url,options1));
	}
	else if(BrowserName.equalsIgnoreCase("Firefox")) {
		FirefoxOptions options1 = new FirefoxOptions();
		options1.setCapability("sauce:options", sauceOptions);
		driver=new WebDriverProxy(new RemoteWebDriver(url,options1));
	}
	else {
		driver=null;
	}
	return driver;
	}
}
