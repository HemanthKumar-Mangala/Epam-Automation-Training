package StepDefinitions;


import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;

//import javax.swing.text.html.HTMLDocument.Iterator;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;

import TestAutomation.selenium.BDD.PageObjectModel.CalculatorPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;

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
	
	@Given("Following button are clicked")
	public void following_button_are_clicked(io.cucumber.datatable.DataTable dataTable) {
	   List< List<String>>buttons=dataTable.asLists(String.class);
	   for(Iterator iterator=buttons.iterator();iterator.hasNext();)
	   {
		   List<String>list=(List<String>)iterator.next();
		   
		   for(Iterator iterator2=list.iterator();iterator2.hasNext();)
		   {
			   String button=(String)iterator2.next();
			   calculatorpage.clickButton(button);
			   
		   }
		   
	   }
	}
	
	

	@Given("Book name and author")
	public void book_name_and_password(List<Book> books) {
		
		System.out.println("Book names and Author names ");
		
		for(Book book:books)
		{
			System.out.println(book.getBook()+"-"+book.getAuthor());
		}
	}

	@Given("Names and id")
	public void names_and_id(List<Employee> employees) {
		
		System.out.println("Names and id's of Employees");
		for(Employee employee:employees)
		{
			System.out.println(employee.getName()+" "+employee.getId());
		}
	    
	}

}

