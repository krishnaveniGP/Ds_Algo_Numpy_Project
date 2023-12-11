@logIn
Feature: Login Action

  Background: 
    Given The User opens  DS Algo portal Page
    When User click on Get Started button
#signin
  Scenario: User is on Home page and Clicks on Signins
    Given user is on Home Page
    When user clicks on SignIn button he is directed to login page
    Then user validates the login page

  Scenario: To verify SignIn with Empty fields
    Given User is on Login page
    When User clicks on login button with all empty field
    Then User verify the message at username as "Please fill out this field."

  Scenario: User is on Home page and Clicks on Register
    Given user is on Home Page
    When user clicks on Register button he is directed to register page
    Then user validates the register page

  Scenario Outline: To verify SignIn with invalid "<username>" and "<password>"
    Given User is on Login page
    When User enters invalid username as "<username>" and password as "<password>"
    Then User verify the message as "Invalid Username and Password"

    Examples: 
      | username | password |
      | abcdefgh | zxyu1234 |
      | asdfger  | @@@@     |
      | ER@$     | sdkfsk12 |

  Scenario Outline: User  Login with  valid "<username>" and "<password>"
    Given User is on Login page
    When User enters valid username "<username>" and password "<password>"
    Then It should navigate to the home page with a message "You are logged in"

    Examples: 
      | username | password   |
      | queen    | ninjaqueen |

  Scenario: To verify SignIn with username only
    Given User is on Login page
    When User clicks on login button with username as "numpy" only
    Then User verify the message at password as "Please fill out this field."

  Scenario: To verify SignIn with password only
    Given User is on Login page
    When User clicks on login button with password as "numpy" only
    Then User verify the message at user as "Please fill out this field."

  @logout
  Scenario: Successful LogOut
    When User clicks on signout
    Then Message displayed "Logged out successfully"
