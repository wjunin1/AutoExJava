Feature: Automation Pratice

  Scenario: Login User with correct email and password
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Signup / Login' button
    Then 'Login to your account' should be displayed
    When the user enters a correct email address and password
    And And clicks the 'Login' button
    Then 'Logged in as ' should be displayed
#    When the user clicks the 'Delete Account' button
#    Then 'Account Deleted!' should be displayed
#    And the user clicks the 'Continue' button