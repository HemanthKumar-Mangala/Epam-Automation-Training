package StepDefinitions;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import TestAutomation.selenium.BDD.PageObjectModel.CalculatorPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CalculatorImpl {
	private static WebDriver driver;
	private static String platformname;
	private String browserName;
	private String calculatorURl;
	private CalculatorPage calculatorpage;

	public CalculatorImpl()
	{
		SharedData shareddata=new SharedData();
	    driver=(WebDriver) shareddata.getAttribute("WebDriver");	
	    calculatorpage=new CalculatorPage(driver);
	}

	@Given("Calculator page is open")
	public void calculator_page_is_open() {
   driver.get("C:/Users/Hemanthkumar_Mangala/Downloads/calculator.html");
	}

	@Then("Calcaultor has number {string}")
	public void calcaultor_has_number(String buttonLabel) {
		calculatorpage.buttonWithLabelExists(buttonLabel);
	}

	@Then("Calcaultor has operator {string}")
	public void calcaultor_has_operator(String buttonLabel) {
		calculatorpage.buttonWithLabelExists(buttonLabel);
	}

	@Then("Calcaultor has display field")
	public void calcaultor_has_display_field() {
		calculatorpage.displayFieldExists();
	}

	@Then("Calcaultor {string} has color {string}")
	public void calcaultor_has_color(String buttonLabel, String color) {
		calculatorpage.buttonColorMatches(buttonLabel, color);
	}

	@Given("number button is clicked {string}")
	public void number_button_is_clicked(String buttonLabel) {
		calculatorpage.clickButton(buttonLabel);
	}

	@Then("display screen should have number {string}")
	public void display_screen_should_have_number(String buttonLabel) {
		String result=calculatorpage.displaySreenText();
		assertEquals(result,buttonLabel);
	}

	@Given("Operator button is clicked {string}")
	public void operator_button_is_clicked(String buttonLabel) {
		calculatorpage.clickButton(buttonLabel);
	}

	@Given("Number button is click {string}")
	public void number_button_is_click(String buttonLabel) {
		calculatorpage.clickButton(buttonLabel);
	}
}

