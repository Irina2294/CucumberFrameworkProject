Feature: Login validation for HRM portal

  @login
  Scenario Outline: Validate login error messages
    #Given user is able to access HRMS application
    When user enters "<username>" as username
    And user enters "<password>" as password
    And user clicks the login button
    Then user should see the error message "<errorMsg>"

    Examples:
      | username | password           | errorMsg                  |
      |          | Hum@nhrm123        |Username cannot be empty   |
      | Admin    |                    |Password is Empty         |
      | ABCD     | Hum@nhrm123,       |Invalid credentials       |









