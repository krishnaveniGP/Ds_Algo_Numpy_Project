@login
Feature: login feature

  Scenario Outline: User  Login with  valid "<username>" and "<password>"
    Given User is on Login page
    When User enters valid username "<username>" and password "<password>"
    Then It should navigate to the home page with a message " You are logged in  "

    Examples: 
      | username | password   |
      | queen    | ninjaqueen |
