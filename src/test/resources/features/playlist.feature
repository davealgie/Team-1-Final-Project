
@webpage
Feature: playlist create
  I want to use this template for my feature file

  Scenario: create playlist
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on playlists management
    And I click on create a playlist
    And I fill in the required playlist fields
    And I click create new playlist
    Then I validate the outcomes
    
    Scenario: update playlist
     Given I am on "http://127.0.0.1:5500/static/index.html"
     When I click on playlist management menu
     And I click on update a playlist
     And I fill in the required update playlist fields
     And I click the update playlist button
     Then I should see the updated playlist
    
		
  


