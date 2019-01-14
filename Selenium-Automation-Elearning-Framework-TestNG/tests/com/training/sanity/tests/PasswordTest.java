


// This is a test case to verify the error message displayed when the new password and confirm new password are different


package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class PasswordTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private PasswordPOM passwordPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		loginPOM = new LoginPOM(driver); 
		passwordPOM = new PasswordPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test 
	public void validpasswordTest() {
		// login to the application as admin
		passwordPOM.sendUserName("admin");      
		passwordPOM.sendPassword("12345");      
		passwordPOM.clickLoginBtn();              
		screenShot.captureScreenShot("1_passwordTest");
		// Click on the personal Link
		passwordPOM.clickpersonal();    
		// Click on change password
		passwordPOM.clickchangePassword();   
		// Enter current password
		passwordPOM.sendcurrentPassword("12345");
		// Enter different values for new password and confirm new password
		passwordPOM.sendnewPassword("1234");      
		passwordPOM.sendnewPassword1("1234567"); 
		screenShot.captureScreenShot("2_passwordTest"); 
		// Click on submit button
		passwordPOM.clicksubmit();               
		screenShot.captureScreenShot("3_passwordTest");
		// Verify the alert message displayed
		Alert alert=driver.switchTo().alert();
		String expected1="Passwords are not Equal";
		String actual1=alert.getText().replace("\n","");
		alert.accept();
		Assert.assertEquals(actual1, expected1);
	
		
		
		
	}
}

