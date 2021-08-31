@webpage
Feature: create album
  I want to use this template for my feature file

 
  Scenario: album create
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on album management
    And I click on create album
    And I fill in the album name
    And I fill in the cover field for the album
    And I click create new album
    Then I should see album created

