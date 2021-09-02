package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.AlbumPage;
import com.qa.choonz.uat.pages.ArtistPage;
import com.qa.choonz.uat.pages.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlbumsStepDefs {
	private WebDriver driver;
	private AlbumPage albumPage;
	private UsersPage usersPage;
	private ArtistPage artistPage;

	public AlbumsStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.albumPage = PageFactory.initElements(driver, AlbumPage.class);
		this.usersPage = PageFactory.initElements(driver, UsersPage.class);
		this.artistPage = PageFactory.initElements(driver, ArtistPage.class);
	}

	@Given("I am on the albums page")
	public void iAmOnTheAlbumPage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@When("I click album log in and sign up")
	public void i_click_album_log_in_and_sign_up() throws InterruptedException {
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

	@When("I create an artist")
	public void i_create_an_artist() throws InterruptedException {
		artistPage.clickArtistMenu();
		artistPage.clickCreateArtist();
		artistPage.addNameField("Metallica");
		artistPage.clickCreate();
		Thread.sleep(2000);
		artistPage.closeCreate();
	}

	@When("I click on the album management button")
	public void i_click_on_the_album_management_button() {
		albumPage.clickAlbumMenu();
	}

	@When("I click on create album")
	public void i_click_on_create_album() {
		albumPage.clickAlbumCreate();
	}

	@When("I fill in the required fields")
	public void i_fill_in_the_required_fields() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.albumContents("Black Album", "Black", "1");
	}

	@When("I click create album")
	public void i_click_create_album() {
		albumPage.createAlbum();
	}

	@Then("I should see New Album created successfully")
	public void i_should_see_new_album_created_successfully() {
		assertEquals("New Album created successfully!", albumPage.assertText());
		
	}

	@When("I click on the albums page")
	public void i_click_on_the_albums_page() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.clickAlbumPage();
	}

	@When("I click on the created album")
	public void i_click_on_the_created_album() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.readCard();
	}

	@Then("I should be able to see the album created")
	public void i_should_be_able_to_see_the_album_created() {
		assertEquals("http://127.0.0.1:5500/static/album.html?id=1", this.driver.getCurrentUrl());
	}

	@When("I sign up and login to update")
	public void i_sign_up_and_login_to_update() throws InterruptedException {
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

	@When("I click on the albums management drop down")
	public void i_click_on_the_albums_management_drop_down() {
		albumPage.clickAlbumMenu();
	}

	@When("I click on the update albums button")
	public void i_click_on_the_update_albums_button() {
		albumPage.updateAlb();
	}

	@When("I enter the required fields")
	public void i_enter_the_required_fields() {
		albumPage.updatedAlbumContents("1", "Kill em all", "Hammer", "1");
	}

	@When("I click update")
	public void i_click_update() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.updatedAlb();
	}

	@When("I click close")
	public void i_click_close() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.closeBtn();
	}

	@When("I click on the updated albums page")
	public void i_click_on_the_updated_albums_page() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.clickAlbumPage();
	}

	@When("I click on the new updated card")
	public void i_click_on_the_new_updated_card() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.updatedCard();
	}

	@Then("I should be able to see the updated album")
	public void i_should_be_able_to_see_the_updated_album() {
		assertEquals("http://127.0.0.1:5500/static/album.html?id=1", this.driver.getCurrentUrl());
	}

	@When("I sign up and login to delete")
	public void i_sign_up_and_login_to_delete() throws InterruptedException {
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

	@When("I click on the albums management menu")
	public void i_click_on_the_albums_management_menu() {
		albumPage.clickAlbumMenu();
	}

	@When("I click on the delete albums button")
	public void i_click_on_the_delete_albums_button() {
		albumPage.deleteBtn();
	}

	@When("I enter the id of the album to delete")
	public void i_enter_the_id_of_the_album_to_delete() {
		albumPage.deleteId("1");
	}

	@When("I click delete")
	public void i_click_delete() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.deleteAlbum();
	}

	@When("I close off the window")
	public void i_close_off_the_window() throws InterruptedException {
		Thread.sleep(2000);
		albumPage.closeOff();
	}

	@When("I click on the album page again")
	public void i_click_on_the_album_page_again() {
		albumPage.clickAlbumPage();
	}

	@Then("I should see the album has been removed")
	public void i_should_see_the_album_has_been_removed() throws InterruptedException {
		Thread.sleep(2000);
		assertEquals("http://127.0.0.1:5500/static/album.html", this.driver.getCurrentUrl());
	}

}
