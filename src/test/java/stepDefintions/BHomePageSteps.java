package stepDefintions;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driverFactory.DriverFactory;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.pages.SignInPage;
import com.pages.StartedPage;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class BHomePageSteps {
	private WebDriver driver=DriverFactory.getDriver();
	private StartedPage sgPage=new StartedPage(driver);
	private HomePage homePage=new HomePage(driver);
	private SignInPage loginPage=new SignInPage(driver);
	private RegistrationPage registerPage=new RegistrationPage(driver);
	
	public ConfigReader reader=new ConfigReader();
	
	Properties prop;
	WebDriverWait wait;
	String actual_PageUrl, expected_PageUrl;
	
	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		String home_Url=driver.getCurrentUrl();
		System.out.println("home page url is  "+driver.getCurrentUrl());
	   assertEquals(ConfigReader.homePage(),home_Url);
	}

	@When("The user clicks on data structure dropdown before signin")
	public void the_user_clicks_on_data_structure_dropdown_before_signin() {
		homePage.clickDropDownMenu();
	}

	@Then("The user select any dropdown menu {string}")
	public void the_user_select_any_dropdown_menu(String string) throws InterruptedException {
	    
	    homePage.clickDropDownMenu();
	    homePage.dropDownList(string);
	}

	@Then("The user should get the error message {string}")
	public void the_user_should_get_the_error_message(String actual_ErrorMsg) {
	   
	   String expected_ErrorMsg=homePage.getErr_msg();
		assertEquals(expected_ErrorMsg,actual_ErrorMsg);
	}

	@When("The user click any of the Get started link before signin {string} in home page")
	public void the_user_click_any_of_the_get_started_link_before_signin_in_home_page(String string) throws InterruptedException {
	    homePage.getStartBtn_click();
	}

	@When("user clicks on SignIn button he is directed to login page")
	public void user_clicks_on_sign_in_button_he_is_directed_to_login_page() {
		loginPage=homePage.signin_Btn();
		System.out.println(driver.getCurrentUrl());
	    
	}

	@Then("user validates the login page")
	public void user_validates_the_login_page() {
		actual_PageUrl=driver.getCurrentUrl();		
		expected_PageUrl="https://dsportalapp.herokuapp.com/login";
		assertEquals(actual_PageUrl,expected_PageUrl);
		System.out.println("Login page check "+actual_PageUrl);
	    
	}

	@When("user clicks on Register button he is directed to register page")
	public void user_clicks_on_register_button_he_is_directed_to_register_page() throws InterruptedException {
	    
		registerPage=homePage.clickRegisterButton();
//		  actual_PageUrl=driver.getCurrentUrl();
//		  expected_PageUrl="https://dsportalapp.herokuapp.com/register";
	    
	}

	@Then("user validates the register page")
	public void user_validates_the_register_page() {
		actual_PageUrl=driver.getCurrentUrl();		    
		expected_PageUrl="https://dsportalapp.herokuapp.com/register";
		assertEquals(actual_PageUrl,expected_PageUrl);
	    
	}

	@When("The user click any of the Get started link after signin {string} in home page")
	public void the_user_click_any_of_the_get_started_link_after_signin_in_home_page(String string) throws InterruptedException {
		//homePage.getStart_Btn_After_SignIn_click(string);
	    
	}

	@Then("The user should able to goto its respective page")
	public void the_user_should_able_to_goto_its_respective_page() {
	    
	}


}
