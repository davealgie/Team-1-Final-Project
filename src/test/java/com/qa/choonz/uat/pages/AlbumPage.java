package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumPage {
	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[1]/div/div/div/button")
	private WebElement albumMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[1]/div/div/div/div/button[1]")
	private WebElement createAlbumBtn;

	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[1]/input")
	private WebElement albumNameField;
	
	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[2]/input")
	private WebElement albumCoverField;

	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[4]/button[1]")
	private WebElement createBtn;

	public AlbumPage clickAlbumMenu() {
		albumMenuBtn.click();
		return this;
	}

	public AlbumPage clickCreateAlbum() {
		createAlbumBtn.click();
		return this;
	}

	public AlbumPage  addNameField(String name) {
		albumNameField.sendKeys(name);
		return this;
	}
	
	public AlbumPage addCoverField(String cover) {
		albumCoverField.sendKeys(cover);
		return this;
	}

	public AlbumPage  clickCreate() {
		createBtn.click();
		return this;
	}
}


