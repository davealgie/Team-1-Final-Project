
Feature: album page
  I want to use this template for my feature file

  Scenario: album create
		Given I am on "http://127.0.0.1:5500/static/album.html"
		When I click Album menu
		And I click on create
		And I enter my album name
		And I enter my cover
		And I click create album
		Then I should see New user created successfully!
		
