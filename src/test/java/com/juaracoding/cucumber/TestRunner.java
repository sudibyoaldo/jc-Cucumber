package com.juaracoding.cucumber;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.Utils;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

@CucumberOptions(features = {"src/main/resources/feature"},
        glue = "com.juaracoding.cucumber",
        plugin = {"pretty","html:target/cucumber-report.html","json:target/cucumber-report.json"}
)
public class TestRunner extends AbstractTestNGCucumberTests{
    @BeforeTest
    @Parameters("Browser")
    public void test(String browser){
        DriverSingleton.getInstance(browser);
    }
    @AfterTest
    public static void finish(){
        //Utils.delay(5);
        DriverSingleton.closeObjectInstance();
    }

}
