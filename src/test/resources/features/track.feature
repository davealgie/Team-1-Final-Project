@webpage
Feature: track create
  I want to use this template for my feature file

  Scenario: create track
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I sign up and login to create a track
    And I create a new artist
    And I create a new album again
    And I create a new genre
    And I click on track management and select create
    And I fill in the necessary fields
    And I click the create track button
    Then I should see track created
    
    Scenario: read track
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on the track page
		And I click on created track card
		Then I should be able to see the track created
		
		Scenario: update track
		 Given I am on "http://127.0.0.1:5500/static/index.html"
		 When  I sign up and login to update a track
		 And I click on the track management drop down
		 And I click on the update track button
		 And I enter the necessary fields to update
		 And I click update track
		 And I click the x
		 And I click back on the tracks page
		 And I click on the updated card
		 Then I should be able to see the updated track
		 
		 Scenario: delete track
		  Given I am on "http://127.0.0.1:5500/static/index.html"
		  When I sign up and login to delete a track
		  And I click on the track management menu
		  And I click on the delete track button
		  And I enter of the id of the track I want to delete
		  And I click the delete button
		  And I click on the tracks page
		  Then I should be able to see no tracks
		 
		