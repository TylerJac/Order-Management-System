package org.order_management_system;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources",
        glue = "org.order_management_system"  // Replace with your package for step definitions
)
public class CucumberTest {
}

