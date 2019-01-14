

package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PasswordPOM {

	private WebDriver driver; 
	
	
	public PasswordPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	// Login to application
	
	
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

	// Locating the link personal
	@FindBy(id="menu1")
	private WebElement personal; 
	
	// Locating the change password button
	@FindBy(id="submenu1.1")
	private WebElement changePassword; 
	
	//Locating the old password text box
	@FindBy(name="oldPassword")
	private WebElement currentPassword;
	
	// Locating the new password text box
	@FindBy(name="newPassword")
	private WebElement newPassword;
	
	//Locating the Confirm new password text Box
	@FindBy(name="newPasswordConfirmation")
	private WebElement newPassword1;
	
	// Locating the Submit button
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	//Sending the value of old password 
	public void sendcurrentPassword(String currentPassword) {
		this.currentPassword.clear();
		this.currentPassword.sendKeys(currentPassword);
	}
	
	// Sending the value of new password
	public void sendnewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
	}
	
	// Sending the value of confirm new password
	public void sendnewPassword1(String newPassword1) {
		this.newPassword1.clear();
		this.newPassword1.sendKeys(newPassword1);
	}
	
	// Click on personal link
	public void clickpersonal() {
		this.personal.click(); 
	}
	
	// Click on change password
	public void clickchangePassword() {
		this.changePassword.click(); 
	}
	
	// click on submit button
	public void clicksubmit() {
		this.submit.click(); 
	}
	
	


	
}