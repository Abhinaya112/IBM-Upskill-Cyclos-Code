// This is a Test case to check if member is able to repay the loan amount sanctioned by the Admin
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.LoanRepaymentPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoanRepaymentTest {
	private WebDriver driver;
	private String baseUrl;
	private LoanRepaymentPOM loanRepayPOM;
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
		loanRepayPOM = new LoanRepaymentPOM(driver); 
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
	public void RepayLoanTest() throws InterruptedException {
		//Login as Admin
		loanRepayPOM.sendUserName("admin");
		loanRepayPOM.sendPassword("12345");
		loanRepayPOM.clickLoginBtn(); 
		screenShot.captureScreenShot("First");
		//Search for member
		loanRepayPOM.sendmemberName("abhinaya");
		Thread.sleep(1000);
		// Grant loan to Member
		loanRepayPOM.ClickGrantLoan();
		loanRepayPOM.sendAmount("1000");
		loanRepayPOM.sendDescription("Home Loan");
		loanRepayPOM.clickSubmit();
		loanRepayPOM.clickSubmit();
		//Verify that the loan was granted successfully
		Alert alert=driver.switchTo().alert();
		String expected1="The loan was successfully granted";
		String actual1=alert.getText();
		assertEquals(actual1, expected1);
		System.out.println(actual1);
	    alert.accept();
		// Logout 
		loanRepayPOM.clickLogOut();
		
		// Login as Member
		loanRepayPOM.sendUserName("abhinaya");
		loanRepayPOM.sendPassword("abhinaya");
		loanRepayPOM.clickLoginBtn();
		// Click on Account >Loan
		loanRepayPOM.clickAccount();
		loanRepayPOM.clickloan();
		//loanRepayPOM.clicklastpage();
		loanRepayPOM.clickfirstloan();
		// Enter the amount for Repay
		loanRepayPOM.sendRepayAmount("500");
		loanRepayPOM.clickrepay();
		Thread.sleep(2000);
		// Verify if the Repayments was successful
	    alert=driver.switchTo().alert();
		String expected2="The repayment was succesfully processed";
		String actual2=alert.getText();
		assertEquals(actual2, expected2);
		System.out.println(actual2);
		alert.accept();
		// Display the remaining amount
		loanRepayPOM.remaining();
	
	}
}
