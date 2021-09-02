@webpage

 Feature: album create
  I want to use this template for my feature file
  
  Scenario: create album
    Given I am on "http://127.0.0.1:5500/static/index.html"
    When I click album log in and sign up
    And I create an artist
    And I click on the album management button
    And I click on create album
   	And I fill in the required fields
    And I click create album
    Then I should see New Album created successfully
    
    Scenario: read album
     Given I am on "http://127.0.0.1:5500/static/index.html"
     When I click on the albums page
     And I click on the created album
     Then I should be able to see the album created
     
     Scenario: update album
      Given I am on "http://127.0.0.1:5500/static/index.html"
      When I sign up and login to update
      And I click on the albums management drop down
      And I click on the update albums button
      And I enter the required fields
      And I click update
      And I click close
     	And I click on the updated albums page 
     	When I click on the new updated card
     	Then I should be able to see the updated album
     
     Scenario: delete album
     Given I am on "http://127.0.0.1:5500/static/index.html"
     When I sign up and login to delete
     And I click on the albums management menu
     And I click on the delete albums button
     And I enter the id of the album to delete
     And I click delete
     And I close off the window
     When I click on the album page again
     Then I should see the album has been removed
     