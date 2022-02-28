Feature: System Users Page
  
  Description: Changing the role of the user to Global Admin and again disabling the role and logging out
  Given Browser

  Scenario: SystemUserPage
    Given Username is 'Admin' and password is 'U@qBLVtm09'
    When user click on login button
    Then user should navigate to Dashboard
    When click on Admin button and click on user management button and click on users
    Then user should navigate to SystemUsersPage
    When click on Amnada_user edit button
    Then A child window should be opened 
    When click on roles dropdown
    Then change the role to Global Admin and save
    When click on Amnada_user edit button
    Then verify Global Admin is selected or not
    When click on roles dropdown
    Then change the role to Select and save 
    When click on Amnada_user edit button
    Then verify the role is set to selected and save
    When click on user drop down menu and click on click logout
    Then user is navigated to login page
    
  