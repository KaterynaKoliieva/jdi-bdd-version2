@login
Feature: Login

  Scenario: Check the login of a registered user to the site
    Given submit form "Login Form" with "UserData"
    Then the "//span[@class='user-name']" text equals to "1660074366230cucumber 1660074366230cucumber"





