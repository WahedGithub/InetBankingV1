package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage{

	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	WebElement EditCustomer;
	
	@FindBy(name="cusid")
	WebElement CustomerID;
	
	@FindBy(name="AccSubmit")
	WebElement Btnsubmit;
	
	@FindBy(name="addr")
	WebElement CustomerAddress;
	
	@FindBy(name= "pinno")
	WebElement CustomerPin;
	
	@FindBy(name= "telephoneno")
	WebElement TelephoneNo;
	
	@FindBy(name ="sub")
	WebElement LoginSubmit;
	
	@FindBy(id="locatorToIdentifyFrame")
	public WebElement ad;
	
	@FindBy(id= "locatorToCloseAd")
	WebElement CloseAd;
	
	@FindBy(id= "PopUp")
	WebElement popup;
	
	public void clickEditCustomer() 
	{
		EditCustomer.click();
	}
	
	public void setCustomerID(int cusid) 
	{
		CustomerID.sendKeys(String.valueOf(cusid));
	}
	
	public void clickSubmitButton() 
	{
		Btnsubmit.click();
	}
	
	public void EditCustomerAddress(String custaddr) 
	{
		CustomerAddress.clear();
		CustomerAddress.sendKeys(custaddr);
	}
	
	public void EditCustomerPin(String pinno) 
	{
		CustomerPin.clear();
		CustomerPin.sendKeys("123456");
		
	}
	
	public void EditTelephoneNo(String telno) 
	{
		TelephoneNo.clear();
		TelephoneNo.sendKeys("1234567890");
	}
	
	public void loginSubmit() {
		LoginSubmit.click();
	}
	
	public void CloseAd() {
		CloseAd.click();
		
	}
	
	public void Popup() {
		popup.click();
		
	}
	
	
	
	
}
