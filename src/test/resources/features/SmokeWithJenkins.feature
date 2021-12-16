@TRN-1241
Feature: 

	
	@TRN-1239
	Scenario: createcar
		 Given the user is on the login page
		    When the user logs in using following credentials "storemanager51" and "UserUser123"
		    And the user navigates to "Fleet" "Vehicles"
		    Then the user clicks on Create Car button
		    And the user enters new Car information
		    Then the user clicks on save changes button	

	
	@TRN-1244
	Scenario Outline: loginJenkins
		
		  Given the user is on the login page
		    When the user enters valid credentials for each "<userType>"
		    And the user clicks login button
		    Then the page subtitle is "<subtitle>"
		    Examples:
		      | userType      | subtitle        |
		      | sales manager | Dashboard       |