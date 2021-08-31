
Feature: Track create
  I want to use this template for my feature file

 
  Scenario: Create track
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click on tracks management
    And I click create track
    And I enter my track name
    An
    Then I validate the outcomes
    And check more outcomes


  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

   