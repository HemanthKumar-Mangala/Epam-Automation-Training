package TestAutomation.selenium.BDD.feature;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import StepDefinitions.CucumberDefinitionImpl;

import StepDefinitions.SharedData;
import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/main/resources/Calculator.feature",
		glue="StepDefinitions"
		)
public class TestCalculator extends AbstractTestNGCucumberTests{

	
	
	@BeforeTest
	 public void setup(ITestContext context) throws MalformedURLException
	 
	 {
		SharedData shareddata = new SharedData();
		WebDriver driver=null;
		
		

		 String platformname;
		 String orangeHRMURL;
		
    
		
		 String browserName = context.getCurrentXmlTest().getParameter("BrowserName");
			platformname = context.getCurrentXmlTest().getParameter("OrangeHRmTestExecutionPlatfrom");
			orangeHRMURL = context.getCurrentXmlTest().getParameter("url");
		
			driver = WebDriverFactoryOfFactory.getWebDriverfactory(platformname).getWebDriver(browserName);
			shareddata.setAttribute("WebDriver", driver);
			driver.get("C:/Users/Hemanthkumar_Mangala/Downloads/calculator.html" );
			driver.manage().window().maximize();
			
	 }


}
