package com.juaracoding.cucumber;

import com.juaracoding.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginTest {

    private static WebDriver driver;
    private static LoginPage loginPage;
    private static ExtentTest extentTest;


    public LoginTest(){
        loginPage = new LoginPage();
        this.driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @Given("The user navigates to the SauceDemo login page")
    public void The_user_navigates_to_the_SauceDemo_login_page(){
        driver.get("https://www.saucedemo.com/");
    }

    @When("The user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password){
        loginPage.clearPage();
        loginPage.login(username, password);
    }

    @And("The user clicks on the login button")
    public void the_user_clicks_on_the_login_button(){
        loginPage.loginbtn();
    }

    @Then("The user should see the error message {string}")
    public void the_user_should_see_the_error_message(String error){
        Assert.assertEquals(loginPage.getTxtError(), error);
    }

    @Then("The user should move to HomePage URL")
    public void the_user_should_move_to_homepage_url(){
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }

}
