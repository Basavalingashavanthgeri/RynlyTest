package com.rynly.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rynly.qa.base.TestBase;
import com.rynly.qa.pages.HomePage;
import com.rynly.qa.pages.LoginPage;
import com.rynly.qa.pages.PackageCreatePage;
import com.rynly.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	LoginPageTest loginPageTest;
	HomePage homePage;
	PackageCreatePage packageCreatePage; 
	TestUtil testUtil;
	
	public HomePageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		loginPage.clickOnSignInLink();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
//	public void createPackageTest() {
//		//testUtil.switchToFrame();
//		try {
//			packageCreatePage = homePage.clickOnCreatePackage();
//		}
//		catch (org.openqa.selenium.StaleElementReferenceException ex) {
//			packageCreatePage = homePage.clickOnCreatePackage();
//		}
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
