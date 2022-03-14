package TestAutomation.Selenium.PageObjectModel;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class SignUpPage {

	WebDriver driver;
	
	@FindBy(id="exampleInputEmail1")
	WebElement emailAddressInputField;
	
	@FindBy(id="exampleInputPassword1")
	WebElement passwordInputField;
	
	@FindBy(id="form_submit")
	WebElement signUpButton;
	
	@FindBy(xpath="//a[text()='Cancel']")
	WebElement cancelButton;
	
	public SignUpPage(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	
		
		}
	
	public NgWebDriver getNGDriver()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return(new NgWebDriver(js));
	}
	
	public SignUpPage enterEmailToSignUp(String email)
	{
		getNGDriver().waitForAngularRequestsToFinish();
		this.emailAddressInputField.sendKeys(email);
		return this;
	}
	
	public SignUpPage verifyUserIsInSignUpPage()
	{
		String result=driver.getCurrentUrl();
		assertTrue(result.contains("register"));
		return this;
	}
	
	public SignUpPage enterPasswordToSignUp(String password)
	{
		this.passwordInputField.sendKeys(password);
		return this;
	}
	
	public SignInPage clickSignUpButton()
	{
		this.signUpButton.click();
		getNGDriver().waitForAngularRequestsToFinish();
		return new SignInPage(driver);
	}
	
	
	public SignInPage clickCancelButton()
	{
		this.cancelButton.click();
		return new SignInPage(driver);
	}
	
}
