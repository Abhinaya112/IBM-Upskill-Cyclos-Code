package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MemberLoginPOM {

private WebDriver driver; 
	
	public MemberLoginPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	 
	// Login to the Application
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement loginBtn; 
	
	// Locate the text box to input member name
	@FindBy(id="memberUsername")
	private WebElement memberUserName;
	
	// Locate manage password button
	@FindBy(xpath="//input[@linkurl='managePasswords?userId=4']")
	private WebElement managepwd;
	
	// Locate text box for new password
	@FindBy(name="newPassword")
	private WebElement newPassword;
	
	@FindBy(name="newPasswordConfirmation")
	private WebElement newPassword1;
	
	// Locate element for force change checkbox
	@FindBy(name="forceChange")
	private WebElement forceChange;
	
	// locate reset password botton
	@FindBy(id="resetAndSendButton")
	private WebElement reset;
	
	// Send username for login
	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}
	
	// Send password for login
	public void sendPassword(String password) {
		this.password.clear(); 
		this.password.sendKeys(password); 
	}
	
	// click on login bUtton
	public void clickLoginBtn() {
		this.loginBtn.click(); 
	}
	
	// Enter member name whose password needs to be reset by the admin
	public void sendmemberUserName(String memberUserName) throws InterruptedException {
		this.memberUserName.clear();
		this.memberUserName.sendKeys(memberUserName);
		Thread.sleep(5000);
		this.memberUserName.sendKeys(Keys.ENTER);
		//this.memberUserName.sendKeys(Keys.ENTER);
	}
	
	// Click on manage password
	public void clickmanagepwd() {
		this.managepwd.click(); 
	}
	
	// Send new password
	public void sendNewPassword(String newPassword) {
		this.newPassword.sendKeys(newPassword);
	}
	
	
	// confirm new password
	public void sendNewPassword1(String newPassword1) {
		this.newPassword1.sendKeys(newPassword1);
	}
	
	// Place a tick mark on force change checkbox
	public void clickforceChange() {
		this.forceChange.click(); 
	}
	
	// Click on reset button
	public void clickreset() {
		this.reset.click(); 
	}
	
	// confirm that password needs to be reset
	public void handleAlert(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	
}


