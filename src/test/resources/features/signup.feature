
Feature: Sign up
  I want to use this template for my feature file

  Scenario: Sign up
		Given I am on "http://127.0.0.1:5500/static/index.html"
		When I click the sign up button
		And I enter my fullname
		And I enter my username
		And I enter my password
		And I click create
		Then I should see New user created successfully!