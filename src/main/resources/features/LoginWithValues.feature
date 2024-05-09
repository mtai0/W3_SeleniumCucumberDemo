Feature: Login to the site
  Scenario: Successful Login with Valid Credentials
    Given User is on homepage
    When User navigates to login page
    And User enters "testuser" and "Password@123"
    Then Message displayed Login Successful