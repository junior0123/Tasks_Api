package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty:target/cucumber-html-report.html", "json:target/cucmber-report.json"},
features="src/test/resources", glue = {"steps", "hooks"})
public class Runner {
}
