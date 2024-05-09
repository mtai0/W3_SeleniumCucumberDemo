Feature: Login to the site
  Scenario: Successful Login with Valid Credentials
    Given User is on homepage
    When User navigates to login page
    And User enters Username and Password
    Then Message displayed Login Successful