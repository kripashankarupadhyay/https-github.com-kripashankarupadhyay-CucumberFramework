#Author: Aashish Pardeshi.


Feature: Verify all the Scenarios for Login.
  I want to use this template to Verify the Login Functinality.

  @Regression
  Scenario Outline: Verify the Login with "<testcase>"
    Given Open "<Browser>" and  Open "<website>"
    When User navigate to login page
    Then User enter the valid "<username>" and "<password>"
    Then Verify User should be "<status>"
    Then Close the browser
    Examples: 
  | Browser | website                               |                             testcase| username             | password | status   |
  | chrome  | https://www.medicalscrubsmall.com/en/ |                     validcredentials| test_aashish@test.in | test12345| LOGIN    |
  | chrome  | https://www.medicalscrubsmall.com/en/ |                   invalidcredentials| invalid@test.in      | wrongpas | NOT LOGIN|
  | chrome  | https://www.medicalscrubsmall.com/en/ |  Valid_UserName and Invalid_Password| test_aashish@test.in | wrongpas | NOT LOGIN|
  | chrome  | https://www.medicalscrubsmall.com/en/ |  Invalid_UserName and Valid_Password| invalid@test.in      | test12345| NOT LOGIN|
