package stepDefintions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.pages.DataStructuresPage;
import com.pages.HomePage;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataStructuresSteps {
	WebDriver driver = DriverFactory.getDriver();

	//private StartedPage sgPage = new StartedPage(driver);
	private HomePage homePage = new HomePage(driver);
	//private SignInPage loginPage = new SignInPage(driver);
	//private RegistrationPage registerPage = new RegistrationPage(driver);

	//private ConfigReader reader = new ConfigReader();
	private DataStructuresPage dataPage = new DataStructuresPage(driver);
	String timpe_page_actual_title;
	String click_here_page_title;
	private static String actualAlertText;

	@When("user clicks on datastructure getstarted")
	public void user_clicks_on_datastructure_getstarted() {
		homePage.click_data_Structure_GetStarted();
	}

	@Then("user redirected to page with title {string}")
	public void user_redirected_to_page_with_title(String string) {
		String expected_title = string;
		String actual_title = dataPage.get_title();
		Assert.assertEquals(actual_title, expected_title);
	}

	@When("user click on Time Complexity")
	public void user_click_on_time_complexity() {
		timpe_page_actual_title = dataPage.click_Time_Complexity();
		System.out.println("data structure time complexity page title  " + timpe_page_actual_title);
	}

	@Then("It should navigate to corresponding page with title {string}")
	public void it_should_navigate_to_corresponding_page_with_title(String string) {
		Assert.assertEquals(timpe_page_actual_title, string);

	}

	@When("user click on Try here")
	public void user_click_on_try_here() {
		click_here_page_title = dataPage.click_try_Here();
		System.out.println("click here title is  " + click_here_page_title);
	}

	@Then("It should navigate to corresponding page with Title {string}")
	public void it_should_navigate_to_corresponding_page_with_Title(String string) {
		Assert.assertEquals(click_here_page_title, string);

	}
	

//	@Then("It should navigate to corresponding page with Title {string}")
//	public void it_should_navigate_to_corresponding_page_with_title(String string) {
//	    
//	}



	// Then It should navigate to corresponding page with title "Assessment"

	@When("user enter the Python code")
	public void user_enter_the_python_code(io.cucumber.datatable.DataTable pythonCode) {
		List<String> data = pythonCode.asList();
		dataPage.send_Python_code(data.get(0));

	}

	@When("user clicks run button and goes to home page")
	public void user_clicks_run_button_and_goes_to_home_page() {
		dataPage.click_Run_Button();

	}

	@When("user enter the invalid Python code")
	public void user_enter_the_invalid_python_code(io.cucumber.datatable.DataTable pythonCode) {
		List<String> data = pythonCode.asList();
		dataPage.send_Python_code(data.get(0));

	}

	@When("user clicks run button")
	public void user_clicks_run_button() throws InterruptedException {
		actualAlertText=dataPage.handling_Alert();

	}

	@Then("user should get the alert message with text {string}")
	public void user_should_get_the_alert_message_with_text(String expectedAlertText) throws InterruptedException {

		//actualAlertText = dataPage.handling_Alert();
		Assert.assertEquals(expectedAlertText,actualAlertText);
	}

	@Then("user accepts the error")
	public void user_accepts_the_error() throws InterruptedException {
		//dataPage.Is_AlertPresent();
		System.out.println(driver.getCurrentUrl());

	}

}
