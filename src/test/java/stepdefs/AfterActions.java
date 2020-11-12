package stepdefs;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import testBase.DriverFactory;
import testBase.TestBase;

public class AfterActions {

	@After
	public void tearDown(Scenario scenario) {
		TestBase tb = new TestBase();

		// Take screenshot in case of failure
		if (scenario.isFailed()) {
			byte[] screenshotBytes = ((TakesScreenshot) DriverFactory.getInstance().getDriver())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshotBytes, "image/png");
		}

		//To close the driver Instance
		tb.tearDown();
	}
}
