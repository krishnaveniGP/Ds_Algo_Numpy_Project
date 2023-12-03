@dataStructurePage
Feature: Data Structure page validation dsalgo

  Background: 
    #User  Login with  valid "<username>" and "<password>"
    Given The User opens  DS Algo portal Page
    When User click on Get Started button
    And user clicks on SignIn button he is directed to login page
    When User enters valid username "queen" and password "ninjaqueen"
    #And User clicks on login button
    Then It should navigate to the home page with a message "You are logged in"

  #Examples:
  #| username | password   |
  #| queen    | ninjaqueen |
  Scenario: User clicks on datastructure page and checks with valid python code
    Given user is on Home Page
    When user clicks on datastructure getstarted
    Then user redirected to page with title "Data Structures-Introduction"
    When user click on Time Complexity
    Then It should navigate to corresponding page with title "Time Complexity"
    When user click on Try here
    Then It should navigate to corresponding page with Title "Assessment"
    When user enter the Python code
      | validPyhoncode                    |
      | print"DataStructure Introduction" |
    And user clicks run button and goes to home page

  Scenario: User clicks on datastructure page and checks with invalid python code
    Given user is on Home Page
    When user clicks on datastructure getstarted
    Then user redirected to page with title "Data Structures-Introduction"
    When user click on Time Complexity
    Then It should navigate to corresponding page with title "Time Complexity"
    When user click on Try here
    Then It should navigate to corresponding page with Title "Assessment"
    When user enter the invalid Python code
      | invalidPythoncode                    |
      | printlnn"DataStructure Introduction" |
    And user clicks run button
    Then user should get the alert message with text "SyntaxError: bad input on line 1"
    And user accepts the error
