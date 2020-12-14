#Author Amit Das
Feature: API validation for use of Logout API 

  Scenario Outline: Validate Logout API successfully 
    Given Login successfully and generate authorisation token 
     When DELETE request on Logout API 
     Then Status code returned is "<status_code>" 
      And Response message returned "<message>"
  
    Examples: 
      | status_code | message            | 
      | 200         | Log off successful | 
  
  Scenario Outline: Validate Logout API Unsuccessfully for Invalid authentication 
    Given Login successfully and generate authorisation token 
     When DELETE request on Logout API with invalid scene "<auth_type>" "<user_id_type>" 
     Then Status code returned is "<status_code>" 
      And Error code returned is "<error_code>" 
      And Response body returned is "<error_description>" 
  
    Examples: 
      | Test Description           | auth_type | user_id_type | status_code | error_code | error_description       | 
      | Logout with invalid userID | invalid   | valid        | 401         | 9001       | Unauthorized access     | 
      | Logout with blank userID   | invalid   | invalid      | 400         | 9010       | Please enter valid GUID | 
      | Logout with valid userID   | invalid   | blank        | 404         |            |                         | 
  
  Scenario Outline: Validate Logout API Unsuccessfully for Blank Authentication 
    Given Login successfully and generate authorisation token 
     When DELETE request on Logout API with invalid scene "<auth_type>" "<user_id_type>" 
     Then Status code returned is "<status_code>" 
      And Error code returned is "<error_code>" 
      And Response body returned is "<error_description>" 
  
    Examples: 
      | Test Description           | auth_type | user_id_type | status_code | error_code | error_description                        | 
      | Logout with invalid userID | blank     | valid        | 401         | 9001       | Unauthorized access                      | 
      | Logout with blank userID   | blank     | invalid      | 400         | 9010       | Please enter valid GUID                  | 
      | Logout with valid userID   | blank     | blank        | 404         |            |                                          | 
  
  Scenario Outline: Validate Logout API Unsuccessfully for Expired Authentication 
    Given Login successfully and generate authorisation token 
     When DELETE request on Logout API with invalid scene "<auth_type>" "<user_id_type>" 
     Then Status code returned is "<status_code>" 
      And Error code returned is "<error_code>" 
      And Response body returned is "<error_description>" 
  
    Examples: 
      | Test Description           | auth_type | user_id_type | status_code | error_code | error_description       | 
      | Logout with invalid userID | expired   | valid        | 401         | 9001       | Unauthorized access     | 
      | Logout with blank userID   | expired   | invalid      | 400         | 9010       | Please enter valid GUID | 
      | Logout with valid userID   | expired   | blank        | 404         |            |                         | 
  
  Scenario Outline: Validate Logout API Unsuccessfully for Valid Authentication 
    Given Login successfully and generate authorisation token 
     When DELETE request on Logout API with invalid scene "<auth_type>" "<user_id_type>" 
     Then Status code returned is "<status_code>" 
      And Error code returned is "<error_code>" 
      And Response body returned is "<error_description>" 
  
    Examples: 
      | Test Description           | auth_type | user_id_type | status_code | error_code | error_description       | 
      | Logout with invalid userID | valid     | invalid      | 400         | 9010       | Please enter valid GUID | 
      | Logout with blank userID   | valid     | blank        | 404         |            |                         | 
  
  
