package TestAutomation.selenium.SeleniumSAUCE;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Dashboard  {
	
	private final WebDriver driver;
	
	public Dashboard(WebDriver driver) {
        
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		// PageFactory.initElements(driver, this);
	}

}
