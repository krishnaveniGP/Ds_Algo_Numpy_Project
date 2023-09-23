package stepDefintions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.driverFactory.DriverFactory;
import com.pages.HomePage;
import com.pages.StartedPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StartedPageSteps {
	private WebDriver driver=DriverFactory.getDriver();

	private StartedPage sgPage = new StartedPage(driver);
	private HomePage homePage=new HomePage(driver);
	public SoftAssert softAssert=new SoftAssert();
	public static String expected,actual;

	@Given("User is on Home Page")
	public void user_is_on_get_started_page() {

		driver.get("https://dsportalapp.herokuapp.com/");
		actual=driver.getCurrentUrl();
		expected="https://dsportalapp.herokuapp.com/";
		assertEquals(expected,actual);
		System.out.println(actual);
		
	}

	@When("User click on Get Started")
	public void user_click_on_get_started() {
		homePage=sgPage.clickGetStarted();
		System.out.println("current URL is "+driver.getCurrentUrl());

	}

	@Then("User should land on NumpyNinja HomePage")
	public void user_should_land_on_NumpyNinja_page() {
		expected="https://dsportalapp.herokuapp.com/home";
		actual=driver.getCurrentUrl();
		System.out.println("current URL is "+driver.getCurrentUrl());
		 assertEquals(expected,actual);
		    softAssert.assertEquals(expected,actual,"passed");

	}

	@Then("user gets the Page Title as {string}")
	public void user_gets_the_page_title_as(String string) {
		expected=string;

		actual=driver.getTitle();
		
		System.out.println("actual title is "+actual);
		assertEquals(expected, actual);

	}

}
