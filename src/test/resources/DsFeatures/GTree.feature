@TreeTest
Feature: Test Tree Page

  Background: The user is logged in to DS Algo portal
    Given The User opens  DS Algo portal Page
    When User click on Get Started button
    And user clicks on SignIn button he is directed to login page
    When User enters valid username "queen" and password "ninjaqueen"
    Then It should navigate to the home page with a message "You are logged in"

  Scenario: User clicks on Tree page
    Given user is on Home Page
    When user clicks on Tree getstarted
    And The user clicks "Overview of Trees" button
    And The user click tryhere
    Then user is on Tryeditorpage

  

  
      
