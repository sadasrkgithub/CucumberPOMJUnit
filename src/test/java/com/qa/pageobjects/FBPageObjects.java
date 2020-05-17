package com.qa.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.basepack.BaseEngine;

public class FBPageObjects 
{
	@FindBy(id="email")
	private static WebElement emaiL;
		
	@FindBy(id="pass")
	private static WebElement password;
	
	@FindBy(id="u_0_b")
	private static WebElement login;
	
	public static void enterUserName(String un)
	{
		emaiL.sendKeys(un);
	}
	
	public static void enterPWD(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	
	public static void clickOnLogin()
	{
		login.click();
	}
	
	static 
	   {
		
		   PageFactory.initElements(BaseEngine.getDriver(), FBPageObjects.class);
	   }
}
