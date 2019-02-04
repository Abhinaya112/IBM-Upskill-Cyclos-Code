package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoanRepaymentPOM {

	private WebDriver driver;

	public LoanRepaymentPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// Login to the application

	@FindBy(id = "cyclosUsername")
	private WebElement userName;

	@FindBy(id = "cyclosPassword")
	private WebElement password;

	@FindBy(xpath = "//input[@value='Submit']")
	private WebElement loginBtn;

	public void sendUserName(String userName) {
		this.userName.clear();
		this.userName.sendKeys(userName);
	}

	public void sendPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);
	}

	public void clickLoginBtn() {
		this.loginBtn.click();
	}

	// Grant Loan by admin

	// Locate member name field
	@FindBy(id = "memberUsername")
	private WebElement memberName;

	// Send member user name
	public void sendmemberName(String memberName) throws InterruptedException {
		this.memberName.clear();
		this.memberName.sendKeys(memberName);
		// Thread.sleep(5000);
		this.memberName.sendKeys(Keys.ENTER);
		Thread.sleep(1000);

	}

	// Locate submit button on grant loan
	@FindBy(xpath = "//input[@linkurl='grantLoan?memberId=30']")
	private WebElement grantLoanSubmit;

	// Click on grant loan button
	public void ClickGrantLoan() {
		this.grantLoanSubmit.click();
	}

	// Locate Amount field

	@FindBy(id = "amount")
	private WebElement amount;

	// Enter value on amount field

	public void sendAmount(String amount) {
		this.amount.clear();
		this.amount.sendKeys(amount);
	}

	// Locate description
	@FindBy(id = "description")
	private WebElement description;

	// Send values for description
	public void sendDescription(String description) {
		this.description.clear();
		this.description.sendKeys(description);
	}

	// Locate Submit
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submit;

	// Click on submit
	public void clickSubmit() throws InterruptedException {
		this.submit.click();
		Thread.sleep(1000);
	}

	// Locate LogOut button
	@FindBy(id = "menu15")
	private WebElement logOut;

	// Click on LogOut and accept the alert
	public void clickLogOut() {
		this.logOut.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// Click on Account
	@FindBy(id = "menu2")
	private WebElement account;

	// Click on Account
	public void clickAccount() {
		this.account.click();
	}

	// Click on Loans
	@FindBy(id = "submenu2.3")
	private WebElement loan;

	// Click on loan
	public void clickloan() {
		this.loan.click();
	}

	// Click on first loan

	// @FindBy(xpath="//tbody/tr[2]/td/table/tbody/tr[9]/td[4]/img")
	@FindBy(xpath = "//table/tbody/tr[2]/td[4]/img")
	private WebElement firstloan;

	@FindBy(linkText = "8")
	// @FindBy(xpath="/*[@id='tdContents']/table[2]/tbody/tr/td[2]/span/span")
	private WebElement lastPage;

	// Click on first loan
	public void clickfirstloan() {
		this.firstloan.click();

	}
	// Click on last page

	public void clicklastpage() {
		this.lastPage.click();
	}

	// Click on repay button
	@FindBy(xpath = "//input[@value='Repay']")
	private WebElement repay;

	// Click on repay button
	public void clickrepay() {
		this.repay.click();

		// accept alert
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	// Locate RepayAmount
	@FindBy(id = "amountText")
	private WebElement repayAmount;

	// Send values for repayAmount
	public void sendRepayAmount(String repayAmount) {
		this.repayAmount.clear();
		this.repayAmount.sendKeys(repayAmount);
	}

	// Get the value of remaining amount

	public void remaining() {
		String s = repayAmount.getAttribute("value");
		System.out.println("Remaining amount is " + s);
	}

}
