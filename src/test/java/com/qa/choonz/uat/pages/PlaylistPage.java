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

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[4]/input")
	private WebElement playlistArtworkField;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[3]/input")
	private WebElement userIdField;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[5]/button[2]")
	private WebElement createBtn;
	
	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[2]")
	private WebElement updateBtn;

	@FindBy(xpath = "/html/body/div[8]/div/div/div[2]/form/div[1]/input")
	private WebElement updateIdField;
	
	@FindBy(xpath = "/html/body/div[8]/div/div/div[2]/form/div[2]/input")
	private WebElement updateUserIdField;

	@FindBy(xpath = "/html/body/div[8]/div/div/div[2]/form/div[3]/input")
	private WebElement updateName;
	
	@FindBy(xpath = "/html/body/div[8]/div/div/div[2]/form/div[4]/input")
	private WebElement updateDescription;
	
	@FindBy(xpath = "/html/body/div[8]/div/div/div[2]/form/div[5]/input")
	private WebElement updateArtwork;
	
	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[2]")
	private WebElement updatePlaylistBtn;
	
	
	


	public PlaylistPage clickPlaylistMenu() {
		playlistMenuBtn.click();
		return this;
	}

	public PlaylistPage clickCreatePlaylist() {
		createPlaylistBtn.click();
		return this;
	}

	public PlaylistPage addFields(String name, String description, String id, String artwork) {
		playlistNameField.sendKeys(name);
		playlistDescriptionField.sendKeys(description);
		userIdField.sendKeys(id);
		playlistArtworkField.sendKeys(artwork);
		return this;
	}

	public PlaylistPage clickCreate() {
		createBtn.click();
		return this;
	}
	
	public PlaylistPage clickUpdatePlaylist() {
		updateBtn.click();
		return this;
	}
}
