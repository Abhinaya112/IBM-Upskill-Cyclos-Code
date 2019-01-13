package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.CreateAdPOM;
import com.training.pom.LoginPOM;
import com.training.pom.PasswordPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
	public void validCreateAdTest() {
		loginPOM.sendUserName("manzoor");
		loginPOM.sendPassword("manzoor");
		loginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_createAd");
		createAdPOM.clickpersonal();
		screenShot.captureScreenShot("2_createAd");
		createAdPOM.clickad();
		createAdPOM.clicksubmit();
		createAdPOM.sendtitle("new offer 1");
		createAdPOM.selectcategory(1);
		createAdPOM.sendprice("7");
		createAdPOM.checknotexpire();
		createAdPOM.senddescription("new offer for member");
		screenShot.captureScreenShot("3_createAd");
		createAdPOM.clicksave();
		createAdPOM.closealert();
		screenShot.captureScreenShot("4_createAd");
		createAdPOM.clickback();
		screenShot.captureScreenShot("5_createAd");
		

		
	}
}


