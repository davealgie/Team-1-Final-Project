@webpage
Feature: create genre
  I want to use this template for my feature file


 
 Scenario: genre create
 Given I am on "http://127.0.0.1:5500/static/index.html"
 When I sign up and log in
 And I click on genre management
 And I click on create genre
 And I fill in the genre name field
 And I fill in the description field
 And I click on create new genre
 Then I should see the new genre created
    
Scenario: read genre
Given I am on "http://127.0.0.1:5500/static/index.html"
When I click on the genre page
And I click on the created genre
Then I should be able to see the genre created
 
Scenario: update genre
Given I am on "http://127.0.0.1:5500/static/index.html"
When I click sign up and log in
And I click on the genre drop down 
And I click on the update genre button
And I enter the genre Id field
And I enter the updated genre name
And I enter the updated genre description
And I click create updated genre
And I close the update window
And I click on the genre page again
And I click on the new genre card
Then I should be able to see the updated genre

Scenario: delete genre
Given I am on "http://127.0.0.1:5500/static/index.html"
When I sign up and log in again
And I click on the genre management drop down menu
And I click on the delete genre button
And I enter the genre id i want to delete
And I click delete genre
And I press close
When I click back on the genre page
Then I should be able to see the genre has gone
