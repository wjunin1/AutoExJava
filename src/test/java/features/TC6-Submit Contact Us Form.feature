Feature: Automation Pratice

  Scenario: Submit Contact Us Form
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Contact Us' button
    Then 'GET IN TOUCH' should be displayed
    When the user fills in the contact form with name, email, subject, and message
    And uploads a file
    And clicks the 'Submit' button
    And confirms the alert
    Then 'Success! Your details have been submitted successfully.' should be displayed
    When the user clicks the 'Home' button
    Then the user should be redirected to the home page successfully