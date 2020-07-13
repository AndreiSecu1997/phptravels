package com.asecu.steps;

import com.asecu.actions.CommonActions;
import com.asecu.flows.CommonFlows;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

public class CommonSteps {
    private CommonActions commonActions;
    private CommonFlows commonFlows;

    public CommonSteps(CommonActions commonActions, CommonFlows commonFlows) {
        this.commonActions = commonActions;
        this.commonFlows = commonFlows;
    }

    @Given("{string} Page is accessed")
    public void userIsOnPage(String pageName) throws NoSuchMethodException, InstantiationException,
            NoSuchFieldException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        commonActions.navigateTo(pageName);
        commonActions.userIsOnPage(pageName);
    }

    @When("{string} field is populated with {string} data")
    public void userEntersDataIntoElement(String element, String data) throws NoSuchMethodException,
            InstantiationException, NoSuchFieldException, IllegalAccessException, InvocationTargetException,
            ClassNotFoundException {
        commonActions.enterDataInto(data, element);
    }

    @And("{string} is clicked")
    public void isClicked(String elementName) throws NoSuchMethodException, InstantiationException,
            ClassNotFoundException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        commonActions.clickOnElement(elementName);
    }

    @When("the following fields are populated with corespondent data:")
    public void userEntersTheFollowingData(Map<String, String> dataSetMap) {
        dataSetMap.forEach((element, data) -> {
            try {
                commonActions.enterDataInto(data, element);
            } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | InstantiationException |
                    IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        });
    }


    @Then("the following elements are displayed")
    public void theFollowingElementsAreDisplayed(List<String> elementsList) {
        elementsList.forEach(element -> {
            try {
                commonActions.elementIsDisplayed(element);
            } catch (NoSuchMethodException | InstantiationException | NoSuchFieldException | IllegalAccessException
                    | InvocationTargetException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
}
