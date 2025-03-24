Feature: Automation Pratice

  Scenario: Verify All Products and product detail page
    Given the user navigates to the URL 'http://automationexercise.com'
    Then the home page should be displayed successfully
    When the user clicks the 'Products' button
    Then the user should be redirected to the ALL PRODUCTS page successfully
    And the products list should be visible
    When the user clicks the 'View Product' button for the first product
    Then the user should be redirected to the product detail page
    And the product details should be displayed: name, category, price, availability, condition, brand
