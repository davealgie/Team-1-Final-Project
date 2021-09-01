package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumPage {

	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[1]/div/div/div/button")
	private WebElement albumMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[1]/div/div/div/div/button[1]")
	private WebElement albumCreateBtn;

	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[1]/input")
	private WebElement albumName;

	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[2]/input")
	private WebElement coverName;

	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/div[4]/button[1]")
	private WebElement createName;

	@FindBy(xpath = "/html/body/div[2]/div[7]/div/div/div[2]/form/p")
	private WebElement assertText;

	@FindBy(xpath = "/html/body/nav/div[2]/ul[2]/class/li[3]/a")
	private WebElement albumPage;

	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div/a")
	private WebElement readCard;

	@FindBy(xpath = "/html/body/div[1]/h1[1]/div/div/div/div/button[2]")
	private WebElement updateAlb;

	@FindBy(xpath = "/html/body/div[2]/div[6]/div/div/div[2]/form/div[1]/input")
	private WebElement updateId;

	@FindBy(xpath = "/html/body/div[2]/div[6]/div/div/div[2]/form/div[2]/input")
	private WebElement updateName;

	@FindBy(xpath = "/html/body/div[2]/div[6]/div/div/div[2]/form/div[3]/input")
	private WebElement updateCover;

	@FindBy(xpath = "/html/body/div[2]/div[6]/div/div/div[2]/form/div[5]/button")
	private WebElement updateAlbumButton;

	@FindBy(xpath = "/html/body/div[2]/div[6]/div/div/div[3]/button")
	private WebElement closeButton;
	
	@FindBy(xpath = "/html/body/div[1]/div[2]/div/div[1]/a")
	private WebElement updatedCard;

	@FindBy(xpath = "/html/body/div[1]/h1[1]/div/div/div/div/button[3]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div[8]/div/div/div[2]/form/div[1]/input")
	private WebElement deleteId;
	
	@FindBy(xpath = "/html/body/div[2]/div[8]/div/div/div[2]/form/div[2]/button")
	private WebElement deleteAlbum;
	
	@FindBy(xpath = "/html/body/div[2]/div[8]/div/div/div[3]/button")
	private WebElement closeOff;
	
	
	public AlbumPage closeOff() {
		closeOff.click();
		return this;
	}
	
	public AlbumPage deleteAlbum() {
		deleteAlbum.click();
		return this;
	}
	
	public AlbumPage deleteId(String id) {
		deleteId.sendKeys(id);
		return this;
	}
	
	public AlbumPage deleteBtn() {
		deleteBtn.click();
		return this;
	}
	
	public AlbumPage updatedCard() {
		updatedCard.click();
		return this;
	}
	public AlbumPage updatedAlbumContents(String id, String name, String cover) {
		updateId.sendKeys(id);
		updateName.sendKeys(name);
		updateCover.sendKeys(cover);
		return this;
	}

	public AlbumPage updatedAlb() {
		updateAlbumButton.click();
		return this;

	}
	public AlbumPage closeBtn() {
		closeButton.click();
		return this;
	}

	public AlbumPage updateAlb() {
		updateAlb.click();
		return this;
	}

	public AlbumPage readCard() {
		readCard.click();
		return this;
	}

	public AlbumPage clickAlbumPage() {
		albumPage.click();
		return this;
	}

	public AlbumPage clickAlbumMenu() {
		albumMenuBtn.click();
		return this;
	}

	public AlbumPage clickAlbumCreate() {
		albumCreateBtn.click();
		return this;
	}

	public AlbumPage albumName(String name) {
		albumName.sendKeys(name);
		return this;
	}

	public AlbumPage coverName(String cover) {
		coverName.sendKeys(cover);
		return this;
	}

	public AlbumPage createAlbum() {
		createName.click();
		return this;
	}

	public AlbumPage assertText() {
		assertText.getText();
		return this;
	}
}
