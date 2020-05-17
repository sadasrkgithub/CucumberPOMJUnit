package steps;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.qa.basepack.BaseEngine;

import io.cucumber.java.Before;

public class BeforeActions 
{
	@Before
    public static void setUp() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		BaseEngine baseEngine	= new BaseEngine();
		baseEngine.openBrowser("chrome");
	}

}
