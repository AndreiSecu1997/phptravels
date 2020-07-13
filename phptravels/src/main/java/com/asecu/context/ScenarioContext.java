package com.asecu.context;

import lombok.Data;

@Data
public class ScenarioContext {
    private static ScenarioContext scenarioContext;
    private String currentPage;


    private ScenarioContext() {
    }

    public static ScenarioContext getContext() {
        if (scenarioContext == null) scenarioContext = new ScenarioContext();
        return scenarioContext;
    }
}
