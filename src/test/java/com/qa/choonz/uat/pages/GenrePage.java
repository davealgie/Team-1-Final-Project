package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GenrePage {
	public final String url = "http://127.0.0.1:5500/static/index.html";

	@FindBy(xpath = "/html/body/div[1]/h1[5]/div/div/div/button")
	private WebElement genreMenuBtn;

	@FindBy(xpath = "/html/body/div[1]/h1[5]/div/div/div/div/button[1]")
	private WebElement createGenreBtn;

	@FindBy(xpath = "/html/body/div[9]/div/div/div[2]/form/div[1]/input")
	private WebElement genreNameField;
	
	@FindBy(xpath = "/html/body/div[9]/div/div/div[2]/form/div[2]/input")
	private WebElement genreDescriptionField;

	@FindBy(xpath = "/html/body/div[9]/div/div/div[2]/form/div[3]/button[2]")
	private WebElement createBtn;

	public GenrePage  clickGenreMenu() {
		genreMenuBtn.click();
		return this;
	}

	public GenrePage  clickCreateGenre() {
		createGenreBtn.click();
		return this;
	}

	public GenrePage addNameField(String name) {
		genreNameField.sendKeys(name);
		return this;
	}
	
	public GenrePage addDescriptionField(String name) {
		genreDescriptionField.sendKeys(name);
		return this;
	}
	

	public GenrePage clickCreate() {
		createBtn.click();
		return this;
	}
}


