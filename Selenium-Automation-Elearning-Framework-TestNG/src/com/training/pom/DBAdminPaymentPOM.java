package com.training.pom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DBAdminPaymentPOM {
private WebDriver driver; 
	
	public DBAdminPaymentPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	 // Login to the application
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Submit']")
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
	
	// code to make admin payment to members starts here
	
	
	// Locate and click on account
	@FindBy(id="menu3")
	private WebElement Accounts; 
	
	public void clickAccounts () {
		this.Accounts.click();
	}
	
	// Locate and click on member payment
	@FindBy(id="submenu3.6")
	private WebElement memberPay; 
	
	public void clickMemberPay() {
		this.memberPay.click();
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
		
		
		// Locate and select transaction type
		@FindBy(id = "type")
		private WebElement transactionType;
		
		public void selectTransactionType(String transactionType) {
			this.transactionType.click();
			Select drop=new Select(this.transactionType);
			drop.selectByVisibleText(transactionType);
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


}
