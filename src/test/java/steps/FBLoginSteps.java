package steps;

import java.io.IOException;

import org.junit.Assert;

import com.qa.basepack.ActionEngine;
import com.qa.basepack.BaseEngine;
import com.qa.pageobjects.FBPageObjects;
import com.qa.supporters.PropertiesReader;
import com.qa.utilities.FilePaths;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FBLoginSteps 
{
	@Given("^when user is home page$")
	public void when_user_is_home_page() throws IOException
	{
		PropertiesReader propertiesReader = new PropertiesReader(FilePaths.configPath);
		String fburl = propertiesReader.getPropertyValue("fb_url");
		ActionEngine.enterURL(fburl);				
	}
	
	@When("^I enter UN as \"([^\"]*)\" and pwd as \"([^\"]*)\"$")
	public void i_enter_UN_and_pwd(String un, String pwd) 
	{
		FBPageObjects.enterUserName(un);
		FBPageObjects.enterPWD(pwd);	
	}

	
	@When("^when i click on login button$")
	public void when_i_click_on_login_button() throws InterruptedException 
	{
		Thread.sleep(3000);
		FBPageObjects.clickOnLogin();
	}

	
	@Then("^login page should be opened as \"([^\"]*)\"$")
	public void login_page_should_be_opened(String expectedPageTitle) throws InterruptedException 
	{
		Thread.sleep(3000);
		Assert.assertEquals(expectedPageTitle, BaseEngine.getDriver().getTitle());
		 
	}

	
}
