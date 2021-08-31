package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrackPage {
	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[2]/div/div/div/button")
	private WebElement trackMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[2]/div/div/div/div/button[1]")
	private WebElement createTrackBtn;

	@FindBy(xpath = "/html/body/div[2]/div[9]/div/div/div[2]/form/div[1]/input")
	private WebElement trackNameField;
	
	@FindBy(xpath = "/html/body/div[2]/div[9]/div/div/div[2]/form/div[2]/input")
	private WebElement trackLyricsField;
	
	@FindBy(xpath = "/html/body/div[2]/div[9]/div/div/div[2]/form/div[3]/input")
	private WebElement trackDurationField;

	@FindBy(xpath = "/html/body/div[2]/div[9]/div/div/div[2]/form/div[6]/button[1]")
	private WebElement createBtn;

	public TrackPage  clickTrackMenu() {
		trackMenuBtn.click();
		return this;
	}

	public TrackPage   clickCreateTrack() {
		createTrackBtn.click();
		return this;
	}

	public TrackPage  addNameField(String name) {
		trackNameField.sendKeys(name);
		return this;
	}
	
	public TrackPage addLyricsField(String name) {
		trackLyricsField.sendKeys(name);
		return this;
	}
	
	public TrackPage addDurationField(String duration) {
		trackDurationField.sendKeys(duration);
		return this;
	}
	

	public TrackPage  clickCreate() {
		createBtn.click();
		return this;
	}
}




