@wip
Feature: Create Car

  Background:

    Given the user is on the login page
    When the user logs in using following credentials "storemanager51" and "UserUser123"
    And the user navigates to "Fleet" "Vehicles"

  Scenario: Create car as a Store Manager

    Then the user clicks on Create Car button
    And the user enters new Car information
    Then the user clicks on save changes button









