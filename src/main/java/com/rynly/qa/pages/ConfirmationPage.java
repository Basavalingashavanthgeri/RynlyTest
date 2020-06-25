package com.rynly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.rynly.qa.base.TestBase;

public class ConfirmationPage extends TestBase{
	
	@FindBy(xpath = "//button[contains(text(),'CONFIRM & PAY')]")
	WebElement confirmBtn;
	
	//Initializing objects
	public ConfirmationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LabelPage confirmationDetails() {
		confirmBtn.click();
		
		return new LabelPage();
	}
}
