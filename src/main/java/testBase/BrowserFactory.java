package testBase;

import java.net.MalformedURLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	// Create WebDriver object for given browser
	public WebDriver createBrowserInstance(String browser) throws MalformedURLException {

		WebDriver driver = null;

		if (browser.equalsIgnoreCase("Chrome")) {

			// Using WebDriverManager for setting up Chrome driver
			WebDriverManager.chromedriver().setup();

			// To ensure browser starts in incognito mode
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("firefox")) {

			// Using WebDriverManager for setting up Firefox driver
			WebDriverManager.firefoxdriver().setup();

			// To ensure browser starts in private mode (Firefox)
			FirefoxOptions foptions = new FirefoxOptions();
			foptions.addArguments("-private");

			driver = new FirefoxDriver(foptions);
		}
		if (browser.equalsIgnoreCase("ie")) {

			// Using WebDriverManager for setting up Internet Explorer driver
			WebDriverManager.iedriver().setup();

			// To ensure browser starts in private mode (IE)
			InternetExplorerOptions iOptions = new InternetExplorerOptions();
			iOptions.addCommandSwitches("-private");

			driver = new InternetExplorerDriver(iOptions);
		}
		return driver;
	}

}
