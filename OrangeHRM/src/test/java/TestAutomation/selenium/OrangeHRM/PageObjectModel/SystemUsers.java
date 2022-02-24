package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

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
    
    
  //tr//td//span[contains(text(),'Amanda')]/ancestor::td/following-sibling::td[@class="edit_item tooltipped"]
  //label[@for="adminrole"]/following-sibling::div//div//button/i[@class='material-icons']
  //a[@role="option"]/span[contains(text(),'Global Admin')]
  //button[contains(text(),'Save')]
    
    public SystemUsers amandaEditClick()
    {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.amandaEdit=driver.findElement(By.xpath("//tr//td//span[contains(text(),'Amanda')]/ancestor::td/following-sibling::td[@class=\"edit_item tooltipped\"]"));
    	this.amandaEdit.click();
    	return this;
    }

    public SystemUsers adminroleDropDownClick()
    {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.savebtn=driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
    	this.savebtn.click();
    	return this;
    }
    
    public SystemUsers selectclick()
    {
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.selectbtn=driver.findElement(By.xpath("//*[@id=\"bs-select-6-0\"]"));
    	this.selectbtn.click();
    	return this;
    }
    
    public SystemUsers verifyGlobalButtonDisplay()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.adminGlobalDisplay=driver.findElement(By.xpath("//button[@data-id='adminrole']//div[contains(text(),'Global Admin')]"));
    	Boolean result=this.adminGlobalDisplay.isDisplayed();
    	assertTrue(result);
    	return this;
    }
    
    public SystemUsers   verifySelectDisplay()
    {
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
