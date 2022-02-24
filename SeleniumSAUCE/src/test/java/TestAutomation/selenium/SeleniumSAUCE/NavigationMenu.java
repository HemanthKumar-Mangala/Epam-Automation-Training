package TestAutomation.selenium.SeleniumSAUCE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;


public class NavigationMenu {
	
	private  WebDriver driver;
	ApplyLeave applyleavepage;
	
	
	@FindBy(xpath = "(//span[@class='left-menu-title'][contains(.,'Leave')])[1]")
	private WebElement Leave;
	
	
	@FindBy(xpath = "//span[@class='left-menu-title'][contains(.,'Apply')]")
	private WebElement Apply;
	
	@FindBy(xpath = "//span[contains(.,'Leave List')]")
	private WebElement Leavelist;
	
	
	
	public NavigationMenu(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
		// PageFactory.initElements(driver, this);
	}

	public  NavigationMenu selectLeaveOptionFromLeftMenu()
	{
		this.Leave.click();
		return this;
	}
	
	public void selectApplyOptionFromLeftMenu()
	{
		this.Apply.click();
		
	}

	public void Leavelistclick()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.Leavelist.click();
		
	}

}
