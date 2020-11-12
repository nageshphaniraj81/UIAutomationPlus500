package stepdefs;

import cucumber.api.java.Before;
import testBase.MyLogger;
import testBase.TestBase;

public class BeforeActions {

	@Before
	public void LaunchApplication() throws Exception {
		TestBase tb = new TestBase();
		tb.LaunchApplication();
	}
}
