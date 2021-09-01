@webpage
Feature: track create
  I want to use this template for my feature file

  Scenario: create track
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on track management
    And I click on create track
    And I fill in the track name field
    And I fill in the lyrics field
    And I fill in the duration field
    Then I should see track created
