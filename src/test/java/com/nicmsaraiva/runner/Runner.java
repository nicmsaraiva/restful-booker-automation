package com.nicmsaraiva.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        features = "src/test/resources/features",
        glue = "com.nicmsaraiva.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"}
)
public class Runner {
}
