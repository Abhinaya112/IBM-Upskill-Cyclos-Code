// This test case to remove an Advertisement
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.DeleteAdPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DeleteAdTest {

	private WebDriver driver;
	private String baseUrl;
	private LoginPOM loginPOM;
	private DeleteAdPOM deleteAdPOM;
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
		deleteAdPOM = new DeleteAdPOM(driver);
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
	public void deleteAdTest() throws InterruptedException {
		//Login to the Application
		deleteAdPOM.sendUserName("manzoor");
		deleteAdPOM.sendPassword("manzoor");
		deleteAdPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_deleteAd");
		//Click on personal link
		deleteAdPOM.clickpersonal();
		// Click on the Ad that needs to be deleted
		deleteAdPOM.clickad();
		deleteAdPOM.deleteAd();
		// Confirm deletion
		deleteAdPOM.confirmdelete();
		screenShot.captureScreenShot("2_deleteAd");
		// verify that the Ad is removed successfully
		Thread.sleep(5000);
		Alert alert= driver.switchTo().alert();
		String actual1=alert.getText();
		String expected1="Advertisement removed";
		assertEquals(actual1, expected1);
		alert.accept();
		screenShot.captureScreenShot("3_deleteAd");
		

		
	}
}

