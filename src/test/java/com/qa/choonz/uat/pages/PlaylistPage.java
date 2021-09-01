package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage {
	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/button")
	private WebElement playlistMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[1]")
	private WebElement createPlaylistBtn;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[1]/input")
	private WebElement playlistNameField;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[2]/input")
	private WebElement playlistDescriptionField;
	
	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[2]/input")
	private WebElement playlistCoverField;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[4]/input")
	private WebElement playlistArtworkField;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[5]/button[2]")
	private WebElement createBtn;

	public PlaylistPage clickPlaylistMenu() {
		playlistMenuBtn.click();
		return this;
	}

	public PlaylistPage clickCreatePlaylist() {
		createPlaylistBtn.click();
		return this;
	}

	public PlaylistPage addNameField(String name) {
		playlistNameField.sendKeys(name);
		return this;
	}
	
	public PlaylistPage addDescriptionField(String description) {
		playlistDescriptionField.sendKeys(description);
		return this;
	}
	
	public PlaylistPage addArtworkField(String artwork) {
		playlistArtworkField.sendKeys(artwork);
		return this;
	}

	public PlaylistPage addCoverField(String cover) {
		playlistCoverField.sendKeys(cover);
		return this;
	}

	public PlaylistPage clickCreate() {
		createBtn.click();
		return this;
	}
}
