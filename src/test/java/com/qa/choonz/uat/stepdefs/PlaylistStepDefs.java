package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;

import com.qa.choonz.uat.pages.PlaylistPage;
import com.qa.choonz.uat.pages.TrackPage;
import com.qa.choonz.uat.pages.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PlaylistStepDefs {
	private WebDriver driver;
	private PlaylistPage playlistPage;
	private UsersPage usersPage;
	private TrackPage trackPage;

	public PlaylistStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.playlistPage = PageFactory.initElements(driver, PlaylistPage.class);
		this.usersPage = PageFactory.initElements(driver, UsersPage.class);
		this.trackPage = PageFactory.initElements(driver, TrackPage.class);
	}

	@Given("I am on the playlists page")
	public void iAmOnThePlaylistsPage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I sign up and login to create a playlist")
	public void I_sign_up_and_login_to_create_a_playlist() throws InterruptedException {
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

	@When("I click on playlists management")
	public void i_click_on_playlists_management() {
		playlistPage.clickPlaylistMenu();
	}

	@When("I click on create a playlist")
	public void i_click_on_create_a_playlist() {
		playlistPage.clickCreatePlaylist();
	}

	@When("I fill in the required playlist fields")
	public void i_fill_in_the_required_playlist_name_field() throws InterruptedException {
		Thread.sleep(3000);
		playlistPage.addFields("Motley crúe vibes", "for the energetic", "motorbikes", "picture of the sun");
	}

	@When("I click create new playlist")
	public void i_click_create_new_playlist() throws InterruptedException {
		playlistPage.clickCreate();
		Thread.sleep(2000);
		playlistPage.closeBtn();
		Thread.sleep(2000);
		usersPage.clickHome();
	}

	@Then("I validate the outcomes")
	public void i_validate_the_outcomes() {
		assertEquals("Motley crúe vibes", playlistPage.verifyText());
	}

	@When("I sign up and login to update a playlist")
	public void I_sign_up_and_login_to_update_a_playlist() throws InterruptedException {
		usersPage.clickLogIn();
		Thread.sleep(2000);
		usersPage.AddLogInInfo("sirisho", "sirish123");
		Thread.sleep(2000);
		usersPage.clickLogInUser();
		usersPage.closeLogIn();
		Thread.sleep(2000);
		usersPage.clickHome();
	}

	@When("I click on playlist management menu")
	public void i_click_on_playlist_management_menu() {
		playlistPage.clickPlaylistMenu();
	}

	@When("I click on update a playlist")
	public void i_click_on_update_a_playlist() {
		playlistPage.clickUpdatePlaylist();
	}

	@When("I fill in the required update playlist fields")
	public void i_fill_in_the_required_update_playlist_fields() {
		playlistPage.fillInFields("1", "1", "Van halen Tribute", "ultimate hits of van halen",
				"Van halen with flying v");
	}

	@When("I click the update playlist button")
	public void i_click_the_update_playlist_button() throws InterruptedException {
		Thread.sleep(2000);
		playlistPage.clickUpdatePlaylist();
	}

	@Then("I should see the updated playlist")
	public void i_should_see_the_updated_playlist() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals("http://127.0.0.1:5500/static/index.html", this.driver.getCurrentUrl());
	}

	@When("I sign up and login to add a track to a playlist")
	public void i_sign_up_and_login_to_add_a_track_to_a_playlist() throws InterruptedException {
		usersPage.clickLogIn();
		Thread.sleep(2000);
		usersPage.AddLogInInfo("sirisho", "sirish123");
		Thread.sleep(2000);
		usersPage.clickLogInUser();
		usersPage.closeLogIn();
		Thread.sleep(2000);
		usersPage.clickHome();
	}

	@When("I create a track for the playlist")
	public void i_create_a_track_for_the_playlist() throws InterruptedException {
		trackPage.clickTrackMenu();
		trackPage.clickCreateTrack();
		trackPage.addRequiredFields("Nightrain",
				"Loaded like a freight train, Flyin' like an aeroplane, Feelin' like a space brain, One more time tonight",
				"280", "1", "1");
		trackPage.clickCreate();
		trackPage.closeCreate();
		Thread.sleep(2000);
		usersPage.clickHome();
	}

	@When("I click on the playlist management menu drop down")
	public void i_click_on_the_playlist_management_menu_drop_down() {
		playlistPage.clickPlaylistMenu();
	}

	@When("I click on add a track to playlist")
	public void i_click_on_add_a_track_to_playlist() {
		playlistPage.addTrack();
	}

	@When("I fill in the required ids")
	public void i_fill_in_the_required_ids() {
		playlistPage.trackFields("1", "1");
	}

	@When("I click add by id")
	public void i_click_add_by_id() throws InterruptedException {
		playlistPage.addById();
		Thread.sleep(2000);
		playlistPage.closeTrack();
		Thread.sleep(2000);
	}

	@Then("I should see the track added to my playlist")
	public void i_should_see_the_track_added_to_my_playlist() throws InterruptedException {
		usersPage.clickHome();
		Thread.sleep(2000);
		assertEquals("http://127.0.0.1:5500/static/index.html", this.driver.getCurrentUrl());
	}

	@When("I sign up and login to delete a playlist")
	public void i_sign_up_and_login_to_delete_a_playlist() throws InterruptedException {
		usersPage.clickLogIn();
		Thread.sleep(2000);
		usersPage.AddLogInInfo("sirisho", "sirish123");
		Thread.sleep(2000);
		usersPage.clickLogInUser();
		usersPage.closeLogIn();
		Thread.sleep(2000);
		usersPage.clickHome();
	}

	@When("I click on the playlist management menu")
	public void i_click_on_the_playlist_management_menu() {
		playlistPage.clickPlaylistMenu();
	}

	@When("I click on delete a playlist")
	public void i_click_on_delete_a_playlist() {
		playlistPage.deleteBtn();
	}

	@When("I fill in the id of the playlist to delete")
	public void i_fill_in_the_id_of_the_playlist_to_delete() {
		playlistPage.deleteId("1");
	}

	@When("I click the delete playlist button")
	public void i_click_the_delete_playlist_button() throws InterruptedException {
		Thread.sleep(2000);
		playlistPage.deletePlaylist();
		playlistPage.closeDelete();
		Thread.sleep(2000);
	}

	@Then("I should see no playlists")
	public void i_should_see_no_playlists() throws InterruptedException {
		usersPage.clickHome();
		Thread.sleep(2000);
		assertEquals("http://127.0.0.1:5500/static/index.html", this.driver.getCurrentUrl());
	}

	@When("I sign up and login to remove a track from a playlist")
	public void i_sign_up_and_login_to_remove_a_track_from_a_playlist() throws InterruptedException {
		usersPage.clickLogIn();
		Thread.sleep(2000);
		usersPage.AddLogInInfo("sirisho", "sirish123");
		Thread.sleep(2000);
		usersPage.clickLogInUser();
		usersPage.closeLogIn();
		Thread.sleep(2000);
		usersPage.clickHome();
	}

	@When("I click on the menu and fill in the fields")
	public void i_click_on_the_menu_and_fill_in_the_fields() {
		playlistPage.clickPlaylistMenu();
		playlistPage.removeTrack();
		playlistPage.removeTrackId("1", "1");
	}

	@When("click remove")
	public void click_remove() throws InterruptedException {
		playlistPage.removeTrackFromPlaylist();
		Thread.sleep(2000);
		playlistPage.closeRemove();
	}

	@Then("I should see the track removed")
	public void i_should_see_the_track_removed() throws InterruptedException {
		usersPage.clickHome();
		Thread.sleep(2000);
		assertEquals("http://127.0.0.1:5500/static/index.html", this.driver.getCurrentUrl());
	}

}
