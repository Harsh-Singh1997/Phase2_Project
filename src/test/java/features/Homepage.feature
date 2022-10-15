Feature: Homepage Feature Scenario

  Background: 
    Given I have launched the application
    And I enter username as "standard_user" and password as "secret_sauce"
    And I Click the Login Button

  @Regression
  Scenario: I need to add product in cart from homepage
    When I click on Add to Cart of "Sauce Labs Backpack"
    Then Cart value increased
