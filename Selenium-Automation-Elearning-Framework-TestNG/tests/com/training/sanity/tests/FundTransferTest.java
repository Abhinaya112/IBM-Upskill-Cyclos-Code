// This is a test case to verify if fund transfer is successful from one member to another and later verify it as Admin login
package com.training.sanity.tests;

import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.FundTransferPOM;
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

public class FundTransferTest {
	private WebDriver driver;
	private String baseUrl;
	private FundTransferPOM fundTransferPOM;
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
		fundTransferPOM = new FundTransferPOM(driver); 
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
	public void TransferFundsTest() throws InterruptedException {
		// Login as Member
		fundTransferPOM.sendUserName("abhinaya");
		fundTransferPOM.sendPassword("abhinaya");
		fundTransferPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_transferFund");
		//Click on account
		fundTransferPOM.clickAccounts();
		// Search and enter name of another member
		fundTransferPOM.clickMemberPayment();
		fundTransferPOM.sendmemberName("Selenium");
		//Input all values needed for fund transfer
		fundTransferPOM.sendAmount("1");
		fundTransferPOM.sendDesc("Bday");
		//Click on Submit
		fundTransferPOM.clickSubmit();
		fundTransferPOM.clickSubmit1();
		// Logout 
		fundTransferPOM.clickLogOut();
		// Login as Admin
		fundTransferPOM.sendUserName("admin");
		fundTransferPOM.sendPassword("12345");
		fundTransferPOM.clickLoginBtn(); 
		// Search for the member who has made the payment
		fundTransferPOM.sendmemberName1("abhinaya");
		// click on account info and open the details of the transaction
		fundTransferPOM.clickAccountInfo();
		fundTransferPOM.clickOpen();
		// verify the From, To and Amount details present on the transaction page
		String ActualFrom=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/a")).getText();
		String ExpectedFrom="abhinaya";
		assertEquals(ActualFrom, ExpectedFrom);
		String ActualTo=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[3]/td[2]/a")).getText();
		String ExpectedTo="selenium";
		assertEquals(ActualTo, ExpectedTo);
		String ActualAmount=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]")).getText();
		String ExpectedAmount="0,01 units";
		assertEquals(ActualAmount, ExpectedAmount);

		
	}
}
