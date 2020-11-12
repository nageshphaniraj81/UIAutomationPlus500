package testBase;

import java.io.File;
import java.text.SimpleDateFormat;

import com.cucumber.listener.ExtentCucumberFormatter;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ExtentReporter {
	static ExtentCucumberFormatter extent;

	public static ExtentCucumberFormatter setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		String reportPath = System.getProperty("user.dir") + "/target/Extent_Reports/ExecutionReport_" + actualDate
				+ ".html";
		File newFile = new File(reportPath);
		extent = new ExtentCucumberFormatter();

		ExtentCucumberFormatter.initiateExtentCucumberFormatter(newFile, false);

		// Loads the extent config xml to customize on the report.
		ExtentCucumberFormatter.loadConfig(new File("src/test/resources/extent-config.xml"));

		// User can add the system information as follows
		ExtentCucumberFormatter.addSystemInfo("Browser Name", "Chrome");
		ExtentCucumberFormatter.addSystemInfo("Browser version", "v57.0");
		ExtentCucumberFormatter.addSystemInfo("Selenium version", "v3.1.0");

		// Also you can add system information using a hash map
		Map<String, String> systemInfo = new HashMap<String, String>();
		systemInfo.put("Cucumber version", "v1.2.3");
		systemInfo.put("Extent Cucumber Reporter version", "v1.1.0");
		ExtentCucumberFormatter.addSystemInfo(systemInfo);

		return extent;

	}
}
