
@webpage
Feature: playlist create
  I want to use this template for my feature file

  Scenario: create playlist
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on playlists management
    And I click on create a playlist
    And I fill in the playlist name field
    And I fill in the playlist description field
    And I fill in the playlist Artwork
    And I click create new playlist
    Then I validate the outcomes
  


