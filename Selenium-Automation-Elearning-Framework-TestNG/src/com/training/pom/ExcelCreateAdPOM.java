package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ExcelCreateAdPOM {
private WebDriver driver; 
	
	public ExcelCreateAdPOM(WebDriver driver) {
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
	
	// Locate the personal link
	@FindBy(id="menu1")
	private WebElement personal; 
	
	// locate advertisements
	@FindBy(id="submenu1.2")
	private WebElement advertisements; 
	
	// Locate new ad button
	@FindBy(id="newButton")
	private WebElement submit;
	
	// Locate fields for creating new Ad
	@FindBy(name="ad(title)")
	private WebElement title;
	
	@FindBy(name="ad(category)")
	private WebElement category;
	
	@FindBy(name="ad(price)")
	private WebElement price;
	
	@FindBy(id="notExpirableCheck")
	private WebElement notexpire;
	
	@FindBy(xpath="//*[@class='CSS1Compat']")
	private WebElement description;
	// Locate save button
	@FindBy(id="saveButton")
	private WebElement save;
	// locate Back button
	@FindBy(id="backButton")
	private WebElement back;
	
	// Send values for creating Ad 
	public void sendtitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	
	public void selectcategory(String category) {
		this.category.click();
		Select drop=new Select(this.category);
		drop.selectByVisibleText(category);
	}
	public void sendprice(String price) {
		this.price.clear();
		this.price.sendKeys(price);
	}
	
	public void senddescription(String description) {
		
		driver.switchTo().frame(0);
		this.description.sendKeys(description);
		driver.switchTo().defaultContent();
		
	}
	
	// click on personal link
	public void clickpersonal() {
		this.personal.click(); 
	}
	
	// click on create Ad button
	public void clickad() {
		this.advertisements.click(); 
	}
	// click on submit button
	public void clicksubmit() {
		this.submit.click(); 
	}
	
	// Click on check not expire checkbox
	public void checknotexpire() {
		this.notexpire.click(); 
	}
	// Click on save 
	public void clicksave() {
		this.save.click(); 
	}
	
	// Click on back button
	public void clickback() {
		this.back.click(); 
	}
	
	


	
}

