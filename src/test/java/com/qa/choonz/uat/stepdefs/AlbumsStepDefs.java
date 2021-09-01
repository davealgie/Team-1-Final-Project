package com.qa.choonz.uat.stepdefs;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.AlbumPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlbumsStepDefs {
	private WebDriver driver;
	private AlbumPage albumPage;

	public AlbumsStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.albumPage = PageFactory.initElements(driver, AlbumPage.class);
	}
		
		@Given("I am on the albums page")
		public void iAmOnTheAlbumPage() {
			this.driver.get("http://127.0.0.1:5500/static/index.html");
			this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
		
		@When("I click on the album management button")
		public void i_click_on_the_album_management_button() {
		   albumPage.clickAlbumMenu();
		}

		@When("I click on create album")
		public void i_click_on_create_album() {
		   albumPage.clickAlbumCreate();
		}

		@When("I fill in the album name")
		public void i_fill_in_the_album_name() {
		   albumPage.albumName("Black Album");
		}

		@When("I fil in the Cover")
		public void i_fil_in_the_cover() {
		  albumPage.coverName("Black");
		}

		@When("I click create album")
		public void i_click_create_album() {
		 albumPage.createAlbum();
		}

		@Then("I should see new album created successfully")
		public void i_should_see_new_album_created_successfully() {
		 assertEquals("New Album created successfully!", albumPage.assertText());
		}
		
		@When("I click on the albums page")
		public void i_click_on_the_albums_page() {
		   albumPage.clickAlbumPage();
		}

		@When("I click on the created album")
		public void i_click_on_the_created_album() {
		albumPage.readCard();
		}

		@Then("I should be able to see the album created")
		public void i_should_be_able_to_see_the_album_created() {
		  assertEquals("http://localhost:81/albums/read/1", this.driver.getCurrentUrl());
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
		 albumPage.updatedAlbumContents("1", "Kill em all", "Hammer");
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
			  assertEquals("http://localhost:81/albums/read/1", this.driver.getCurrentUrl());
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
