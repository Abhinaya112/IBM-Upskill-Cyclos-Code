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
	
	@FindBy(id="cyclosUsername")
	private WebElement userName; 
	
	@FindBy(id="cyclosPassword")
	private WebElement password;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement loginBtn; 
	
	@FindBy(id="memberUsername")
	private WebElement memberUserName;
	
	@FindBy(xpath="//input[@linkurl='managePasswords?userId=4']")
	private WebElement managepwd;
	
	@FindBy(name="newPassword")
	private WebElement newPassword;
	
	@FindBy(name="newPasswordConfirmation")
	private WebElement newPassword1;
	
	@FindBy(name="forceChange")
	private WebElement forceChange;
	
	@FindBy(id="resetAndSendButton")
	private WebElement reset;
	
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
	public void sendmemberUserName(String memberUserName) throws InterruptedException {
		this.memberUserName.clear();
		this.memberUserName.sendKeys(memberUserName);
		Thread.sleep(5000);
		this.memberUserName.sendKeys(Keys.ENTER);
		//this.memberUserName.sendKeys(Keys.ENTER);
	}
	
	public void clickmanagepwd() {
		this.managepwd.click(); 
	}
	
	public void sendNewPassword(String newPassword) {
		this.newPassword.sendKeys(newPassword);
	}
	
	public void sendNewPassword1(String newPassword1) {
		this.newPassword1.sendKeys(newPassword1);
	}
	
	public void clickforceChange() {
		this.forceChange.click(); 
	}
	public void clickreset() {
		this.reset.click(); 
	}
	
	
	public void handleAlert(){
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void okmessage(){
		Alert alert=driver.switchTo().alert();
		String actual1=alert.getText();
		String expected1="The password was reset and sent to member";
		Assert.assertEquals(actual1, expected1);
		//System.out.println(actual1);
	}
}


