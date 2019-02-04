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
import com.training.pom.DBAdminPaymentPOM;
import com.training.pom.ExcelAdminPaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class DBAdminPayment {
	private WebDriver driver;
	private String baseUrl;
	private DBAdminPaymentPOM dbAdminPayPOM;
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
		dbAdminPayPOM = new DBAdminPaymentPOM(driver);
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
		dbAdminPayPOM.sendUserName("admin");
		dbAdminPayPOM.sendPassword("12345");
		dbAdminPayPOM.clickLoginBtn();
	}

	@Test(priority=2 ,dataProvider = "db-inputs1", dataProviderClass = LoginDataProviders.class)
	public void memberPayment (String memberUserName, String amount, String transactionType,String description) throws InterruptedException {
		
		// Click on Account
		dbAdminPayPOM.clickAccounts();
		// Click on Member Payment
		dbAdminPayPOM.clickMemberPay();
		// Send in the details to make the payment to the Member
		dbAdminPayPOM.sendMemberUserName(memberUserName);
		dbAdminPayPOM.sendAmount(amount);
		dbAdminPayPOM.selectTransactionType(transactionType);
		dbAdminPayPOM.sendDescription(description);
		dbAdminPayPOM.clickSubmit();
		dbAdminPayPOM.clickSubmit1();
		String Expected="The payment has been performed";
		String Actual= driver.findElement(By.xpath("//td/table/tbody/tr[1]/td")).getText();
		assertEquals(Actual, Expected);

	}

}