package com.qa.basepack;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionEngine extends BaseEngine 
{
	
	private static WebElement element;
	private static List<WebElement> elements;
	private static Actions actions = new Actions(getDriver());
	
	
   public static void enterURL(String url)
   {
	   getDriver().get(url);
   }
   
   public static void enterURL(URL url)
   {
	  Navigation navigation = getDriver().navigate();
	  navigation.to(url);
   }
   
   public static String getTitleOfThePage()
   {
	   return getDriver().getTitle(); 
   }
   
   public static WebElement identifyElement(String locMech, String locValue)
   {
	
	    switch(locMech)
	   {
	     case "id"              :  element = getDriver().findElement(By.id(locValue));
	                               break;
	                 
	     case "name"            :  element = getDriver().findElement(By.name(locValue));            
	                               break;
	                   
	     case "classname"       :  element = getDriver().findElement(By.className(locValue));              
	                               break;
	                        
	     case "tagName"         :  element = getDriver().findElement(By.tagName(locValue));
	                               break;
	                      
	     case "linkText"        :  element = getDriver().findElement(By.linkText(locValue));  
	                               break;
	                       
	     case "partialLinkText" :  element = getDriver().findElement(By.partialLinkText(locValue)); 
                                   break;
            
	     case "xpath"           :  element = getDriver().findElement(By.xpath(locValue));                       
	    		                   break;
	    
	     case "cssSelector"     :  element = getDriver().findElement(By.cssSelector(locValue));
	    		                   break;
	   }
	   return element;
	   
   }
   
   
   
   
   public static List<WebElement> identifyElements(String locMech, String locValue)
   {
	
	    switch(locMech)
	   {
	     case "id"              : elements = getDriver().findElementsById(locValue);
	                               break;
	                 
	     case "name"            : elements = getDriver().findElementsByName(locValue);            
	                               break;
	                   
	     case "classname"       : elements = getDriver().findElementsByClassName(locValue);              
	                               break;
	                        
	     case "tagName"         :  elements = getDriver().findElementsByTagName(locValue);
	                               break;
	                      
	     case "linkText"        :  elements = getDriver().findElementsByLinkText(locValue);  
	                               break;
	                       
	     case "partialLinkText" :  elements = getDriver().findElementsByPartialLinkText(locValue); 
                                   break;
            
	     case "xpath"           :  elements = getDriver().findElementsByXPath(locValue);                       
	    		                   break;
	    
	     case "cssSelector"     :  elements = getDriver().findElementsByCssSelector(locValue);
	    		                   break;
	   }
	   return elements;
	   
   }
   
   
   public static void dataTypingAction(String locMech, String locValue, String testData)
   {
	   element  = identifyElement(locMech, locValue);
	   if(element.isDisplayed() && element.isEnabled())
	   {
		   element.clear();
		   element.sendKeys(testData);
	   }
   }
   
   public static void clickAction(String locMech, String locValue)
   {
	   element = identifyElement(locMech, locValue);
	   if(element.isDisplayed() && element.isEnabled())
	   {
		   element.click();
	   }
   }
   
   
   public static void clickActionUsingActionsClass()
   {
	   actions.sendKeys(Keys.ENTER).build().perform();
   }
   
   public static void mouseHoverAction(String locMech, String locValue)
   {
	   element = identifyElement(locMech, locValue);
	   actions.sendKeys(element).build().perform();
   }
   
  /* public static void main(String[] args)
   {
	   identifyElement("id","IdentidierId");
   }*/
}
