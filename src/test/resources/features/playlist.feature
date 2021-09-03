
  @webpage
  Feature: playlist create
  I want to use this template for my feature file

    Scenario: create playlist
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I sign up and login to create a playlist
    And I click on playlists management
    And I click on create a playlist
    And I fill in the required playlist fields
    And I click create new playlist
    Then I validate the outcomes
    
    
     Scenario: update playlist
     Given I am on "http://127.0.0.1:5500/static/index.html"
     When I sign up and login to update a playlist
     And I click on playlist management menu
     And I click on update a playlist
     And I fill in the required update playlist fields
     And I click the update playlist button
     Then I should see the updated playlist
    
   Scenario: add track to playlist
   Given I am on "http://127.0.0.1:5500/static/index.html"
	 When I sign up and login to add a track to a playlist
	 And I create a track for the playlist
	 And I click on the playlist management menu drop down
   And I click on add a track to playlist
   And I fill in the required ids
   And I click add by id
   Then I should see the track added to my playlist
   
   Scenario: remove track from playlist
   Given I am on "http://127.0.0.1:5500/static/index.html"
   When I sign up and login to remove a track from a playlist
   And I click on the menu and fill in the fields
   And click remove
   Then I should see the track removed
     
   
 Scenario: delete playlist
 Given I am on "http://127.0.0.1:5500/static/index.html"
 When I sign up and login to delete a playlist
 And I click on the playlist management menu
 And I click on delete a playlist
 And I fill in the id of the playlist to delete
 And I click the delete playlist button
 Then I should see no playlists

 