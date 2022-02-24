package TestAutomation.selenium.OrangeHRM.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

public  class Listener implements ITestListener	{


	
	
	
	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("On test Failure");
		ITestContext context=result.getTestContext();
		WebDriver driver=(WebDriver) context.getAttribute("WebDriver");
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);



		try {
		FileUtils.copyFile(screenShotFile, new File("./loginPage2.jpg"));
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
	
	
	public  void takeScreenShot(WebDriver driver) throws Exception{

	     

	     TakesScreenshot scrShot =((TakesScreenshot)driver);

	     

	             File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	         

	             File DestFile=new File("./img.png");

	             FileUtils.copyFile(SrcFile, DestFile);
	 }

	
	

	
    }

	
	


