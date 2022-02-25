package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SystemUsers {
WebDriver driver;
	
public SystemUsers(WebDriver driver) {
        
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
	
	}

    WebElement amandaEdit;
    
    WebElement adminroleDropDown;
    
    WebElement adminGlobal;
    
    WebElement savebtn;
    
    WebElement selectbtn;
    
    WebElement adminGlobalDisplay;
    
    WebElement selectbtnDisplay;
    
    
  
    
    public SystemUsers amandaEditClick()
    {

    	this.amandaEdit=driver.findElement(By.xpath("//tr//td//span[contains(text(),'Amanda')]/ancestor::td/following-sibling::td[@class=\"edit_item tooltipped\"]"));
    	this.amandaEdit.click();
    	return this;
    }

    public SystemUsers adminroleDropDownClick()
    {

    	this.adminroleDropDown=driver.findElement(By.xpath("//label[@for=\"adminrole\"]/following-sibling::div//div//button/i[@class='material-icons']"));
    	this.adminroleDropDown.click();
    	return this;
    }
    
    
    
    
    public SystemUsers globalAdminClick()
    {
    	this.adminGlobal=driver.findElement(By.xpath("//a[@role=\"option\"]/span[contains(text(),'Global Admin')]"));
    	this.adminGlobal.click();
    	return this;
    }
    
    
    public SystemUsers savebtnClick()
    {

    	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		savebtn = (WebElement) js.executeScript("return document.evaluate( '//button[contains(text(),\"Save\")]' ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(50));
		wait.until(ExpectedConditions.elementToBeClickable(this.savebtn));
		
		
		while(true)
		{
			try
			{
				js.executeScript("arguments[0].click();",this.savebtn);
			}
			catch(Exception e)
			{
				return this;
			}
		}
    	
    }
    
    public SystemUsers selectclick()
    {

    	this.selectbtn=driver.findElement(By.xpath("//*[@id=\"bs-select-6-0\"]"));
    	this.selectbtn.click();
    	return this;
    }
    
    public SystemUsers verifyGlobalButtonDisplay()
    {

    	this.adminGlobalDisplay=driver.findElement(By.xpath("//button[@data-id='adminrole']//div[contains(text(),'Global Admin')]"));
    	Boolean result=this.adminGlobalDisplay.isDisplayed();
    	assertTrue(result);
    	return this;
    }
    
    public SystemUsers   verifySelectDisplay()
    {

    	this.selectbtnDisplay=driver.findElement(By.xpath("//button[@data-id='adminrole']//div[contains(text(),'-- Select --')]"));
    	Boolean result=this.selectbtnDisplay.isDisplayed();
    	assertTrue(result);
    	return this;
    	
    }
    
    public NavigationMenu navigateToMenu()
	{
		return new  NavigationMenu(driver);
	}
    
    
    
    
    


}
