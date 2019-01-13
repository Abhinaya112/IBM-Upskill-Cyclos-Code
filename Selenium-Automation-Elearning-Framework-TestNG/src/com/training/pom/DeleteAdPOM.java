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
	
	
	@FindBy(id="menu1")
	private WebElement personal; 
	
	@FindBy(id="submenu1.2")
	private WebElement advertisements; 
	
	//@FindBy(id="//table/tbody/tr[2]/td[6]/img[2]")
	@FindBy(xpath="//tr[2]/td[6]/img[@src='/web/pages/images/delete.gif']")
	private WebElement deleteAd; 
	
	
	public void clickpersonal() {
		this.personal.click(); 
	}
	public void clickad() {
		this.advertisements.click(); 
	}
	
	public void deleteAd() {
		
		this.deleteAd.click(); 
	}
	
	public void confirmdelete(){
		Alert alert= driver.switchTo().alert();
		alert.accept();
	}
		public void success() throws InterruptedException{
			Thread.sleep(5000);
			Alert alert= driver.switchTo().alert();
			String actual1=alert.getText();
			String expected1="Advertisement removed";
			assertEquals(actual1, expected1);
			alert.accept();
		}
	
}
