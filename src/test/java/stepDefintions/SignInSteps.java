package stepDefintions;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.pages.SignInPage;
import com.pages.StartedPage;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignInSteps {
	private WebDriver driver=DriverFactory.getDriver();
	private StartedPage stPage=new StartedPage(driver);
	private HomePage homePage=new HomePage(driver);
	private RegistrationPage registerPage=new RegistrationPage(driver);
	private ConfigReader config=new ConfigReader();
	private SignInPage sign_In_Page=new SignInPage(driver);
	String error="";
	String invalid="";
	String success="";
	
	
	
	
	@Given("User is on Login page")
	public void user_is_on_login_page() {
		sign_In_Page=homePage.signin_Btn();
		System.out.println("login url is "+driver.getCurrentUrl());
	    
	}

	@When("User clicks on login button with all empty field")
	public void user_clicks_on_login_button_with_all_empty_field() {
		error=sign_In_Page.click_Login_with_Empty_Fields();
	    
	}

	@Then("User verify the message at username as {string}")
	public void user_verify_the_message_at_username_as(String expected_error) {
	    Assert.assertEquals(error,expected_error );
	}
	@When("User enters invalid username as {string} and password as {string}")
	public void user_enters_invalid_username_as_and_password_as(String uname, String pwd) {
		invalid=sign_In_Page.click_Login_with_invalid_credentils(uname, pwd);
	}

	@Then("User verify the message as {string}")
	public void user_verify_the_message_as(String expecter_msg) {
	    Assert.assertEquals(invalid, expecter_msg);
	}

	@When("User clicks on login button with username as {string} only")
	public void user_clicks_on_login_button_with_username_as_only(String uname) {
	    error=sign_In_Page.click_login_with_UserName_only(uname);
	}

	@Then("User verify the message at password as {string}")
	public void user_verify_the_message_at_password_as(String expected_msg) {
		Assert.assertEquals(error,expected_msg);
	}

	@When("User clicks on login button with password as {string} only")
	public void user_clicks_on_login_button_with_password_as_only(String pwd) {
		error=sign_In_Page.click_login_with_password_Only(pwd);
	}

	@Then("User verify the message at user as {string}")
	public void user_verify_the_message_at_user_as(String expected_msg) {
		Assert.assertEquals(error,expected_msg);
	}

	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String uname, String pwd) {
		sign_In_Page.click_Login_with_Valid_Credentils(uname, pwd);
	}

	@Then("It should navigate to the home page with a message {string}")
	public void it_should_navigate_to_the_home_page_with_a_message(String expected_msg) {
		//System.out.println("success login message is "+homePage.logged_In_message());
		Assert.assertEquals(homePage.logged_In_message(),expected_msg);
		System.out.println("***************************"+driver.getCurrentUrl()+"*******************");
		
	}

	@When("User clicks on signout")
	public void user_clicks_on_signout() {
		//sign_In_Page.click_Logout();
		//sign_In_Page=homePage.signin_Btn();
		sign_In_Page.click_Sign_In();
		System.out.println("$$$$$$$$$$$$$$$$$"+driver.getCurrentUrl()+"*******************");
		String name=config.getUserName();
		String pwd=config.getPassword();
				sign_In_Page.click_Login_with_Valid_Credentils(name, pwd);
			
	    success=sign_In_Page.click_Successfull_Logout();
	    
//	    loginPage=homePage.signin_Btn();
//		//System.out.println(driver.getCurrentUrl());
//		String uname=config.getUserName();
//		String pwd=config.getPassword();
//		//System.out.println(uname +pwd);
//		 loginPage.valid_login(uname, pwd);
//		 result=loginPage.success_login();
//		// System.out.println(result);
//		  msg=loginPage.success_logout();
	}

	@Then("Message displayed {string}")
	public void message_displayed_logged_out_successfully(String expected_msg) {
	    Assert.assertEquals(success,expected_msg);
	}

}
