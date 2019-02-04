package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DBContactPaymentPOM {

private WebDriver driver; 
	
	public DBContactPaymentPOM(WebDriver driver) {
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
	
	// code to make member payment to contacts starts here
	
	
	// Locate and click on personal
	@FindBy(id="menu1")
	private WebElement personal; 
	
	public void clickpersonal () {
		this.personal.click();
	}
	
	// Locate and click on contacts
	@FindBy(id="submenu1.3")
	private WebElement contacts; 
	
	public void clickContacts() {
		this.contacts.click();
	}
	
	
	
		
		// Locate and click on make payment
		@FindBy(xpath="//table/tbody/tr[1]/td[2]/input")
		private WebElement makePayment;
		
		public void clickMakePayment(){
			this.makePayment.click();
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

