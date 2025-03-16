*** Settings ***
Resource    ../resources/keywords.robot
Test Setup    Given API is Set Up

*** Test Cases ***
Scenario: Verify POST Create User
    When I Send a POST Request to Create a User    John Doe    QA Engineer
    Then The Response Status Should Be 201
    And The Response Should Contain the Created User Data