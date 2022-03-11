package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class MyAttendanceSheetPage {
	
	
	WebDriver driver;
	WebElement punchOutIcon;
	WebElement punchInIcon;	
	WebElement periodDropDown;
	WebElement particularDatedetails;
	List<WebElement> deleteDetailsList;
	WebElement deleteButton;
	WebElement deletePunchin;
	WebElement yesDeleteButton;
	WebElement totalDayTime;
	public  NgWebDriver ngWebDriver;
	WebElement EditParticulatPunchinOut;
	WebElement punchInEdit;
	WebElement punchOutEdit;
	WebElement editSave;
	WebElement editverify;
	public MyAttendanceSheetPage(WebDriver driver)
	{
		this.driver=driver;
		 ngWebDriver = new NgWebDriver((JavascriptExecutor) driver);
	}

	public MyAttendanceSheetPage punchoutClick()
	{
		this.punchOutIcon=driver.findElement(By.xpath("//span[(text()='timer_off')]"));
		this.punchOutIcon.click();
		return this;
	}
	
	public MyAttendanceSheetPage punchInClick()
	{
		this.punchInIcon=driver.findElement(By.xpath("//span[@class='punch-in-icon material-icons'][contains(text(),'timer')]"));
		this.punchInIcon.click();
		return this;
	}
	
	public PunchInOutPage navigateToPunchInOutPage(){
		
		try {
			punchInClick();
			
		}
		catch(Exception e)
		{
			punchoutClick();
		}
		return new PunchInOutPage(driver);
	}
	
	public MyAttendanceSheetPage periodDropDownClick()
	{
		this.periodDropDown=driver.findElement(By.xpath("//button[@data-id='attendanceSheet']"));
		this.periodDropDown.click();
		return this;
	}
	
	public MyAttendanceSheetPage clickOnParticularDateOnAttendanceSheet(String date)
	{
		this.particularDatedetails=driver.findElement(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]"));
		
		this.particularDatedetails.click();
		return this;
		
		//div[@class='timesheetDate'][(text()='09 Mar')]
		//div[@aria-label='Delete']
		//div[@class='timesheetDate'][(text()='07 Mar')]//parent::span//parent::div//parent::li//div[@aria-label='Delete']
		//div[@class='timesheetDate'][contains(.,'14 Mar')]//parent::span//parent::div//parent::li//span[contains(.,'Mon, 14 Mar 2022 08:00')]//parent::div//parent::div//div[@aria-label='Delete']
		//div[@class='timesheetDate'][contains(.,'14 Mar')]//parent::span//parent::div//parent::li//span[contains(.,'Mon, 14 Mar 2022 08:00')]//parent::div//parent::div//div[@aria-label='Edit']
	}
	public MyAttendanceSheetPage  deleteButtonClick(String date)
	{
		this.deleteButton=driver.findElement(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]//parent::span//parent::div//parent::li//div[@aria-label='Delete']"));
		deleteButton.click();
		
		return this;
	}
	 public MyAttendanceSheetPage yesButtonClick()
	 {
		 //"//button[@data-icon='delete_forever']"
		//this.yesDeleteButton=driver.findElement(By.xpath("//button[@type='button'][(text()='Yes, Delete')]"));
		yesDeleteButton=driver.findElement(By.xpath("//button[@data-icon='delete_forever']"));
			
	   yesDeleteButton.click();
	   //System.out.println("Error "+yesDeleteButton);
		 
		 return this;
	 }
	
	public MyAttendanceSheetPage deletePunchInPunchOutDetailsOfParticulardate(String date)
	{
		this.deleteDetailsList=driver.findElements(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]//parent::span//parent::div//parent::li//div[@aria-label='Delete']"));
		//this.yesDeleteButton=driver.findElement(By.xpath("//button[@type='button'][(text()='Yes, Delete')]"));
		int count=deleteDetailsList.size();
		for(int i=0;i<count;i++)
		{
	
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			deleteButtonClick(date);
//			driver.findElement(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]//parent::span//parent::div//parent::li//div[@aria-label='Delete']")).click();
//			delete.click();
//			try {
//				Thread.sleep(3000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated c
//				System.out.println("Time error");
//			}
			yesButtonClick();
			
			
		}
		
		//this.particularDatedetails=driver.findElement(By.xpath("//div[@class='timesheetDate'][contains(.,"+date+")]//parent::span//parent::div//parent::li//span[contains(.,"+date_time+")]//parent::div//parent::div//div[@aria-label='Edit']"));
		return this;
	}
	
	public NavigationMenu navigateToMenu()
	{
		return new NavigationMenu(driver);
	}
	public  MyAttendanceSheetPage editParticularPunchInOut(String date,String dateTime)
	{
		
		this.EditParticulatPunchinOut=driver.findElement(By.xpath("//div[@class='timesheetDate'][contains(.,\""+date+"\")]//parent::span//parent::div//parent::li//span[contains(.,\""+dateTime+"\")]//parent::div//parent::div//div[@aria-label='Edit']"));
		EditParticulatPunchinOut.click();
		
		
		return this;
	}
	
	public  MyAttendanceSheetPage editPunchIn(String time)
	{
		this.punchInEdit=driver.findElement(By.xpath("//input[@id='punchInTime']"));
		punchInEdit.click();
		punchInEdit.clear();
		this.punchInEdit.sendKeys(time);
		return this;
	}
	
	public  MyAttendanceSheetPage editPunchout(String time)
	{
		this.punchOutEdit=driver.findElement(By.xpath("//input[@id='punchOutTime']"));
		punchOutEdit.click();
		punchOutEdit.clear();
		this.punchOutEdit.sendKeys(time);
		return this;
	}
	
	public  MyAttendanceSheetPage editSaveClick()
	{
		this.editSave=driver.findElement(By.xpath("//i[@class='material-icons'][contains(.,'save')]"));
		editSave.click();
		return this;
	}
	public  MyAttendanceSheetPage deleteParticularPunchInOut(String date,String dateTime)
	{
		
		this.deletePunchin=driver.findElement(By.xpath("//div[@class='timesheetDate'][contains(.,\""+date+"\")]//parent::span//parent::div//parent::li//span[contains(.,\""+dateTime+"\")]//parent::div//parent::div//div[@aria-label='Delete']"));
		deletePunchin.click();
		yesButtonClick();
		
		return this;
	}
	
	public String getCalculateTotalDaytime(String date)
	{
		this.totalDayTime=driver.findElement(By.xpath("//div[@class='timesheetDate'][(text()=\""+date+"\")]//parent::span//parent::div//div[@class='dayTotal']"));
		String result=totalDayTime.getText();
		return result;
	}
	
	public String convertTime(String time)
	{
		int index=0;
		for(int i=0;i<time.length();i++)
		{
			if(time.charAt(i)=='h')
			{
				index=i;
			}
		}
		
		String h=time.substring(0, index);
		String m=time.substring(time.length()-3, time.length()-1);
		String resultTime=h+":"+m;
		return resultTime;
	}
	
	public String addTwoTimes(String time1,String time2)
	{
		String time1Hours=time1.split(":")[0];
		String time2Hours=time2.split(":")[0];
		
		String time1Minutes=time1.split(":")[1];
		String time2Minutes=time2.split(":")[1];
		
		int hh1=Integer.parseInt(time1Hours);
		int hh2=Integer.parseInt(time2Hours);
		
		int mm1=Integer.parseInt(time1Minutes);
		int mm2=Integer.parseInt(time2Minutes);
		
		int mm=mm1+mm2;
		int hh=hh1+hh2;
		
		
		if(mm>=60)
		{
			mm=mm-60;
			hh++;
		}
		
		String minutes=String.valueOf(mm);
		if(minutes.length()==1)
		{
			minutes="0"+minutes;
		}
		
		return hh+":"+minutes;
	}
}
