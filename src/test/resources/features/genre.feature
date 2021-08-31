@webpage
Feature: create genre
  I want to use this template for my feature file

 
  Scenario: genre create
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on genre management
    And I click on create genre
    And I fill in the genre name field
    And I fill in the description field
    And I click on create new genre
    Then I should see new genre created
    


 