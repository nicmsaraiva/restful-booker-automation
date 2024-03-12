package com.nicmsaraiva.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        dryRun = false,
        tags = "@e2e",
        features = "src/test/resources/features",
        glue = "com.nicmsaraiva.stepDefinitions",
        plugin = {"pretty", "html:target/cucumber-reports"},
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Runner {
}
