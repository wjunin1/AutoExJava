Feature: Automation Pratice

  Scenario: Logout User
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Signup / Login' button
    Then 'Login to your account' should be displayed
    When the user enters a correct email address and password
    And And clicks the 'Login' button
    Then 'Logged in as ' should be displayed
    When the user clicks the 'Logout' button
    Then the user should be redirected to the login page