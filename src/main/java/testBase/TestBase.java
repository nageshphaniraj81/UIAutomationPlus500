package testBase;

import java.util.concurrent.TimeUnit;

import utilities.PropertiesUtility;

public class TestBase {
	BrowserFactory bf = new BrowserFactory();

	public void LaunchApplication() throws Exception {
		String browser = PropertiesUtility.getPropertyValueByKey("browser");
		String url = PropertiesUtility.getPropertyValueByKey("url");

		DriverFactory.getInstance().setDriver(bf.createBrowserInstance(browser));
		DriverFactory.getInstance().getDriver().manage().window().maximize();
		DriverFactory.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverFactory.getInstance().getDriver().navigate().to(url);
	}

	public void tearDown() {
		DriverFactory.getInstance().closeBrowser();
	}
}
