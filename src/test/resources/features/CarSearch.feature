Feature: Validation of car search page

In order to validate car search
As a buyer
I navigate to http://www.carsguide.com.au

@Search-Cars
Scenario: Searching for a new car

Given I am on the home page https://www.carsguide.com.au of carsguide website
When I move to buyAndsell menu
Then I click on Search cars
And I Select make as "BMW"
And I Select Model as "1 Series"
And I Select location as "WA - All"
And I Select price as "$10,000"
And I click on Find my next car button
Then I should see list of searched cars from "BMW"
And the page title should be "Bmw 1 Series Under 10000 for Sale WA | carsguide" 


