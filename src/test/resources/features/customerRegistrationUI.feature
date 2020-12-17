#Author: Amit Das
#
#
Feature: Customer Registration UI

@BrowswerAction 
Scenario: Navigate to Customer Registration page 
	Given User navigates to login page 
	When Enter "fadr_support_technician@eaton.com" and "Form7@22" 
	And User clicks Login button 
	And User clicks on factory reset dropdown 
	And User clicks on customer registration option 
	Then Navigated to customer registration 
	
@BrowserAction 
Scenario Outline: Unsuccessful Customer Registration with input fields left blank 
   Given User Navigates to customer registration 
	When Enter "<customer_name>" "<contact_name>" "<contact_phone>" "<contact_email>" "<contact_method>" 
	Then Submit button is disabled 
	Then Submission fails with "<error_messages>" 
	
	Examples: 
		| Test Description                      | customer_name | contact_name | contact_phone | contact_email      | contact_method | error_messages                                                                                                                     | 
		| Registration with blank customer name |               | Vladimir     | 9999999999    | vladimir@putin.com | email          | Customer name is required                                                                                                          | 
		| Registration with blank contact name  | Jeff          |              | 9999999999    | joe@biden.com      | phone          | Contact name is required                                                                                                           | 
		| Registration with blank phone number  | Bernard       | Boris        |               | boris@jhonson.com  | other          | Phone number is required                                                                                                           | 
		| Registration with blank contact email | Elon          | Donald       | 9999999999    |                    | email          | E-mail is required                                                                                                                 | 
		| Registration with no contact method   | Bill          | Narendra     | 9999999999    | narendra@modi.com  |                | Approved contact method is required                                                                                                | 
		| Registration with all fields blank    |               |              |               |                    |                | Customer name is required,Contact name is required,Phone number is required,E-mail is required,Approved contact method is required | 
		
  @BroswerAction
  Scenario Outline: Unsuccessful Customer Registration with invalid phone number
    Given User Navigates to customer registration 
     When Enter "<customer_name>" "<contact_name>" "<contact_phone>" "<contact_email>" "<contact_method>" 
     Then Submit button is disabled 
     Then Submission fails with "<error_messages>" 
  
    Examples: 
      | Test Description                               | customer_name | contact_name | contact_phone | contact_email      | contact_method | error_messages                  |  
      | Registration with alphanumberic phone number   | Jeff          | Joe          | qwerty382324  | joe@biden.com      | phone          | Please enter valid phone number | 
      | Registration with phone number with space      | Jeff          | Joe          | 91 566382324  | joe@biden.com      | phone          | Please enter valid phone number |
      | Registration with phone with special character | Jeff          | Joe          | #91245678954  | joe@biden.com      | phone          | Please enter valid phone number |
  
  @BroswerAction
  Scenario: Unsuccessful Customer Registration with invalid email ID
    Given User Navigates to customer registration 
     When Enter "Elon" "Vladimir" "123456789" "vladimir@putin" "phone" 
     Then Submit button is disabled 
     Then Submission fails with "Please enter a valid email"  
     
  @BroswerAction
  Scenario Outline: Checking character length limits of input fields
    Given User Navigates to customer registration 
     When Enter "<customer_name>" "<contact_name>" "<contact_phone>" "vladimir@putin" "phone"
     Then Check the length of accepted input "<value>"
  
    Examples: 
      | Test Description                        | customer_name        | contact_name        | contact_phone     | 
      | Customer name is more than 256 chars    | break_limit_customer | Jeff                | 1234567890        | 
      | Contact name is more than 256 chars     | Elon                 | break_limit_contact | 1234567890        | 
      | Contact phone no. is more than 16 chars | Elon                 | Jeff                | break_limit_phone | 
      
  @BrowserAction
  Scenario: Reset button
    Given User Navigates to customer registration 
     When Enter "Elon" "Vladimir" "123456789" "vladimir@putin.com" "phone" 
      And User clicks the reset button
     Then All input fields should reset
     Then Logout