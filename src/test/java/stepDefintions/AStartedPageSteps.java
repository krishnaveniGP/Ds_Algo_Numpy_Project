package stepDefintions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.driverFactory.DriverFactory;
import com.pages.StartedPage;
import com.utilities.LoggerLoad;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AStartedPageSteps {
	private WebDriver driver=DriverFactory.getDriver();

	private StartedPage sgPage = new StartedPage(driver);
	public SoftAssert softAssert=new SoftAssert();
	public static String expected,actual_url,actual_title;
	

	@Given("The User opens  DS Algo portal Page")
	public void the_user_opens_ds_algo_portal_page() {
		LoggerLoad.info("user opened the dsAlgo portal");
		driver.get("https://dsportalapp.herokuapp.com/");
		actual_url=driver.getCurrentUrl();
		expected="https://dsportalapp.herokuapp.com/";
		assertEquals(expected,actual_url);
		System.out.println(actual_url);
		
	}

	@When("User click on Get Started button")
	public void user_click_on_get_started_button() {
		LoggerLoad.info("user clicked getstarted button");
		sgPage.clickGetStarted();
		System.out.println("current URL is "+driver.getCurrentUrl());

	}

	@Then("User should land on NumpyNinja HomePage")
	public void user_should_land_on_NumpyNinja_page() {
		LoggerLoad.info("user is on home page");
		expected="https://dsportalapp.herokuapp.com/home";
		actual_url=driver.getCurrentUrl();
		 actual_title = driver.getTitle();
		System.out.println("current URL is "+driver.getCurrentUrl());
		 assertEquals(expected,actual_url);
		    softAssert.assertEquals(expected,actual_url,"passed");

	}

	@Then("user gets the Page Title as {string}")
	public void user_gets_the_page_title_as(String string) {
		LoggerLoad.info("user gets the page title");
		expected=string;
		
		System.out.println("expected is "+expected);
		System.out.println("actual title is "+actual_title);
		assertEquals(actual_title,expected);
		

	}

}
