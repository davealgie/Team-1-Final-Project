package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;

import com.qa.choonz.uat.pages.TrackPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackStepDefs {

	private WebDriver driver;
	private TrackPage trackPage;

	public TrackStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.trackPage = PageFactory.initElements(driver, TrackPage.class);
	}

	@Given("I am on the track page")
	public void iAmOnTheTrackPage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I click on track management")
	public void i_click_on_track_management() {
		trackPage.clickTrackMenu();

	}

	@When("I click on create track")
	public void i_click_on_create_track() {
		trackPage.clickCreateTrack();

	}

	@When("I fill in the necessary fields")
	public void i_fill_in_the_necessary_field() {
		trackPage.addRequiredFields("Nothing else matters", "nothing matters", "280", "1", "1");
	}

	@When("I click the create track button")
	public void i_click_the_create_track_button() {
		trackPage.clickCreate();
	}

	@Then("I should see track created")
	public void i_should_see_track_created() {

	}

	@When("I click on the track page")
	public void i_click_on_the_track_page() {
		trackPage.clickTrackPage();
	}

	@When("I click on created track card")
	public void i_click_on_created_track_card() {
		trackPage.clickCardCreated();
	}

	@Then("I should be able to see the track created")
	public void i_should_be_able_to_see_the_track_created() {
		assertEquals("http://127.0.0.1:5500/static/tracks.html?id=1", this.driver.getCurrentUrl());
	}

	@When("I click on the track management drop down")
	public void i_click_on_the_track_management_drop_down() {
		trackPage.clickTrackMenu();
	}

	@When("I click on the update track button")
	public void i_click_on_the_update_track_button() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.clickUpdate();
	}


	@When("I enter the necessary fields to update")
	public void i_enter_the_necessary_fields_to_update() throws InterruptedException {
		Thread.sleep(4000);
		trackPage.updateFields("1","The unforgiven", "and you will be unforgiven", "200", "1", "1");
	}

	@When("I click update track")
	public void i_click_update_track() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.updatedCreateBtn();
	}

	@When("I click the x")
	public void i_click_the_x() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.clickX();
	}

	@When("I click back on the tracks page")
	public void i_click_back_on_the_tracks_page() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.clickTrackPage();
	}

	@When("I click on the updated card")
	public void i_click_on_the_updated_card() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.updatedCard();
	}

	@Then("I should be able to see the updated track")
	public void i_should_be_able_to_see_the_updated_track() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals("http://127.0.0.1:5500/static/tracks.html?id=1", this.driver.getCurrentUrl());
	}

	@When("I click on the track management menu")
	public void i_click_on_the_track_management_menu() {
		trackPage.clickTrackMenu();
	}

	@When("I click on the delete track button")
	public void i_click_on_the_delete_track_button() {
		trackPage.deleteBtn();
	}

	@When("I enter of the id of the track I want to delete")
	public void i_enter_of_the_id_of_the_track_i_want_to_delete() {
		trackPage.deleteIdField("1");
	}

	@When("I click the delete button")
	public void i_click_the_delete_button() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.deleteTrackBtn();
	}

	@When("I click on the tracks page")
	public void i_click_on_the_tracks_page() {
		trackPage.clickTrackPage();
	}

	@Then("I should be able to see no tracks")
	public void i_should_be_able_to_see_no_tracks() {
		assertEquals("http://127.0.0.1:5500/static/tracks.html", this.driver.getCurrentUrl());
	}
}
