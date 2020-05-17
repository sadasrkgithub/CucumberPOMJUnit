package runners;
import java.io.File;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentCucumberFormatter;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
		features={"src/test/resources/features"}, 
		glue= {"steps"}, 
		dryRun=false,
		tags= {"@Search-Cars,@fbLogin"},
		monochrome=true, 
		plugin={"pretty","html:target/cucumber-html-report","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
		)


public class TestRunner {
	
	
		
	@BeforeClass
    public static void setup() 
	{
	  ExtentCucumberFormatter.initiateExtentCucumberFormatter();

        // Loads the extent config xml to customize on the report.
        ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

        // User can add the system information as follows
        ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
        ExtentCucumberFormatter.addSystemInfo("Browser version", "v81.0.1");
        ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.141.59");

     }


}
