package TestAutomation.selenium.BDD.feature;


import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import StepDefinitions.CucumberDefinitionImpl;

import StepDefinitions.SharedData;
import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.FeatureWrapper;
import io.cucumber.testng.PickleWrapper;
import io.cucumber.testng.TestNGCucumberRunner;

@CucumberOptions(
		features ="src/main/resources/Calculator.feature",
		glue="StepDefinitions",
		tags="@DataTable"
		)
public class TestCalculatorUsingRunner {

	TestNGCucumberRunner runner;
	
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
			 runner=new TestNGCucumberRunner(this.getClass());
			
	 }
	@Test(dataProvider="scenariors")
	public void testCucumberScenario(PickleWrapper pickle,FeatureWrapper feature)
	{
		runner.runScenario(pickle.getPickle());
	}
	@DataProvider
	public Object[][] scenariors()
	{
		return runner.provideScenarios();
	}
	
   @AfterClass
   public void finishRunner()
   {
	   runner.finish();
   }

}

