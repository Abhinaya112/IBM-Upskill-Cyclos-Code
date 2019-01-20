// This is a test case to send the money from Admin to Member and verify the same.

package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.AdminPaymentPOM;
import com.training.pom.LoginPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminPaymentTest {
	private WebDriver driver;
	private String baseUrl;
	private AdminPaymentPOM adminPaymentPOM;
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
		adminPaymentPOM = new AdminPaymentPOM(driver); 
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
	public void AdminPayTest() throws InterruptedException {
		//Login as Admin
		adminPaymentPOM.sendUserName("admin");
		adminPaymentPOM.sendPassword("12345");
		adminPaymentPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_AdminPay");
		//Click on Account
		adminPaymentPOM.clickAccount();
		//Click on Member Payment
		adminPaymentPOM.clickMemberPayment();
		//Send in the details to make the payment to the Member
		adminPaymentPOM.sendMemberUserName("abhinaya");
		adminPaymentPOM.sendAmount("1");
		adminPaymentPOM.sendDescription("From Admin to Abhinaya");
		adminPaymentPOM.clickSubmit();
		adminPaymentPOM.clickSubmit1();
		//Logout from the application
		adminPaymentPOM.clickLogOut();
		//Login as Member 
		adminPaymentPOM.sendUserName("abhinaya");
		adminPaymentPOM.sendPassword("abhinaya");
		adminPaymentPOM.clickLoginBtn();
		//click on Member Account > Account Info > click on first icon
		adminPaymentPOM.clickMemberAccount();
		adminPaymentPOM.clickAccountInfo();
		adminPaymentPOM.clickExpandAccount();
		// Assert if member has received the amount from Admin
		String ActualFrom=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")).getText();
		String ExpectedFrom ="Community account";
		assertEquals(ActualFrom, ExpectedFrom);
		String ActualAmount=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]")).getText();
		String ExpectedAmount ="0,01 units";
		assertEquals(ActualAmount, ExpectedAmount);
		
		
		
	}
}
