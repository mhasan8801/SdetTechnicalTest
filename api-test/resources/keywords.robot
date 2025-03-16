*** Settings ***
Library    RequestsLibrary
Library    Collections
Library    JSONLibrary
Resource    ../resources/variables.robot

*** Variables ***
${SESSION}    API_TEST

*** Keywords ***
Given API is Set Up
    Create Session    ${SESSION}    ${BASE_URL}

When I Send a GET Request for a Single User
    [Arguments]    ${user_id}
    ${response}    GET On Session    ${SESSION}    ${SINGLE_USER_ENDPOINT}/${user_id}
    Set Test Variable    ${GET_RESPONSE}    ${response}

Then The Response Status Should Be 200
    Should Be Equal As Numbers    ${GET_RESPONSE.status_code}    200

And The Response Should Contain User Data
    Should Be Equal As Numbers    ${GET_RESPONSE.status_code}    200
    Should Contain    ${GET_RESPONSE.json()}    data
    ${data}    Get From Dictionary    ${GET_RESPONSE.json()}    data
    Should Contain    ${data}    id
    Should Be True    ${data["id"]} != None

When I Send a POST Request to Create a User
    [Arguments]    ${name}    ${job}
    ${data}    Create Dictionary    name=${name}    job=${job}
    ${response}    Post Request    ${SESSION}    ${CREATE_USER_ENDPOINT}    json=${data}
    Set Test Variable    ${POST_RESPONSE}    ${response}

Then The Response Status Should Be 201
    Should Be Equal As Numbers    ${POST_RESPONSE.status_code}    201

And The Response Should Contain the Created User Data
    Should Contain    ${POST_RESPONSE.json()}    id
    Should Be Equal    ${POST_RESPONSE.json()["name"]}    John Doe
    Should Be Equal    ${POST_RESPONSE.json()["job"]}    QA Engineer
    Log    ${POST_RESPONSE.json()}