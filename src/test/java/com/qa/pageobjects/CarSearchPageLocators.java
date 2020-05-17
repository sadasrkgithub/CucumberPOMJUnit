package com.qa.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.basepack.BaseEngine;

public class CarSearchPageLocators 
{
	@FindBy(how=How.XPATH, using="//select[@id='makes']")
	private static WebElement carMakerDropDown;
	
	@FindBy(how=How.XPATH, using="//select[@id='models']")
	private static WebElement carModelDropDown;
	
	
	@FindBy(how=How.XPATH, using="//select[@id='locations']")
	private static WebElement carLocationDropDown;
	
	
	@FindBy(how=How.XPATH, using="//select[@id='priceTo']")
	private static WebElement carPriceDropDown;
	
	
	@FindBy(how=How.XPATH, using="//input[@id='search-submit']")
	private static WebElement findMyNextCarButton;
	
	
	public static void make_Selection(String make)
	{
		Assert.assertTrue(carMakerDropDown.isDisplayed() && carMakerDropDown.isEnabled());
		new Select(carMakerDropDown).selectByVisibleText(make);	
	}
	
	public static void model_Selection(String model)
	{
		Assert.assertTrue(carModelDropDown.isDisplayed() && carModelDropDown.isEnabled());
		new Select(carModelDropDown).selectByVisibleText(model);
	}
	
	
	public static void location_Selection(String location)
	{
		Assert.assertTrue(carLocationDropDown.isDisplayed() && carLocationDropDown.isEnabled());
		new Select(carLocationDropDown).selectByVisibleText(location);
	}
	
	
	public static void price_Selection(String price)
	{
		Assert.assertTrue(carPriceDropDown.isDisplayed() && carPriceDropDown.isEnabled());
		new Select(carPriceDropDown).selectByVisibleText(price);
	}
	
	
	public static void find_my_car()
	{
		Assert.assertTrue(findMyNextCarButton.isDisplayed() && findMyNextCarButton.isEnabled());
		findMyNextCarButton.click();
	}
	
	static 
	   {
		
		   PageFactory.initElements(BaseEngine.getDriver(), CarSearchPageLocators.class);
	   }
	
}
