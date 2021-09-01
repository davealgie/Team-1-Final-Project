package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArtistPage {

	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[4]/div/div/div/button")
	private WebElement artistMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[4]/div/div/div/div/button[1]")
	private WebElement createArtistBtn;

	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/input")
	private WebElement artistNameField;

	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[2]/button[2]")
	private WebElement createBtn;

	public ArtistPage clickArtistMenu() {
		artistMenuBtn.click();
		return this;
	}

	public ArtistPage clickCreateArtist() {
		createArtistBtn.click();
		return this;
	}

	public ArtistPage addNameField(String name) {
		artistNameField.sendKeys(name);
		return this;
	}

	public ArtistPage clickCreate() {
		createBtn.click();
		return this;
	}
}
