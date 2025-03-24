Feature: Automation Pratice

  Scenario: Register User with existing email
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Signup / Login' button
    Then 'New User Signup!' should be displayed
    When the user enters a name and an already registered email address
    And clicks the 'Signup' button
    Then 'Email Address already exist!' should be displayed