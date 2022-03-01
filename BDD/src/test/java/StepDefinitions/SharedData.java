package StepDefinitions;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.BDD.PageObjectModel.LoginPage;

public class SharedData {
	private static Map<String, Object> map= new HashMap<>() ;
	
    public void setAttribute(String attribute ,Object value)
    {
    	map.put(attribute, value);
    }
    
    public Object getAttribute(String attribute)
    {
    	return map.get(attribute);
    }
	

}
