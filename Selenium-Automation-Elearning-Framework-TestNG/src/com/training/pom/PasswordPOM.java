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
	
	@FindBy(id="menu1")
	private WebElement personal; 
	
	@FindBy(id="submenu1.7")
	private WebElement changePassword; 
	
	@FindBy(name="oldPassword")
	private WebElement currentPassword;
	
	@FindBy(name="newPassword")
	private WebElement newPassword;
	
	@FindBy(name="newPasswordConfirmation")
	private WebElement newPassword1;
	
	@FindBy(xpath="//input[@value='Submit']")
	private WebElement submit;
	
	
	public void sendcurrentPassword(String currentPassword) {
		this.currentPassword.clear();
		this.currentPassword.sendKeys(currentPassword);
	}
	public void sendnewPassword(String newPassword) {
		this.newPassword.clear();
		this.newPassword.sendKeys(newPassword);
	}
	public void sendnewPassword1(String newPassword1) {
		this.newPassword1.clear();
		this.newPassword1.sendKeys(newPassword1);
	}
	
	
	public void clickpersonal() {
		this.personal.click(); 
	}
	public void clickchangePassword() {
		this.changePassword.click(); 
	}
	
	public void clicksubmit() {
		this.submit.click(); 
	}
	
	
	public void verifyPassword(){
		/* this.currentPassword.getText();
		this.newPassword.getText();
		this.newPassword1.getText(); */
		Alert alert=driver.switchTo().alert();
		String expected1="Passwords are not Equal";
		String actual1=alert.getText().replace("\n","");
		alert.accept();
		Assert.assertEquals(actual1, expected1);

	}
}