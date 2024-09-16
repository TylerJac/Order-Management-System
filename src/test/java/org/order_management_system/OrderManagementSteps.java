package org.order_management_system;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources")
@CucumberContextConfiguration
@SpringBootTest
public class OrderManagementSteps {

    @Autowired
    private OrderService orderService;

    private Order testOrder;
    private Order resultOrder;

    @Given("I have an order with order number {string}")
    public void i_have_an_order_with_order_number(String orderNumber) {
        testOrder = new Order();
        testOrder.setOrderNumber(orderNumber);
    }

    @When("I create the order")
    public void i_create_the_order() {
        resultOrder = orderService.saveOrder(testOrder);
    }

    @Then("the order should be saved successfully")
    public void the_order_should_be_saved_successfully() {
        assertNotNull(resultOrder);
        assertEquals(testOrder.getOrderNumber(), resultOrder.getOrderNumber());
    }

    @Given("there is an order with ID {long}")
    public void there_is_an_order_with_ID(Long orderId) {
        resultOrder = orderService.getOrderById(orderId);
        testOrder = orderService.getOrderById(orderId);
        assertNotNull(resultOrder, "Order not found with ID: " + orderId);

    }

    @When("I retrieve the order")
    public void i_retrieve_the_order() {
        assertNotNull(resultOrder);
    }

    @Then("the order should be returned with the correct details")
    public void the_order_should_be_returned_with_the_correct_details() {

        assertEquals(testOrder.getOrderNumber(), resultOrder.getOrderNumber());
    }

    @When("I update the order with a new order number {string}")
    public void i_update_the_order_with_new_order_number(String newOrderNumber) {
        resultOrder.setOrderNumber(newOrderNumber);
        orderService.updateOrder(resultOrder);
    }

    @Then("the order should be updated successfully")
    public void the_order_should_be_updated_successfully() {
        assertEquals("ORD456", resultOrder.getOrderNumber());
    }

    @When("I delete the order")
    public void i_delete_the_order() {
        orderService.deleteOrder(resultOrder.getId());
    }

    @Then("the order should be removed from the database")
    public void the_order_should_be_removed_from_the_database() {
        assertNull(orderService.getOrderById(resultOrder.getId()));
    }
}

