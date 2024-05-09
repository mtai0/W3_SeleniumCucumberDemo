Feature: Log out of the site
  Background: User is logged in
    Given user is on the site homepage
    When user navigates to the login page
    And user enters "testuser_1" and "Test@123"
    Then user is logged in

  Scenario: Successful Logout for Logged In User
    Given user is on their profile page
    When user clicks the logout button
    Then user is logged out