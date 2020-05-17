package steps;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.qa.basepack.ActionEngine;
import com.qa.basepack.BaseEngine;
import com.qa.pageobjects.CarSearchPageLocators;
import com.qa.pageobjects.CarsGuideHomePage;
import com.qa.supporters.PropertiesReader;
import com.qa.utilities.FilePaths;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarSearchSteps 
{
  
	@Given("^I am on the home page https://www\\.carsguide\\.com\\.au of carsguide website$")
	public void i_am_on_the_home_page_https_www_carsguide_com_au_of_carsguide_website() throws IOException 
	{
		PropertiesReader propertiesReader = new PropertiesReader(FilePaths.configPath);
		String urlCar = propertiesReader.getPropertyValue("car_url");
		ActionEngine.enterURL(urlCar);	
		
	}

	@When("^I move to buyAndsell menu$")
	public void i_move_to_buyAndsell_menu() throws InterruptedException 
	{
		CarsGuideHomePage.moveToBuyAndSellCars();
		Thread.sleep(3000);
	  
	}

	@Then("^I click on Search cars$")
	public void i_click_on_Search_cars() throws InterruptedException 
	{
		CarsGuideHomePage.click_on_search_cars();
		Thread.sleep(3000);
	}

	
	@Then("^I Select make as \"([^\"]*)\"$")
	public void i_Select_make_as(String make) throws InterruptedException 
	{
		CarSearchPageLocators.make_Selection(make);
		Thread.sleep(3000);

	}

	@Then("^I Select Model as \"([^\"]*)\"$")
	public void i_Select_Model_as(String model) throws InterruptedException 
	{
		CarSearchPageLocators.model_Selection(model);
		Thread.sleep(3000);
	    
	}

	@Then("^I Select location as \"([^\"]*)\"$")
	public void i_Select_location_as(String location) throws InterruptedException 
	{
		CarSearchPageLocators.location_Selection(location);
		Thread.sleep(3000);
	}

	@Then("^I Select price as \"([^\"]*)\"$")
	public void i_Select_price_as(String price) throws InterruptedException 
	{
		CarSearchPageLocators.price_Selection(price);
		Thread.sleep(3000);
	    
	}

	@Then("^I click on Find my next car button$")
	public void i_click_on_Find_my_next_car_button() throws InterruptedException 
	{
		CarSearchPageLocators.find_my_car();
		Thread.sleep(3000);    
	}

	@Then("^I should see list of searched cars from \"([^\"]*)\"$")
	public void i_should_see_list_of_searched_cars(String cars) 
	{
		
	    Assert.assertTrue(BaseEngine.getDriver().findElement(By.xpath("//h5[contains(text(),'BMW')]")).getText().contains(cars));
	}

	@Then("^the page title should be \"([^\"]*)\"$")
	public void the_page_title_should_be(String expected) 
	{
		
	    Assert.assertEquals(expected, BaseEngine.getDriver().getTitle());
	    
	}



	
}
