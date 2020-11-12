package testBase;

import com.cucumber.listener.ExtentCucumberFormatter;

public class ExtentFactory {

	// private constructor so that no one else can create object of this class
	private ExtentFactory() {

	}

	private static ExtentFactory instance = new ExtentFactory();

	public static ExtentFactory getInstance() {
		return instance;
	}

	// factory design pattern
	ThreadLocal<ExtentCucumberFormatter> extent = new ThreadLocal<ExtentCucumberFormatter>();

	public ExtentCucumberFormatter getExtent() {
		return extent.get();
	}

	public void setExtent(ExtentCucumberFormatter extentTestObject) {
		extent.set(extentTestObject);
	}

	public void removeExtentObject() {
		extent.remove();
	}
}
