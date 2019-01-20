package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPaymentPOM {

	private WebDriver driver;

	public AdminPaymentPOM(WebDriver driver) {
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

	// Code for admin payment starts here

	// Locate and click on Accounts
	@FindBy(id = "menu3")
	private WebElement account;

	public void clickAccount() {
		this.account.click();
	}

	// Locate and click on member payment
	@FindBy(id = "submenu3.6")
	private WebElement memberPayment;

	public void clickMemberPayment() {
		this.memberPayment.click();
	}

	// Locate Member name and send value
	@FindBy(id = "memberUsername")
	private WebElement memberUserName;

	public void sendMemberUserName(String memberUserName) throws InterruptedException {
		this.memberUserName.clear();
		this.memberUserName.sendKeys(memberUserName);
		Thread.sleep(2000);
		this.memberUserName.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	// Locate and send Amount
	@FindBy(id = "amount")
	private WebElement amount;

	public void sendAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}

	// Locate and send Description

	@FindBy(id = "description")
	private WebElement description;

	public void sendDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}

	// Locate and click on Submit button

	@FindBy(id = "submitButton")
	private WebElement submit;

	public void clickSubmit() {
		this.submit.click();
	}

	// Locate and Click on submit

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submit1;

	public void clickSubmit1() {
		this.submit1.click();
	}

	// Locate and click on LogOut

	@FindBy(id = "menu15")
	private WebElement logOut;

	public void clickLogOut() {
		this.logOut.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// locate and click on member account

	@FindBy(id = "menu2")
	private WebElement memberAccount;

	public void clickMemberAccount() {
		this.memberAccount.click();
	}

	// locate and click on Account Info

	@FindBy(id = "submenu2.0")
	private WebElement AccountInfo;

	public void clickAccountInfo() {
		this.AccountInfo.click();
	}

	// locate and click on expand account info

	@FindBy(xpath = "//table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[5]/img")
	private WebElement expandAccount;

	public void clickExpandAccount() {
		this.expandAccount.click();
	}

}
