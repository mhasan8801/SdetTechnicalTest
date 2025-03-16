*** Settings ***
Resource    ../resources/keywords.robot
Test Setup    Given API is Set Up

*** Test Cases ***
Scenario: Verify GET Single User
    When I Send a GET Request for a Single User    2
    Then The Response Status Should Be 200
    And The Response Should Contain User Data