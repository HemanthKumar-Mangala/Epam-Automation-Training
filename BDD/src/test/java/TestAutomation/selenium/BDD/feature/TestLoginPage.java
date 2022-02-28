package TestAutomation.selenium.BDD.feature;

import java.net.MalformedURLException;

import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import StepDefinitions.CucumberDefinitionImpl;
import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import io.cucumber.java.Before;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features ="src/main/resources/SystemUserPage.feature",
		glue="StepDefinitions"
	
		
		)
public class TestLoginPage extends AbstractTestNGCucumberTests {

	@BeforeClass
	public void setup() throws MalformedURLException
	{
		CucumberDefinitionImpl.beforeScenario();
	}
}


