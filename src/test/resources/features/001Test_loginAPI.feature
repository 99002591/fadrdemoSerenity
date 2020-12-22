#Author: Amit
#Sample Feature Definition Template
Feature: API validation for negative test cases in Login 

  @API @API_SECURITY
  Scenario Outline: Validate Login API UnSuccessfully for Invalid scenarios
  
    Given Prepare Request Body for Login API with email = "<email>" and password = "<password>"
     When POST request on Login API
     Then Status code returned is "<status_code>"
      And Error code returned is "<error_code>"
      And Response body returned is "<error_description>"
    Examples: 
      | Test description                | email                        | password  | status_code | error_code | error_description                             | 
      | Test with invalid email format  | admin@eaton                  | qwert@123 | 400         | 9007       | Please provide valid email address            | 
      | Test with invalid password      | fadr_support_admin@eaton.com | qwert@123 | 401         | 9001       | Unauthorized access                           | 
      | Test with Unregistered email    | admin@eaton.com              | qwert@123 | 401         | 9001       | Unauthorized access                           | 
      | Test with blank email           |                              | qwert@123 | 400         | 1001       | User name or password cannot be null or empty | 
      | Test with blank password        | fadr_support_admin@eaton.com |           | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without credentials        |                              |           | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without email attribute    |                              | qwert@123 | 400         | 1001       | User name or password cannot be null or empty | 
      | Test without password attribute | fadr_support_admin@eaton.com |           | 400         | 1001       | User name or password cannot be null or empty | 

   @API @API_SECURITY   
   Scenario Outline: Validate Login API Succesfully
    Given Prepare Request Body for Login API with email = "<email>" and password = "<password>"
     When POST request on Login API
     Then Status code returned is "<status_code>"
      And Response message returned "<message>"
    Examples: 
      | Test description            | email                             | password | status_code | message          | 
      | Test with valid credentials | fadr_support_technician@eaton.com | Form7@22 | 200         | Login successful | 