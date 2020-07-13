package com.asecu.actions;

import com.asecu.context.ScenarioContext;
import com.asecu.filemanagers.PropertiesFileReader;
import com.asecu.pageobjects.Page;
import com.asecu.utils.WebDriverManager;
import lombok.Value;
import org.openqa.selenium.*;
import org.junit.Assert;

import static org.awaitility.Awaitility.await;

import java.lang.reflect.*;
import java.util.concurrent.TimeUnit;

@Value
public class CommonActions {
    WebDriverManager webDriverManager = new WebDriverManager();
    WebDriver driver = webDriverManager.getDriver();
    ScenarioContext scenarioContext = ScenarioContext.getContext();


    public void navigateTo(String page) throws ClassNotFoundException, NoSuchFieldException, InvocationTargetException,
            NoSuchMethodException, InstantiationException, IllegalAccessException {
        driver.get(PropertiesFileReader.getProperty("url") + getStringValueFromPageField(page + "Page", "URL"));
        scenarioContext.setCurrentPage(page + "Page");
    }

    public void enterDataInto(String data, String element) throws ClassNotFoundException, NoSuchFieldException,
            NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        elementIsDisplayed(element);
        getWebElementFromPage(scenarioContext.getCurrentPage(), element).sendKeys(data);
    }

    public void clickOnElement(String element) throws NoSuchMethodException, InstantiationException,
            NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        WebElement webElement = getWebElementFromPage(scenarioContext.getCurrentPage(), element);
        waitTillElementIsDisplayed(webElement);
        webElement.click();
    }

    public void elementIsDisplayed(String element) throws NoSuchMethodException, InstantiationException,
            NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        waitTillElementIsDisplayed(getWebElementFromPage(scenarioContext.getCurrentPage(), element));
    }

    public void userIsOnPage(String page) throws NoSuchMethodException, InstantiationException, NoSuchFieldException,
            IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        Assert.assertTrue("The displayed page contains expected url", driver.getCurrentUrl()
                .contains(getStringValueFromPageField(page + "Page", "URL")));
    }

    private Class getPageClass(String pageName) throws ClassNotFoundException {
        return Class.forName("com.asecu.pageobjects." + pageName);
    }

    private Field getFieldFromPage(String pageName, String fieldName) throws NoSuchFieldException,
            ClassNotFoundException {
        Field field = getPageClass(pageName).getDeclaredField(fieldName);
        field.setAccessible(true);
        return field;
    }

    private Page getPageInstance(Class<Page> pageClass) throws NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        return pageClass.getConstructor(WebDriver.class).newInstance(driver);
    }

    private String getStringValueFromPageField(String page, String fieldName) throws ClassNotFoundException,
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException,
            NoSuchFieldException {
        return getFieldFromPage(page, fieldName).get(getPageInstance(getPageClass(page))).toString();
    }

    private WebElement getWebElementFromPage(String page, String element) throws ClassNotFoundException,
            InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException,
            NoSuchFieldException {
        return (WebElement) getFieldFromPage(page, element)
                .get(getPageInstance(getPageClass(scenarioContext.getCurrentPage())));
    }

    private void waitTillElementIsDisplayed(WebElement element) {
        await().pollInterval(500, TimeUnit.MILLISECONDS)
                .atMost(3, TimeUnit.SECONDS).until(() -> element.isDisplayed());
    }


}
