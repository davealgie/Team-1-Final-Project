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
	
	@FindBy(xpath = "/html/body/nav/div[2]/ul[2]/class/li[2]/a")
	private WebElement artistNav;

	@FindBy(xpath = "/html/body/div/div[2]/div[1]/div/a")
	private WebElement createdArtistClick;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[2]/form/div[3]/button[2]")
	private WebElement updateArtistButton;
	
	@FindBy(xpath = "/html/body/div[1]/h1[4]/div/div/div/div/button[2]")
	private WebElement updatedArtistOption;

	@FindBy(xpath = "/html/body/div[5]/div/div/div[2]/form/div[1]/input")
	private WebElement artistIdField;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[2]/form/div[2]/input")
	private WebElement updateArtistNameField;
	
	@FindBy(xpath = "/html/body/div[5]/div/div/div[1]/button/span")
	private WebElement closeOff;
	
	@FindBy(xpath ="/html/body/div[4]/div/div/div[1]/button/span")
	private WebElement closeDelete;
	
	@FindBy(xpath = "/html/body/div[1]/h1[4]/div/div/div/div/button[3]")
	private WebElement deleteArtist;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/form/div[1]/input")
	private WebElement deleteId;
	
	@FindBy(xpath = "/html/body/div[4]/div/div/div[2]/form/div[2]/button[2]")
	private WebElement deleteArtistBtn;
	
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
	
	public ArtistPage clickNav() {
		artistNav.click();
		return this;
	}
	
	public ArtistPage checkCreated() {
		createdArtistClick.click();
		return this;
	}
	
	public ArtistPage updateButtonOption() {
		updatedArtistOption.click();
		return this;
	}
	
	public ArtistPage artistId(String id) {
		artistIdField.sendKeys(id);
		return this;
	}
	
	public ArtistPage updateArtistName(String name) {
		updateArtistNameField.sendKeys(name);
		return this;
	}
	
	public ArtistPage updateArtistBtn() {
		updateArtistButton.click();
		return this;
	}
	
	public ArtistPage closeX() {
		closeOff.click();
		return this;
	}
	
	public ArtistPage deleteArtist() {
		deleteArtist.click();
		return this;
	}
	
	public ArtistPage deleteId(String id) {
		deleteId.sendKeys(id);
		return this;
	}
	
	public ArtistPage deleteArtistBtn() {
		deleteArtistBtn.click();
		return this;
	}
	
	public ArtistPage closeDeleteMenu() {
		closeDelete.click();
		return this;
	}
}
