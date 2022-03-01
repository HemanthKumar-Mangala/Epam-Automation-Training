Feature: System Users Page
  
  Description: Changing the role of the user to Global Admin and again disabling the role and logging out
  Given Browser

  Scenario: SystemUserPage
    Given Username is 'Admin' and password is 'U@qBLVtm09'
    When user click on login button
    Then user should navigate to Dashboard
    
    When user click on Admin button 
    And click on user management button 
    And click on users
    Then user should navigate to SystemUsersPage
    
    When user click on Amnada_user edit button
    Then A child window should be opened 
    
    When user click on roles dropdown
    Then change the role to Global Admin 
    And click save button
    
    When user click on Amnada_user edit button
    Then verify Global Admin is selected or not
    
    When user click on roles dropdown
    Then change the role to Select 
    And click save button
    
    When user click on Amnada_user edit button
    Then verify the role is set to selected 
    And click save button
    
    When user click on user drop down menu 
    And click on click logout
    Then user is navigated to login page
    
  