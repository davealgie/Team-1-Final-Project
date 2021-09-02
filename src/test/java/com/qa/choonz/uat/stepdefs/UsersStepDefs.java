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
	public void i_enter_the_required_fields_to_log_in() {
		usersPage.AddLogInInfo("sirisho", "sirish123");
	}

	@When("I click log in")
	public void i_click_log_in() {
		usersPage.clickLogInUser();
	}

	@Then("I should see log in successfull")
	public void i_should_see_log_in_successfull() {

	}

}
