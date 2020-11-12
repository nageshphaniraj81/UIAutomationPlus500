package runner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import testBase.ExtentReporter;


@CucumberOptions(plugin = { "pretty", "json:target/RunCuke/cucumber.json",
		                     "html:target/RunCuke/cucumber.html",
		                     "com.cucumber.listener.ExtentCucumberFormatter" },
                             features = "src/test/java/features", glue = "stepdefs",
                             tags = {"@Price-Range" }, monochrome = true, strict = true, dryRun = false)

public class RunCuke extends AbstractTestNGCucumberTests {
	@BeforeClass
	public static void setup() {
		try {
			ExtentReporter.setupExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {}

}
