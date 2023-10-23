package Hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksDS {
	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order=0)
	public void getProperty()
	{
		configReader=new ConfigReader();
		prop=configReader.initProp();
	}
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
		
	}
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	//@After(order=1)
//	public void tearDown(Scenario scenario)
//	{
//		if(((Object) scenario).isFailed())//take ScreenShot;
//		{	
//			LoggerLoad.error("Steps Failed , Taking Screenshot");
//			String screenShotName=scenario.getName().replaceAll("", "_");
//			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath,"image/png", screenShotName);
//		}
//		
//	}

}
