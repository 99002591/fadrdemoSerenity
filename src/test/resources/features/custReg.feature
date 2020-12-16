#Author: Amit Das
#
#
Feature: Customer Registration 

@BrowswerAction 
Scenario: Navigate to Customer Registration page 
	Given User logs in 
	 When User clicks on factory reset dropdown 
	  And User clicks on customer registration option
	 Then User should be navigated to Customer Registartion page
	 
@BrowserAction
Scenario Outline: Unsuccessful Customer Registration in input fields left blank
	Given User logs in and navigates to customer registration
	 When Enter "<customer_name>" "<contact_name>" "<contact_phone>" "<contact_email>" "<contact_method>"
	  And Click on submit button
	 Then Submit button is disabled
	 Then Submission fails with "<error messages>"
	 
	 Examples:
	 	|Test Description| customer_name | contact_name | contact_phone | contact_email | contact_method |
	 	