package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import libraries.TestLibrary;
import testBase.DriverFactory;
import utilities.PropertiesUtility;

/**
 * Page object class for Login Page
 * 
 * @author Nagesh Phaniraj
 *
 */
public class LoginScreenObject {

	@FindBy(how = How.ID, using = "demoMode")
	public WebElement demoModeButton;

	@FindBy(how = How.LINK_TEXT, using = "Already have an account?")
	public WebElement alreadyHaveAccountLink;

	@FindBy(how = How.ID, using = "newUserCancelExperiment")
	public WebElement loginTab;

	@FindBy(how = How.ID, using = "email")
	public WebElement emailEdit;

	@FindBy(how = How.ID, using = "password")
	public WebElement passwordEdit;

	@FindBy(how = How.ID, using = "submitLogin")
	public WebElement loginButton;

	public LoginScreenObject() {

		// Initialize elements of LoginScreenLocators using PageFactory
		PageFactory.initElements(DriverFactory.getInstance().getDriver(), this);
	}

	/**
	 * To login to Plus500 Application
	 * 
	 * @return LandingPageObject
	 * @throws InterruptedException
	 */
	public LandingPageObject loginToPlus500() throws InterruptedException {

		TestLibrary lib = new TestLibrary();

		// Click on Demo mode
		lib.click_custom(demoModeButton, "Demo Mode Button");

		// // Click on Login Tab
		try {
			if (lib.isDisplayed(loginTab, "Login Tab")) {
				lib.click_custom(loginTab, "Login Tab");
			}
		} catch (Exception e) {
			e.getMessage();
		}

		try {
			if (lib.isDisplayed(alreadyHaveAccountLink, "Already Have Account? - Link")) {
				lib.click_custom(alreadyHaveAccountLink, "Already Have Account? - Link");
			}
		} catch (Exception e) {
			e.getMessage();
		}

		// Enter Email ID
		String strUsername = PropertiesUtility.getPropertyValueByKey("username");
		lib.sendKeys_custom(emailEdit, "User Name", strUsername);

		// Enter Password
		String strPassword = PropertiesUtility.getPropertyValueByKey("password");
		lib.sendKeys_custom(passwordEdit, "Password", strPassword);

		// Click on Login Button
		lib.click_custom(loginButton, "Login");

		return new LandingPageObject();
	}

}
