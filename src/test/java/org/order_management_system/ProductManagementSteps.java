package org.order_management_system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.*;

public class ProductManagementSteps {

    @Autowired
    private ProductService productService;

    private Product testProduct;
    private Product resultProduct;

    @Given("I have a product named {string}")
    public void i_have_a_product_named(String productName) {
        testProduct = new Product();
        testProduct.setName(productName);
    }

    @When("I create the product")
    public void i_create_the_product() {
        resultProduct = productService.saveProduct(testProduct);
    }

    @Then("the product should be saved successfully")
    public void the_product_should_be_saved_successfully() {
        assertNotNull(resultProduct);
        assertEquals(testProduct.getName(), resultProduct.getName());
    }

    @Given("there is a product with ID {long}")
    public void there_is_a_product_with_ID(Long productId) {
        resultProduct = productService.getProductById(productId);
        testProduct = productService.getProductById(productId);
    }

    @When("I retrieve the product")
    public void i_retrieve_the_product() {
        assertNotNull(resultProduct);
    }

    @Then("the product should be returned with the correct details")
    public void the_product_should_be_returned_with_the_correct_details() {
        assertEquals(testProduct.getName(), resultProduct.getName());
    }

    @When("I update the product with a new name {string}")
    public void i_update_the_product_with_new_name(String newName) {
        resultProduct.setName(newName);
        productService.updateProduct(resultProduct);
    }

    @Then("the product should be updated successfully")
    public void the_product_should_be_updated_successfully() {
        assertEquals("Product B", resultProduct.getName());
    }

    @When("I delete the product")
    public void i_delete_the_product() {
        productService.deleteProduct(resultProduct.getId());
    }

    @Then("the product should be removed from the database")
    public void the_product_should_be_removed_from_the_database() {
        assertNull(productService.getProductById(resultProduct.getId()));
    }
}

