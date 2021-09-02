package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.AlbumPage;
import com.qa.choonz.uat.pages.ArtistPage;
import com.qa.choonz.uat.pages.GenrePage;
import com.qa.choonz.uat.pages.TrackPage;
import com.qa.choonz.uat.pages.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrackStepDefs {

	private WebDriver driver;
	private TrackPage trackPage;
	private UsersPage usersPage;
	private AlbumPage albumPage;
	private ArtistPage artistPage;
	private GenrePage genrePage;

	public TrackStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.trackPage = PageFactory.initElements(driver, TrackPage.class);
		this.usersPage = PageFactory.initElements(driver, UsersPage.class);
		this.albumPage = PageFactory.initElements(driver, AlbumPage.class);
		this.artistPage = PageFactory.initElements(driver, ArtistPage.class);
		this.genrePage = PageFactory.initElements(driver, GenrePage.class);
	}

	@Given("I am on the track page")
	public void iAmOnTheTrackPage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("I sign up and login to create a track")
	public void I_sign_up_and_login_to_create_a_track() throws InterruptedException {
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

	@When("I create a new artist")
	public void i_create_a_new_artist() throws InterruptedException {
		artistPage.clickArtistMenu();
		artistPage.clickCreateArtist();
		artistPage.addNameField("Guns N Roses");
		artistPage.clickCreate();
		Thread.sleep(2000);
		artistPage.closeCreate();
		Thread.sleep(2000);
	}

	@When("I create a new album again")
	public void i_create_a_new_album_again() throws InterruptedException {
		albumPage.clickAlbumMenu();
		albumPage.clickAlbumCreate();
		Thread.sleep(2000);
		albumPage.albumContents("Appetite for Destruction", "Skulls and cross", "1");
		albumPage.createAlbum();
		albumPage.closeBtnOff();
	}

	@When("I create a new genre")
	public void i_create_a_new_genre() throws InterruptedException {
		genrePage.clickGenreMenu();
		genrePage.clickCreateGenre();
		genrePage.addNameField("Rock");
		genrePage.addDescriptionField("Lead guitar");
		Thread.sleep(2000);
		genrePage.clickCreate();
		Thread.sleep(2000);
		genrePage.closeBtn();
		Thread.sleep(2000);
	}

	@When("I click on track management and select create")
	public void i_click_on_track_management_and_select_create() {
		trackPage.clickTrackMenu();
		trackPage.clickCreateTrack();

	}

	@When("I fill in the necessary fields")
	public void i_fill_in_the_necessary_field() throws InterruptedException {
		Thread.sleep(2000);
		trackPage.addRequiredFields("Nightrain", "Loaded like a freight train, Flyin' like an aeroplane, Feelin' like a space brain, One more time tonight", "280", "1", "1");
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

	@When("I sign up and login to update a track")
	public void I_sign_up_and_login_to_update_a_track() throws InterruptedException {
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
		trackPage.updateFields("1", "Paradise city", "Take me down to the paradise city where the grass is green and the girls are pretty", "320", "1", "1");
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

	@When("I sign up and login to delete a track")
	public void I_sign_up_and_login_to_delete_a_track() throws InterruptedException {
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
