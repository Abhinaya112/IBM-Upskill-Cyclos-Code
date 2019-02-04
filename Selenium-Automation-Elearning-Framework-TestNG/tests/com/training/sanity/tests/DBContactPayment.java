package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.DBContactPaymentPOM;
import com.training.pom.ExcelPayContactsPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DBContactPayment {
	private WebDriver driver;
	private String baseUrl;
	private DBContactPaymentPOM dbContactPaymentPOM;
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
		dbContactPaymentPOM = new DBContactPaymentPOM(driver);
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
		dbContactPaymentPOM.sendUserName("abhinaya");
		dbContactPaymentPOM.sendPassword("abhinaya");
		dbContactPaymentPOM.clickLoginBtn();
	}

	@Test(priority=2 ,dataProvider = "db-inputs2", dataProviderClass = LoginDataProviders.class)
	public void contactPayment (String name, String amount,String description) throws InterruptedException {
		
		// Click on personal
		dbContactPaymentPOM.clickpersonal();
		// Click on contacts
		dbContactPaymentPOM.clickContacts();
		// Click on any one of the contact
		if (name.equalsIgnoreCase("manzoor"))
		{
			driver.findElement(By.xpath("//table/tbody/tr[2]/td[1]/a")).click();
		}
		else if (name.equalsIgnoreCase("Mariya")) {
			driver.findElement(By.xpath("//table/tbody/tr[3]/td[1]/a")).click();
		}
		else if (name.equalsIgnoreCase("selenium")) {
			driver.findElement(By.xpath("//table/tbody/tr[4]/td[1]/a")).click();
		}
		else if (name.equalsIgnoreCase("sunil")) {
			driver.findElement(By.xpath("//table/tbody/tr[5]/td[1]/a")).click();
		}
		// Click on make payment
		
		dbContactPaymentPOM.clickMakePayment();
		// Send in the details to make the payment to the Member
	
		dbContactPaymentPOM.sendAmount(amount);
		dbContactPaymentPOM.sendDescription(description);
		dbContactPaymentPOM.clickSubmit();
		dbContactPaymentPOM.clickSubmit1();
		String Expected="The payment has been performed";
		String Actual= driver.findElement(By.xpath("//td/table/tbody/tr[1]/td")).getText();
		assertEquals(Actual, Expected);

	}

}
