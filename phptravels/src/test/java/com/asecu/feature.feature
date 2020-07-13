@BeforeAll
Feature: Feature Name

  Scenario: A pop up window is displayed when user subscribes
    Given "Home" Page is accessed
    And the following elements are displayed
      | subscribeButton |
      | subScribeInput  |

    When "subScribeInput" field is populated with "testData@testdata.com" data
    When the following fields are populated with corespondent data:
      | subScribeInput | testData@testdata.com |
    And "subscribeButton" is clicked
