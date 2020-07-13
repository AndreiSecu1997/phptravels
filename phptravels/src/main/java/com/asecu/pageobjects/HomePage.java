package com.asecu.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    private final String URL = "/demo";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "address")
    private WebElement subScribeInput;

    @FindBy(css = "div#email button")
    private WebElement subscribeButton;

}
