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

	@FindBy(xpath = "/html/body/nav/div[2]/ul[2]/class/li[4]/a")
	private WebElement genreBtn;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div/a")
	private WebElement genreCheckCreate;
	
	@FindBy(xpath = "/html/body/div[1]/h1[5]/div/div/div/div/button[2]")
	private WebElement updateGenreBtn;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[1]/input")
	private WebElement updateIdField;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[2]/input")
	private WebElement updateNameField;

	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[3]/input")
	private WebElement updateDescriptionField;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[4]/button[2]")
	private WebElement updateBtn;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div/a")
	private WebElement genreUpdatedCard;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[4]/button[1]")
	private WebElement closeBtn;
	
	@FindBy(xpath = "/html/body/div[1]/h1[5]/div/div/div/div/button[3]")
	private WebElement deleteBtn;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[1]/input")
	private WebElement deleteId;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[2]/button[2]")
	private WebElement deleteGenre;
	
	@FindBy(xpath = "/html/body/div[10]/div/div/div[2]/form/div[2]/button[1]")
	private WebElement closeDelete;
	
	@FindBy(xpath = "/html/body/div[11]/div/div/div[2]/form/div[4]/button[1]")
	private WebElement closeWindow;
	
	
	public GenrePage closeWindow() {
		closeWindow.click();
		return this;
	}
	public GenrePage closeDelete() {
		closeDelete.click();
		return this;
	}
	public GenrePage deleteGenre() {
		deleteGenre.click();
		return this;
	}
	
	public GenrePage deleteId(String id) {
		deleteId.sendKeys(id);
		return this;
	}
	
	public GenrePage deleteBtn() {
		deleteBtn.click();
		return this;
	}


	public GenrePage clickGenreMenu() {
		genreMenuBtn.click();
		return this;
	}

	public GenrePage clickCreateGenre() {
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
	
	public GenrePage genrePage() {
		genreBtn.click();
		return this;
	}
	public GenrePage genreClick() {
		genreCheckCreate.click();
		return this;
	}
	
	public GenrePage updateButton() {
		updateGenreBtn.click();
		return this;
	}
	
	public GenrePage updateId(String id) {
		updateIdField.sendKeys(id);
		return this;
	}
	
	public GenrePage updateName(String name) {
		updateNameField.sendKeys(name);
		return this;
	}
	
	public GenrePage updateDescription(String description) {
		updateDescriptionField.sendKeys(description);
		return this;
	}
	
	public GenrePage updateBtn() {
		updateBtn.click();
		return this;
	}
	
	public GenrePage updatedCard() {
		genreUpdatedCard.click();
		return this;
	}
	
	public GenrePage closeBtn() {
		closeBtn.clear();
		return this;
	}
}
