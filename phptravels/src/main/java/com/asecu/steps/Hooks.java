package com.asecu.steps;


import com.asecu.actions.CommonActions;
import com.asecu.filemanagers.PropertiesFileReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    private final CommonActions commonActions;
    private static boolean switcher;

    public Hooks(CommonActions commonActions) {
        this.commonActions = commonActions;
    }


    @Before()
    public void setUpBeforeTest() {
        System.out.println();
        if (!switcher) {
            switcher = true;
        }
    }


    @After
    public void tearDown() {
        commonActions.getDriver().quit();
    }
}
