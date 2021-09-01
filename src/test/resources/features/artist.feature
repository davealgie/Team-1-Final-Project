@webpage

Feature: artist create
  I want to use this template for my feature file

 
  Scenario: create artist
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click the artist management button
    And I click on create artist
    And I fill in the name field
    And I click on create new artist
    Then I should see new artist created
  
  
Scenario: read artist
Given I am on "http://127.0.0.1:5500/static/index.html"
When I click on the artist page
And I click on created artist card
Then I should be able to see the artist created


Scenario: update artist
Given I am on "http://127.0.0.1:5500/static/index.html"
When I click on the artist management drop down
And I click on the update artist button
And I enter the artist Id field
And I enter the updated artist name
And I click create updated artist
And I close off the box
And I click on the artist page again
And I click on the new card
Then I should be able to see the updated artist 

Scenario: delete artist
Given I am on "http://127.0.0.1:5500/static/index.html"
When I click on the artist management drop down menu
And I click on the delete artist button
And I enter the artist Id i want to delete
And I click delete artist
And I close off the box again
When I click on the updated artist page
Then I should be able to see no artists