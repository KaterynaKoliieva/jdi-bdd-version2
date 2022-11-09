@logout
Feature: Logout

  Scenario: Check the logout of the registered user from the site
    #Given I should be logged in
    And click on "//li[@class='acc']//span[@class='user-name']"
    When click on "//a[@id='header_link_sign_out']"
    Then the "//li[@class='acc']//span[@class='user-name']" text contains "Sign in / Register"



