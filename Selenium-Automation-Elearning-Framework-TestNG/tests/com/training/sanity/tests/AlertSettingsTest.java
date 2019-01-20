// This is a test case to change the admin settings and block the user over 3 times of incorrect credentials
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AlertSettingsPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class AlertSettingsTest {
	private WebDriver driver;
	private String baseUrl;
	private String actual1;
	private String expected1;
	private AlertSettingsPOM alertSettingsPOM;
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
		alertSettingsPOM = new AlertSettingsPOM(driver); 
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
	public void AlertSettingTest() {
		//Login as Admin
		alertSettingsPOM.sendUserName("admin");
		alertSettingsPOM.sendPassword("12345");
		alertSettingsPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_Alert");
		// Click on settings
		alertSettingsPOM.clickSettings();
		alertSettingsPOM.clickAlertSettings();
		// Modify the Bad Reference to 2
		alertSettingsPOM.clickModify();
		alertSettingsPOM.sendBadRefs("2");
		String result=driver.findElement(By.name("setting(givenVeryBadRefs)")).getAttribute("value");
		int j = Integer.parseInt(result);	
		// Click on save
		alertSettingsPOM.clickSave();
		// Logout from the Application
		alertSettingsPOM.clickLogOut();
		// Login 3 times with incorrect user credentials and Print the error message displayed
		String expected1="Your login is now temporarily blocked";
		for (int i=0 ; i <=j ;i++)
		{
			alertSettingsPOM.sendUserName("selenium");
			alertSettingsPOM.sendPassword("selen");
			alertSettingsPOM.clickLoginBtn();
			 String actual=driver.findElement(By.xpath("//table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr[1]/td")).getText().replace("\n","").replace("blocked ", "blocked");
			 System.out.println(actual);
			 String expected="Your login is now temporarily blocked ";
			 actual1= actual;
			 alertSettingsPOM.clickBack();
			// System.out.println(expected);
		}
			 assertEquals(actual1, expected1);
			 System.out.println("success");
			 
		}
			
			
		
		
	}

