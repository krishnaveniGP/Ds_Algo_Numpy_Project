package stepDefintions;

import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.pages.ArraysPage;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.pages.SignInPage;
import com.pages.StartedPage;
import com.utilities.ConfigReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArraysSteps {
	WebDriver driver = DriverFactory.getDriver();

	private StartedPage sgPage = new StartedPage(driver);
	private HomePage homePage = new HomePage(driver);
	private SignInPage loginPage = new SignInPage(driver);
	private RegistrationPage registerPage = new RegistrationPage(driver);

	private ConfigReader reader = new ConfigReader();
	private ArraysPage arrPage=new ArraysPage(driver);
	
	
	@Given("user clicks on Arrays getstarted")
	public void user_clicks_on_arrays_getstarted() {
		arrPage=homePage.click_array_getstart();
	}

	@When("The user clicks {string} button")
	public void the_user_clicks_button(String string) {
		arrPage.arrymenu_click(string);
	   
	}

	@Then("The user in  {string} page")
	public void the_user_in_page(String string) {
	   
	}

	@Given("The user is in a {string} page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test(String string) {
	    
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String string, Integer int1) {
	    
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
	    
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
	    
	}

	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String string, Integer int1) {
	    
	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
	    
	}

	@Given("The user is on the Arrays in Python after logged in")
	public void the_user_is_on_the_arrays_in_python_after_logged_in() {
	    
	}

	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
	    
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
	    
	}

	@Then("The user should redirect to {string} practice question page")
	public void the_user_should_redirect_to_practice_question_page(String string) {
	    
	}

	@Given("The user is in a {string}  practice page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_practice_page_having_an_try_editor_with_a_run_button_to_test(String string) {
	    
	}

	@When("The user clicks on submit")
	public void the_user_clicks_on_submit() {
	    
	}

}
