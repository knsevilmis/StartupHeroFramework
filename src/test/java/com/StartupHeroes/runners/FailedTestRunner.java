package com.StartupHeroes.runners;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {"html:target/failed-html-report"},
        features = "@target/rerun.txt",
        glue = "com/StartupHeroes/StepDefinitions"

)
public class FailedTestRunner {
}