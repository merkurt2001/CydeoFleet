Feature: Login Function

  Background:
    * the user is on the login page

  Scenario Outline: Login as a different user types <userType>

    * the user enters valid credentials for each "<userType>"
    * the user clicks login button
    * the page subtitle is "<subtitle>"
    Examples:
      | userType      | subtitle        |
      | driver        | Quick Launchpad |
      | store manager | Dashboard       |
      | sales manager | Dashboard       |


  Scenario Outline: Breadcrumb, Page Heading, Page URL, Page Title and Modules of 'Dashboard Page'
    * the user logs in using following credentials "storemanager51" and "UserUser123"
    * the user should see following modules
      | Dashboards         |
      | Fleet              |
      | Customers          |
      | Sales              |
      | Activities         |
      | Marketing          |
      | Reports & Segments |
      | System             |

    * Page element  "<Breadcrumb>"  "<Page Heading>"  "<Page URL>"  "<Page Title>" is as expected

    Examples:
      | Breadcrumb            | Page Heading | Page URL                  | Page Title |
      | Dashboards/ Dashboard | Dashboard    | https://qa.intabella.com/ | Dashboard  |

  @wip
  Scenario: The system shouldn't allow users to login without valid credentials
    * the user logs in using following credentials "user1" and "UserUser123"
    * the user gets the current URL
    * the user log out and paste the current URL
    * User should not inside the main page

  Scenario: Closing the Browser without logging out, and opening the application in the Browser again
    * the user logs in using following credentials "user1" and "UserUser123"
    * the user closes the tab
    * the user is again on the login page

  Scenario: The leading and trailing spaces entered into the Username field are trimmed
    * the user logs in using following credentials "        storemanager51     " and "UserUser123"
    * the page subtitle is "Dashboard"


  Scenario: All the fields in the Login page have the proper placeholders
    * Username and password input boxes have proper placeholders


  Scenario Outline: Login functions with invalid info for different users
    * the user logs in using following credentials "<username>" and "<password>"
    * the following "<message>" should be displayed
    Examples:
      | username | password    | message                        |
      | user1    | wrong       | Invalid user name or password. |
      | wrong    | wrong       | Invalid user name or password. |
      | wrong    | UserUser123 | Invalid user name or password. |
      |          |             | Please fill out this field.    |
      |          | UserUser123 | Please fill out this field.    |
      | user1    |             | Please fill out this field.    |


  @command
  Scenario: Dynamic login
    * the user enter valid credentials through command prompt

  Scenario: Password text entered into the 'Password' field is toggled to hide its visibility
    * the user logs in using following credentials "driver" and "UserUser123"
    * the user should see the password in bullet signs by default


  Scenario: Password is not visible in the Page Source
    * the user enters valid credentials to password input box
    * the password is not visible in the Page Source


  Scenario: Copying of the text entered into the Password field
    * the user enters valid credentials to password input box
    * the system should not allow user to copy password

  Scenario: Forgot password page
    * the user clicks on Forgot your password link
    * the user should land on "Forgot Password" page


  Scenario: Remember me checkbox
    * the user logs in using following credentials "driver" and "UserUser123"
    * the user clicks Remember me on this computer checkbox
    * Remember me on this computer checkbox should be selected

  Scenario Outline: Login with ENTER key as a different user types
    * the user enters valid credentials for each "<userType>"
    * the user clicks Enter button of keyboard
    * the page subtitle is "<subtitle>"
    Examples:
      | userType      | subtitle        |
      | driver        | Quick Launchpad |




  Scenario: Background color  of "LOGIN"  button
    * the user should see the background color of "LOGIN" button as "#0c84a3"



