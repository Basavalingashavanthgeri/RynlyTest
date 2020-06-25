package com.rynly.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rynly.qa.base.TestBase;
import com.rynly.qa.pages.HomePage;
import com.rynly.qa.pages.LoginPage;
import com.rynly.qa.pages.PackageCreatePage;
import com.rynly.qa.util.TestUtil;

public class Runner extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PackageCreatePage packageCreatePage;
	TestUtil testUtil;
	String sheetName = "Address";
	
	@BeforeSuite
	public void setUp() {
		initialization();
	}
	
	@Test(priority = 1)
	public void login() {
		loginPage = new LoginPage();
		loginPage.clickOnSignInLink();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
//	@Test(priority = 2)
//	public void createShipment() {
//		try {
//			homePage.clickOnCreatePackage();
//		}
//		catch(org.openqa.selenium.StaleElementReferenceException ex)
//		{
//			homePage.clickOnCreatePackage();
//		}
//		driver.quit();
//		
//	}
	
	
//	@Test(priority = 2)
//	public void createPackage() {
//		homePage = new HomePage();
//		homePage.clickOnCreatePackage();
//	}
	
//	@DataProvider
//	public Object[][] getRynlyTestData() {
//		Object data[][] = TestUtil.getTestData(sheetName);
//		return data;
//	}
//	
//	
//	@Test(priority = 3, dataProvider="getRynlyTestData")
//	public void inpAddress(String Company, String ContactName, String Address1, String Address2, String City, String State, String Zipcode, String PhoneNo) {
//		packageCreatePage = new PackageCreatePage();
//		packageCreatePage.inputAddress(Company, ContactName, Address1, Address2, City, State, Zipcode, PhoneNo);
//	}
	
}
