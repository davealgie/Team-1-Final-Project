package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

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
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		genrePage.addDescriptionField("Rock");
	}

	@When("I click on create new genre")
	public void i_click_on_create_new_genre() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.clickCreate();
	}

	@Then("I should see the new genre created")
	public void i_should_see_the_new_genre_created() {

	}

	@When("I click on the genre page")
	public void i_click_on_the_genre_page() {
		genrePage.genrePage();
	}

	@When("I click on the created genre")
	public void i_click_on_the_created_genre() {
		genrePage.genreClick();
	}

	@Then("I should be able to see the genre created")
	public void i_should_be_able_to_see_the_genre_created() {

		assertEquals("http://127.0.0.1:5500/static/genres.html?id=1", this.driver.getCurrentUrl());
	}

	@When("I click on the genre drop down")
	public void i_click_on_the_genre_drop_down() {
		genrePage.clickGenreMenu();
	}

	@When("I click on the update genre button")
	public void i_click_on_the_update_genre_button() {
		genrePage.updateButton();
	}

	@When("I enter the genre Id field")
	public void i_enter_the_genre_id_field() {
		genrePage.updateId("1");
	}

	@When("I enter the updated genre name")
	public void i_enter_the_updated_genre_name() {
		genrePage.updateName("New Rock");
	}

	@When("I enter the updated genre description")
	public void i_enter_the_updated_genre_description() {
		genrePage.updateDescription("Rock guitar");
	}

	@When("I click create updated genre")
	public void i_click_create_updated_genre() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.updateBtn();
	}

	@When("I close the update window")
	public void i_close_the_updated_window() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.closeWindow();
	}

	@When("I click on the genre page again")
	public void i_click_on_the_genre_page_again() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.genrePage();
	}

	@When("I click on the new genre card")
	public void i_click_on_the_new_genre_card() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.updatedCard();
	}

	@Then("I should be able to see the updated genre")
	public void i_should_be_able_to_see_the_updated_genre() {
		assertEquals("http://127.0.0.1:5500/static/genres.html?id=1", this.driver.getCurrentUrl());
	}

	@When("I click on the genre management drop down menu")
	public void i_click_on_the_genre_management_drop_down_menu() {
		genrePage.clickGenreMenu();
	}

	@When("I click on the delete genre button")
	public void i_click_on_the_delete_genre_button() {
		genrePage.deleteBtn();
	}

	@When("I enter the genre id i want to delete")
	public void i_enter_the_genre_id_i_want_to_delete() {
		genrePage.deleteId("1");
	}

	@When("I click delete genre")
	public void i_click_delete_genre() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.deleteGenre();
	}

	@When("I press close")
	public void i_press_close() throws InterruptedException {
		Thread.sleep(2000);
		genrePage.closeDelete();
	}

	@When("I click back on the genre page")
	public void i_click_back_on_the_genre_page() {
		genrePage.genrePage();
	}

	@Then("I should be able to see the genre has gone")
	public void i_should_be_able_to_see_the_genre_has_gone() {
		assertEquals("http://127.0.0.1:5500/static/genres.html", this.driver.getCurrentUrl());
	}

}
