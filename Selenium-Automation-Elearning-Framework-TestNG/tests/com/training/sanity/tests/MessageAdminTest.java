// This is a test case to check if the member is able to send a message to the Admin
package com.training.sanity.tests;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.MessageAdminPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class MessageAdminTest {
	private WebDriver driver;
	private String baseUrl;
	private MessageAdminPOM messagePOM;
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
		messagePOM = new MessageAdminPOM(driver); 
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
	public void SendMessageTest() throws InterruptedException {
		// Login as Member
		messagePOM.sendUserName("abhinaya");
		messagePOM.sendPassword("abhinaya");
		messagePOM.clickLoginBtn(); 
		screenShot.captureScreenShot("1_sendMessage");
		// Click on Personal> Message > New Message
		messagePOM.clickPersonal();
		messagePOM.clickMessage();
		messagePOM.clickNewMessage();
		// Fill in the details on the message page
		messagePOM.selectSendTo(1);
		messagePOM.selectCategory(3);
		messagePOM.sendSubject("subject");
		messagePOM.senddescription("description");
		messagePOM.clickSubmit();
		// Validate the alert message
		Alert alert= driver.switchTo().alert();
		String expected1="The message was successfully sent";
		String actual1=alert.getText();
		assertEquals(actual1, expected1);
		alert.accept();
		// Logout
		messagePOM.clickLogOut();
		// Login as Admin
		messagePOM.sendUserName("admin");
		messagePOM.sendPassword("12345");
		messagePOM.clickLoginBtn();
		// Search and click to view the latest message
		messagePOM.clickAdminMessage();
		messagePOM.clickAdminMessage1();
		messagePOM.clickFirstMessage();
		Thread.sleep(1000);
		// Validate the From, Subject and Description details of the message 
		String ActualFrom=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[4]/td[2]/a")).getText();
		String ExpectedFrom="abhinaya";
		assertEquals(ActualFrom, ExpectedFrom);
		String Actualsub=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[5]/td[2]")).getText();
		String ExpectedSub="subject";
		assertEquals(Actualsub, ExpectedSub);
		System.out.println("Subject is" + Actualsub);
		String Actualdesc=driver.findElement(By.xpath("//table[1]/tbody/tr[2]/td/table/tbody/tr[6]/td[2]")).getText();
		String Expecteddesc="description";
		assertEquals(Expecteddesc, Actualdesc);
		System.out.println("Description is" + Actualdesc);
	}
}
