package stepDefintions;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.driverFactory.DriverFactory;
import com.pages.HomePage;
import com.pages.RegistrationPage;
import com.pages.SignInPage;
import com.pages.StartedPage;
import com.utilities.ConfigReader;
import com.utilities.ExcelReader;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationSteps {

	private StartedPage sgPage = new StartedPage(DriverFactory.getDriver());
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	private SignInPage loginPage = new SignInPage(DriverFactory.getDriver());
	private RegistrationPage registerPage = new RegistrationPage(DriverFactory.getDriver());
	private WebDriver driver = DriverFactory.getDriver();
	private ConfigReader reader = new ConfigReader();
	Properties prop;
	WebDriverWait wait;
	String error;

	@Given("The user opens Register Page")
	public void the_user_opens_register_page() throws InterruptedException {
		registerPage = homePage.clickRegisterButton();
		System.out.println(driver.getCurrentUrl());

	}

	@When("User click Register with all empty field")
	public void user_click_register_with_all_empty_field() {
		registerPage.clickRegister_Button();

	}

	@Then("It should display an error {string} below username textbox")
	public void it_should_display_an_error_below_username_textbox(String expected_error_msg) {
		Assert.assertEquals(registerPage.clickRegister_Button(), expected_error_msg);

	}

	@When("The user clicks Register button after entering username with other fields empty")
	public void the_user_clicks_register_button_after_entering_username_with_other_fields_empty(DataTable uname) {
		List<Map<String, String>> list = uname.asMaps(); // ******Using Map for with header datatable
		String userName = list.get(0).get("username");
		registerPage.click_Register_Button_with_UserName(userName); // error=

	}

	@Then("It should display an error {string} below password textbox")
	public void it_should_display_an_error_below_password_textbox(String expected_errormsg) {
		// String actual_errormsg=error;
		Assert.assertEquals(registerPage.clickRegister_Button_AfterPassword(), expected_errormsg);

	}

	@When("The user clicks Register button after entering password with other fields empty")
	public void the_user_clicks_register_button_after_entering_password_with_other_fields_empty(DataTable pwd) {
		List<Map<String, String>> list = pwd.asMaps(); // ******Using Map for with header datatable
		String pwd1 = list.get(0).get("password");
		registerPage.click_Register_Button_with_Password(pwd1);

	}
	
	

//	@Then("It should display an error {string} below UserName  textbox")
//	public void it_should_display_an_error_below_UserName_textbox(String expected_error_msg) {
//		Assert.assertEquals(registerPage.clickRegister_Button(), expected_error_msg);
//	    
//	}




	@When("The user clicks Register button after entering confirmation password with other fields empty")
	public void the_user_clicks_register_button_after_entering_confirmation_password_with_other_fields_empty(
			DataTable confirmPwd) {
		List<Map<String, String>> list = confirmPwd.asMaps(); // ******Using Map for with header datatable
		String pwd1 = list.get(0).get("confirm password");
		registerPage.click_Register_Button_with_confirmPwd(pwd1);

	}

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_Username_textbox(String expected_errormsg) {
		 //String actual_errormsg=error;
		Assert.assertEquals(registerPage.clickRegister_Button(), expected_errormsg);

	}

	@When("User enters username and password only and click register")
	public void user_enters_username_and_password_only_and_click_register(io.cucumber.datatable.DataTable credentials) {
		List<Map<String, String>> list = credentials.asMaps();
		String uName = list.get(0).get("username");
		String pwd = list.get(0).get("password");
		registerPage.login_Details(uName, pwd);

	}

	@Then("User verify the message at confirmpassword on Register Page as {string}")
	public void user_verify_the_message_at_confirmpassword_on_register_page_as(String expected_errormsg) {
//		 String actual_errormsg=error;
//		 Assert.assertEquals(actual_errormsg, expected_errormsg);
		Assert.assertEquals(registerPage.clickRegister_Button_After_Confirm_Password(), expected_errormsg);
	}

	@When("user enter invalid {string},{string} and {string}")
	public void user_enter_invalid_and(String username, String password, String confirmpassword) {
		System.out.println("inside datatable2");
		error = registerPage.register_InValid_Credentilas(username, password, confirmpassword);
	}

	@Then("User verifies for the mismatch error message {string}")
	public void user_verifies_for_the_mismatch_error_message(String mismatcherror) {
		Assert.assertEquals(error, mismatcherror);

	}

	@When("user enter the sheetname {string} and row number {int}")
	public void user_enter_the_sheetname_and_row_number(String string, Integer int1) {
		ExcelReader excel = new ExcelReader();
		List<Map<String, String>> list = excel.getData("src/test/resources/Excel_Data/registerDSAlgo.xlsx",
				"validcredentials");
		String uname = list.get(int1).get("username");
		String pwd = list.get(int1).get("password");
		String cpwd = list.get(int1).get("confirmpassword");
		loginPage = registerPage.register_with_Valid_Credentilas(uname, pwd, cpwd);
		System.out.println(driver.getCurrentUrl());

	}

	@Then("User verifies for the successful registration message")
	public void user_verifies_for_the_successful_registration_message() {
		Assert.assertEquals(driver.getCurrentUrl(), "https://dsportalapp.herokuapp.com/home");
		Assert.assertEquals(driver.getTitle(), "NumpyNinja");

	}

}
