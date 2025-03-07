Feature: Lead2  Functionality


  @cl3
  Scenario: Create Lead step parametreization
    Given user should be on login
    When user enters valid credentilas
    And user create the lead data with "<lname>" and  "<comp>" and verify sucessful lead creation
      |lname | comp |
      |Shah | BJP |
      |Gupta | BJP |
      |Gandhi | congress |
      |Koholi | India |
    And close browser


