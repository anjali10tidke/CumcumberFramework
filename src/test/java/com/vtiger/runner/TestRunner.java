package com.vtiger.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue ="com.vtiger.stepsdefination",
        dryRun = false,
        plugin ={ "pretty", "html:target/cucumber-reports/cucumber_report.html" },
        tags = "@cl"
      )
public class TestRunner {


}
