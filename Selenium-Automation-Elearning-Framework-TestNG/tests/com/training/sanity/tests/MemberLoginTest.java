package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MemberLoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MemberLoginTest {
	private WebDriver driver;
	private String baseUrl;
	private MemberLoginPOM memberloginPOM;
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
		memberloginPOM = new MemberLoginPOM(driver); 
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
	public void validLoginTest() throws InterruptedException {
		memberloginPOM.sendUserName("admin");
		memberloginPOM.sendPassword("12345");
		memberloginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_memberlogin");
		memberloginPOM.sendmemberUserName("Sele");
		memberloginPOM.clickmanagepwd();
		memberloginPOM.sendNewPassword("Selenium1");
		memberloginPOM.sendNewPassword1("Selenium1");
		screenShot.captureScreenShot("2_memberlogin");
		memberloginPOM.clickforceChange();
		memberloginPOM.clickreset();
		memberloginPOM.handleAlert();
		screenShot.captureScreenShot("3_memberlogin");
		Thread.sleep(5000);
		screenShot.captureScreenShot("4_memberlogin");
		memberloginPOM.okmessage();
				
	}
}

