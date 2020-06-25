package com.rynly.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rynly.qa.base.TestBase;
import com.rynly.qa.pages.HomePage;
import com.rynly.qa.pages.LoginPage;
import com.rynly.qa.pages.PackageCreatePage;
import com.rynly.qa.util.TestUtil;

public class PackageCreatePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	PackageCreatePage packageCreatePage; 
	TestUtil testUtil;
	String sheetName = "Address";
	
	public PackageCreatePageTest() {
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
	}
	
	@DataProvider
	public Object[][] getRynlyTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@Test(priority = 1, dataProvider="getRynlyTestData")
	public void inputAddressTest(String Company, String ContactName, String Address1, String Address2, String City, String State, String Zipcode, String PhoneNo)
	{
		packageCreatePage.inputAddress(Company, ContactName, Address1, Address2, City, State, Zipcode, PhoneNo);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
