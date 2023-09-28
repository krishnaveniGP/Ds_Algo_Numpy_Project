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

public class HomePageSteps {
	private StartedPage sgPage=new StartedPage(DriverFactory.getDriver());
	private HomePage homePage=new HomePage(DriverFactory.getDriver());
	private SignInPage loginPage=new SignInPage(DriverFactory.getDriver());
	private RegistrationPage registerPage=new RegistrationPage(DriverFactory.getDriver());
	private WebDriver driver=DriverFactory.getDriver();
	private ConfigReader reader=new ConfigReader();
	
	Properties prop;
	WebDriverWait wait;
	String actual_PageUrl, expected_PageUrl;
	
	
//	@Given("The User opens  DS Algo portal Page")
//	public void the_user_opens_ds_algo_portal_page() {
//
//		driver.get("https://dsportalapp.herokuapp.com/");
//
//		
//	}
//
//	@When("User click on Get Started button")
//	public void user_click_on_get_started_button() {
//		homePage=sgPage.clickGetStarted();
//		System.out.println("current URL is "+driver.getCurrentUrl());
//
//	}

//	@Then("User should land on NumpyNinja HomePage")
//	public void user_should_land_on_NumpyNinja_page() {
//		expected_PageUrl="https://dsportalapp.herokuapp.com/home";
//		actual_PageUrl=driver.getCurrentUrl();
//		System.out.println("current URL is "+driver.getCurrentUrl());
//		 assertEquals(expected_PageUrl,actual_PageUrl);
//		    
//
//	}

//	@When("The user clicks the Get Started button")
//	public void the_user_clicks_the_get_started_button() {
//	    
//	}

	@Given("user is on Home Page")
	public void user_is_on_home_page() {
		System.out.println("home page url is  "+driver.getCurrentUrl());
	    
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
	public void the_user_should_get_the_error_message(String string) {
	   homePage.getErr_msg();
	}

	@When("The user click any of the Get started link before signin {string} in home page")
	public void the_user_click_any_of_the_get_started_link_before_signin_in_home_page(String string) throws InterruptedException {
	    homePage.getStartBtn_click();
	}

	@When("user clicks on SignIn button he is directed to login page")
	public void user_clicks_on_sign_in_button_he_is_directed_to_login_page() {
		homePage.signin_Btn();
	    
	}

	@Then("user validates the login page")
	public void user_validates_the_login_page() {
	    
	}

	@When("user clicks on Register button he is directed to register page")
	public void user_clicks_on_register_button_he_is_directed_to_register_page() {
	    
	}

	@Then("user validates the register page")
	public void user_validates_the_register_page() {
	    
	}

	@When("The user click any of the Get started link after signin {string} in home page")
	public void the_user_click_any_of_the_get_started_link_after_signin_in_home_page(String string) {
	    
	}

	@Then("The user should able to goto its respective page")
	public void the_user_should_able_to_goto_its_respective_page() {
	    
	}


}
