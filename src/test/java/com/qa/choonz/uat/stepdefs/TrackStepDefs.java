package com.qa.choonz.uat.stepdefs;

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
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("I click on track management")
	public void i_click_on_track_management() {
		trackPage.clickTrackMenu();

	}

	@When("I click on create track")
	public void i_click_on_create_track() {
		trackPage.clickCreateTrack();
	 
	}

	@When("I fill in the track name field")
	public void i_fill_in_the_track_name_field() {
	   trackPage.addNameField("Nothing else matters");
	}

	@When("I fill in the lyrics field")
	public void i_fill_in_the_lyrics_field() {
		trackPage.addLyricsField("And nothing else matters");
	   
	}

	@When("I fill in the duration field")
	public void i_fill_in_the_duration_field() {
	trackPage.addDurationField("280");
	
	}
	@Then("I should see track created")
	public void i_should_see_track_created() {
	   
	}
}
