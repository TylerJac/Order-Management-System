Feature: Product Management

  Scenario: Create a new product
    Given I have a product named "Product A"
    When I create the product
    Then the product should be saved successfully

  Scenario: Retrieve a product by ID
    Given there is a product with ID 3
    When I retrieve the product
    Then the product should be returned with the correct details

  Scenario: Update an existing product
    Given there is a product with ID 3
    When I update the product with a new name "Product B"
    Then the product should be updated successfully

  Scenario: Delete a product by ID
    Given there is a product with ID 3
    When I delete the product
    Then the product should be removed from the database
