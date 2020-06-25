package com.rynly.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.rynly.qa.base.TestBase;
import com.rynly.qa.pages.HomePage;
import com.rynly.qa.pages.LoginPage;
import com.rynly.qa.pages.RegistrationPage;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	RegistrationPage registrationPage;
	
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
		
	@Test
	public void loginTest() {
		loginPage.clickOnSignInLink();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
//	@Test
//	public void joinTest() {
//		registrationPage = loginPage.join();
//	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
