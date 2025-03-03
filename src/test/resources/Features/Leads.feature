Feature: Lead Functionality


    Background:
      Given user should be on login
      When user enters valid credentilas

  @cl
  Scenario Outline: Create Lead
    When user click on new lead link
    And fill mandatory fields lastname "<lname>" and company "<comp>" click on save button
    Then Lead should be created successfully with "<lname>" and company "<comp>"
    And close browser

    Examples:
    |lname | comp |
    |Shah | BJP |
    |Gupta | BJP |
    |Gandhi | congress |
    |Koholi | India |

