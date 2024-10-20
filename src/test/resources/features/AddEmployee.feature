Feature: Add Employee to HRMS
Background:
    #Given user is able to access HRMS application
    When user enters valid user name and password
    And user clicks on login button
    #Then user is able to see dashboard page
    And user clicks on PIM option
    Then user clicks add employee option

  @noID
  Scenario: Add employee without providing Employee ID
    #Given user logs in as an admin user
    When user enters firstname and lastname and middlename in the name fields
    And user clicks on save button
    Then user added successfully

@withid
  Scenario Outline: Add employee with providing Employee ID
    #Given user logs in as an admin user
    When user adds an employee with First Name "<firstName>", Middle Name "<middleName>", Last Name "<lastName>", Employee ID "<employeeId>"
    And user clicks on save button
    Then user added successfully

    Examples:
      | firstName | middleName | lastName | employeeId |
      | John      | A.         | Doe      | 5937037482 |

@errormsg
  Scenario Outline: Attempt to add an employee with missing information
   # Given user logs in as an admin user
  When doesn't enter "<firstname>" or "<lastname>" fields
  And user clicks on save button
  Then user should see an error message
  Examples:
    | firstname | lastname |
    |           | Gardner  |
    | Adam      |          |



