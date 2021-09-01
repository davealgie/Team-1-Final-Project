package com.qa.choonz.uat.stepdefs;

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
}
