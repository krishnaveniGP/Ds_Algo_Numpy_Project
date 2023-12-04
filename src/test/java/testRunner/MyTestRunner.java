package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"src/test/resources/DsFeatures"},
				
		glue={"stepDefintions","Hooks"},
		plugin = {"pretty",
				"json:target/json/file.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/"},
		dryRun=false,
		monochrome=true
		
		
		)

public class MyTestRunner{

}
