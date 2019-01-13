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
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_passwordTest");
		passwordPOM.clickpersonal();
		passwordPOM.clickchangePassword();
		passwordPOM.sendcurrentPassword("manzoor");
		passwordPOM.sendnewPassword("new1");
		passwordPOM.sendnewPassword1("new123");
		screenShot.captureScreenShot("2_passwordTest");
		passwordPOM.clicksubmit();
		screenShot.captureScreenShot("3_passwordTest");
		passwordPOM.verifyPassword();
		
		
	}
}
