package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PunchInOutPage {
	WebElement dateElement;
	WebElement timeElement;
	WebElement inSubmitButton;
	WebElement outSubmitButton;
	WebElement overlappingRecords;
	WebElement punchInLaterPunchOut;
	WebElement savedSuccessfully;
	
	WebDriver driver;
	
	public PunchInOutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public PunchInOutPage enterDate(String date)
	{
		this.dateElement=driver.findElement(By.xpath("//input[@name='dateTextInput']"));
		this.dateElement.click();
		this.dateElement.clear();
		this.dateElement.sendKeys(date);
		return this;
	}
	
	public PunchInOutPage entertime(String time)
	{
		this.timeElement=driver.findElement(By.xpath("//input[@placeholder='HH:MM']"));
		this.timeElement.click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.timeElement=driver.findElement(By.xpath("//input[@placeholder='HH:MM']"));
		
		this.timeElement.click();
		this.timeElement.clear();
		this.timeElement.sendKeys(time);
		return this;
	}
	
	public PunchInOutPage punchInSubmit()
	{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.inSubmitButton= driver.findElement(By.xpath("//button[@type='button'][(text()='In')]"));
		this.inSubmitButton.click();
		return this;
	}
	
	public PunchInOutPage punchOutSubmit()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.outSubmitButton=driver.findElement(By.xpath("//button[@type='button'][(text()='Out')]"));
		this.outSubmitButton.click();
		return this;
	}
	
	public NavigationMenu navigateToMenu()
	{
		return new NavigationMenu(driver);
	}
	public PunchInOutPage verifyOverlappingRecords()
	{
		this.overlappingRecords=driver.findElement(By.xpath("//span[(text()='Overlapping records found')]"));
		String result=overlappingRecords.getText();
		assertEquals(result,"Overlapping records found");
		return this;
	}
	
	public PunchInOutPage verifyPunchInLaterPunchOut()
	{
		this.punchInLaterPunchOut=driver.findElement(By.xpath("//span[(text()='Punch out time should be later than punch in time')]"));
		String result=punchInLaterPunchOut.getText();
		assertEquals(result,"Punch out time should be later than punch in time");
		return this;
	}
	
	public PunchInOutPage verifySavedSuccefully()
	{
		this.savedSuccessfully=driver.findElement(By.xpath("//div[@class='toast-message'][contains(.,'Successfully Saved')]"));
		return this;
	}
	
}
