package com.rynly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rynly.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(xpath = "//*[@id=\"sign-in-header-button\"]")
	
	WebElement signInLink;
	
	@FindBy(xpath = "//input[@id='txEmail']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='txPassword']")
	WebElement password;
	
	@FindBy(xpath = "/html/body/div/div[3]/div/form/button")
	WebElement signInBtn;
	
	@FindBy(xpath = "//button[contains(text(), 'JOIN')]")
	WebElement joinBtn;
	
	//Initializing objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public RegistrationPage join() {
		joinBtn.click();
		return new RegistrationPage();
	}
	
	public void clickOnSignInLink() {
		signInLink.click();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		signInBtn.click();
		
		return new HomePage();
	}
	
}
