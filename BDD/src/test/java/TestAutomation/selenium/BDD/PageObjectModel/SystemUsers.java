package TestAutomation.selenium.BDD.PageObjectModel;

import static org.testng.Assert.assertTrue;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
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
    
    
	public SystemUsers savebtnClick() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		savebtn = (WebElement) js.executeScript(
				"return document.evaluate( '//button[contains(text(),\"Save\")]' ,document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null ).singleNodeValue;");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
		wait.until(ExpectedConditions.elementToBeClickable(this.savebtn));

		while (true) {

			try {

				js.executeScript("arguments[0].click();", this.savebtn);

			} catch (Exception e) {
				
				return this;
			}

			try {

				driver.findElement(By.xpath("//tr//td//span[contains(text(),'Amanda')]")).click();
				return this;

			} catch (Exception e) {

			}

		}

	}
	
	
	public SystemUsers savebtnClickUsingEnter()
	{
		savebtn =driver.findElement(By.xpath("//button[contains(text(),'Save')]"));
//		
//		savebtn.sendKeys(Keys.ENTER);
		
		Actions actions=new Actions(driver);
		actions.moveToElement(savebtn);
		actions.click(savebtn);
		Action action=actions.build();
		action.perform();
		return this;
		
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
    
    public void windowHandling()
    {
    	this.amandaEditClick();
    	 String MainWindow=driver.getWindowHandle();	
    	 Set<String> s1=driver.getWindowHandles();	
    	 Iterator<String> i1=s1.iterator();		
 		
         while(i1.hasNext())			
         {		
             String ChildWindow=i1.next();		
             		
            
                  
                     System.out.println("Hello");
                     driver.switchTo().window(ChildWindow);	                                                                                                           
                     driver.findElement(By.xpath("//button[contains(text(),\"Save\")]")).click();
                                  
 			// Closing the Child Window.
                         //driver.close();		
           	
         }		
         // Switching to Parent window i.e Main Window.
             driver.switchTo().window(MainWindow);
             this.amandaEditClick();

    }
    
    
    


}
