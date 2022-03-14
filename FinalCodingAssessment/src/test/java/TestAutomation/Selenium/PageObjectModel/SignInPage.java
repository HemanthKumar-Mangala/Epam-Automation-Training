package TestAutomation.Selenium.PageObjectModel;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class SignInPage {

	WebDriver driver;
	
	@FindBy(id="exampleInputEmail1")
	WebElement emailAddressInputField;
	
	@FindBy(id="exampleInputPassword1")
	WebElement passwordInputField;
	
	@FindBy(id="form_submit")
	WebElement submitButton;
	
	@FindBy(xpath="//a[text()='Sign up']")
	WebElement signUpPageNavigationButton;
	
	@FindBy(xpath="//a[text()='Forgot Password?']")
	WebElement forgotPasswordButton;
	
	
	public SignInPage(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
		}
	
	public SignInPage verifyUserIsInSignInPage()
	{
		String result=driver.getCurrentUrl();
		assertTrue(result.contains("login"));
		return this;
		
	}
	
	
	
	public NgWebDriver getNGDriver()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return(new NgWebDriver(js));
	}
	
	public SignInPage enterEmailToSignIn(String email)
	{
		this.emailAddressInputField.sendKeys(email);
		return this;
	}
	
	public SignInPage enterPasswordToSignIn(String password)
	{
		this.passwordInputField.sendKeys(password);
		return this;
	}
	
	public DashBoardPage clickSubmitButton()
	{
		this.submitButton.click();
		//getNGDriver().waitForAngularRequestsToFinish();
		return new DashBoardPage(driver);
	}
	
	public SignUpPage clickSignUpNavigationButton()
	{
		this.signUpPageNavigationButton.click();
		return new SignUpPage(driver);
	}
	
	
}
