package com.juaracoding.cucumber;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.utils.ScenarioTests;
import com.juaracoding.utils.Utils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Hooks {

    public static WebDriver driver;
    public static ExtentTest extentTest;
    public static ExtentReports reports = new ExtentReports("target/extent-report.html");

    @Before
    public static void setUp(){
        driver = DriverSingleton.getDriver();
        ScenarioTests[] tests = ScenarioTests.values();
        extentTest = reports.startTest(tests[Utils.testCount].getScenarioTestName());
        Utils.testCount++;
    }

    @AfterStep
    public void getResultTest(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            String screenshotPath = Utils.getScreenshot(driver,scenario.getName()
                    .replace(" ","_"));
            extentTest.log(LogStatus.FAIL,scenario.getName()+"\n"
                    +extentTest.addScreenCapture(screenshotPath));
        }else{
            extentTest.log(LogStatus.PASS,scenario.getName());
        }
    }

    @After
    public void endScenarioTest(){
        reports.endTest(extentTest);
        reports.flush();
    }

    @AfterAll
    public static void finish(){
        DriverSingleton.closeObjectInstance();
    }

}