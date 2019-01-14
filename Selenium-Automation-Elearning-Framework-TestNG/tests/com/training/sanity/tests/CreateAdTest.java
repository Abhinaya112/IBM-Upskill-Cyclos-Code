// This is a test case to create a new advertisement

package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateAdPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class CreateAdTest {


	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private CreateAdPOM createAdPOM;
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
		createAdPOM = new CreateAdPOM(driver);
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
	public void createAdTest() {
		// Login as a member
		createAdPOM.sendUserName("manzoor");
		createAdPOM.sendPassword("manzoor");
		createAdPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_createAd");
		// Click on personal Link
		createAdPOM.clickpersonal();
		screenShot.captureScreenShot("2_createAd");
		// Click on create Ad
		createAdPOM.clickad();
		createAdPOM.clicksubmit();
		// Fill in values for creating a new Ad
		createAdPOM.sendtitle("new offer 1");
		createAdPOM.selectcategory(1);
		createAdPOM.sendprice("7");
		createAdPOM.checknotexpire();
		createAdPOM.senddescription("new offer for member");
		screenShot.captureScreenShot("3_createAd");
		// Click on save button
		createAdPOM.clicksave();
		// Verify the success message on creating a new Ad
		Alert alert= driver.switchTo().alert();
		String actual1=alert.getText();
		String expected1="Advertisement inserted";
		assertEquals(actual1, expected1);
		alert.accept();
		screenShot.captureScreenShot("4_createAd");
		// click on the back button
		createAdPOM.clickback();
		screenShot.captureScreenShot("5_createAd");
		

		
	}
}


