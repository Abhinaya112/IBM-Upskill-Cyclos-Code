package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MessageAdminPOM {

private WebDriver driver; 
	
	public MessageAdminPOM(WebDriver driver) {
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
	
	//Code to send message starts here
	
	
	// Click on personal
	@FindBy(id="menu1")
	private WebElement personal; 
	
	public void clickPersonal() {
		this.personal.click();
	}
	
	//click on message
	@FindBy(id="submenu1.1")
	private WebElement message; 
	
	public void clickMessage() {
		this.message.click();
	}
	
	//click on new message
		@FindBy(id="newButton")
		private WebElement newMessage; 
		
		public void clickNewMessage() {
			this.newMessage.click();
		}
		
	// Select Send To Member
		
	@FindBy(id="sendToSelect")
	private WebElement sendTo; 
	
	public void selectSendTo(int sendTo) {
		this.sendTo.click();
		Select drop=new Select(this.sendTo);
		drop.selectByIndex(sendTo);
	}
	
	
	// Select Category
	
	@FindBy(id="categorySelect")
	private WebElement category; 
	
	public void selectCategory(int category) {
		this.category.click();
		Select drop=new Select(this.category);
		drop.selectByIndex(category);
	}
	
	// Send Values to Subject TextBox
	
	@FindBy(id="subjectText")
	private WebElement subject; 
	
	public void sendSubject(String subject) {
		this.subject.clear();
		this.subject.sendKeys(subject);
	}
	
	// Send Description
	
	@FindBy(xpath="//*[@class='CSS1Compat']")
	private WebElement description;
	
     public void senddescription(String description) {
		
		driver.switchTo().frame(0);
		this.description.sendKeys(description);
		driver.switchTo().defaultContent();
}
		
		// Click on Submit
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement Submit; 
	
	public void clickSubmit() {
		this.Submit.click();
		}
	
	   // click on Logout
	
	@FindBy(id="menu6")
	private WebElement logOut; 
	
	public void clickLogOut() {
		this.logOut.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	
	// Click on message for Admin user
	@FindBy(id="menu8")
	private WebElement MessageAdmin; 
	
	public void clickAdminMessage() {
		this.MessageAdmin.click();
	}
	
	// Click on  Sub menu message for Admin user
		@FindBy(id="submenu8.0")
		private WebElement MessageAdmin1; 
		
		public void clickAdminMessage1() {
			this.MessageAdmin1.click();
		}
	
		// Click on first message 
	@FindBy(xpath="//table/tbody/tr[2]/td[3]/table/tbody/tr/td[2]/a")
	private WebElement FirstMessage; 
	
	public void clickFirstMessage() {
		this.FirstMessage.click();
	}
	
	
	
}

