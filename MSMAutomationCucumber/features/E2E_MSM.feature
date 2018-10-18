#Author: Aashish Pardeshi.

Feature: Test End to End Flow of MSM.

  @EndToEnd
  Scenario Outline: Verify Buy Product with login user.
    Given Open "<Browser>" and  Open "<website>"
    When User navigate to login page
    Then User enter the valid "<username>" and "<password>"
    Then User should be successully login
    When User navigate to category page "<Menu>" and "<SubMenu>"
    Then User should navigate to right category page
    Then Click on first product
    Then User should move to same product page
    When User add product to cart
    Then Product should add in minicart
    When User move to MyCart page
    Then User can see added product on
    When Click on checkout button
    Then User navigate to shipping page
    When Click on Proceed to Payment button
    Then User navigate to Payment page
    Then Fill all card details "<CardNumber>","<CartType>" and "<Month>" and "<Year>" and "<SecurityCode>"
    Then Click on Review Order button
    Then User navigate to Review and Place Order page
    Then Validate the Amount and Product
    When LogOut from MSM
    Then Validate the successfully logout
    Then Close the browser

    Examples: 
      | Browser | website                               | username             | password  | Menu  | SubMenu | CardNumber       | CartType | Month | Year | SecurityCode |
      | chrome  | https://www.medicalscrubsmall.com/en/ | test_aashish@test.in | test12345 | BRANDS | Barco   |4111111111111111  | VISA     |     2 | 2020 |          123 |
