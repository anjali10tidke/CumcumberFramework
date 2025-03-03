Feature: login functionality

  Background:
    Given user should be on login

  Scenario: valid login
    When user enters valid credentilas
    Then user should navigated to home page
    And user can see logout link
    And close browser

    @modi

    Scenario: Invalid login
      When user enters the invalid credentilas
      Then user should be on same page
      And user can see error message
      And close browser


  @modi
  Scenario Outline: Invalid login with data driven
    When user enters the invalid credentilas username as "<userid>" and passwprd as "<password>"
    Then user should be on same page
    And user can see error message
    And close browser

    Examples:
    |userid | password |
    |ad1    | pw1      |
    |ad2    | pw2      |
    |ad3    | pw3      |
    |ad4    | pw4      |