@TRN-1245
Feature: 

	
	@TRN-1244
	Scenario Outline: loginJenkins
		
		  Given the user is on the login page
		    When the user enters valid credentials for each "<userType>"
		    And the user clicks login button
		    Then the page subtitle is "<subtitle>"
		    Examples:
		      | userType      | subtitle        |
		      | sales manager | Dashboard       |