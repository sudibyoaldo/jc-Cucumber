Feature: Checkout Feature
  Scenario Outline: Invalid Checkout Data
    Given The user open cart
    When The user click checkout button
    And The user input First Name "<firstName>", Last Name "<lastName>" and Postal Code "<postalCode>"
    And The user click continue button
    Then The user should see the error messages "<error_message>"

    Examples:
    |firstName|lastName|postalCode|error_message|
    |        |        |          |Error: First Name is required|
    |First Name|      |          |Error: Last Name is required|
    |          |Last Name|       |Error: First Name is required|
    |          |         |Postal Code|Error: First Name is required|
    |First Name|Last Name|           |Error: Postal Code is required|

  Scenario Outline: Valid Checkout Data
    Given The user open cart
    When The user click checkout button
    And The user input First Name "<firstName>", Last Name "<lastName>" and Postal Code "<postalCode>"
    And The user click continue button
    And The user should see checkout review
    And The user click Finish button
    Then The user see complete order message "<completeMessage>"

    Examples:
      |firstName|lastName|postalCode|completeMessage|
      |First Name|Last Name|A1500  |Thank you for your order!|
