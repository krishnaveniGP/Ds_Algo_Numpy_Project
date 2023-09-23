Feature: Validate DSAlgo HomePage Title

  Background: 
    Given User is on Home Page
    When User click on Get Started
    Then User should land on NumpyNinja HomePage

  Scenario: User validates the title of the HomePage
    Then user gets the Page Title as "NumpyNinja"
