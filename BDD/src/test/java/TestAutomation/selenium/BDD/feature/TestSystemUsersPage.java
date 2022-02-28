package TestAutomation.selenium.BDD.feature;

import java.net.MalformedURLException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import StepDefinitions.CucumberDefinitionImpl;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features ="src/main/resources/SystemUserPage.feature",
		glue="StepDefinitions"
	
		
		)
public class TestSystemUsersPage extends AbstractTestNGCucumberTests{

	@BeforeClass
	public void setup() throws MalformedURLException
	{
		CucumberDefinitionImpl.beforeScenario();
	}

}
