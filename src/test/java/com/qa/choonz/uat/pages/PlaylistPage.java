package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PlaylistPage {
	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/button")
	private WebElement playlistMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[1]")
	private WebElement createPlaylistBtn;

	@FindBy(xpath = "/html/body/div[16]/div/div/div[2]/form/div[1]/input")
	private WebElement playlistNameField;

	@FindBy(xpath = "/html/body/div[16]/div/div/div[2]/form/div[2]/input")
	private WebElement playlistDescriptionField;

	@FindBy(xpath = "/html/body/div[16]/div/div/div[2]/form/div[3]/input")
	private WebElement playlistArtworkField;

	@FindBy(xpath = "/html/body/div[16]/div/div/div[2]/form/div[4]/button[2]")
	private WebElement createBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[2]")
	private WebElement updateBtn;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[1]/input")
	private WebElement updateIdField;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[2]/input")
	private WebElement updateUserIdField;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[3]/input")
	private WebElement updateName;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[4]/input")
	private WebElement updateDescription;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[5]/input")
	private WebElement updateArtwork;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[6]/button[2]")
	private WebElement updatePlaylistBtn;

	@FindBy(xpath = "/html/body/div[18]/div/div/div[2]/form/div[6]/button[1]")
	private WebElement closeUpdateBtn;

	@FindBy(xpath = "/html/body/div[16]/div/div/div[2]/form/div[4]/button[1]")
	private WebElement closeBtn;

	@FindBy(xpath = "//*[@id=\"card-group\"]/div/p")
	private WebElement verifyText;

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[3]")
	private WebElement deleteBtn;

	@FindBy(xpath = "/html/body/div[17]/div/div/div[2]/form/div[1]/input")
	private WebElement idDelete;

	@FindBy(xpath = "/html/body/div[17]/div/div/div[2]/form/div[2]/button[2]")
	private WebElement deletePlaylist;

	@FindBy(xpath = "/html/body/div[17]/div/div/div[2]/form/div[2]/button[1]")
	private WebElement closeDelete;

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[4]")
	private WebElement addTrack;

	@FindBy(xpath = "/html/body/div[22]/div/div/div[2]/form/div[3]/input")
	private WebElement trackId;

	@FindBy(xpath = "/html/body/div[22]/div/div/div[2]/form/div[4]/input")
	private WebElement playlistId;

	@FindBy(xpath = "/html/body/div[22]/div/div/div[3]/button[1]")
	private WebElement addById;

	@FindBy(xpath = "/html/body/div[22]/div/div/div[3]/button[3]")
	private WebElement closeTrack;

	@FindBy(xpath = "/html/body/div[1]/h1[3]/div/div/div/div/button[5]")
	private WebElement removeTrack;

	@FindBy(xpath = "/html/body/div[23]/div/div/div[2]/div[1]/input")
	private WebElement removeTrackId;

	@FindBy(xpath = "/html/body/div[23]/div/div/div[2]/div[2]/input")
	private WebElement removePlaylistId;

	@FindBy(xpath = "/html/body/div[23]/div/div/div[3]/button[1]")
	private WebElement removeTrackFromPlaylistBtn;

	@FindBy(xpath = "/html/body/div[23]/div/div/div[3]/button[2]")
	private WebElement closeRemove;

	public PlaylistPage closeRemove() {
		closeRemove.click();
		return this;
	}

	public PlaylistPage removeTrackFromPlaylist() {
		removeTrackFromPlaylistBtn.click();
		return this;
	}

	public PlaylistPage removeTrackId(String id, String playId) {
		removeTrackId.sendKeys(id);
		removePlaylistId.sendKeys(playId);
		return this;
	}

	public PlaylistPage removeTrack() {
		removeTrack.click();
		return this;
	}

	public PlaylistPage closeTrack() {
		closeTrack.click();
		return this;
	}

	public PlaylistPage trackFields(String id, String playId) {
		trackId.sendKeys(id);
		playlistId.sendKeys(playId);
		return this;
	}

	public PlaylistPage addById() {
		addById.click();
		return this;
	}

	public PlaylistPage addTrack() {
		addTrack.click();
		return this;
	}

	public PlaylistPage deletePlaylist() {
		deletePlaylist.click();
		return this;
	}

	public PlaylistPage closeDelete() {
		closeDelete.click();
		return this;
	}

	public PlaylistPage deleteBtn() {
		deleteBtn.click();
		return this;
	}

	public PlaylistPage deleteId(String id) {
		idDelete.sendKeys(id);
		return this;
	}

	public PlaylistPage fillInFields(String id, String usrId, String name, String description, String artwork) {
		updateIdField.sendKeys(id);
		updateUserIdField.sendKeys(usrId);
		updateName.sendKeys(name);
		updateDescription.sendKeys(description);
		updateArtwork.sendKeys(artwork);
		return this;
	}

	public PlaylistPage closeUpdateBtn() {
		closeUpdateBtn.click();
		return this;
	}

	public PlaylistPage verifyText() {
		verifyText.getText();
		return this;
	}

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
		playlistArtworkField.sendKeys(artwork);
		return this;
	}

	public PlaylistPage closeBtn() {
		closeBtn.click();
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
