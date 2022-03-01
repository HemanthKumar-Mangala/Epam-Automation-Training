
Feature: Login Page Test
 
Given: Browser
  Scenario: Open Browser
   

 
  Scenario Outline: LoginPage Scenario Outline
    Given User is on login page
    Given Username is '<username>' and password is '<password>'
    When user click on login button
    Then user should navigate to '<page>'

    Examples: 
      | username  | password   | page      |
      | Admin |     U@qBLVtm09 | dashboard |
      | Admin |    abcde       |retryLogin |
