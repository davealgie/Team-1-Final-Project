package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;

import com.qa.choonz.uat.pages.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UsersStepDefs {

	private WebDriver driver;
	private UsersPage usersPage;

	public UsersStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.usersPage = PageFactory.initElements(driver, UsersPage.class);

	}

	@Given("I am on {string}")
	public void i_am_on(String string) {
		driver.get(string);

	}

	@When("I click the sign up button")
	public void i_click_the_sign_up_button() {
		usersPage.clickSignUp();

	}

	@When("I enter my fullname")
	public void i_enter_my_fullname() {
		usersPage.addFullname("Sirish Khatry");
	}

	@When("I enter my username")
	public void i_enter_my_username() {
		usersPage.addUsername("sirisho");
	}

	@When("I enter my password")
	public void i_enter_my_password() {
		usersPage.addPassword("sirish123");

	}

	@When("I click create")
	public void i_click_create() {
		usersPage.clickCreateAccBtn();
	}

	@Then("I should see New user created successfully!")
	public void i_should_see_new_user_created_successfully() {
		assertEquals("New user created successfully!", usersPage.getText());
	}

	@When("I click the log in button")
	public void i_click_the_log_in_button() {
		usersPage.clickLogIn();
	}

	@When("I enter the required fields to log in")
	public void i_enter_the_required_fields_to_log_in() throws InterruptedException {
		Thread.sleep(2000);
		usersPage.AddLogInInfo("sirisho", "sirish123");
	}

	@When("I click log in")
	public void i_click_log_in() {
		usersPage.clickLogInUser();
		usersPage.closeLogOut();
		usersPage.clickHomePage();
	}

	@Then("I should see log in successfull")
	public void i_should_see_log_in_successfull() {
		
	}
	
	@When("I log in")
	public void i_log_in() throws InterruptedException {
		usersPage.clickSignUp();
		usersPage.addFullname("Sirish Khatry");
		usersPage.addUsername("sirisho");
		usersPage.addPassword("sirish123");
		Thread.sleep(2000);
		usersPage.clickCreateAccBtn();
		usersPage.closeBtn();
		Thread.sleep(2000);
		usersPage.clickLogIn();
		Thread.sleep(2000);
		usersPage.AddLogInInfo("sirisho", "sirish123");
		Thread.sleep(2000);
		usersPage.clickLogInUser();
		usersPage.closeLogIn();
		Thread.sleep(2000);
		usersPage.clickHome();
	}
	
	
	@When("I click the log out button")
	public void i_click_the_log_out_button() {
	  usersPage.clickUser();
	  usersPage.clickLogOut();
	}

	@Then("I should not see any functions for tracks etc")
	public void i_should_not_see_any_functions_for_tracks_etc() throws InterruptedException {
		Thread.sleep(2000);
	    assertEquals("http://127.0.0.1:5500/static/index.html", this.driver.getCurrentUrl());
	}

}
