Feature: API validation for negative test cases in Customer Registration API 

@API_SITE
Scenario Outline: Validate Customer Registration API Unsuccessfully for Invalid Scenarios 
	Given Login successfully and generate authorisation token 
	And Prepare the request body with "<name>" "<contactName>" "<phoneNumber>" "<emailId>" "<contactMethod>" "<additionalinfo>" 
	When POST request on Customer Registration API 
	Then Status code returned is "<status_code>" 
	And Error code returned is "<error_code>" 
	And Response body returned is "<error_description>" 
	Examples: 
		| Test Description                  | name     | contactName  | phoneNumber | emailId         | contactMethod | additionalinfo             | status_code | error_code | error_description                        | 
		| Test without Blank name           |          | testcustomer | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com | 400         | 9008       | Input parameters cannot be null or empty | 
		| Test without contact name         | custname |              | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com | 400         | 9008       | Input parameters cannot be null or empty | 
		| Test without phone number         | custname | testcustomer |             | some@random.com | Others        | Copy to testcust@eaton.com | 400         | 9008       | Input parameters cannot be null or empty | 
		| Test without emailid              | custname | testcustomer | 123456789   |                 | Others        | Copy to testcust@eaton.com | 400         | 9008       | Input parameters cannot be null or empty | 
		| Test without contact method       | custname | testcustomer | 123456789   | some@random.com |               | Copy to testcust@eaton.com | 400         | 9008       | Input parameters cannot be null or empty | 
		| Test with invalid email format    | custname | testcustomer | 123456789   | some            | Others        |                            | 400         | 9007       | Please provide valid email address       | 
		| Test with blank attribute         |          |              |             |                 |               |                            | 400         | 9008       | Input parameters cannot be null or empty | 
		
 @API_SITE		
 Scenario Outline: Validate Customer Registration API Unsuccessfully with Incorrect Authentication
    Given Login successfully and generate authorisation token
      And Prepare the request body with "<name>" "<contactName>" "<phoneNumber>" "<emailId>" "<contactMethod>" "<additionalinfo>"
     When POST request on Customer Registration API with incorrect authentication of type "<bad_auth_type>"
     Then Status code returned is "<status_code>"
      And Error code returned is "<error_code>"
      And Response body returned is "<error_description>"
    Examples: 
      | Test Description                       | name     | contactName  | phoneNumber | emailId         | contactMethod | additionalinfo             | status_code | error_code | error_description                        | bad_auth_type | 
      | Test with invalid authentication token | custname | testcustomer | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com | 401         | 9001       | Unauthorized access                      | invalid       | 
      | Test with blank authentication token   | custname | testcustomer | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com | 401         | 9009       | Security token must not be null or empty | blank         | 
      | Test with expired authentication token | custname | testcustomer | 123456789   | some@random.com | Others        | Copy to testcust@eaton.com | 401         | 9001       | Unauthorized access                      | expired       | 
  
