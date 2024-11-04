Feature: Login to SauceDemo

  Scenario Outline: Invalid login scenarios
    Given The user navigates to the SauceDemo login page
    When The user enters username "<username>" and password "<password>"
    And The user clicks on the login button
    Then The user should see the error message "<error_message>"

    Examples:
      | username          | password       | error_message           |
      |                   |                |Epic sadface: Username is required|
      |EmptyPassword      |                |Epic sadface: Password is required |
      |                   |EmptyUsername   |Epic sadface: Username is required |
      |InvalidUsername    |secret_sauce    |Epic sadface: Username and password do not match any user in this service|
      |standard_user      |InvalidPassword |Epic sadface: Username and password do not match any user in this service|

  Scenario Outline: Valid login scenarios
    Given The user navigates to the SauceDemo login page
    When The user enters username "<username>" and password "<password>"
    And The user clicks on the login button
    Then The user should move to HomePage URL

    Examples:
      | username                | password     |
      | standard_user           | secret_sauce |