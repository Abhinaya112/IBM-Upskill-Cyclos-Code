package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertSettingsPOM {

	private WebDriver driver;

	public AlertSettingsPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Login to the application

	@FindBy(id = "cyclosUsername")
	private WebElement userName;

	@FindBy(id = "cyclosPassword")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement loginBtn;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// Code to alter Alert Settings starts here

	// Locate and Click on Settings
	@FindBy(id = "menu9")
	private WebElement settings;

	public void clickSettings() {
		this.settings.click();
	}

	// Locate and click alert Settings
	@FindBy(id = "submenu9.1")
	private WebElement alertSettings;

	public void clickAlertSettings() {
		this.alertSettings.click();
	}

	// locate and Enter values on Given Bad Reference

	@FindBy(name = "setting(givenVeryBadRefs)")
	private WebElement BadRefs;

	public void sendBadRefs(String BadRefs) {
		this.BadRefs.clear();
		this.BadRefs.sendKeys(BadRefs);
	}

	// Locate and Click on change

	@FindBy(id = "modifyButton")
	private WebElement modify;

	public void clickModify() {
		this.modify.click();
	}

	// Locate and Click on save Button
	@FindBy(id = "saveButton")
	private WebElement save;

	public void clickSave() {
		this.save.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Logout of the application

	@FindBy(id = "menu15")
	private WebElement logOut;

	public void clickLogOut() {
		this.logOut.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Locate and click Back

	@FindBy(id = "btn")
	private WebElement back;

	public void clickBack() {
		this.back.click();
	}

}
