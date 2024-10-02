package com.cucumber.stepdefination;

import com.selenium.utillity.Constants;
import com.selenium.utillity.Reusable;
import com.utility.LogCapture;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class BaseStep {

    public static String scnario_Name;

    @Before
    public void initalization(Scenario scenario) throws IOException{
        scnario_Name = scenario.getName();
        Constants.Reuse = new Reusable();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//Config//CONFIG.properties");
        System.out.println("User Directory -- >" +System.getProperty("user.dir"));
        Constants.CONFIG = new Properties();
        Constants.CONFIG.load(fis);

        LogCapture.info("--------------Base Step Initialization Completed....-----------------");
    }

    @After
    public void finish(Scenario scenario) throws Exception{

        LogCapture.info("Script Completed.");
    }
}
