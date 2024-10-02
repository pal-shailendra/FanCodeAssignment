package com;

import com.selenium.utillity.TestNGcucumberExecutable;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = {"src/Feature"},
        glue = {"com.cucumber.stepdefination"},
        tags = "@TC_01",
        plugin = {"pretty","html:target/site/cucumber-pretty","json:target/cucumber-reports/cucumber.json","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true)
public class TestNGRunnerCL extends TestNGcucumberExecutable {



}
