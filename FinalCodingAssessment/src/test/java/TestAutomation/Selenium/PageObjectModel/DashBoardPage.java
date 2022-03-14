package TestAutomation.Selenium.PageObjectModel;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class DashBoardPage {

	WebDriver driver;
	@FindBy(className="uui-toggle-box")
	WebElement hamburgerMenu;
	
	public DashBoardPage(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
		}
	public NgWebDriver getNGDriver()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return(new NgWebDriver(js));
	}
	
	public DashBoardPage verifyUserIsInDashBoardPage()
	{
		String result=driver.getCurrentUrl();
		assertTrue(result.contains("programs"));
		
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
  
    
    
}
