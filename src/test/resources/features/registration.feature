@registration
Feature: Registration

  Scenario: Check the registration of a new user
    Given I open "LogInPage"
    When click on "//button[contains(@class,'id-register-button')]"
    And input random email
    And click on "//button[@id='continueRegistrationButton']"
    And choose Title
    And input "Cucumber" in "#firstName"
    And input "Onion" in "#lastName"
    And choose Profession
    And input "E1 6AN" in "#contact-search-postcode"
    And click on "//button[contains(@class,'id-find-address-button')]"
    And selects Address
    And input "OnionOnion2022" in "#password"
    And input "OnionOnion2022" in "#retypePassword"
    And click on "//button[@class='btn btn--primary fill btn--xl']"
    And click on "//a[contains(@class,'btn--primary sm-fill')]"
    Then the "//span[@class='user-name']" text equals to "Cucumber Onion"


