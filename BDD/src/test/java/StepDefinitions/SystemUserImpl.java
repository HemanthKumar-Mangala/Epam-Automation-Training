package StepDefinitions;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import TestAutomation.selenium.BDD.AbstractFactoryDesign.WebDriverFactoryOfFactory;
import TestAutomation.selenium.BDD.PageObjectModel.LoginPage;
import TestAutomation.selenium.BDD.PageObjectModel.NavigationMenu;
import TestAutomation.selenium.BDD.PageObjectModel.SystemUsers;
import io.cucumber.java.en.*;

public class SystemUserImpl {

	public  WebDriver driver;

	public String platformname;
	public String orangeHRMURL;
	
	public SystemUserImpl()
	{
		SharedData shareddata=new SharedData();
	    driver=(WebDriver) shareddata.getAttribute("WebDriver");	
	    menu=new NavigationMenu(driver);
	    users=new SystemUsers(driver);
	}
	
	SystemUsers users;
	LoginPage login;
	NavigationMenu menu;
	

	
	
	@When("user click on Admin button")
	public void user_click_on_admin_button() {
		
		menu.AdminBtnClick();
	}

	@When("click on user management button")
	public void click_on_user_management_button() {
	   menu.userManagementBtnClick();
	}

	@When("click on users")
	public void click_on_users() {
	    menu.usersBtnClick();
	}
	
	@Then("user should navigate to SystemUsersPage")
	public void user_should_navigate_to_system_users_page() {
	    
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("systemUsers"));

    }

	@When("user click on Amnada_user edit button")
	public void user_click_on_amnada_user_edit_button() {
		
	    users.amandaEditClick();
	}

	@When("user click on roles dropdown")
	public void user_click_on_roles_dropdown() {
	    users.adminroleDropDownClick();
	}

	@Then("A child window should be opened")
	public void a_child_window_should_be_opened() {
	  
	   Boolean result=driver.findElement(By.xpath("//h5[@class='modal-title'][contains(.,'Edit User')]")).isDisplayed();
	   assertTrue(result);
	}
	
	@Then("change the role to Global Admin")
	public void change_the_role_to_global_admin() {
	    users.globalAdminClick();
	}
	
	@Then("verify Global Admin is selected or not")
	public void verify_global_admin_is_selected_or_not() {
	   users.verifyGlobalButtonDisplay();
	   
	}

	@Then("click save button")
	public void click_save_button() {
	    users.savebtnClick();
	}

	@Then("change the role to Select")
	public void change_the_role_to_select() {
	    users.selectclick();
	}

	@Then("verify the role is set to selected")
	public void verify_the_role_is_set_to_selected() {
	    users.verifySelectDisplay();
	}

	@When("user click on user drop down menu")
	public void user_click_on_user_drop_down_menu() {
	   menu.clickOnUserDropDown();
	}

	@When("click on click logout")
	public void click_on_click_logout() {
		menu.logout();
	    
	}
	
	@Then("user is navigated to login page")
	public void user_is_navigated_to_login_page() {
		String currentUrl = driver.getCurrentUrl();
		assertTrue(currentUrl.endsWith("login"));
	   
	}


}
