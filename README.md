# UIAutomationPlus500

UI Automation of Plus500 web application

Automation Framework Features : 
--------------------------------------------------------------------------------
1. This framework is Maven integrated and developed using Java 8 and Cucumber-JVM.

2. It makes use of "ThreadLocal" Class enabling thread safety for parallel execution.

3. Designed using Page Object Model and Page Factory.

4. Thread Safe logging using Log4J, both console and File logging is enabled (can disable either of them in log4j2.xml)

5. Makes use of Extent Report for reporting, automatic screenshot capture in case of failures

6. Compatible to run the tests on Chrome, Mozilla Firefox & Internet Explorer (We can set desired browser in Config.Properties)

7. Includes library class (TestLibrary.java) that has common methods used across the test cases to interact with UI elements 
Example : Click, Move to Element, Select Dropdown, is Element displayed, Clear text field, Enter Values into text etc.

8. Cucumber Hooks have been implemented for initialization and teardown operations.  

9. Utilities have been included to interact and retrieve data from DB (MySQL) & Properties file

10. UI Flow is documented using Gherkin feature file with Example tables parameterizing Currency Pairs & Price Range. 
It includes 3 Positive Scenario and 1 negative Scenario (to demonstrate screencapture during failure)  
 
I have also added Sample Report & video recording of test automation execution (under project directory -> Information folder)for reference 
