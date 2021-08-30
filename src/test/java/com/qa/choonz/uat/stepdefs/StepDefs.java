package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.AlbumPage;
import com.qa.choonz.uat.pages.SignUpPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefs {
	
	private WebDriver driver;
	private SignUpPage signUpPage;
	private AlbumPage albumPage;
	
	public StepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.signUpPage = PageFactory.initElements(driver, SignUpPage.class);
		this.albumPage = PageFactory.initElements(driver, AlbumPage.class);
	}
	
	
	@Given("I am on {string}")
	public void i_am_on(String string) {
	    driver.get(string);
	
	}

	@When("I click the sign up button")
	public void i_click_the_sign_up_button() {
	    signUpPage.clickSignUp();
	   
	  
	}
	

	@When("I enter my fullname")
	public void i_enter_my_fullname() {
	signUpPage.addFullname("Sirish Khatry");
	}

	@When("I enter my username")
	public void i_enter_my_username() {
	  signUpPage.addUsername("sirisho");
	}

	@When("I enter my password")
	public void i_enter_my_password() {
	  signUpPage.addPassword("sirish123");
	
	}

	@When("I click create")
	public void i_click_create() {
	    signUpPage.clickCreateAccBtn();
	}

	@Then("I should see New user created successfully!")
	public void i_should_see_new_user_created_successfully() {
	   assertEquals("New user created successfully!", signUpPage.getText());
	}

	
	@When("I click Album menu")
	public void i_click_album_menu() {
	  albumPage.clickAlbumBtn();
	}
	@When("I click on create")
	public void i_click_on_create() {
	  albumPage.clickCreateAlbBtn();
	}
	

	@When("I enter my album name")
	public void i_enter_my_album_name() {
	albumPage.addAlbumName("Kill Em all");
							
	}

	@When("I enter my cover")
	public void i_enter_my_cover() {
	albumPage.addCover("blood");
	}
}
