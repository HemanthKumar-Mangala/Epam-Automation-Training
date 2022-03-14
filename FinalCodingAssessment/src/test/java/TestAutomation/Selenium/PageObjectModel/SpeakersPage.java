package TestAutomation.Selenium.PageObjectModel;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class SpeakersPage {

	WebDriver driver;
	
	@FindBy(xpath="//button[contains(.,'Add Speaker')]")
	WebElement addSpeaker;
	
	@FindBy(xpath = "//input[@name='speakerName']")
	WebElement speakerNameInputField;
	
	@FindBy(xpath = "//input[@name='speakerEmail']")
	WebElement speakerEmailInputField;
	
	@FindBy(xpath = "//input[@name='speakerProfile']")
	WebElement speakerProfileInputField;
	
	@FindBy(xpath = "//button[@type='button'][contains(.,'Cancel')]")
	WebElement cancelButton;
	
	@FindBy(xpath = "//button[text()='Save']")
	WebElement saveButton;
	
	@FindBy(className="uui-toggle-box")
	WebElement hamburgerMenu;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement searchInputField;
	
	@FindBy(xpath="//button[text()='Disable']")
	WebElement disableButton;
	
	@FindBy(xpath="//p[text()=' Check Email format. ']")
	WebElement emailFormat;
	
	@FindBy(xpath="//p[text()=' *Speaker Name is required. ']")
	WebElement nameRequiredError;
	
	@FindBy(xpath="//p[text()=' *Speaker Name is required. ']")
	WebElement emailRequiredError;
	
	@FindBy(xpath="//p[text()=' *Speaker Name is required. ']")
	WebElement profileRequiredError;
	
	WebElement deleteButton;
	
	WebElement speakerStatus;
	
	
	
	public SpeakersPage(WebDriver driver)
	{
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
	}public NgWebDriver getNGDriver()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return(new NgWebDriver(js));
	}
	
	
	public SpeakersPage addSpeakerButtonClick() throws InterruptedException
	{
		this.addSpeaker.click();
		Thread.sleep(7000);
		return this;
	}
	
	public SpeakersPage verifyUserIsInSpeakersPage()
	{
		String result=driver.getCurrentUrl();
		assertTrue(result.contains("speakers"));
		return this;
		
	}
	public SpeakersPage enterSpeakerNameInputField(String name)
	{
		this.speakerNameInputField.sendKeys(name);
		return this;
	}
	
	public SpeakersPage enterSpeakerEmailInputField(String email)
	{
		this.speakerEmailInputField.sendKeys(email);
		return this;
	}
	
	public SpeakersPage enterspeakerProfileInputField(String profile)
	{
		this.speakerProfileInputField.sendKeys(profile);
		return this;
	}
	
	public SpeakersPage saveButtonClick()
	{
		this.saveButton.click();
		return this;
	}
	
	public SpeakersPage cancelButtonClick()
	{
		this.cancelButton.click();
		return this;
	}
	
	public HamburgerMenuPage navigateToHambergerMenu()
	 {
	   return new HamburgerMenuPage(driver);
	 }
	    
	public HamburgerMenuPage clickHambergerMenu()
	 {
	    this.hamburgerMenu.click();
	    return new HamburgerMenuPage(driver);
	 }
	
	public SpeakersPage deleteParticularSpeaker(String email) throws InterruptedException
	{
		Thread.sleep(5000);
		this.deleteButton=driver.findElement(By.xpath("//td[text()='"+email+"']//parent::tr//button[@data-original-title='Delete Speaker']"));
		this.deleteButton.click();
		return this;
		
	}
	
	public SpeakersPage verifySpeakerIsDisabled(String email) throws InterruptedException
	{
		Thread.sleep(5000);
		this.speakerStatus=driver.findElement(By.xpath("\"//td[text()=\""+email+"\"]//parent::tr//td[text()='Disabled']"));
		boolean result=this.speakerStatus.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	public SpeakersPage search(String email) throws InterruptedException
	{
		Thread.sleep(5000);
		this.searchInputField.sendKeys(email);
		return this;
	}
	
	public SpeakersPage disableButtonClick() throws InterruptedException
	{
		Thread.sleep(5000);
		this.disableButton.click();
		return this;
	}
	
	public SpeakersPage verifySaveButtonisDissabled()
	{
		boolean result=this.saveButton.isEnabled();
		assertFalse(result);
		return this;
		
	}
	public SpeakersPage verifyEmailErrorIsDisplayed()
	{
		boolean result=this.emailFormat.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	public SpeakersPage verifynameRequiredError()
	{
		
		boolean result=this.nameRequiredError.isDisplayed();
		assertTrue(result);
		return this;
		
	}
	
	public SpeakersPage verifyEmailRequiredError()
	{
		
		boolean result=this.emailRequiredError.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	public SpeakersPage verifyprofileRequiredError()
	{
		
		boolean result=this.profileRequiredError.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	
	public SpeakersPage verifySpeakerIsAdded(String email) throws InterruptedException
	{
		Thread.sleep(5000);
		WebElement user=driver.findElement(By.xpath("//td[text()='"+email+"']"));
		boolean result=user.isDisplayed();
		assertTrue(result);
		return this;
	}
}
