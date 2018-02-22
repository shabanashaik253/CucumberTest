Feature: GmailFlow

  @SmokeTest
  Scenario: Testing with parameters
    When data is sent as parameter
      |first data|
      |second data|
      |third data|
    Then data should come


  @SmokeTest
  Scenario Outline: Successful Login with Valid Credentials
    Given User is on Login Home Page
    When User enters Valid "<username>" AND "<password>"
    Then User is successfully logged in
    Examples:
      | username | password |
      | annu253 | choprapriyanka |

  @RegressionTest
  Scenario: User to goto Gmailpage
    Given user is logged in
    When user clicks on the Gmail symbol
    Then user is taken to the Gmail page