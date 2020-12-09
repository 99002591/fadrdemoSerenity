#Author Amit Das
Feature: API validation for successful use of Logout API

  Scenario Outline: Validate Logout API successfully
    Given Login successfully and generate authorisation token
    When DELETE request on Logout API
    Then Status code returned is "<status_code>"
    And Response body returned  "<message>"

    Examples: 
      | status_code | message            |
      |         200 | Log off successful |
