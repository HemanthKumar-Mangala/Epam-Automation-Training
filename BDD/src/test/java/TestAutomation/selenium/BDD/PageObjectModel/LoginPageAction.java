package TestAutomation.selenium.BDD.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageAction {
	
	private final WebDriver driver;
	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement password;

	@FindBy(xpath="//button[contains(text(),'Login')]")
	private WebElement loginButton;



	@FindBy(className = "form-body")
	private WebElement form;



	public LoginPageAction(WebDriver driver) {
	this.driver = driver;
	AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
	PageFactory.initElements(factory, this);
	}
	public LoginPageAction enterUserName(String userName)
	{
	this.userName.sendKeys(userName);
	return this;
	}




	public LoginPageAction enterPassword(String password)
	{
	this.password.sendKeys(password);
	return this;
	}



	public LoginPageAction clickLoginButton() throws InterruptedException
	{
	//this.loginButton.click();
	//this.form.submit();
	Actions actions=new Actions(driver);
	actions.moveToElement(this.loginButton).click().perform();
	return this;
	}


	

}
