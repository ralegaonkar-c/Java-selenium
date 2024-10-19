package org.finsys.finance.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"org.finsys.finance.stepDefinitions", "org.finsys.finance.driver"},
    plugin = {"pretty", "html:target/cucumber-reports"},
    monochrome = true,
    name = "Verify Creation of a New Company by passing all Valid Details"
)
public class TestRunner {
}
