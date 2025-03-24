Feature: Automation Pratice

Scenario: Login User with incorrect email and password
Given the user navigates to the URL 'http://automationexercise.com'
Then the home page should be displayed successfully
When the user clicks the 'Signup / Login' button
Then 'Login to your account' should be displayed
When the user enters an incorrect email address and password
And clicks the 'Login' button
Then 'Your email or password is incorrect!' should be displayed