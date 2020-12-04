#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: API validation for negative test cases in Login

    Scenario Outline: Validate Login API UnSuccessfully 
  
    Given Prepare "<RequestBody>" for Login API
     When POST request on Login API
     Then Status code returned is "<status_code>"
      And Error code returned is "<error_code>"
      And Response body returned is "<error_description>"
    Examples: 
      | Test description                | RequestBody                        | status_code | error_code | error_description                             | 
      | Test with invalid email format  | LoginWithInvalidEmailFormat.json   | 400         | 9007       | Please provide valid email address            | 
      | Test with invalid password      | LoginWithInvalidPassword.json      | 401         | 9001       | Unauthorized access                           | 
      | Test with Unregistered email    | LoginWithUnregisteredEmail.json    | 401         | 9001       | Unauthorized access                           | 
      | Test with blank email           | LoginWithBlankEmail.json           | 400         | 1001       | User name or password cannot be null or empty | 
      | Test with blank password        | LoginWithBlankPassword.json        | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without credentials        | LoginWithoutCredentials.json       | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without email attribute    | LoginWithoutEmailAttribute.json    | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without password attribute | LoginWithoutPasswordAttribute.json | 400         | 1001       | User name or password cannot be null or empty | 