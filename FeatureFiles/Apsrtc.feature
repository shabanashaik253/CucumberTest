Feature: Apsrtc Bus booking flow

  @SmokeTest @RegressionTest
  Scenario: Opening Apsrtc Home page
    When user hits the Apsrtc url
    Then user should land on Apsrtc home page

  @SmokeTest @RegressionTest
  Scenario: Entering From & To
    Given user is on Apsrtc home page
    When user enter From and To places
    And enter Depart on date
    And click on Check Availability
    Then user should get the bus details related to the search

  @RegressionTest
  Scenario: User Navigates to Seats page
    Given When user is in Bus details page
    When user Selects a particular bus service and enters all the details
    And click on Show Layout
    Then Seats page will be opened

  @SmokeTest
  Scenario: User selects a seat, fill details and Continue
    Given Seats page is opened
    When user selects a seat & fills in all the details
      | Passenger name | Mobile No | Email Id |
      | Shabana Shaik  | 7204592337 | annu253@gmail.com |
    And click on Continue
    Then user should go to payment page