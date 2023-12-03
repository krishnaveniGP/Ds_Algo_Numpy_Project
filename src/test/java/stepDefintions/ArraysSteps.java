package stepDefintions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.pages.ArraysPage;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.pages.SignInPage;
import com.pages.StartedPage;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;

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
	private String code;
	private String actualresult;
	private String expectedresult;
	
	@Given("user clicks on Arrays getstarted")
	public void user_clicks_on_arrays_getstarted() {
		arrPage=homePage.click_array_getstart();
	}
	@Then("user redirected to Arrayspage with title {string}")
	public void user_redirected_to_Arrayspage_with_title(String string) {
	String expected_title = string;
	String actual_title = arrPage.get_Title();
	Assert.assertEquals(actual_title, expected_title);
	}

	@When("The user clicks {string} button")
	public void the_user_clicks_button(String option) {
		arrPage.arrymenu_click(option);
	   
	}

	@Then("The user in  {string} page")
	public void the_user_in_page(String string) {
		System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(),string);
	}

	@Given("The user is in a {string} page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_page_having_an_try_editor_with_a_run_button_to_test(String option) {
		arrPage=homePage.click_array_getstart();
		arrPage.arrymenu_click(option);
		arrPage.tryedit_click();
	}

	@When("The user enter valid python code in tryEditor from sheet {string} and {int}")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheet_and(String SheetName, Integer rowno) {
		ExcelReader reader=new ExcelReader();
		List<Map<String, String>> rdata = reader.getData("./src/test/resources/Excel_Data/programdata.xlsx",SheetName);
		code=rdata.get(rowno).get("Pythoncode");
		expectedresult=rdata.get(rowno).get("Result");
		System.out.println("Code:"+code);
		arrPage.enter_code(code);
	    
	}

	@When("The user clicks on run button")
	public void the_user_clicks_on_run_button() {
	    arrPage.click_run();
	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() {
		actualresult=arrPage.present_result();
		Assert.assertEquals(actualresult, expectedresult);
	}

	@When("The user enter python code with invalid syntax in tryEditor from sheet {string} and {int}")
	public void the_user_enter_python_code_with_invalid_syntax_in_try_editor_from_sheet_and(String SheetName, Integer rowno) {
		ExcelReader reader=new ExcelReader();
		List<Map<String, String>> rdata = reader.getData("./src/test/resources/Excel_Data/programdata.xlsx",SheetName);
		code=rdata.get(rowno).get("Pythoncode");
		expectedresult=rdata.get(rowno).get("Result");
		arrPage.enter_code(code);
	    
	}

	@Then("The user should be presented with error message")
	public void the_user_should_be_presented_with_error_message() {
		actualresult=arrPage.present_invalidmsg();
		Assert.assertEquals(actualresult, expectedresult);
	}

	@Given("The user is on the Arrays in Python after logged in")
	public void the_user_is_on_the_arrays_in_python_after_logged_in() {
		arrPage=homePage.click_array_getstart();
		arrPage.click_arrayInPython();
	}

	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() {
	    arrPage.practice_click();
	}

	@Then("The user should be redirected to {string} page")
	public void the_user_should_be_redirected_to_page(String string) {
		Assert.assertTrue(driver.getCurrentUrl().contains(string));
	}

	@Then("The user should redirect to {string} practice question page")
	public void the_user_should_redirect_to_practice_question_page(String string) {
		arrPage.practicemenu_click(string);
	}

	@Given("The user is in a {string}  practice page having an tryEditor with a Run button to test")
	public void the_user_is_in_a_practice_page_having_an_try_editor_with_a_run_button_to_test(String option) {
		arrPage=homePage.click_array_getstart();
		arrPage.click_arrayInPython();
		arrPage.practice_click();
		arrPage.practicemenu_click(option);
	}

	@When("The user clicks on submit")
	public void the_user_clicks_on_submit() {
		 arrPage.click_submit();
	}
}