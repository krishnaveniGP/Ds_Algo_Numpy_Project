package Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.driverFactory.DriverFactory;
import com.utilities.ConfigReader;
import com.utilities.LoggerLoad;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class HooksDS {
	private WebDriver driver;
	private DriverFactory driverFactory;
	private ConfigReader configReader;
	Properties prop;
	Scenario scenario;
	@Before(order=0)
	public void getProperty()
	{
		LoggerLoad.info("Loading Config Properties ");
		configReader=new ConfigReader();
		prop=configReader.initProp();
	}
	@Before(order=1)
	public void launchBrowser()
	{
		String browserName=prop.getProperty("browser");
		LoggerLoad.info("Initializing the DriverFactory class ");
		driverFactory=new DriverFactory();
		LoggerLoad.info(browserName+ " browser is Launching");
		driver=driverFactory.init_driver(browserName);
		
	}
	@After(order=0)
	public void quitBrowser()
	{
		LoggerLoad.info("Closing Browser");
		driver.quit();
	}
	@AfterStep(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())//take ScreenShot;
		{	
			LoggerLoad.error("Steps Failed , Taking Screenshot");
			String screenShotName=scenario.getName().replaceAll("", "_");
			byte[] sourcePath=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			 scenario.attach(sourcePath,"image/png", screenShotName);
		}
		
	}
//	public void captureScreen(Scenario scenario) 
//	{
//		System.out.println("sceanario status  "+scenario.getStatus());
//		
//		TakesScreenshot ts=(TakesScreenshot) driver;
//		byte[] source=ts.getScreenshotAs(OutputType.BYTES);
//		File target=new File(System.getProperty("user.dir")+"/Screenshot/"+testname+".png");
//		FileUtils.
//		FileUtils.copyURLToFile(source, target);
//		System.out.println("screenshot taken");
//	}

}
