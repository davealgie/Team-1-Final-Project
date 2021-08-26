package com.qa.choonz.uat.stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.SignUpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	private WebDriver driver;
	private SignUpPage signuppage;
	
	public StepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.signuppage = PageFactory.initElements(driver, SignUpPage.class);
	}
	
	
	@Given("I am on {string}")
	public void i_am_on(String string) {
	    driver.get(string);
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click create account")
	public void i_click_create_account() {
	    
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter my fullname")
	public void i_enter_my_fullname() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter my username")
	public void i_enter_my_username() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I enter my password")
	public void i_enter_my_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I click create")
	public void i_click_create() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should see New user created successfully!")
	public void i_should_see_new_user_created_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
}