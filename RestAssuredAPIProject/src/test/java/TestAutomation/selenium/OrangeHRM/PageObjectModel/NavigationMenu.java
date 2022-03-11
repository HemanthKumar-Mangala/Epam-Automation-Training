package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import java.time.Duration;
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
	
	WebElement attendanceButton;
	WebElement myAttendanceSheetButton;
	
    WebElement leftdropdown;
    
    WebElement userManagement;
	
	WebElement logoutbtn;
	
	WebElement usersbtn;
	
	WebElement punchInOut;
	
	@FindBy(xpath = "(//span[@class='left-menu-title'][contains(.,'Leave')])[1]")
	private WebElement Leave;
	

	
	@FindBy(xpath = "//span[@class='left-menu-title'][contains(.,'Apply')]")
	private WebElement Apply;
	
	@FindBy(xpath = "//span[contains(.,'Leave List')]")
	private WebElement Leavelist;
	
	private WebElement adminLeftMenu;
	
	public NavigationMenu(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		//driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
		
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
	
	public NavigationMenu AdminBtnClick() {
	
	this.adminLeftMenu=driver.findElement(By.xpath("//span[contains(text(),\"Admin\")]"));
		this.adminLeftMenu.click();
		return this;
	}
	
	public NavigationMenu userManagementBtnClick()
	{
		this.userManagement=driver.findElement(By.xpath("//span[contains(text(),\"User Management\")]"));
		this.userManagement.click();
		return this;
	}
	
	
	public SystemUsers usersBtnClick()
	{
		this.usersbtn=driver.findElement(By.xpath("//span[contains(text(),\"Users\")]"));
		this.usersbtn.click();
		return new SystemUsers(driver);
	}
	
	public NavigationMenu attendanceButtonClick()
	{
		attendanceButton=driver.findElement(By.xpath("//span[(text()='Attendance')]"));
		
		attendanceButton.click();
		
		return this;
	}
	
	public MyAttendanceSheetPage myAttendanceSheetButtonClick()
	{
		myAttendanceSheetButton=driver.findElement(By.xpath("//span[(text()='My Attendance Sheet')]"));
		myAttendanceSheetButton.click();
		return new MyAttendanceSheetPage(driver);
	}
	
	public PunchInOutPage punchInOutButtonClick()
	{
		this.punchInOut=driver.findElement(By.xpath("//span[@class='left-menu-title'][(text()='Punch In/Out')]"));
		punchInOut.click();
		return new PunchInOutPage(driver);
	}
	
	public NavigationMenu logout()
	{
	this.leftdropdown=driver.findElement(By.id("user-dropdown"));
	
	this.leftdropdown.click();
	
	this.logoutbtn=driver.findElement(By.id("logoutLink"));
	
	this.logoutbtn.click();
	
	return this;
	}
   
	

}
