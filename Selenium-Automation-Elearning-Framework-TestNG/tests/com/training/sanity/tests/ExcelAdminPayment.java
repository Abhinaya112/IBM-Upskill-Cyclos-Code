package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
import com.training.pom.ExcelAdminPaymentPOM;
import com.training.pom.LoginPOM;
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

public class ExcelAdminPayment {
	private WebDriver driver;
	private String baseUrl;
	private ExcelAdminPaymentPOM excelAdminPayPOM;
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
		excelAdminPayPOM = new ExcelAdminPaymentPOM(driver);
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
		excelAdminPayPOM.sendUserName("admin");
		excelAdminPayPOM.sendPassword("12345");
		excelAdminPayPOM.clickLoginBtn();
	}

	@Test(priority=2 ,dataProvider = "excel-inputs1", dataProviderClass = LoginDataProviders.class)
	public void memberPayment (String memberUserName, String amount, String transactionType,String description) throws InterruptedException {
		
		// Click on Account
		excelAdminPayPOM.clickAccounts();
		// Click on Member Payment
		excelAdminPayPOM.clickMemberPay();
		// Send in the details to make the payment to the Member
		excelAdminPayPOM.sendMemberUserName(memberUserName);
		excelAdminPayPOM.sendAmount(amount);
		excelAdminPayPOM.selectTransactionType(transactionType);
		excelAdminPayPOM.sendDescription(description);
		excelAdminPayPOM.clickSubmit();
		excelAdminPayPOM.clickSubmit1();
		String Expected="The payment has been performed";
		String Actual= driver.findElement(By.xpath("//td/table/tbody/tr[1]/td")).getText();
		assertEquals(Actual, Expected);

	}

}