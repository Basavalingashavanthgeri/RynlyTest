package com.rynly.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rynly.qa.base.TestBase;
import com.rynly.qa.pages.HomePage;
import com.rynly.qa.pages.LoginPage;
import com.rynly.qa.pages.PackageCreatePage;
import com.rynly.qa.pages.BillingPage;
import com.rynly.qa.util.TestUtil;

public class BillingPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	PackageCreatePage packageCreatePage;
	TestUtil testUtil;
	String sheetName = "Address";
	String sheetName1 = "CardDetails";
	String sheetName2 = "PromoCode";
	BillingPage billingPage;
	
	public BillingPageTest() {
		super();
	}
	
//	@BeforeMethod
//	public void setUp() {
//		initialization();
//		testUtil = new TestUtil();
//		loginPage = new LoginPage();
//		homePage = new HomePage();
//		loginPage.clickOnSignInLink();
//		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		try {
//			packageCreatePage = homePage.clickOnCreatePackage();
//		}
//		catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			packageCreatePage = homePage.clickOnCreatePackage();
//		}
//		Object data[][] = TestUtil.getTestData(sheetName);
//		billingPage = packageCreatePage.inputAddress((String)data[0][0], (String)data[0][1], (String)data[0][2], (String)data[0][3], (String)data[0][4], (String)data[0][5], (String)data[0][6], (String)data[0][7]);
//	}
//	
//	@Test(priority = 1)
//	public void billingPageClick() {
//		billingPage.billingDetails();
//	}
	
	@DataProvider
	public Object[][] getRynlyTestData() {
		Object data1[][] = TestUtil.getTestData(sheetName1);
		return data1;
	}
	
	@Test(priority = 2, dataProvider = "getRynlyTestData")
	public void newBillingPageClick(String CardNumber, String Month, String Year, String Cvv, String Name, String Address, String Zipcode) {
		billingPage.newBillingDetails(CardNumber, Month, Year, Cvv, Name, Address, Zipcode);
	}
	
//	@DataProvider
//	public Object[][] getRynlyTestData1() {
//		Object data2[][] = TestUtil.getTestData(sheetName2);
//		return data2;
//	}
//	
//	@Test(priority = 3, dataProvider = "getRynlyTestData1")
//	public void errorMsgPromo(String PromoCode) {
//		billingPage.errorMsg(PromoCode);
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
