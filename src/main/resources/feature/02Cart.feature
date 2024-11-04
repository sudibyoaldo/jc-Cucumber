Feature: Add Product to Cart

  Scenario Outline: Add Product to Cart
    Given The user add Product "<productName>" to Cart in HomePage
    When The user klik Cart
    And The user should see Product "<productName>" in Cart
    Then The user klik Continue Shopping button

    Examples:
    |productName|
    |BackPack|
    |Bike Light|
    |Tshirt|
    |Jacket|
    |OneSie|
    |Red Tshirt|
