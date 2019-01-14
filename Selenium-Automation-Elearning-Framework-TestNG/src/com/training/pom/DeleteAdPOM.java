package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DeleteAdPOM {

private WebDriver driver; 
	
	public DeleteAdPOM(WebDriver driver) {
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
	
	// Locate personal link
	@FindBy(id="menu1")
	private WebElement personal; 
	
	// Locate Advertisement link
	@FindBy(id="submenu1.2")
	private WebElement advertisements; 
	
	// Locate ad to be deleted
	@FindBy(xpath="//tr[2]/td[6]/img[@src='/web/pages/images/delete.gif']")
	private WebElement deleteAd; 
	
	// click on personal link
	public void clickpersonal() {
		this.personal.click(); 
	}
	// click on ad
	public void clickad() {
		this.advertisements.click(); 
	}
	// click on delete Ad icon
	public void deleteAd() {
		
		this.deleteAd.click(); 
	}
	
	// confirm delete
	public void confirmdelete(){
		Alert alert= driver.switchTo().alert();
		alert.accept();
	}
		
	
}
