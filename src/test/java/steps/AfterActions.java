package steps;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import com.qa.basepack.BaseEngine;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;

public class AfterActions 
{
	@After
    public static void tearDown(Scenario scenario) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
    	
    	/*WebDriver driver= BaseEngine.getDriver();
    	System.out.println(scenario.isFailed());
    	*/ 
		 if (scenario.isFailed()) 
    	 {
			 	
             byte[] screenshotBytes = ((TakesScreenshot) BaseEngine.getDriver()).getScreenshotAs(OutputType.BYTES);
             scenario.embed(screenshotBytes, "image/png");
          
         }
    
    	 BaseEngine baseEngine	= new BaseEngine();
    	 baseEngine.closeBroswer();
    }
}
