package com.qa.choonz.uat.stepdefs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.choonz.hooks.SeleniumHooks;
import com.qa.choonz.uat.pages.AlbumPage;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class AlbumStepDefs {
	private WebDriver driver;
	private AlbumPage albumPage;

	public AlbumStepDefs(SeleniumHooks hooks) {
		this.driver = hooks.getDriver();
		this.albumPage = PageFactory.initElements(driver, AlbumPage.class);
		
	}
	@Given("I am on the playlist page")
	public void iAmOnThePlaylistPage() {
		this.driver.get("http://127.0.0.1:5500/static/index.html");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@When("I click Album menu")
	public void i_click_album_menu() {
	    albumPage.clickAlbumMenu();
	}

	@When("I click on create")
	public void i_click_on_create() {
	   albumPage.clickCreateAlbum();
	}

	@When("I enter my album name")
	public void i_enter_my_album_name() {
	   albumPage.addNameField("Name");
	}

	@When("I enter my cover")
	public void i_enter_my_cover() {
	   albumPage.addCoverField("Cover");
	}
	
}
