package TestAutomation.selenium.OrangeHRM.PageObjectModel;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPageJS {

	private final WebDriver driver;

	@FindBy(id = "txtUsername")
	private WebElement userName;

	@FindBy(id = "txtPassword")
	private WebElement Password;
	
	@FindBy(className = "form-body")
	private WebElement form;

	@FindBy(xpath = "/html/body/div/div/div[1]/div[2]/div/form/div[3]/button")
	private WebElement LoginButton;

	public LoginPageJS(WebDriver driver) {

		this.driver = driver;
		AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
		PageFactory.initElements(factory, this);
		//driver.manage().timeouts().setScriptTimeout(Duration.ofSeconds(15));
		// PageFactory.initElements(driver, this);
	}

	public LoginPageJS checkUserNameJS(String userName) {
		String script="document.getElementById('txtUsername').value= "+userName;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script);
		//String scriptForElement="document.getElementById('txtUsername')";
		//WebElement userNameElement=(WebElement)js.executeScript(scriptForElement);
		//userNameElement.click();
		return this;
	}
	public LoginPageJS checkPasswordJS(String Password) {
		String script="document.getElementById('txtPassword').value= "+Password;
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script);
		//this.password.sendKeys(password);
		return this;
	}
	public LoginPageJS checkLoginButton() {
		String script="document.querySelector('button[type=submit]').click()";
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript(script);
		//this.loginButton.click();
		//this.form.submit();
		return this;
	}
	public LoginPageJS enterUserName(String userName) {
		this.userName.sendKeys(userName);
		return this;
	}

	public LoginPageJS enterPassword(String password) {
		this.Password.sendKeys(password);
		return this;
	}

	public LoginPageJS clickLoginButton() {
		//this.LoginButton.click();
		 this.form.submit();
		//return this;
		return this;
	}
	public Dashboard clickLoginButton2() {
		this.LoginButton.click();
		// this.form.submit();
		//return this;
		return new Dashboard(driver);
	}

	public LoginPageJS testscreenshot() {
		String nameForTheCurrentWindow = driver.getWindowHandle();

		System.out.println("Name of the current Window : " + nameForTheCurrentWindow);

		Set<String> windowHandler = driver.getWindowHandles();
		for (Iterator iterator = windowHandler.iterator(); iterator.hasNext();) {
			String windowName = (String) iterator.next();
			System.out.println("window Name - > " + windowName);

		}

		// ScreenShot capturing in selenium
		TakesScreenshot screenShot = (TakesScreenshot) driver;
		File screenShotFile = screenShot.getScreenshotAs(OutputType.FILE);

		try {
			FileUtils.copyFile(screenShotFile, new File("./loginPage.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this;
	}

}
