@Sanity
Feature: Login Feature Scenario

  Scenario: The scenario is to define positive case for login path
    Given I have launched the application
    When I enter username as "standard_user" and password as "secret_sauce"
    And I Click the Login Button
    Then I should land on the home page

  Scenario: This scenario is to define failure path.
    Given I have launched the application
    When I enter username as "standard_user" and password as "Abcd@12344"
    And I Click the Login Button
    Then I should get error message "Epic sadface: Username and password do not match any user in this service"
