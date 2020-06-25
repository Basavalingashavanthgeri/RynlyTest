package com.rynly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.rynly.qa.base.TestBase;

public class BillingPage extends TestBase{
	
	@FindBy(xpath = "//*[@id=\"billing\"]/div[2]/div/div[3]/div/label/span[1]")
	WebElement newCardArrow;
	
	@FindBy(xpath = "//div[@class='row no-gutters']//input[@placeholder='XXXX-XXXX-XXXX-XXXX']")
	WebElement cardNumber;
	
	@FindBy(xpath = "//input[@placeholder='MM']")
	WebElement expMonth;
	
	@FindBy(xpath = "//input[@placeholder='YYYY']")
	WebElement expYear;
	
	@FindBy(xpath = "//input[@id='cvc']")
	WebElement cvv;
	
	@FindBy(xpath = "//*[@id=\"new-card\"]/div[3]/input")
	WebElement name;
	
	@FindBy(xpath = "//*[@id=\"new-card\"]/div[4]/input")
	WebElement address;
	
	@FindBy(xpath = "//*[@id=\"new-card\"]/div[5]/input")
	WebElement zipCode;
	
	@FindBy(xpath = "//*[@id=\"billing\"]/div[2]/div/div[4]/input")
	WebElement promoCode;
	
	@FindBy(xpath = "//button[@id='apply-promo-button']")
	WebElement applyBtn;
	
	@FindBy(xpath = "//li[@class='ng-binding ng-scope']")
	WebElement msg;
	
	@FindBy(xpath = "//button[contains(text(),'GO TO PREVIEW')]")
	WebElement gotoPreviewBtn;
	
	//Initializing objects
	public BillingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public ConfirmationPage billingDetails() {
		gotoPreviewBtn.click();
		return new ConfirmationPage();
	}
	
	public ConfirmationPage newBillingDetails(String CardNumber, String Month, String Year, String Cvv, String Name, String Address, String Zipcode) {
		newCardArrow.click();
		cardNumber.sendKeys(CardNumber);
		expMonth.sendKeys(Month);
		expYear.sendKeys(Year);
		cvv.sendKeys(Cvv);
		name.sendKeys(Name);
		address.sendKeys(Address);
		zipCode.sendKeys(Zipcode);
		gotoPreviewBtn.click();
		return new ConfirmationPage();
	}
	
	public void errorMsg(String PromoCode) {
		promoCode.sendKeys(PromoCode);
		gotoPreviewBtn.click();
		String invalidPromoText = "Invalid Promo Code";
		String text = msg.getText();
		Assert.assertEquals(text, invalidPromoText);
	}
}
