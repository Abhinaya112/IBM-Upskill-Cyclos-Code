// This is a test case enabling the Admin to successfully search for a member and reset the password

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
	public void memberLoginTest() throws InterruptedException {
		// Login as Admin
		memberloginPOM.sendUserName("admin");
		memberloginPOM.sendPassword("12345");
		memberloginPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_memberlogin");
		//Search for the member named Selenium
		memberloginPOM.sendmemberUserName("Sele");
		// click on manage password
		memberloginPOM.clickmanagepwd();
		// Send new password
		memberloginPOM.sendNewPassword("Selenium1");
		memberloginPOM.sendNewPassword1("Selenium1");
		screenShot.captureScreenShot("2_memberlogin");
		// Click on force change checkbox
		memberloginPOM.clickforceChange();
		// click on reset button
		memberloginPOM.clickreset();
		memberloginPOM.handleAlert();
		screenShot.captureScreenShot("3_memberlogin");
		Thread.sleep(5000);
		screenShot.captureScreenShot("4_memberlogin");
		// verify if the password has been reset by the admin
		Alert alert=driver.switchTo().alert();
		String actual1=alert.getText();
		String expected1="The password was reset and sent to member";
		Assert.assertEquals(actual1, expected1);
				
	}
}

