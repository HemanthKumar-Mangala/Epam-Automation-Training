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



public class LeaveList {
	private final WebDriver driver;
public LeaveList (WebDriver driver) {
        
		
		
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(factory, this);
		// PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//input[contains(@id,'from')]")
	private WebElement SelectFromDate;
	
	@FindBy(xpath = "//label[contains(.,'All')]")
	private WebElement ShowLeaveStatuscCheckBoxAll;
	
	@FindBy(xpath = "//*[@id=\"subunit_inputfileddiv\"]/div/input")
	private WebElement SubunitDropDown;
	
	@FindBy(xpath = "//span[contains(.,'Architecture Team')]")
	private WebElement Architecture;
	
	@FindBy(xpath = "//button[contains(.,'Search')]")
	private WebElement searchbutton;
	
	@FindBy(xpath = "//div[@class='toast-message'][contains(.,'No Records Found')]")
	private WebElement ToastMessage;
	
	public LeaveList enterFromDate(String fromdate)
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.SelectFromDate.click();
		this.SelectFromDate.clear();
		this.SelectFromDate.sendKeys(fromdate);
		return this;
		
	}
	
	public LeaveList selectSubUnit()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.SubunitDropDown.click();
		return this;
	}
	
	public LeaveList selectArchitecture()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Architecture.click();
		return this;
	}
	
	
	public LeaveList selectAll()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.ShowLeaveStatuscCheckBoxAll.click();
		return this;
	}
	
	public LeaveList searchClick()
	{
		
		this.searchbutton.click();
		return this;
	}
	
	public LeaveList verifyRecordsNotFound()
	{
		Boolean result=this.ToastMessage.isDisplayed();
		assertTrue(result);
		return this;
	}
	
	
	
	
	
	
}
