package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AlbumPage {

	public final String url = "http://127.0.0.1:5500/static/album.html";
	
	@FindBy(xpath = "/html/body/div/li/div/button")
	private WebElement albumMenuBtn;
	// CLICKS OPTION TO MAKE AN ALBUM
	@FindBy(xpath = "/html/body/div/li/div/div/button[1]")
	private WebElement createAlbBtn;
	// FINDS ALBUM NAME SECTION
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/form/div[1]/input")
	private WebElement albumNameField;
	// FINDS COVER SECTION
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/form/div[2]/input")
	private WebElement coverField;
	// FINDS CREATE BUTTON TO MAKE ALBUM
	@FindBy(xpath = "/html/body/div[1]/div[3]/div/div/div[2]/form/div[4]/button")
	private WebElement createBtn;
	// FINDS TEXT SAYING CREATED
	/*@FindBy(xpath="//*[@id=\"success-create\"]")
	private WebElement textBox;
}*/
	
	public AlbumPage clickAlbumBtn() {
		albumMenuBtn.click();

		return this;
	}
	
	public AlbumPage clickCreateAlbBtn() {
		createAlbBtn.click();
		return this;
	}
	public AlbumPage addAlbumName(String name) {
		albumNameField.sendKeys(name);
		return this;
	}
	public AlbumPage addCover(String name) {
		coverField.sendKeys(name);
		return this;
	}
	public AlbumPage clickCreate() {
		createBtn.click();
		return this;
	}
}
