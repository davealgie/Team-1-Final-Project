package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackPage {
	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[2]/div/div/div/button")
	private WebElement trackMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[2]/div/div/div/div/button[1]")
	private WebElement createTrackBtn;

	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[1]/input")
	private WebElement trackNameField;

	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[2]/input")
	private WebElement trackLyricsField;

	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[3]/input")
	private WebElement trackDurationField;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[4]/input")
	private WebElement trackAlbumId;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[5]/input")
	private WebElement trackGenreId;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[6]/button[1]")
	private WebElement createBtn;

	@FindBy(xpath = "/html/body/nav/div[2]/ul[2]/class/li[5]/a")
	private WebElement trackPage;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/a")
	private WebElement trackPageCard;

	@FindBy(xpath = "/html/body/div[1]/h1[2]/div/div/div/div/button[2]")
	private WebElement updateBtn;

	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/form/div[1]/input")
	private WebElement updateId;

	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/form/div[2]/input")
	private WebElement updatedNameField;

	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/form/div[3]/input")
	private WebElement updatedLyricsField;

	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/form/div[4]/input")
	private WebElement updatedDurationField;

	@FindBy(xpath = "/html/body/div[12]/div/div/div[3]/button[2]")
	private WebElement updatedCreateBtn;

	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/form/div[5]/input")
	private WebElement updatedAlbumId;
	
	@FindBy(xpath = "/html/body/div[12]/div/div/div[2]/form/div[6]/input")
	private WebElement updatedGenreId;
	
	@FindBy(xpath = "/html/body/div[12]/div/div/div[3]/button[1]")
	private WebElement clickX;

	@FindBy(xpath = "/html/body/div[2]/div[10]/div/div/div[1]/button/span")
	private WebElement clickXAgain;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/a")
	private WebElement updatedPageCard;

	@FindBy(xpath = "/html/body/div[1]/h1[2]/div/div/div/div/button[3]")
	private WebElement deleteBtn;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[1]/input")
	private WebElement deleteIdField;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[2]/button[2]")
	private WebElement deleteTrackBtn;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[6]/button[2]")
	private WebElement closeCreate;
	
	public TrackPage closeCreate() {
		closeCreate.click();
		return this;
	}
	


	public TrackPage clickTrackMenu() {
		trackMenuBtn.click();
		return this;
	}

	public TrackPage clickCreateTrack() {
		createTrackBtn.click();
		return this;
	}

	public TrackPage addRequiredFields(String name, String lyrics, String duration, String albId, String genreId) {
		trackNameField.sendKeys(name);
		trackLyricsField.sendKeys(lyrics);
		trackDurationField.sendKeys(duration);
		trackAlbumId.sendKeys(albId);
		trackGenreId.sendKeys(genreId);
		return this;
	}

	public TrackPage clickCreate() {
		createBtn.click();
		return this;
	}

	public TrackPage clickTrackPage() {
		trackPage.click();
		return this;
	}

	public TrackPage clickCardCreated() {
		trackPageCard.click();
		return this;
	}

	public TrackPage clickUpdate() {
		updateBtn.click();
		return this;
	}

	

	public TrackPage updateFields(String id,String name, String lyrics, String duration, String albumId, String genreId) {
		updateId.sendKeys(id);
		updatedNameField.sendKeys(name);
		updatedLyricsField.sendKeys(lyrics);
		updatedDurationField.sendKeys(duration);
		updatedAlbumId.sendKeys(albumId);
		updatedGenreId.sendKeys(genreId);
		return this;
	}


	public TrackPage updatedCreateBtn() {
		updatedCreateBtn.click();
		return this;
	}

	public TrackPage clickX() {
		clickX.click();
		return this;
	}

	public TrackPage clickXAgain() {
		clickXAgain.click();
		return this;
	}

	public TrackPage updatedCard() {
		updatedPageCard.click();
		return this;
	}

	public TrackPage deleteBtn() {
		deleteBtn.click();
		return this;
	}

	public TrackPage deleteIdField(String id) {
		deleteIdField.sendKeys(id);
		return this;
	}

	public TrackPage deleteTrackBtn() {
		deleteTrackBtn.click();
		return this;
	}
}
