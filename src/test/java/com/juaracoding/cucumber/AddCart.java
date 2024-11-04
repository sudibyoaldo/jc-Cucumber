package com.juaracoding.cucumber;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddCart {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private String homePagePrice;
    private String cartPagePrice;
    private static ExtentTest extentTest;


    public AddCart(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("The user add Product {string} to Cart in HomePage")
    public void add_product_to_cart(String productName){
        //Utils.delay(3);
        homePagePrice = "";
        switch (productName){
            case "BackPack":
                homePagePrice = homePage.getBackPackPrice();
                homePage.addBackpack();
                break;
            case "Bike Light":
                homePagePrice = homePage.getBikeLightPrice();
                homePage.addBikeLight();
                break;
            case "Tshirt":
                homePagePrice = homePage.getTShirtPrice();
                homePage.addTShirt();
                break;
            case "Jacket":
                homePagePrice = homePage.getJacketPrice();
                homePage.addJacket();
                break;
            case "OneSie":
                homePagePrice = homePage.getOneSiePrice();
                homePage.addOneSie();
                break;
            case "Red Tshirt":
                homePagePrice = homePage.getRedTshirtPrice();
                homePage.addRedTshirt();
                break;
        }
    }

    @When("The user klik Cart")
    public void the_user_klik_cart(){
        homePage.klikCart();
    }

    @And ("The user should see Product {string} in Cart")
    public void user_see_product_in_cart(String productName){
        //Utils.delay(3);
        cartPagePrice = "";
        switch (productName){
            case "BackPack":
                cartPagePrice = cartPage.getBackPackPrice();
                break;
            case "Bike Light":
                cartPagePrice = cartPage.getBikeLightPrice();
                break;
            case "Tshirt":
                cartPagePrice = cartPage.getTShirtPrice();
                break;
            case "Jacket":
                cartPagePrice = cartPage.getJacketPrice();
                break;
            case "OneSie":
                cartPagePrice = cartPage.getOneSiePrice();
                break;
            case "Red Tshirt":
                cartPagePrice = cartPage.getRedTshirtPrice();
                break;
        }
        Assert.assertEquals(homePagePrice,cartPagePrice);
    }

    @Then("The user klik Continue Shopping button")
    public void klik_continue_shopping_button()
    {
        cartPage.klikContinueShopping();
    }
}
