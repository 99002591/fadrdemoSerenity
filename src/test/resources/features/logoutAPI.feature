#Author Amit Das
Feature: API validation for use of Logout API 

  Scenario Outline: Validate Logout API successfully 
    Given Login successfully and generate authorisation token 
     When DELETE request on Logout API 
     Then Status code returned is "<status_code>" 
      And Response body returned  "<message>" 
  
    Examples: 
      | status_code | message            | 
      | 200         | Log off successful | 
  
  Scenario Outline: Validate Logout API Unsuccessfully
    Given Login successfully and generate authorisation token
     When DELETE request on Logout API with invalid scene "<auth_type>" "<user_id_type>"
     Then Status code returned is "<status_code>"
      And Error code returned is "<error_code>"
      And Response body returned is "<error_description>"
  
    Examples: 
      | Test Description                        | auth_type | user_id_type | status_code | error_code | error_description                        | 
      | Logout with valid auth & invalid userID | valid     | invalid      | 400         | 9010       | Please enter valid GUID                  |  
  	  | Logout with invalid auth                | invalid   | valid        | 401         | 9001       | Unauthorized access                      |
  	  | Logout with blank auth                  | blank     | valid        | 401         | 9009       | Security token must not be null or empty |
      | Logout with expired auth                | expired   | valid        | 401         | 9001       | Unauthorized access                      |
      | Logout with valid auth & blank userID   | valid     | blank        | 404         | 9008       | Input parameters cannot be null or empty |
      | Logout with blank auth & blank userID   | blank     | blank        | 404         | 9009       | Security token must not be null or empty |