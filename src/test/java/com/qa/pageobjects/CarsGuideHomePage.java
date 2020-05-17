package com.qa.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.basepack.BaseEngine;

public class CarsGuideHomePage 
{
	@FindBy(how=How.XPATH, using="//a[contains(text(),'buy + sell')]")
	private static WebElement buyAndSell;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'Search Cars')]")
	private static WebElement searchCars;
	
	@FindBy(how=How.XPATH, using="//div[@class='uhf-child-content']//a[contains(text(),'Used')]")
	private static WebElement usedCars;
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'buy + sell')]")
	private static WebElement buyAndSellTwo;
	
	
	public static void moveToBuyAndSellCars() throws InterruptedException
	{
		BaseEngine BaseEngine5 = new BaseEngine();
		
		Assert.assertTrue(buyAndSell.isDisplayed() && buyAndSell.isEnabled());
		new Actions(BaseEngine5.getDriver()).moveToElement(buyAndSell).perform();
		Thread.sleep(3000);	  
	}
	
	
	public static void moveToBuyAndSellCarstwo() throws InterruptedException
	{
		BaseEngine BaseEngine6 = new BaseEngine();
		
		Assert.assertTrue(buyAndSellTwo.isDisplayed() && buyAndSellTwo.isEnabled());
		new Actions(BaseEngine6.getDriver()).moveToElement(buyAndSellTwo).perform();
		Thread.sleep(3000);	  
	}
	
	
	public static void click_on_search_cars()
	{
		Assert.assertTrue(searchCars.isDisplayed() && searchCars.isEnabled());
		searchCars.click();
	}
	
	
	public static void click_on_used_cars()
	{
		Assert.assertTrue(usedCars.isDisplayed() && usedCars.isEnabled());
		usedCars.click();
	}
	
	
	   static 
	   {
		   BaseEngine BaseEngine7 = new BaseEngine();
			
		   PageFactory.initElements(BaseEngine7.getDriver(), CarsGuideHomePage.class);
	   }
}
