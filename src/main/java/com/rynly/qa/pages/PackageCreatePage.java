package com.rynly.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.rynly.qa.base.TestBase;

public class PackageCreatePage extends TestBase {
	
	//From address
	
	@FindBy(xpath = "//*[@id=\"update-profile-container\"]")
	WebElement updateProfileAddress;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[1]/div[1]/input")
	WebElement fromCompany;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[1]/div[2]/input")
	WebElement fromContactName;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[1]/div[3]/input")
	WebElement fromAddress1;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[1]/div[4]/input")
	WebElement fromAddress2;
	
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[2]/div[1]/input")
	WebElement fromCity;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[2]/div[2]/input")
	WebElement fromState;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[2]/div[3]/input")
	WebElement fromZipcode;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[2]/div[4]/input")
	WebElement fromPhoneNo;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[3]/div[1]/div[5]/input")
	WebElement pickupNote;
	
	@FindBy(id="chkDropOff")
	WebElement checkDropOff;
	
	//To address
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[1]/div[1]/input")
	WebElement toCompany;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[1]/div[2]/input")
	WebElement toContactName;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[1]/div[3]/input")
	WebElement toAddress1;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[1]/div[4]/input")
	WebElement toAddress2;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[2]/div[1]/input")
	WebElement toCity;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[2]/div[2]/input")
	WebElement toState;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[2]/div[3]/input")
	WebElement toZipcode;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[2]/div[4]/input")
	WebElement toPhoneNo;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[1]/div[5]/input")
	WebElement deliveryNote;
	
	@FindBy(xpath = "//*[@id=\"create-order\"]/div[5]/div[1]/div[6]/div[1]/select")
	WebElement packageSize;
	
	
	@FindBy(id="chkExpedite")
	WebElement checkExpedite;
	
	@FindBy(id="chkSignature")
	WebElement checkSignature;
	
	//Add shipment button
	@FindBy(xpath = "//*[@id = 'add-shiment-button']")
	WebElement addShipmentBtn;
	
	//Goto billing button
	@FindBy(xpath = "//button[contains(text(),'GO TO BILLING')]")
	WebElement gotoBillingBtn;		
			
	//Initializing objects
	public PackageCreatePage() {
		PageFactory.initElements(driver, this);
	}
	
	public BillingPage inputAddress(String Company, String ContactName, String Address1, String Address2, String City,
			String State, String Zipcode, String PhoneNo) {
		toCompany.sendKeys(Company);
		toContactName.sendKeys(ContactName);
		toAddress1.sendKeys(Address1);
		toAddress2.sendKeys(Address2);
		toCity.sendKeys(City);
		toState.sendKeys(State);
		toZipcode.sendKeys(Zipcode);
		toPhoneNo.sendKeys(PhoneNo);
		Select packagesize = new Select(packageSize);
		packagesize.selectByIndex(1);
		gotoBillingBtn.click();
		
		return new BillingPage();
		
	}
	
}
