package com.training.pom;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class CreateAdPOM {
	
private WebDriver driver; 
	
	public CreateAdPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="menu1")
	private WebElement personal; 
	
	@FindBy(id="submenu1.2")
	private WebElement advertisements; 
	
	@FindBy(id="newButton")
	private WebElement submit;
	
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
	
	@FindBy(id="saveButton")
	private WebElement save;
	
	@FindBy(id="backButton")
	private WebElement back;
	
	public void sendtitle(String title) {
		this.title.clear();
		this.title.sendKeys(title);
	}
	
	
	public void selectcategory(int category) {
		this.category.click();
		Select drop=new Select(this.category);
		drop.selectByIndex(category);
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
	
	public void clickpersonal() {
		this.personal.click(); 
	}
	public void clickad() {
		this.advertisements.click(); 
	}
	
	public void clicksubmit() {
		this.submit.click(); 
	}
	
	public void checknotexpire() {
		this.notexpire.click(); 
	}
	
	public void clicksave() {
		this.save.click(); 
	}
	
	
	public void clickback() {
		this.back.click(); 
	}
	
	public void closealert(){
		Alert alert= driver.switchTo().alert();
		String actual1=alert.getText();
		String expected1="Advertisement inserted";
		assertEquals(actual1, expected1);
		alert.accept();
		
	}


	
}
