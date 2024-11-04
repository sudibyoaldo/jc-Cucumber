package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import io.cucumber.java.de.Wenn;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage {
    private WebDriver driver;

    public CheckoutPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstName;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastName;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCode;
    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtError;
    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement clearBtnError;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement continueBtn;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement priceTotal;
    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;
    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement completeOrderMessage;

    public void inputData(String firstName, String lastName, String postalCode){
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postalCode.sendKeys(postalCode);
    }
    public void clearBtnError(){
        clearBtnError.click();
    }

    public void clearPage(){
        this.firstName.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        this.lastName.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        this.postalCode.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }
    public void clickContinueBtn(){
        continueBtn.click();
    }
    public String getTxtError(){
        return txtError.getText();
    }

    public double getPriceTotal(){

        return Double.parseDouble(priceTotal.getText().replaceAll("Item total: \\$",""));
    }

    public void clickFinishButton(){
        finishBtn.click();
    }

    public String getCompleteOrderMessage(){
        return completeOrderMessage.getText();
    }
}
