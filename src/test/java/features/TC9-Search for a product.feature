Feature: Automation Pratice

  Scenario: Search for a product
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Products' button
    Then the user should be redirected to the ALL PRODUCTS page successfully
    When the user enters a product name in the search input and clicks the 'Search' button
    Then 'SEARCHED PRODUCTS' should be displayed
    And all products related to the search should be visible