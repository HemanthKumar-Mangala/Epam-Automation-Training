package TestAutomation.selenium.PageObjectModel;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {
	
	private final WebDriver driver;
	
	
	@FindBy(id="txtUsername")
	private WebElement userName;
	
	@FindBy(id="txtPassword")
	private WebElement Password;
	
	@FindBy(xpath="/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")
	private WebElement LoginButton;
	
	
	private WebElement url;
	
	@FindBy(className="input-field")
	private List<WebElement> inputfields;
	
	@FindBys({@FindBy(className= "input-field"), @FindBy(tagName="div")})
	private List<WebElement> inputFieldBYS;
	
	@FindAll({@FindBy(className = "input-field"), @FindBy(tagName = "td")})
	private List<WebElement> inputFieldsBYALL;
	
	@FindBy(className = "form-body")
	private WebElement form;
	
	@FindBy(xpath="//label[@for='30_Yes']")
	private WebElement radiobutton;
	@FindBy(xpath="//label[@for='26Dairy-Free']")
	private WebElement firstcheckbox;
	@FindBy(xpath="//label[@for='26Gluten-Free']")
	private WebElement secondcheckbox;
	@FindBy(xpath="//button[@ng-click='buttonClick($event,form)'] ")
	private WebElement saveemployeeDetails;
	
	
	public LoginPage(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		
		PageFactory.initElements(factory, this);
		
		}
	
	public LoginPage enterUserName(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}
	
	public LoginPage enterPassword(String password) {
		this.Password.sendKeys(password);
		return this;
	}
	
	public LoginPage clickLoginButton() {
		this.LoginButton.click();
		//this.form.submit();
		return this;
	}
	
	public void clickRadioButton() throws InterruptedException {
		Thread.sleep(1000);
		this.radiobutton.click();
		//return this;
	}
	public void clickCheckBoxes() throws InterruptedException {
		Thread.sleep(2000);
		this.firstcheckbox.click();
		this.secondcheckbox.click();
		//return this;
	}
	
	public void quitemployee() {
	     driver.close();
	}
	
		
	public LoginPage printElementInputfields() {
		System.out.println("Number of Element: "+inputfields.size());
		for(Iterator iterator=inputfields.iterator();iterator.hasNext();) {
			WebElement webElement=(WebElement)iterator.next();
			System.out.println("Element is "+webElement.getTagName());
		}
		System.out.println("Number of Element: "+inputFieldBYS.size());
		for(Iterator iterator=inputFieldBYS.iterator();iterator.hasNext();) {
			WebElement webElement=(WebElement)iterator.next();
			System.out.println("Element is "+webElement.getTagName());
		}
		
		System.out.println("Number of element : " + inputFieldsBYALL.size());

		for (Iterator iterator = inputFieldsBYALL.iterator(); iterator.hasNext();) {
		WebElement webElement = (WebElement) iterator.next();
		System.out.println("Element : " + webElement.getTagName());
		}
		
		
		
		return this;
	}

	public void navigatetoUrl() throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		driver.navigate().to("https://prasoonr-trials73.orangehrmlive.com/client/#/pim/employees/13/personal_details");
		//return this;
		
	}
	
	
	

}
