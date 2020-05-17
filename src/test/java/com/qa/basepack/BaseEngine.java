package com.qa.basepack;

import java.io.IOException;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.qa.supporters.ExcelReader;
import com.qa.utilities.DriverPaths;

public class BaseEngine 
{
	private static RemoteWebDriver driver;
	private static String curDir;
	private static ExcelReader excelReader;
	private static int count = 1;
	private static String tcName;
	private static int rowCount = 1;
    
	
	public void openBrowser(@org.testng.annotations.Optional("chrome")String browser) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		curDir = System.getProperty("user.dir");
		
		
		
		if(browser.equalsIgnoreCase("ie"))
		{
	      System.setProperty(DriverPaths.ieKey, DriverPaths.ieValue);
	      //System.setProperty("webdriver.ie.driver","C:\\Users\\K SADA SIVA REDDY\\eclipse-workspaceE\\FrameworksSelenium\\Drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			init();
		}
		
		else if(browser.equalsIgnoreCase("chrome"))
		{
			
			System.setProperty(DriverPaths.chromeKey, DriverPaths.chromeValue);
		//	System.setProperty("webdriver.chrome.driver","C:\\Users\\K SADA SIVA REDDY\\eclipse-workspaceE\\FrameworksSelenium\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); 
			init();
		}
		
		else if(browser.equalsIgnoreCase("firefox"))
		{
		 	System.setProperty(DriverPaths.firefoxKey, DriverPaths.firefoxValue);		
		//	System.setProperty("webdriver.gecko.driver","C:\\Users\\K SADA SIVA REDDY\\eclipse-workspaceE\\FrameworksSelenium\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();	
			init();
		}
		
		
	}
	
	
	private static void init() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();	
		
		/*Method method = null;
		 
		tcName = method.getName();
		excelReader = new ExcelReader(FilePaths.excelPath);
		excelReader.writeData("Frame",count,0,tcName);
		*/   
	}
	
	
	
	public void closeBroswer() throws EncryptedDocumentException, InvalidFormatException, IOException 
	{
		/*excelReader = new ExcelReader(FilePaths.excelPath);
		excelReader.writeDataTwo("Frame",rowCount,1,"PASS");
		*/
		
		Optional<RemoteWebDriver> optional = Optional.ofNullable(driver);
		if(optional.isPresent())
		{
			driver.quit();
		}
		
		else
		{
		
			System.out.println("Driver is pointing to NULL");
		}
	}
	
	public static String getCurDir()
	{
		return curDir;
	}
	
	public static RemoteWebDriver getDriver()
	{
		return driver;
	}
	
}
