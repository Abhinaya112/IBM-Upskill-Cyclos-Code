package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPOM {

private WebDriver driver; 
	
	public LogOutPOM(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="menu15")
	private WebElement logout; 


	public void logout() {
		this.logout.click(); 
	}
	
public void alerts() {
	Alert alert=driver.switchTo().alert();
	alert.accept();
	
	
}

}