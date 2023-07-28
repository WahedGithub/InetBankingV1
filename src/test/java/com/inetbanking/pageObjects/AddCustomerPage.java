package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(how=How.XPATH, using="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement AddNewCustomer;
	
	@FindBy(how=How.NAME, using="name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how=How.NAME, using="rad1")
	@CacheLookup
	WebElement Gender;
	
	@FindBy(how=How.ID_OR_NAME, using="dob")
	@CacheLookup
	WebElement DOB;
	
	@FindBy(how=How.NAME, using="addr")
	WebElement Address;
	
	@FindBy(how=How.NAME, using="city")
	WebElement City;
	
	@FindBy(how=How.NAME, using="state")
	WebElement State;
	
	@FindBy(how=How.NAME, using="pinno")
	WebElement PinNo;
	
	@FindBy(how=How.NAME, using="telephoneno")
	WebElement TelephoneNo;
	
	@FindBy(how=How.NAME, using="emailid")
	WebElement EmailId;
	
	@FindBy(how=How.NAME, using="password")
	WebElement Password;
	
	@FindBy(how=How.NAME, using="sub")
	WebElement btnSubmit;
	
	
	public void clickAddNewCustomer() {
		AddNewCustomer.click();
	}
	
	public void CustName(String cname) {
		CustomerName.sendKeys(cname);
	}
	
	public void CustGender(String cgender) {
		Gender.sendKeys(cgender);
	}
	
	public void CustDOB(String mm, String dd, String yy) {
		DOB.sendKeys(mm);
		DOB.sendKeys(dd);
		DOB.sendKeys(yy);
	}
	
	public void CustAddress(String caddress) {
		Address.sendKeys(caddress);
	}
	
	public void CustCity(String ccity) {
		City.sendKeys(ccity);
	}
	
	public void CustState(String cstate) {
		State.sendKeys(cstate);
	}
	
	public void CustPinNo(String pinno) {
		PinNo.sendKeys(String.valueOf(pinno)); // if anything is define as int then while passing we have to convert to string as sendkeys wont accept Integer.
	}
	
	public void CustTelephoneNo(String ctelephoneno) {
		TelephoneNo.sendKeys(ctelephoneno);
	}
	
	public void Custemailid(String cemailid) {
		EmailId.sendKeys(cemailid);
	}
	
	public void CustPassword(String cpassword) {
		Password.sendKeys(cpassword);
	}
	
	public void Custsubmit() {
		btnSubmit.click();
	}
}
