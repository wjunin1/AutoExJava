Feature: Automation Pratice

  Scenario: Verify Subscription in the home page
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user scrolls down to the footer
    Then 'SUBSCRIPTION' should be displayed
    When the user enters an email address in the input field and clicks the 'Subscribe' button
    Then 'You have been successfully subscribed!' should be displayed