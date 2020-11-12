@Price-Range
Feature: To test price range of GBP/USD currency pair are proper decimal numbers in the specified range

  @Regression
  Scenario Outline: Validate if Buy and Sell Price of Currency <Currency> are in the range <MinRange> to <MaxRange>
    Given I login to Plus500 application
    When I select <Currency> currency pair from search menu
    Then I should see Sell and Buy Prices
    And I verify both Buy and Sell Prices are proper decimal numbers
    And I verify both Buy and Sell Prices are in the range <MinRange> to <MaxRange>

    Examples: 
      | Currency | MinRange | MaxRange |
      | GBP/USD  |      1.2 |      1.4 |
      | GBP/NZD  |      1.2 |      2.6 |
      | GBP/JPY  |    130.0 |    140.4 |
      | USD/HKD  |      5.2 |      6.0 |
