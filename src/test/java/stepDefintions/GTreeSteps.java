package stepDefintions;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.pages.HomePage;
import com.pages.TreePage;
import com.utilities.ExcelReader;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GTreeSteps {
	WebDriver driver = DriverFactory.getDriver();

	private HomePage homePage = new HomePage(driver);
	private TreePage treePage=new TreePage(driver);
	private String code;
	private String actualresult;
	private String expectedresult;
	@When("user clicks on Tree getstarted")
	public void user_clicks_on_tree_getstarted() {
	    homePage.click_Tree_getstart();
	 
	    treePage.click_overview_Of_trees();
	}

	@When("The user click tryhere")
	public void the_user_click_tryhere() {
	    treePage.tryHere_click();
	}

	@Then("user is on Tryeditorpage")
	public void user_is_on_tryeditorpage() {
	  System.out.println(driver.getTitle());
	  
	}

	
	
}
