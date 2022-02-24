package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard  {
	//@FindBy(id="user-dropdown")
	WebElement leftdropdown;
	
	WebElement logoutbtn;
	
	private final WebDriver driver;
	
	public Dashboard(WebDriver driver) {
        
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
	}
	
	public Dashboard logout()
	{
		this.leftdropdown=driver.findElement(By.id("user-dropdown"));
		
		this.leftdropdown.click();
		
		this.logoutbtn=driver.findElement(By.id("logoutLink"));
		
		this.logoutbtn.click();
		
		return this;
	}
	

}
