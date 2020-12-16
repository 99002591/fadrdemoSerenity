#Author: Amit Das
#
#
Feature: Login with UI 

  @BrowserAction
  Scenario: Login with correct credentials
    Given User navigates to login page
     When Enter "fadr_support_technician@eaton.com" and "Form7@22"
      And User clicks Login button
     Then Login successful with user redirected to dashboard
     Then Logout
  
#    Examples: 
#      | Category of user | email                             | password | 
#      | Eaton Technician | fadr_support_technician@eaton.com | Form7@22 | 

@BrowserAction 
  Scenario Outline: Login with incorrect credentials. 
    Given User navigates to login page 
     When Enter "<email>" and "<password>" 
      And User clicks Login button 
     Then Login fails with error message "<error_message>" 
  
    Examples: 
      | Description                             | email                        | password      | error_message                        | 
      | Login with incorrect email              | admin@eaton.com              | valid@123     | Invalid Email or Password            | 
      | Login with incorrect password           | fadr_support_admin@eaton.com | qwert_9877@BH | Invalid Email or Password            | 
      | Login with invalid email format         | admin@eaton                  | valid@123     | E-mail must be a valid email address | 
      | Login with incorrect email and password | admin@eaton.com              | qwert_9877@BH | Invalid Email or Password            | 
  
  @BrowserAction 
  Scenario Outline: Login with blank credentials. 
    Given User navigates to login page
     When Enter "<email>" and "<password>" 
      And User clicks Login button
     Then Login button is disabled
     Then Login fails with error message "<error_message>" 
  
    Examples: 
      | Description                         | email                        | password  | error_message                           | 
      | Login with blank password           | fadr_support_admin@eaton.com |           | Password is required                    | 
      | Login with blank email              |                              | valid@123 | E-mail is required                      | 
      | Login with blank email and password |                              |           | E-mail is required,Password is required | 
  
  @BrowserAction 
  Scenario Outline: Password masking and unmasking 
    Given User navigates to login page
     When Enter "<email>" and "<password>" 
     When Eye button is clicked "<times>" 
     Then Password should be "<visibility>" 
  
    Examples: 
      | times | visibility       | email                        | password      | 
      | once  | visibility       | fadr_support_admin@eaton.com | qwert_9877@BH | 
      | twice | visibility_off   | fadr_support_admin@eaton.com | qwert_9877@BH | 
  
  @BrowserAction 
  Scenario: Forgot password 
    Given User navigates to login page
     When Forgot password link is clicked 
     Then Redirect to Forgot password page 
  
  @BrowserAction 
  Scenario: Contact EATON support 
    Given User navigates to login page
     When Contact EATON support representative link is clicked 
     Then Help section dialog box opens up 
  
#  	  Scenario Outline: Verify the when remember me check box is checked, email should be autofilled 
#  	     When Enter "<email>" and "<password>" 
#  	     When Remember Me button is <button> 
#  	      And User clicks Login button 
#  	      And User clicks the logout button 
#  	     Then Verify if username field on login page is <username field> 
#  	  
#  	    Examples: 
#  	      | button    | username field | email                        | password      | 
#  	      | unchecked | not autofilled | fadr_support_admin@eaton.com | valid@123     | 
#  	      | checked   | autofilled     | fadr_support_admin@eaton.com | valid@123     | 
  
