package com.qa.choonz.uat.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;

import com.qa.choonz.uat.pages.GenrePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GenreStepDefs {
	private WebDriver driver;
	private GenrePage genrePage;

	public GenreStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.genrePage = PageFactory.initElements(driver, GenrePage.class);
	}

	@Given("I am on the genre page")
	public void iAmOnTheGenrePage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I click on genre management")
	public void i_click_on_genre_management() {
		genrePage.clickGenreMenu();
	}

	@When("I click on create genre")
	public void i_click_on_create_genre() {
		genrePage.clickCreateGenre();
	}

	@When("I fill in the genre name field")
	public void i_fill_in_the_genre_name_field() {
		genrePage.addNameField("Rock");
	}

	@When("I fill in the description field")
	public void i_fill_in_the_description_field() {
		genrePage.addDescriptionField("lead guitar");
	}

	@When("I click on create new genre")
	public void i_click_on_create_new_genre() {
		genrePage.clickCreate();
	}

	@Then("I should see new genre created")
	public void i_should_see_new_genre_created() {
	   
	}

	}


