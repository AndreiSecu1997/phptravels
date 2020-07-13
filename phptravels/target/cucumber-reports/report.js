$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/java/com/asecu/feature.feature");
formatter.feature({
  "name": "Feature Name",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@BeforeAll"
    }
  ]
});
formatter.scenario({
  "name": "A pop up window is displayed when user subscribes",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@BeforeAll"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "\"Home\" Page is accessed",
  "keyword": "Given "
});
formatter.match({
  "location": "CommonSteps.userIsOnPage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the following elements are displayed",
  "rows": [
    {
      "cells": [
        "subscribeButton"
      ]
    },
    {
      "cells": [
        "subScribeInput"
      ]
    }
  ],
  "keyword": "And "
});
formatter.match({
  "location": "CommonSteps.theFollowingElementsAreDisplayed(String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"subScribeInput\" field is populated with \"testData@testdata.com\" data",
  "keyword": "When "
});
formatter.match({
  "location": "CommonSteps.userEntersDataIntoElement(String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "the following fields are populated with corespondent data:",
  "rows": [
    {
      "cells": [
        "subScribeInput",
        "testData@testdata.com"
      ]
    }
  ],
  "keyword": "When "
});
formatter.match({
  "location": "CommonSteps.userEntersTheFollowingData(String,String\u003e)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "\"subscribeButton\" is clicked",
  "keyword": "And "
});
formatter.match({
  "location": "CommonSteps.isClicked(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});