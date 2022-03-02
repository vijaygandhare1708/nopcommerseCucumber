package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(strict = true, dryRun = false, monochrome = true, features = {".//src/test/java/features/Login.feature",".//src/test/java/features/Customers.feature"}, plugin = {
		"pretty", "html:test-output" }, glue = { "stepDefinitions" })
//tags= {"@SearchCustomer"})
//features="src/test/java/features/"
public class TestRun {

}
