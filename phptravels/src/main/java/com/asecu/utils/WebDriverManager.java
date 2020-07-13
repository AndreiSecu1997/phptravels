package com.asecu.utils;

import com.asecu.filemanagers.PropertiesFileReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

    private WebDriver driver;
    private static String driverType;
    protected static final String driverPath = PropertiesFileReader.getProperty("driversPath");

    public WebDriverManager() {
        new PropertiesFileReader();
        driverType = PropertiesFileReader.getProperty("browser").toUpperCase();
    }

    private WebDriver initiateInstance() {
        switch (driverType) {
            case "CHROME":
                System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FIREFOX":
                System.setProperty("webdriver.gheko.driver", driverPath + "ghekodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
        return driver;
    }

    public WebDriver getDriver() {
        return driver == null ? initiateInstance() : driver;
    }
}
