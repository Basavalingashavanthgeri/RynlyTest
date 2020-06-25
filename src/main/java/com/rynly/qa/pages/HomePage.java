package com.rynly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rynly.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath = "/html/body/div/div[5]/div[1]/ul/li[1]/div[2]/div/form/a")
	WebElement createPackage;
	
	@FindBy(xpath = "//span[contains(text(), SIDDU MS)]")
	WebElement homePageTitle;
	
	//Initializing objects
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
//		public String verifyHomePageTitle() {
//		  return homePageTitle.isDisplayed();	
//		}
		
		public PackageCreatePage clickOnCreatePackage() {
			//testUtil.
			createPackage.click();
			return new PackageCreatePage();
		}
}




