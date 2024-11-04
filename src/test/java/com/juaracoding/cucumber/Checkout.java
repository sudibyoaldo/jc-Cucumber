package com.juaracoding.cucumber;

import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.CheckoutPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Checkout {
    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private String homePagePrice;
    private String cartPagePrice;
    private static ExtentTest extentTest;
    private double cartPriceTotal=0;
    private double reviewPriceTotal=0;


    public Checkout(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        checkoutPage = new CheckoutPage();
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("The user open cart")
    public void the_user_open_cart(){
        homePage.klikCart();
    }

    @When("The user click checkout button")
    public void the_user_click_checkout_button(){
        cartPriceTotal = cartPage.getPriceTotal();
        System.out.println("cartPriceTotal="+cartPriceTotal);
        cartPage.klikCheckout();
    }

    @And("The user input First Name {string}, Last Name {string} and Postal Code {string}")
    public void the_user_input_checkout_data(String firstName, String lastName, String postalCode){
        checkoutPage.clearPage();
        checkoutPage.inputData(firstName,lastName,postalCode);
    }

    @And("The user click continue button")
    public void the_user_click_continue_button(){
        checkoutPage.clickContinueBtn();
    }

    @Then("The user should see the error messages {string}")
    public void the_user_see_error_message(String errorMessage){
        Assert.assertEquals(checkoutPage.getTxtError(),errorMessage);
    }

    @And("The user should see checkout review")
    public void the_user_see_checkout_review(){
        reviewPriceTotal = checkoutPage.getPriceTotal();
        Assert.assertEquals(cartPriceTotal,reviewPriceTotal);
    }

    @And("The user click Finish button")
    public void the_user_click_finish_button(){
        checkoutPage.clickFinishButton();
    }

    @Then("The user see complete order message {string}")
    public void the_user_see_complete_order_message(String completeMessage){
        Assert.assertEquals(checkoutPage.getCompleteOrderMessage(),completeMessage);
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
    }

}
