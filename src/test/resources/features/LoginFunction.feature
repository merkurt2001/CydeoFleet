Feature:

  Background:
    Given the user is on the login page

  @smoke
  Scenario Outline: Login as a different user types

    When the user enters valid credentials for each "<userType>"
    And the user clicks login button
    Then the page subtitle is "<subtitle>"
    Examples:
      | userType      | subtitle  |
    #  | driver        | Quick Launchpad |
     # | store manager | Dashboard       |
      | sales manager | Dashboard |

  Scenario: Go to Login page after closing the browser
    When the user logs in using following credentials "user1" and "UserUser123"
    And the user gets the current URL
    When the user clicks on logout link under username


  Scenario Outline: Login functions with invalid info for different users
    When the user logs in using following credentials "<username>" and "<password>"
    Then the following "<message>" should be displayed
    Examples:
      | username        | password    | message                        |
      | user            | wrong       | Invalid user name or password. |
      | user1           | 123         | Invalid user name or password. |
      | user1           | UserUser123 | Invalid user name or password. |
      |                 |             | Please fill out this field.    |
      |                 | UserUser123 | Please fill out this field.    |
      | user1           |             | Please fill out this field.    |
      | salesmanager101 | 123         | Invalid user name or password. |
      | user            | UserUser123 | Invalid user name or password. |
      |                 | UserUser123 | Please fill out this field.    |
      | salesmanager101 |             | Please fill out this field.    |
      | storemanager51  | 123         | Invalid user name or password. |
      | user            | UserUser123 | Invalid user name or password. |
      |                 | UserUser123 | Please fill out this field.    |
      | storemanager51  |             | Please fill out this field.    |


  Scenario Outline: Password in bullet signs
    When the user enters valid credentials for each "<userType>"
    Then the user should see the password in bullet signs by default
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |

  Scenario: Forgot password page
    When the user clicks on Forgot your password link
    Then the user should land on "Forgot Password" page

  Scenario Outline: Remember me checkbox
    When the user enters valid credentials for each "<userType>"
    And the user clicks Remember me on this computer checkbox
    Then Remember me on this computer checkbox should be selected
    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  Scenario Outline: Login with ENTER key as a different user types
    When the user enters valid credentials for each "<userType>"
    And the user clicks Enter button of keyboard
    Then the page subtitle is "<subtitle>"
    Examples:
      | userType      | subtitle        |
      | driver        | Quick Launchpad |
      | store manager | Dashboard       |
      | sales manager | Dashboard       |


  @command
  Scenario: Dynamic login
    * the user enter valid credentials through command prompt



