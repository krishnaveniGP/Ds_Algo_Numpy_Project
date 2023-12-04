package testRunner;

import org.junit.runner.RunWith;


import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(publish = true,
		features = {"src/test/resources/DsFeatures"},
				//features ="@target/rerun.txt",	
		glue={"stepDefintions","Hooks"},
		plugin = {"pretty",
				"json:target/jsonfile.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","timeline:test-output-thread/",
				"rerun:target/rerun.txt"},
		dryRun=false,
		monochrome=true
		
		
		)

public class MyTestRunner{

}
