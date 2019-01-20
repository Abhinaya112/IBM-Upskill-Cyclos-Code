package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FundTransferPOM {

	private WebDriver driver;

	public FundTransferPOM(WebDriver driver) {
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

	// Fund Transfer Code starts here

	// click on accounts Link
	@FindBy(id = "menu2")
	private WebElement Accounts;

	public void clickAccounts() {
		this.Accounts.click();
	}

	// Click on Member payments
	@FindBy(id = "submenu2.4")
	private WebElement memberPayment;

	public void clickMemberPayment() {
		this.memberPayment.click();
	}

	// Locate member name field
	@FindBy(id = "memberUsername")
	private WebElement memberName;

	// Send member user name
	public void sendmemberName(String memberName) throws InterruptedException {
		this.memberName.clear();
		this.memberName.sendKeys(memberName);
		// Thread.sleep(5000);
		this.memberName.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		this.memberName.sendKeys(Keys.ENTER);
	}

	// Send Amount

	@FindBy(id = "amount")
	private WebElement amount;

	public void sendAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}

	// Send Description

	@FindBy(id = "description")
	private WebElement description;

	public void sendDesc(String description) throws InterruptedException {
		this.description.clear();
		this.description.sendKeys(description);
		Thread.sleep(1000);
	}

	// Click submit

	@FindBy(id = "submitButton")
	private WebElement submitBtn;

	public void clickSubmit() throws InterruptedException {
		this.submitBtn.click();
		Thread.sleep(2000);
	}

	// Click Submit1

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement submit1;

	public void clickSubmit1() {
		this.submit1.click();
	}

	// Click LogOut

	@FindBy(id = "menu6")
	private WebElement logOut;

	public void clickLogOut() {
		this.logOut.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Search for member name as Admin

	public void sendmemberName1(String memberName) throws InterruptedException {
		this.memberName.clear();
		this.memberName.sendKeys(memberName);
		// Thread.sleep(5000);
		this.memberName.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	// Click Account info of the member
	@FindBy(xpath = "//input[@linkurl='accountOverview?memberId=30']")
	private WebElement AccountInfo;

	public void clickAccountInfo() throws InterruptedException {
		Thread.sleep(1000);
		this.AccountInfo.click();
	}

	// Check the Account Info

	@FindBy(xpath = "//table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[5]/img")
	private WebElement Open;

	public void clickOpen() {
		this.Open.click();
	}

}
