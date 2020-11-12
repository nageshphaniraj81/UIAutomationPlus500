package libraries;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import testBase.DriverFactory;
import testBase.MyLogger;

/**
 * This is a Test Library for commonly used Selenium actions
 * 
 * @author Nagesh Phaniraj
 *
 */
public class TestLibrary {

	/**
	 * Customized sendkeys method-> To log sendkeys message for every occ.
	 * 
	 * @param element
	 *            : Webelement
	 * @param fieldName
	 *            : Name of the field
	 * @param valueToBeSent
	 *            : Value to be set in the edit field
	 */

	public void sendKeys_custom(WebElement element, String fieldName, String valueToBeSent) {
		try {
			element.sendKeys(valueToBeSent);
			MyLogger.info(fieldName + "==> Ented value as: " + valueToBeSent);
		} catch (Exception e) {
			MyLogger.error("Value enter in field: " + fieldName + " is failed due to exception: " + e);
		}
	}

	/**
	 * custom click method to log evey click action in to extent report
	 * 
	 * @param element
	 *            : Element to be clicked
	 * @param fieldName
	 *            : Name of the UI element to be clicked
	 */
	public void click_custom(WebElement element, String fieldName) {
		try {
			element.click();
			MyLogger.info(fieldName + "==> Clicked Successfully! ");
		} catch (Exception e) {
			MyLogger.error("Unable to click on field: " + fieldName + " due to exception: " + e);
		}
	}

	/**
	 * clear data from field
	 * 
	 * @param element
	 *            : Element to be cleared
	 * @param fieldName
	 *            : Name of the element to clear text
	 */
	public void clear_custom(WebElement element, String fieldName) {
		try {
			element.clear();
			Thread.sleep(250);
			MyLogger.info(fieldName + "==> Data Cleared Successfully! ");
		} catch (Exception e) {
			MyLogger.error("Unable to clear Data on field: " + fieldName + " due to exception: " + e);

		}
	}

	/**
	 * custom mouseHover
	 * 
	 * @param element
	 *            : Element to move to
	 * @param fieldName
	 *            : Name of the field to move cursor to
	 */
	public void moveToElement_custom(WebElement element, String fieldName) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) DriverFactory.getInstance().getDriver();
			executor.executeScript("arguments[0].scrollIntoView(true);", element);
			Actions actions = new Actions(DriverFactory.getInstance().getDriver());
			actions.moveToElement(element).build().perform();
			MyLogger.info(fieldName + "==> Mouse hovered Successfully! ");
			Thread.sleep(1000);
		} catch (Exception e) {
			MyLogger.error("Unable to hover mouse on field: " + fieldName + " due to exception: " + e);

		}
	}

	/**
	 * Select dropdown value value by visibleText
	 * 
	 * @param element
	 *            : Dropdown element
	 * @param fieldName
	 *            : Name of the dropdown element
	 * @param ddVisibleText
	 *            : Text to select from dropdown
	 * @throws Throwable
	 */
	public void selectDropDownByVisibleText_custom(WebElement element, String fieldName, String ddVisibleText)
			throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByVisibleText(ddVisibleText);
			MyLogger.info(fieldName + "==> Dropdown Value Selected by visible text: " + ddVisibleText);
		} catch (Exception e) {
			MyLogger.error("Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	/**
	 * Select dropdown value value by value
	 * 
	 * @param element
	 *            : Dropdown element
	 * @param fieldName
	 *            : Name of the dropdown element
	 * @param ddValue
	 *            : Text to select from dropdown
	 * @throws Throwable
	 */
	public void selectDropDownByValue_custom(WebElement element, String fieldName, String ddValue) throws Throwable {
		try {
			Select s = new Select(element);
			s.selectByValue(ddValue);
			MyLogger.info(fieldName + "==> Dropdown Value Selected by visible text: " + ddValue);
		} catch (Exception e) {
			MyLogger.error("Dropdown value not selected for field: " + fieldName + "  due to exception: " + e);
		}
	}

	/**
	 * String Asserts
	 * 
	 * @param expvalue
	 *            : Expected Value
	 * @param actualValue
	 *            : Actual Value
	 * @param locatorName
	 *            : Locator Name
	 * @throws Throwable
	 */
	public void assertEqualsString_custom(String expvalue, String actualValue, String locatorName) throws Throwable {
		try {
			if (actualValue.equals(expvalue)) {
				MyLogger.info("String Assertion is successful on field " + locatorName + " Expected value was: "
						+ expvalue + " actual value is: " + actualValue);
			} else {
				MyLogger.error("String Assertion FAILED on field " + locatorName + " Expected value was: " + expvalue
						+ " actual value is: " + actualValue);
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
			Assert.assertTrue(false, e.toString());
		}
	}

	/**
	 * Get text from webelement
	 * 
	 * @param element
	 *            : element to get text from
	 * @param fieldName
	 *            : Name of the element to get text
	 * @return
	 */
	public String getText_custom(WebElement element, String fieldName) {
		String text = "";
		try {
			text = element.getText();
			MyLogger.info(fieldName + "==> Text retried is: " + text);
			return text;
		} catch (Exception e) {
			MyLogger.error(fieldName + "==> Text not retried due to exception: " + e);

		}
		return text;
	}

	/**
	 * To check if Element is displayed
	 * 
	 * @param element
	 *            : element to check if it is displayed
	 * @param fieldName
	 *            : Name of the element
	 * @return
	 */
	public boolean isDisplayed(WebElement element, String fieldName) {
		try {
			if (element.isDisplayed()) {
				MyLogger.info("Element  " + fieldName + " is Displayed");
				return true;
			} else {
				MyLogger.info("Element  " + fieldName + " is Not Displayed");
				return false;
			}
		} catch (Exception e) {
			MyLogger.info("Element  " + fieldName + " is Not Displayed");
			return false;
		}
	}

}
