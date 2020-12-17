#Author: Amit Das
#
#
Feature: Customer Registration 

@BrowswerAction 
  Scenario: Navigate to Customer Registration page 
    Given User navigates to login page 
     When Enter "fadr_support_technician@eaton.com" and "Form7@22" 
      And User clicks Login button
      And User clicks on factory reset dropdown
      And User clicks on customer registration option
     Then Navigated to customer registration
  
  @BrowserAction 
  Scenario Outline: Unsuccessful Customer Registration in input fields left blank 
    Given User Navigates to customer registration
     When Enter "<customer_name>" "<contact_name>" "<contact_phone>" "<contact_email>" "<contact_method>"
#      And Click on submit button
#     Then Submit button is disabled
     Then Submission fails with "<error_messages>"
  
    Examples: 
      | Test Description                      | customer_name | contact_name | contact_phone | contact_email      | contact_method | error_messages                                                                                                                     | 
      | Registration with blank customer name |               | vladimir     | 9999999999    | vladimir@putin.com | email          | Customer name is required                                                                                                          | 
      | Registration with blank contact name  | Vostok        |              | 9999999999    | vladimir@putin.com | phone          | Contact name is required                                                                                                           | 
      | Registration with blank phone number  | Vostok        | vladimir     |               | vladimir@putin.com | other          | Phone number is required                                                                                                           | 
      | Registration with blank contact email | Vostok        | vladimir     | 9999999999    |                    | email          | E-mail is required                                                                                                                 | 
      | Registration with no contact method   | Vostok        | vladimir     | 9999999999    | vladimir@putin.com |                | Approved contact method is required                                                                                                | 
      | Registration with all fields blank    |               |              |               |                    |                | Customer name is required,Contact name is required,Phone number is required,E-mail is required,Approved contact method is required | 
  
