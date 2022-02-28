package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;

import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.BDD.PageObjectModel.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class CucumberDefinitionImpl {
	public static WebDriver driver;

	public static String platformname;
	public static String orangeHRMURL;
	public LoginPage loginPage;
	
	
	
	 public static  void beforeScenario() throws MalformedURLException {
			String browserName = "chrome";
			platformname = "LocalWebDriver";
			orangeHRMURL = "https://prasoonr-trials73.orangehrmlive.com/" ;
	
			driver = WebDriverFactoryOfFactory.getWebDriverfactory(platformname).getWebDriver(browserName);
			driver.get(orangeHRMURL);
			driver.manage().window().maximize();

	}

	
	@Given("Open Browser")
	public void open_browser() {
		
		driver.get(orangeHRMURL);

	}

	@Given("Username is {string} and password is {string}")
	public void username_is_and_password_is(String userName, String password) {
		loginPage = new LoginPage(driver);
		loginPage = loginPage.enterUserName(userName).enterPassword(password);

	}

	@When("user click on login button")
	public void user_click_on_login_button() {

		//loginPage = new LoginPage(driver);

		loginPage.clickLoginButton();

	}

	@Then("user should navigate to Dashboard")
	public void user_should_navigate_to_dashboard() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("dashboard"));

	}

	@Then("User should navigate to Retry Page")
	public void user_should_navigate_to_retry_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("retry"));

	}

}
