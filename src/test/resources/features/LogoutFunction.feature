@logout
Feature: 

	Background:

		Given the user is on the login page
		


	Scenario Outline: Log out as a different user types
		When the user enters valid credentials for each "<userType>"
		And the user clicks login button
		When the user clicks on logout link under username
		Then the user should land on "Login" page
		Examples:
		  | userType      |
		  | driver        |
		  | store manager |
		  | sales manager |	


	Scenario Outline: Log out and navigate back as a different user types
		When the user enters valid credentials for each "<userType>"
		And the user clicks login button
		When the user clicks on logout link under username
		Then the user should land on "Login" page
		When the user clicks step back button
		Then the user should land on "Login" page
		Examples:
		  | userType      |
		  | driver        |
		  | store manager |
		  | sales manager |

	Scenario: Go to Login page after closing the tab
		When the user logs in using "user1" and "UserUser123"
		And the user closes the tab
		When the user is again on the login page
		Then the user should login the page successfully