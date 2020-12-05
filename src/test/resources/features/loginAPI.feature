#Author: Amit
#Sample Feature Definition Template
Feature: API validation for negative test cases in Login 

  Scenario Outline: Validate Login API UnSuccessfully for "<Test description>"
  
    Given Prepare Request Body for Login API with email = "<email>" and password = "<password>"
     When POST request on Login API
     Then Status code returned is "<status_code>"
      And Error code returned is "<error_code>"
      And Response body returned is "<error_description>"
    Examples: 
      | Test description                | RequestBody                        | email                        | password  | status_code | error_code | error_description                             | 
      | Test with invalid email format  | LoginWithInvalidEmailFormat.json   | admin@eaton                  | qwert@123 | 400         | 9007       | Please provide valid email address            | 
      | Test with invalid password      | LoginWithInvalidPassword.json      | fadr_support_admin@eaton.com | qwert@123 | 401         | 9001       | Unauthorized access                           | 
      | Test with Unregistered email    | LoginWithUnregisteredEmail.json    | admin@eaton.com              | qwert@123 | 401         | 9001       | Unauthorized access                           | 
      | Test with blank email           | LoginWithBlankEmail.json           |                              | qwert@123 | 400         | 1001       | User name or password cannot be null or empty | 
      | Test with blank password        | LoginWithBlankPassword.json        | fadr_support_admin@eaton.com |           | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without credentials        | LoginWithoutCredentials.json       |                              |           | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without email attribute    | LoginWithoutEmailAttribute.json    |                              | qwert@123 | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without password attribute | LoginWithoutPasswordAttribute.json | fadr_support_admin@eaton.com |           | 400         | 1001       | User name or password cannot be null or empty | 
