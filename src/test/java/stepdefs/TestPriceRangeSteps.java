package stepdefs;

import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.*;
import testBase.MyLogger;

public class TestPriceRangeSteps {

	LoginScreenObject LoginScreenActions = new LoginScreenObject();
	LandingPageObject LandingPageActions;

	@Given("^I login to Plus500 application$")
	public void i_login_to_Plus_application() throws Throwable {
		MyLogger.startTestCase();
		MyLogger.info("Logging into Application");
		LandingPageActions = LoginScreenActions.loginToPlus500();
	}

	@When("^I select (.*) currency pair from search menu$")
	public void i_select_currency_pair_from_search_menu(String strCurrency) throws Throwable {
		MyLogger.info("Selecting following currency from the Search Menu " + strCurrency);
		LandingPageActions.searchCurrency(strCurrency);
	}

	@Then("^I should see Sell and Buy Prices$")
	public void i_should_see_Sell_and_Buy_Prices() throws Throwable {
		MyLogger.info("Checking if Buy and Sell prices are displayed");
		Assert.assertTrue(LandingPageActions.isBuyPriceDisplayed());
		Assert.assertTrue(LandingPageActions.isSellPriceDisplayed());
	}

	@Then("^I verify both Buy and Sell Prices are proper decimal numbers$")
	public void i_verify_both_Buy_and_Sell_Prices_are_proper_decimal_numbers() throws Throwable {
		MyLogger.info("Checking if Buy and Sell prices are proper decimal numbers");
		Assert.assertTrue(LandingPageActions.checkifPriceisDecimalValue(LandingPageActions.getSellPrice()));
		Assert.assertTrue(LandingPageActions.checkifPriceisDecimalValue(LandingPageActions.getBuyPrice()));
	}

	@Then("^I verify both Buy and Sell Prices are in the range (.*) to (.*)$")
	public void i_verify_both_Buy_and_Sell_Prices_are_in_the_range_to(String strMinRange, String strMaxRange)
			throws Throwable {
		MyLogger.info("Checking if Buy and Sell prices are in the range " + strMinRange + " - " + strMaxRange);
		Assert.assertTrue(LandingPageActions.checkPriceRange(strMinRange, strMaxRange));
	}

}
