package testBase;

import org.openqa.selenium.WebDriver;

public class DriverFactory {
	
	// private constructor so that no one else can create object of this class
	private DriverFactory() {

	}

	// Creating private instance of the current class
	private static DriverFactory instance = new DriverFactory();

	// Returns the instance of current class
	public static DriverFactory getInstance() {
		return instance;
	}

	// Factory design pattern
	// To enable Thread Safe Multithreading useful for parallel execution	
	ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

	//Get the respective driver object
	public WebDriver getDriver() {
		return driver.get();
	}

	// Set the WebDriver to Threadlocal Hashmap
	public void setDriver(WebDriver driverParm) {
		driver.set(driverParm);
	}

	// To close current driver instanse
	public void closeBrowser() {
		driver.get().quit();
		driver.remove();
	}
}
