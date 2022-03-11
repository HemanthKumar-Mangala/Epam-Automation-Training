package TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;

abstract public  class DriverFactory {

	public abstract WebDriver getWebDriver(String BrowserName)throws MalformedURLException;
}
