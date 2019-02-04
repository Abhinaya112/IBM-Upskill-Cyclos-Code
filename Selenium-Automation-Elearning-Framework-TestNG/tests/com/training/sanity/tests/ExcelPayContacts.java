package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ExcelAdminPaymentPOM;
import com.training.pom.ExcelPayContactsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class ExcelPayContacts {
	private WebDriver driver;
	private String baseUrl;
	private ExcelPayContactsPOM excelPayContactsPOM;
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
		excelPayContactsPOM = new ExcelPayContactsPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginTest () throws InterruptedException {
		excelPayContactsPOM.sendUserName("abhinaya");
		excelPayContactsPOM.sendPassword("abhinaya");
		excelPayContactsPOM.clickLoginBtn();
	}

	@Test(priority=2 ,dataProvider = "excel-inputs2", dataProviderClass = LoginDataProviders.class)
	public void contactPayment (String memberUserName, String amount,String description) throws InterruptedException {
		
		// Click on personal
		excelPayContactsPOM.clickpersonal();
		// Click on contacts
		excelPayContactsPOM.clickContacts();
		// Click on any one of the contact
		if (memberUserName.equalsIgnoreCase("manzoor"))
		{
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/a")).click();
		}
		else if (memberUserName.equalsIgnoreCase("Mariya")) {
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]/a")).click();
		}
		else if (memberUserName.equalsIgnoreCase("selenium")) {
			driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]/a")).click();
		}
		else if (memberUserName.equalsIgnoreCase("sunil")) {
			driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]/a")).click();
		}
		// Click on make payment
		
		excelPayContactsPOM.clickMakePayment();
		// Send in the details to make the payment to the Member
	
		excelPayContactsPOM.sendAmount(amount);
		excelPayContactsPOM.sendDescription(description);
		excelPayContactsPOM.clickSubmit();
		excelPayContactsPOM.clickSubmit1();
		String Expected="The payment has been performed";
		String Actual= driver.findElement(By.xpath("//td/table/tbody/tr[1]/td")).getText();
		assertEquals(Actual, Expected);

	}

}