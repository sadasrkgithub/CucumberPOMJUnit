package com.qa.utilities;

import com.qa.basepack.BaseEngine;

public interface DriverPaths 
{
	  String ieKey = "webdriver.ie.driver";
	  String ieValue = BaseEngine.getCurDir() +"\\Drivers\\IEDriverServer.exe";
	  
	  String chromeKey = "webdriver.chrome.driver";
	  String chromeValue = BaseEngine.getCurDir() +"\\Drivers\\chromedriver.exe";
	  
	  String firefoxKey = "webdriver.gecko.driver";
	  String firefoxValue = BaseEngine.getCurDir() +"\\Drivers\\geckodriver.exe";
	 
}
