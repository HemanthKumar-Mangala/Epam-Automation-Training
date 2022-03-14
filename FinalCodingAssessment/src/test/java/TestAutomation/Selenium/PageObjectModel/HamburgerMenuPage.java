package TestAutomation.Selenium.PageObjectModel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class HamburgerMenuPage {

	WebDriver driver;
	
	@FindBy(xpath="//div[@id='mCSB_2_container']//span[contains(.,'Master Data management')]")
	WebElement masterDataManagementButton;
	
	@FindBy(xpath="//div[@id='mCSB_2_container']//span[contains(.,'Speakers')]")
	WebElement speakersButton;
	
	
	
	public HamburgerMenuPage(WebDriver driver)
	{
		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		
	}
	public NgWebDriver getNGDriver()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		return(new NgWebDriver(js));
	}
	
	public HamburgerMenuPage masterDataManagementButtonClick() throws InterruptedException
	{Thread.sleep(7000);
		this.masterDataManagementButton.click();
		
		return this;
	}
	
	
	public SpeakersPage SpeakersButtonClick() throws InterruptedException
	{
		
		Thread.sleep(7000);
		this.speakersButton.click();
		return new SpeakersPage(driver);
	}
	
	
	
}
