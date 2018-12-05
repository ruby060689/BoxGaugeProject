package com.box.steps;

import com.box.driver.DriverClass;
import com.thoughtworks.gauge.*;
import org.openqa.selenium.WebDriver;

public class ExecutionHooks
{

    DriverClass driverObj = DriverClass.getInstance();

    WebDriver driver = driverObj.driver;

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("before executing suite");
    }

    @AfterSuite
    public void AfterSuite() {
        // Code for after suite
        System.out.println("quiting driver");
        if (driver != null)
            driver.quit();
    }

    @BeforeSpec
    public void BeforeSpec() {
        // Code for before spec
    }

    @AfterSpec
    public void AfterSpec() {
        // Code for after spec
    }

    @BeforeScenario
    public void BeforeScenario() {
        // Code for before scenario
    }

    @AfterScenario
    public void AfterScenario() {
        // Code for after scenario
    }

    // Code for before scenario
    @BeforeStep
    public void BeforeStep() {
        // Code for before step
    }

    @AfterStep
    public void AfterStep() {
        // Code for after step
    }

}