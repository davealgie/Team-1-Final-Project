package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.ArtistPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArtistStepDefs {

	private WebDriver driver;
	private ArtistPage artistPage;

	public ArtistStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.artistPage = PageFactory.initElements(driver, ArtistPage.class);
	}

	@Given("I am on the index page")
	public void iAmOnTheIndexPage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I click the artist management button")
	public void i_click_the_artist_management_button() {
		artistPage.clickArtistMenu();
	}

	@When("I click on create artist")
	public void i_click_on_create_artist() {
		artistPage.clickCreateArtist();
	}

	@When("I fill in the name field")
	public void i_fill_in_the_name_field() {
		artistPage.addNameField("Kirk Hammett");
	}

	@When("I click on create new artist")
	public void i_click_on_create_new_artist() {
		artistPage.clickCreate();
	}

	@Then("I should see new artist created")
	public void i_should_see_new_artist_created() {

	}

	@When("I click on the artist page")
	public void i_click_on_the_artist_page() {
		artistPage.clickNav();
	}

	@When("I click on created artist card")
	public void i_click_on_created_artist_card() {
		artistPage.checkCreated();
	}

	@Then("I should be able to see the artist created")
	public void i_should_be_able_to_see_the_artist_created() throws InterruptedException {
		Thread.sleep(1000);
		assertEquals("http://127.0.0.1:5500/static/artist.html?id=50", this.driver.getCurrentUrl());

	}

	@When("I click on the artist management drop down")
	public void i_click_on_the_artist_management_drop_down() {
		artistPage.clickArtistMenu();
	}

	@When("I click on the update artist button")
	public void i_click_on_the_update_artist_button() {
		artistPage.updateButtonOption();
	}

	@When("I enter the artist Id field")
	public void i_enter_the_artist_id_field() {
		artistPage.artistId("50");
	}

	@When("I enter the updated artist name")
	public void i_enter_the_updated_artist_name() {
		artistPage.updateArtistName("James Hetfield");
	}
	
	@When("I click create updated artist")
	public void i_click_create_updated_artist() throws InterruptedException {
		Thread.sleep(3000);
	  artistPage.updateArtistBtn();
	}
	@When("I close off the box")
	public void i_close_off_the_box() {
		
	   artistPage.closeX();
	}

	@When("I click on the artist page again")
	public void i_click_on_the_artist_page_again() {
		artistPage.clickNav();
	}

	@When("I click on the new card")
	public void i_click_on_the_new_card() {
		artistPage.checkCreated();
	}

	@Then("I should be able to see the updated artist")
	public void i_should_be_able_to_see_the_updated_artist() throws InterruptedException {
		Thread.sleep(3000);
		assertEquals("http://127.0.0.1:5500/static/artist.html?id=50", this.driver.getCurrentUrl());

	}
	
	@When("I click on the artist management drop down menu")
	public void i_click_on_the_artist_management_drop_down_menu() {
	 artistPage.clickArtistMenu();
	}

	@When("I click on the delete artist button")
	public void i_click_on_the_delete_artist_button() {
	  artistPage.deleteArtist();
	}

	@When("I enter the artist Id i want to delete")
	public void i_enter_the_artist_id_i_want_to_delete() {
	   artistPage.deleteId("50");
	}

	@When("I click delete artist")
	public void i_click_delete_artist() {
	   artistPage.deleteArtistBtn();
	}
	   
	 @When("I close off the box again")
		public void i_close_off_the_box_again() throws InterruptedException {
		 Thread.sleep(1000);
		   artistPage.closeDeleteMenu();
	}

	@When("I click on the updated artist page")
	public void i_click_on_the_updated_artist_page() {
	artistPage.clickNav();
	}

	
	@Then("I should be able to see no artists")
	public void i_should_be_able_to_see_no_artists() {
		assertEquals("http://127.0.0.1:5500/static/artist.html", this.driver.getCurrentUrl());
	}
	
	


}
