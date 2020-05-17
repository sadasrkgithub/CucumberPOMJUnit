package steps;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.qa.basepack.ActionEngine;
import com.qa.basepack.BaseEngine;
import com.qa.pageobjects.CarsGuideHomePage;
import com.qa.pageobjects.UsedCarPageObjects;
import com.qa.supporters.PropertiesReader;
import com.qa.utilities.FilePaths;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsedCarsSearchSteps 
{
	@Given("^I navigate to the  Home Page \"([^\"]*)\" of CarsGuide Website$")
	public void i_navigate_to_the_Home_Page_of_CarsGuide_Website(String url) throws IOException, InterruptedException  
	{
		PropertiesReader propertiesReader = new PropertiesReader(FilePaths.configPath);
		String urlCar = propertiesReader.getPropertyValue("car_url");
		ActionEngine.enterURL(urlCar);
		Thread.sleep(3000);
	}
	
	
	@When("^I move to Car-For-Sale Menu$")
	public void i_move_to_Car_For_Sale_Menu() throws InterruptedException  
	{
		Thread.sleep(3000);
		CarsGuideHomePage.moveToBuyAndSellCarstwo();
		Thread.sleep(3000);
	  
	}

	@When("^click on submenu Used Cars Search link$")
	public void click_on_submenu_Used_Cars_Search_link() throws InterruptedException  
	{
		CarsGuideHomePage.click_on_used_cars();
		Thread.sleep(3000);
	}

	@When("^select carMaker from AnyMake dropdown$")
	public void select_carMaker_from_AnyMake_dropdown(List<String> carMaker) 
	{
	    UsedCarPageObjects.make_Selection(carMaker.get(1));
	}

	@When("^select  car model$")
	public void select_car_model(List<String> list)  
	{
		UsedCarPageObjects.model_Selection(list.get(1));
	}

	@When("^select location  from SelectLocation dropdown$")
	public void select_location_from_SelectLocation_dropdown(List<String> location)  
	{
	
		UsedCarPageObjects.location_Selection(location.get(1));
	}

	@When("^select price$")
	public void select_price(List<String> price)  
	{
		UsedCarPageObjects.price_Selection(price.get(1));
		
	}

	@When("^click on Find_My_Car button$")
	public void click_on_Find_My_Car_button() throws InterruptedException  
	{
		UsedCarPageObjects.find_my_car();
		Thread.sleep(3000);
	}

	@Then("^I should see list of Used \"([^\"]*)\"$")
	public void i_should_see_list_of_Used_cars(String cars) throws InterruptedException  
	{
		
	  Assert.assertTrue(BaseEngine.getDriver().findElement(By.xpath("//h5[contains(text(),'Audi')]")).getText().contains(cars));
	  Thread.sleep(3000);
	}

	@Then("^the page title should match expected title  \"([^\"]*)\"$")
	public void the_page_title_should_match_expected_title(String expectedPageTitle) throws InterruptedException  
	{
		
		 Assert.assertEquals(expectedPageTitle, BaseEngine.getDriver().getTitle());
		 Thread.sleep(3000);
		   		 
	}
	
}
