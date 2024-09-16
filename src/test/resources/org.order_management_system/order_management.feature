Feature: Order Management

  Scenario: Create a new order
    Given I have an order with order number "ORD123"
    When I create the order
    Then the order should be saved successfully

  Scenario: Retrieve an order by ID
    Given there is an order with ID 3
    When I retrieve the order
    Then the order should be returned with the correct details

  Scenario: Update an existing order
    Given there is an order with ID 3
    When I update the order with a new order number "ORD456"
    Then the order should be updated successfully

  Scenario: Delete an order by ID
    Given there is an order with ID 3
    When I delete the order
    Then the order should be removed from the database

