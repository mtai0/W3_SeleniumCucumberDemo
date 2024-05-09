Feature: Login with multiple usernames and passwords
  Scenario Outline: Successful login with valid credentials
    Given User is on homepage
    When User navigates to login page
    And User enters "<username>" and "<password>"
    Then Message displayed Login Successful
    Examples:
      | username | password |
      | testuser_1 | Test@153 |
      | testuser_2 | Test@153 |