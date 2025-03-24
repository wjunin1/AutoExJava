Feature: Automation Pratice

  Scenario: Register new user successfully and delete account
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Signup / Login' button
    Then 'New User Signup!' should be displayed
    When the user enters a name and email address
    And clicks the Signup button
    Then 'Enter Account Information' should be displayed
    When the user fills in the details: Title, Name, Email, Password, Date of birth
    And selects the checkbox 'Sign up for our newsletter!'
    And selects the checkbox 'Receive special offers from our partners!'
    And fills in the details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
    And clicks the Create Account button
    Then 'Account Created!' should be displayed
    When the user clicks the 'Continue' button
    Then 'Logged in as ' should be displayed
    When the user clicks the 'Delete Account' button
    Then 'Account Deleted!' should be displayed
    And the user clicks the 'Continue' button