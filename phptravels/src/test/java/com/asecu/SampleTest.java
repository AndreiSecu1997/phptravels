package com.asecu;

import com.asecu.filemanagers.PropertiesFileReader;
import com.asecu.utils.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;


public class SampleTest {


    @Test
    public void openGoogleWebPage() {
        PropertiesFileReader file = new PropertiesFileReader();
        WebDriverManager webDriver = new WebDriverManager();
        WebDriver driver = webDriver.getDriver();

        driver.get(PropertiesFileReader.getProperty("url"));
        driver.quit();
    }

}
