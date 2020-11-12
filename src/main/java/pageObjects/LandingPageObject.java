package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraries.TestLibrary;
import testBase.DriverFactory;

/**
 * Page object class for Landing Page
 * 
 * @author Nagesh Phaniraj
 *
 */
public class LandingPageObject {

	private static TestLibrary lib = new TestLibrary();

	@FindBy(how = How.ID, using = "main-search-input")
	public WebElement searchFieldEdit;

	@FindBy(how = How.XPATH, using = "//button/span[text()='Sell']/following-sibling::span")
	public WebElement sellPriceLabel;

	@FindBy(how = How.XPATH, using = "//button/span[text()='Buy']/following-sibling::span")
	public WebElement buyPriceLabel;

	public LandingPageObject() {

		// Initialize elements of LoginScreenLocators using PageFactory
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	/**
	 * To Search for currency in currency field
	 * 
	 * @param strCurrency
	 *            : Currency to search
	 * @throws InterruptedException
	 */
	public void searchCurrency(String strCurrency) throws InterruptedException {
		try {
			// To search for required currency in landing page
			WebDriverWait wait = new WebDriverWait(DriverFactory.getInstance().getDriver(), 30);
			WebElement eleSearchField = wait.until(ExpectedConditions.visibilityOf(searchFieldEdit));
			Thread.sleep(3000);
			lib.sendKeys_custom(eleSearchField, "Search", strCurrency);
			Thread.sleep(3000);
			eleSearchField.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			e.getStackTrace();
		}

	}

	/**
	 * To check if sell price is displayed
	 * 
	 * @return True if displayed and false otherwise
	 */
	public boolean isSellPriceDisplayed() {
		try {
			if (getSellPrice().length() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * To check if Buy Price is displayed
	 * 
	 * @return True if displayed and false otherwise
	 */
	public boolean isBuyPriceDisplayed() {
		try {
			if (getBuyPrice().length() > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * To get sell price
	 * 
	 * @return Sell Price String value if displayed and null otherwise
	 */
	public String getSellPrice() {
		try {
			return lib.getText_custom(sellPriceLabel, "Sell Price");
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * To get buy price
	 * 
	 * @return Sell Price String value if displayed and null otherwise
	 */
	public String getBuyPrice() {
		try {
			return lib.getText_custom(buyPriceLabel, "Buy Price");
		} catch (Exception e) {
			e.getStackTrace();
			return null;
		}
	}

	/**
	 * To check if price is a decimal value
	 * 
	 * @param strPrice
	 *            : Price to be checked
	 * @return True if value is decimal else return false
	 */
	public boolean checkifPriceisDecimalValue(String strPrice) {
		try {
			Boolean isDecimal;
			try {
				Double num = Double.parseDouble(strPrice);
				isDecimal = true;
			} catch (Exception e) {
				isDecimal = false;
			}
			return isDecimal;
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * To check if price is in the specified range
	 * 
	 * @param strMinRange
	 * @param strMaxRange
	 * @return True if the price is in the range else false
	 */
	public boolean checkPriceRange(String strMinRange, String strMaxRange) {
		try {
			LandingPageObject la = new LandingPageObject();
			String strSellPrice = la.getSellPrice();
			String strBuyPrice = la.getBuyPrice();
			if (checkifPriceisDecimalValue(strSellPrice) && checkifPriceisDecimalValue(strBuyPrice)) {
				if (la.checkRange(Double.parseDouble(strSellPrice), Double.parseDouble(strMinRange),
						Double.parseDouble(strMaxRange))
						&& la.checkRange(Double.parseDouble(strBuyPrice), Double.parseDouble(strMinRange),
								Double.parseDouble(strMaxRange))) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		} catch (Exception e) {
			e.getStackTrace();
			return false;
		}
	}

	/**
	 * To check if 2 decimal numbers are is specified range
	 * 
	 * @param numberToCheck
	 * @param bottom
	 * @param top
	 * @return
	 */
	private boolean checkRange(double numberToCheck, double bottom, double top) {
		return (numberToCheck >= bottom && numberToCheck <= top);
	}

}
