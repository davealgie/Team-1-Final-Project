package com.qa.choonz.uat.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UsersPage {

	public final String url = "http://127.0.0.1:5500/static/index.html";
	// CLICK LOG IN/SIGN UP BUTTON
	@FindBy(xpath = "/html/body/nav/div[2]/ul[1]/form/div[1]/li/div/button")
	private WebElement signUpBtn;
	// CLICKS OPTION TO MAKE AN ACCOUNT
	@FindBy(xpath = "/html/body/nav/div[2]/ul[1]/form/div[1]/li/div/div/button[2]")
	private WebElement createAccBtn;
	// FINDS YOUR NAME SECTION
	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[1]/input")
	private WebElement fullNameField;
	// FINDS USERNAME SECTION
	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[2]/input")
	private WebElement userNameField;
	// FINDS PASSWORD SECTION
	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[3]/input")
	private WebElement passwordField;
	// FINDS CREATE BUTTON TO MAKE ACCOUNT
	@FindBy(xpath = "/html/body/div[3]/div/div/div[2]/form/div[4]/button")
	private WebElement createBtn;
	// FINDS TEXT SAYING CREATED
	@FindBy(xpath = "//*[@id=\"success-create\"]")
	private WebElement textBox;

	@FindBy(xpath = "/html/body/nav/div[2]/ul[1]/form/div[1]/li/div/div/button[1]")
	private WebElement logInBtn;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[3]/button[2]")
	private WebElement logInUser;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[1]/input")
	private WebElement loginUserName;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[2]/input")
	private WebElement loginPassword;

	@FindBy(xpath = "/html/body/nav/div[2]/ul[2]/class/li[1]/a")
	private WebElement homeBtn;

	@FindBy(xpath = "/html/body/div[3]/div/div/div[3]/button")
	private WebElement closeBtn;
	
	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[3]/button[1]")
	private WebElement closeLogOut;

	@FindBy(xpath = "/html/body/div[6]/div/div/div[2]/form/div[3]/button[1]")
	private WebElement closeLogIn;

	@FindBy(xpath = "/html/body/nav/div[2]/ul[1]/form/div[2]/li/div/button")
	private WebElement clickUser;

	@FindBy(xpath = "/html/body/nav/div[2]/ul[1]/form/div[2]/li/div/div/button")
	private WebElement clickLogOut;
	
	@FindBy(xpath = "/html/body/nav/div[2]/ul[2]/class/li[1]/a")
	private WebElement clickHomePage;
	
	public UsersPage clickHomePage() {
		clickHomePage.click();
		return this;
	}

	public UsersPage closeLogOut() {
		closeLogOut.click();
		return this;
	}
	
	public UsersPage clickLogOut() {
		clickLogOut.click();
		return this;
	}

	public UsersPage clickUser() {
		clickUser.click();
		return this;
	}

	public UsersPage closeLogIn() {
		closeLogIn.click();
		return this;
	}

	public UsersPage closeBtn() {
		closeBtn.click();
		return this;
	}

	public UsersPage clickHome() {
		homeBtn.click();
		return this;
	}

	public UsersPage clickLogInUser() {
		logInUser.click();
		return this;
	}

	public UsersPage AddLogInInfo(String user_name, String password) {
		loginUserName.sendKeys(user_name);
		loginPassword.sendKeys(password);
		return this;
	}

	public UsersPage clickLogIn() {
		signUpBtn.click();
		logInBtn.click();
		return this;
	}

	public UsersPage LogInBtn() {
		logInBtn.click();
		return this;
	}

	public UsersPage addFullname(String full_name) {
		fullNameField.sendKeys(full_name);
		return this;
	}

	public UsersPage addUsername(String user_name) {
		userNameField.sendKeys(user_name);
		return this;
	}

	public UsersPage addPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	public UsersPage clickSignUp() {
		signUpBtn.click();
		createAccBtn.click();
		return this;
	}

	public UsersPage clickCreate() {
		createAccBtn.click();
		return this;
	}

	public UsersPage clickCreateAccBtn() {
		createBtn.click();
		return this;
	}

	public String getText() {
		return textBox.getText();
	}

}
