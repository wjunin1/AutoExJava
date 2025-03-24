Feature: Automation Pratice

  Scenario: Verify Test Cases Page
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Test Cases' button
    Then the user should be redirected to the Test Cases page successfully