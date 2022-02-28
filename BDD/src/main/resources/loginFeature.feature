	Feature: Login Page
  
  Description: Test the login functionality for OrangeHRM applicationBackground: To launch the chrome browser
  Given Browser

  Scenario: LoginPage
    Given Username is 'Admin' and password is 'U@qBLVtm09'
    When user click on login button
    Then user should navigate to Dashboard

  #Scenario: LoginPageIncorrect 
    #Given Username is 'Admin' and password is 'abcd'
    #When user click on login button
    #Then user should navigate to Retry Page
