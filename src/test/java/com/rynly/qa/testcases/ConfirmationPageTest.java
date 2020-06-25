package com.rynly.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rynly.qa.base.TestBase;
import com.rynly.qa.pages.ConfirmationPage;
import com.rynly.qa.pages.HomePage;
import com.rynly.qa.pages.LoginPage;
import com.rynly.qa.pages.PackageCreatePage;
import com.rynly.qa.pages.BillingPage;
import com.rynly.qa.util.TestUtil;

public class ConfirmationPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PackageCreatePage packageCreatePage;
	TestUtil testUtil;
	String sheetName = "Address";
	BillingPage billingPage;
	ConfirmationPage confirmationPage;
	
	public ConfirmationPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		homePage = new HomePage();
		loginPage.clickOnSignInLink();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		try {
			packageCreatePage = homePage.clickOnCreatePackage();
		}
		catch (org.openqa.selenium.StaleElementReferenceException ex) {
			packageCreatePage = homePage.clickOnCreatePackage();
		}
		Object data[][] = TestUtil.getTestData(sheetName);
		billingPage = packageCreatePage.inputAddress((String)data[0][0], (String)data[0][1], (String)data[0][2], (String)data[0][3], (String)data[0][4], (String)data[0][5], (String)data[0][6], (String)data[0][7]);
		confirmationPage = billingPage.billingDetails();
	}
	
	@Test
	public void confirmationClick() {
		confirmationPage.confirmationDetails();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
