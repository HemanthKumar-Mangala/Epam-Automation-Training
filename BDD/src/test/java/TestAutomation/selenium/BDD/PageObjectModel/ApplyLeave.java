package TestAutomation.selenium.BDD.PageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class ApplyLeave {
	private final WebDriver driver;
	
	@FindBy(xpath = "//input[@value='-- Select --']")
	private WebElement TypeOfLeaveDropDown;
	
	@FindBy(xpath = "//li/span[contains(text(),'Sick Leave - US')]")
	private WebElement SickLeaveOption;
	
	@FindBy(xpath = "//input[contains(@id,'from')]")
	private WebElement FromDateInput;
	
	@FindBy(xpath = "//input[contains(@id,'to')]")
	private WebElement ToDateInput;
	
	@FindBy(xpath = "//textarea[contains(@id,'comment')]")
	private WebElement CommentInput;
	
	@FindBy(xpath = "//button[contains(@type,'submit')]")
	private WebElement  Apply;
	
	@FindBy(xpath = "//a[contains(.,'Close')]")
	private WebElement InsuficientLeavePopUpClose;
	
	@FindBy(xpath = "//a[contains(.,'Available balance for this period is not sufficient')]")
	private WebElement InsuficientLeavePopUpMessage;
	
	@FindBy(xpath = "//a[contains(.,'Check Leave Balance')]")
	private WebElement CheckBalanceOption;
	
	@FindBy(xpath = "//span[contains(.,'0.00')]")
	private WebElement ZeroLeave;
	
	@FindBy(xpath = "//a[contains(.,'Close')]")
	private WebElement checkLeavePopUpClose;
	
	
	@FindBy(xpath = "//span[@class='help-block'][contains(.,'From date should be before to date')]")
	private WebElement ErrorMessage;
	
	
	public ApplyLeave(WebDriver driver) {
        
		
		
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		// PageFactory.initElements(driver, this);
	}
	
	
	public ApplyLeave clickOnTypeOfLeaveDropDown() 
	{
		this.TypeOfLeaveDropDown.click();
       try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return this;
	}

	public ApplyLeave selectSickLeave()
	{
		this.SickLeaveOption.click();
		return this;
	}
	
	public ApplyLeave fromDate(String fromdate)
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.FromDateInput.click();
		this.FromDateInput.clear();
		this.FromDateInput.sendKeys(fromdate);
		return this;
	}
	
	public ApplyLeave toDate(String todate)
	
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.ToDateInput.click();
		this.ToDateInput.clear();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@id,'to')]")));
		this.ToDateInput.sendKeys(todate);
		return this;
	}
	
	
	public ApplyLeave clearTodate()
	{
		this.ToDateInput.click();
		this.ToDateInput.clear();
		
		return this;
	}
	public ApplyLeave enterComments(String comment)
	{

		
		this.CommentInput.click();
		this.CommentInput.sendKeys(comment);
		return this;
	}
	
	public ApplyLeave submitLeave()
	{
		
		this.Apply.click();
		this.Apply.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}
	
	public ApplyLeave verifyPopupmessageandClose()
	{
	String message=this.InsuficientLeavePopUpMessage.getText();
	assertEquals(message,"Available balance for this period is not sufficient");
	this.InsuficientLeavePopUpClose.click();
	return this;
		
	}
	
	public ApplyLeave clickOnCheckLeaveBalance()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.CheckBalanceOption.click();
		return this;
	}
    
	public ApplyLeave verifyZeroLeavesAndClose()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean result=this.ZeroLeave.isDisplayed();
		assertTrue(result);
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.checkLeavePopUpClose.click();
		
		
		
		return this;
		
	}
	
	public ApplyLeave assertErrorMessageAndColor()
	{
		
		
		this.FromDateInput.click();
		
		Boolean result=this.ErrorMessage.isDisplayed();
		assertTrue(result);
		
		String message=this.ErrorMessage.getText();
		assertEquals(message,"From date should be before to date");
		
		String Color=this.ErrorMessage.getCssValue("color");
		assertEquals(Color,"rgba(244, 67, 54, 1)");
		return this;
		
	}

		
	
}
