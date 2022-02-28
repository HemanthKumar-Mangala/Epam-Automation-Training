package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.BDD.PageObjectModel.LoginPage;
import TestAutomation.selenium.BDD.PageObjectModel.NavigationMenu;
import TestAutomation.selenium.BDD.PageObjectModel.SystemUsers;
import io.cucumber.java.en.*;


public class SystemUserImpl {

	public static WebDriver driver=CucumberDefinitionImpl.driver;

	public static String platformname;
	public static String orangeHRMURL;
	
	
	
	SystemUsers users;
	LoginPage login;
	NavigationMenu menu;
	public static  void beforeScenario() throws MalformedURLException {
		String browserName = "chrome";
		platformname = "LocalWebDriver";
		orangeHRMURL = "https://prasoonr-trials73.orangehrmlive.com/" ;

		driver = WebDriverFactoryOfFactory.getWebDriverfactory(platformname).getWebDriver(browserName);
		driver.get(orangeHRMURL);
		

}
	
	



	@When("click on Admin button and click on user management button and click on users")
	public void click_on_Admin_button_and_click_on_user_management_button_and_click_on_users() {
	   
		menu=new NavigationMenu(driver);
		menu.AdminBtnClick().userManagementBtnClick().usersBtnClick();
		 
	    
	}

	@Then("user should navigate to SystemUsersPage")
	public void user_should_navigate_to_system_users_page() {
	    
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("systemUsers"));

		
	 
	}

	@When("click on Amnada_user edit button")
	public void click_on_amnada_user_edit_button() {
		users=new SystemUsers(driver);
	    users.amandaEditClick();
		
	   
	}

	@Then("A child window should be opened")
	public void a_child_window_should_be_opened() {
	  
	   Boolean result=driver.findElement(By.xpath("//h5[@class='modal-title'][contains(.,'Edit User')]")).isDisplayed();
	   assertTrue(result);
	}

	@When("click on roles dropdown")
	public void click_on_roles_dropdown() {
	   
		  users.adminroleDropDownClick();
	    
	}

	@Then("change the role to Global Admin and save")
	public void change_the_role_to_global_admin_and_save() {
	   
		users.globalAdminClick().savebtnClick();
	    
	}

	@Then("verify Global Admin is selected or not")
	public void verify_global_admin_is_selected_or_not() {
	   users.verifyGlobalButtonDisplay();
	   
	}

	@Then("change the role to Select and save")
	public void change_the_role_to_select_and_save() {
	  users.selectclick().savebtnClick();
	    
	}

	@Then("verify the role is set to selected and save")
	public void verify_the_role_is_set_to_selected_and_save() {
		 users.verifySelectDisplay().savebtnClick();
	   
	}

	@When("click on user drop down menu and click on click logout")
	public void click_on_user_drop_down_menu_and_click_on_click_logout() {
	    menu.logout();
	    
	}

	@Then("user is navigated to login page")
	public void user_is_navigated_to_login_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("login"));
	   
	}
}
