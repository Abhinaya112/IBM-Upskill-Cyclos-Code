package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.CreateAdPOM;
import com.training.pom.ExcelCreateAdPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ExcelCreateAd {
	private WebDriver driver;
	private String baseUrl;
	private ExcelCreateAdPOM excelCreateAdPOM;
	private CreateAdPOM createAdPOM;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeTest
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeClass
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.FIREFOX);
		excelCreateAdPOM = new ExcelCreateAdPOM(driver); 
		createAdPOM = new CreateAdPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}
	
	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginTest () throws InterruptedException {
		excelCreateAdPOM.sendUserName("abhinaya");
		excelCreateAdPOM.sendPassword("abhinaya");
		excelCreateAdPOM.clickLoginBtn();
	}

	@Test(priority=2 ,dataProvider = "excel-inputs3", dataProviderClass = LoginDataProviders.class)
	public void memberPayment (String title, String category, String price,String description, String message) throws InterruptedException {
		
		// Click on personal Link
		excelCreateAdPOM.clickpersonal();
		screenShot.captureScreenShot("2_createAd");
		// Click on create Ad
		excelCreateAdPOM.clickad();
		excelCreateAdPOM.clicksubmit();
		// Fill in values for creating a new Ad
		if (title !=null)excelCreateAdPOM.sendtitle(title);
		//if (title==null)excelCreateAdPOM.sendtitle(null);
		if (category !=null)excelCreateAdPOM.selectcategory(category);
		if (price !=null)excelCreateAdPOM.sendprice(price);
		excelCreateAdPOM.checknotexpire();
		if (description !=null)excelCreateAdPOM.senddescription(description);
		screenShot.captureScreenShot("3_createAd");
		// Click on save button
		excelCreateAdPOM.clicksave();
		// Verify the success message on creating a new Ad
		Alert alert= driver.switchTo().alert();
		String Actual=alert.getText().replaceFirst("\n", "");
		System.out.println("Actual is "+Actual);
		System.out.println("Expected is "+message);
		assertEquals(Actual, message);
		alert.accept();
		

		
	}
}


