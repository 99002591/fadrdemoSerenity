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
		| Registration with blank contact name  | Jeff          |              | 9999999999    | joe@biden.com       | phone          | Contact name is required                                                                                                           | 
		| Registration with blank phone number  | Bernard       | Boris        |               | boris@jhonson.com  | other          | Phone number is required                                                                                                           | 
		| Registration with blank contact email | Elon          | Donald       | 9999999999    |                    | email          | E-mail is required                                                                                                                 | 
		| Registration with no contact method   | Bill          | Narendra     | 9999999999    | narendra@modi.com  |                | Approved contact method is required                                                                                                | 
		| Registration with all fields blank    |               |              |               |                    |                | Customer name is required,Contact name is required,Phone number is required,E-mail is required,Approved contact method is required | 
		
  @BroswerAction
  Scenario Outline: Unsuccessful Customer Registration with invalid data format
    Given User Navigates to customer registration 
     When Enter "<customer_name>" "<contact_name>" "<contact_phone>" "<contact_email>" "<contact_method>" 
     Then Submit button is disabled 
     Then Submission fails with "<error_messages>" 
  
    Examples: 
      | Test Description                                            | customer_name | contact_name | contact_phone | contact_email      | contact_method | error_messages                                             | 
      | Registration with invalid email format                      | Elon          | Vladimir     | 9999999999    | vladimir@          | email          | Please enter a valid email                                 | 
      | Registration with  alphabetic phone number                  | Jeff          | Joe          | qwertyuiop    | joe@biden.com      | phone          | Please enter valid phone number                            | 
      | Registration with invalid email format and alphabetic phone | Bill          | Boris        | asdfghjklm    | narendra@          | other          | Please enter valid phone number,Please enter a valid email |
      
#   @Logout
#   Scenario Outline 