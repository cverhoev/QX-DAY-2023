package nl.sogeti.pageobjects.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/pageobjects", glue = {"nl.sogeti.pageobjects"})
public class TestRunner {
}
