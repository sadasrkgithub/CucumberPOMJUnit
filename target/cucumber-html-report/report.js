$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/CarSearch.feature");
formatter.feature({
  "name": "Validation of car search page",
  "description": "In order to validate car search\nAs a buyer\nI navigate to http://www.carsguide.com.au",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Searching for a new car",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Search-Cars"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the home page https://www.carsguide.com.au of carsguide website",
  "keyword": "Given "
});
formatter.match({
  "location": "CarSearchSteps.i_am_on_the_home_page_https_www_carsguide_com_au_of_carsguide_website()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I move to buyAndsell menu",
  "keyword": "When "
});
formatter.match({
  "location": "CarSearchSteps.i_move_to_buyAndsell_menu()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I click on Search cars",
  "keyword": "Then "
});
formatter.match({
  "location": "CarSearchSteps.i_click_on_Search_cars()"
});
formatter.result({
  "error_message": "java.lang.AssertionError\r\n\tat org.junit.Assert.fail(Assert.java:87)\r\n\tat org.junit.Assert.assertTrue(Assert.java:42)\r\n\tat org.junit.Assert.assertTrue(Assert.java:53)\r\n\tat com.qa.pageobjects.CarsGuideHomePage.click_on_search_cars(CarsGuideHomePage.java:49)\r\n\tat steps.CarSearchSteps.i_click_on_Search_cars(CarSearchSteps.java:43)\r\n\tat ✽.I click on Search cars(file:src/test/resources/features/CarSearch.feature:12)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I Select make as \"BMW\"",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchSteps.i_Select_make_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I Select Model as \"1 Series\"",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchSteps.i_Select_Model_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I Select location as \"WA - All\"",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchSteps.i_Select_location_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I Select price as \"$10,000\"",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchSteps.i_Select_price_as(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I click on Find my next car button",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchSteps.i_click_on_Find_my_next_car_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I should see list of searched cars from \"BMW\"",
  "keyword": "Then "
});
formatter.match({
  "location": "CarSearchSteps.i_should_see_list_of_searched_cars(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "the page title should be \"Bmw 1 Series Under 10000 for Sale WA | carsguide\"",
  "keyword": "And "
});
formatter.match({
  "location": "CarSearchSteps.the_page_title_should_be(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.embedding("image/png", "embedded0.png", null);
formatter.after({
  "status": "passed"
});
formatter.uri("file:src/test/resources/features/Facebook_Login.feature");
formatter.feature({
  "name": "FB login use case",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@fbLogin"
    }
  ]
});
formatter.scenario({
  "name": "FB test case with correct un and pwd",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@fbLogin"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "when user is home page",
  "keyword": "Given "
});
formatter.match({
  "location": "FBLoginSteps.when_user_is_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "I enter UN as \"rameshsoft.selenium\" and pwd as \"practice\"",
  "keyword": "When "
});
formatter.match({
  "location": "FBLoginSteps.i_enter_UN_and_pwd(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "when i click on login button",
  "keyword": "And "
});
formatter.match({
  "location": "FBLoginSteps.when_i_click_on_login_button()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "login page should be opened as \"Log in to Facebook | Facebook\"",
  "keyword": "Then "
});
formatter.match({
  "location": "FBLoginSteps.login_page_should_be_opened(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});