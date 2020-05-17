@fbLogin
Feature: FB login use case

 Scenario: FB test case with correct un and pwd
 
 Given when user is home page
 When I enter UN as "rameshsoft.selenium" and pwd as "practice"
 And when i click on login button
 Then login page should be opened as "Log in to Facebook | Facebook"
 