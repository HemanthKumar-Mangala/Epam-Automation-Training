package TestAutomation.Selenium.TestClass;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;

import TestAutomation.Selenium.Factories.WebDriverFactoryOfFactory;
import TestAutomation.Selenium.PageObjectModel.DashBoardPage;
import TestAutomation.Selenium.PageObjectModel.HamburgerMenuPage;
import TestAutomation.Selenium.PageObjectModel.SignInPage;
import TestAutomation.Selenium.PageObjectModel.SpeakersPage;

//import TestAutomation.selenium.OrangeHRM.AbstractFactoryDesign.WebDriverFactoryOfFactory;
@Listeners(TestAutomation.Selenium.Listeners.IReporterClass.class)
public class TestAddSpeaker {
    
	WebDriver driver;
	String browserName;
	String platformName;
	String url;
	String accountEmail;
	String accountPassword;
	String spearkerName;
	String speakerEmail;
	String speakerProfile;
	SignInPage signIn;
	DashBoardPage dashboard;
	HamburgerMenuPage menu;
	SpeakersPage speaker;
	
	
	@BeforeTest
	public void setup(ITestContext context) throws MalformedURLException
	{
		browserName = context.getCurrentXmlTest().getParameter("BrowserName");
		platformName = context.getCurrentXmlTest().getParameter("OrangeHRmTestExecutionPlatfrom");
		url = context.getCurrentXmlTest().getParameter("url");
		accountEmail = context.getCurrentXmlTest().getParameter("accountEmail");
		accountPassword = context.getCurrentXmlTest().getParameter("accountPassword");
		spearkerName = context.getCurrentXmlTest().getParameter("spearkerName");
		speakerEmail = context.getCurrentXmlTest().getParameter("speakerEmail");
		speakerProfile = context.getCurrentXmlTest().getParameter("speakerProfile");
		
		driver = WebDriverFactoryOfFactory.getWebDriverfactory(platformName).getWebDriver(browserName);
		driver.get(url);
		driver.manage().window().maximize();

	}
	
	@Test(priority=1)
	public void verifyUserIsInSignInPageOrNot()
	{
		signIn= new SignInPage(driver);
		signIn.verifyUserIsInSignInPage();
	}
	
	@Test(priority=2)
	public void testSignUpPage()
	{
		signIn.clickSignUpNavigationButton()
		      .verifyUserIsInSignUpPage()
		      .enterEmailToSignUp(accountEmail)
			  .enterPasswordToSignUp(accountPassword)
			  .clickSignUpButton();
	}
	
	@Test(priority=3)
	public void testSignInPage()
	{
		dashboard=signIn.verifyUserIsInSignInPage()
		.enterEmailToSignIn(accountEmail)
		.enterPasswordToSignIn(accountPassword)
		.clickSubmitButton();
		
	}
	
	@Test(priority=4)
	public void testDashBoardPage() throws InterruptedException
	{
		speaker=dashboard.verifyUserIsInDashBoardPage()
		         .clickHambergerMenu()
		         .masterDataManagementButtonClick()
		         .SpeakersButtonClick();
	}
	
	@Test(priority=5)
	public void testAddSpeakers() throws InterruptedException
	{
		speaker.verifyUserIsInSpeakersPage()
		       .addSpeakerButtonClick()
		       .enterSpeakerNameInputField(spearkerName)
		       .enterSpeakerEmailInputField(speakerEmail)
		       .enterspeakerProfileInputField(speakerProfile)
		       .saveButtonClick();
	}
	
	@Test(priority=6)
	public void testverifySpeakerAddedOrNot() throws InterruptedException
	{
		speaker.search(speakerEmail).verifySpeakerIsAdded(speakerEmail);
	}
	
    @Test(priority=7)
    public void testNameRequiredFieldError() throws InterruptedException
    {
    	speaker.addSpeakerButtonClick()
    	       .verifynameRequiredError();
    }
    
    @Test(priority=8)
    public void testEmailRequiredFieldError()
    {
    	speaker.verifyEmailRequiredError();
    }
    
    
    @Test(priority=9)
    public void testEmailformatError()
    {
    	speaker.enterSpeakerEmailInputField("Adcdef")
    	       .verifyEmailErrorIsDisplayed();
    }
    
    @Test(priority=10)
    public void testProfileRequiredField()
    {
    	speaker.verifyprofileRequiredError();
    	
    }
    
    @Test(priority=11)
    public void testSaveButtonDisabled()
    {
    	speaker.verifySaveButtonisDissabled()
    	.cancelButtonClick();
    }
    
    
    @Test(priority=12)
    public void testDisableUser() throws InterruptedException
    {
    	speaker.deleteParticularSpeaker(speakerEmail)
    	       .disableButtonClick();
    }
    
    
    @Test(priority=13)
    public void testUserDisabled() throws InterruptedException
    {
    	speaker.verifySpeakerIsDisabled(speakerEmail);
    }
    
    
}


