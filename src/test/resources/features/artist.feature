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
  


