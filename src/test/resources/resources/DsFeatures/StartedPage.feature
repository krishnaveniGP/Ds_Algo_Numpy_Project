Feature: Validate DSAlgo HomePage Title

  #Background: 
  Scenario: User launches the Dsalgo portal Page
    Given The User opens  DS Algo portal Page
    When User click on Get Started button
    Then User should land on NumpyNinja HomePage

  Scenario: User validates the title of the HomePage
    Then user gets the Page Title as "NumpyNinja"
