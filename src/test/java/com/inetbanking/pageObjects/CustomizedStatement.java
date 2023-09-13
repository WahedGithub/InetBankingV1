package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomizedStatement {

	WebDriver ldriver;
	
	public CustomizedStatement(WebDriver rdriver) {
		ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath= "//a[contains(text(),'Customised Statement')]" )
	WebElement CustomizedStatement;
	
	@FindBy(name= "accountno")
	WebElement CustomerAcc;
	
	@FindBy(name= "fdate")
	WebElement FromDate;
	
	@FindBy(name= "tdate")
	WebElement ToDate;
	
	@FindBy(name = "amountlowerlimit")
	WebElement MinTransactionvalue;
	
	
	@FindBy(name= "numtransaction")
	WebElement NoTransactions;
	
	@FindBy(name ="AccSubmit")
	WebElement BtnSubmit;
	
	public void ClickCustomizedStatement() {
		CustomizedStatement.click();
	}
	
	public void CustomerAccountNo(String accno) {
		CustomerAcc.sendKeys(accno);
	}
	
	public void FromDate(String mm, String dd, String yy) {
		//Select sd= new Select(FromDate);
		FromDate.sendKeys(mm);
		FromDate.sendKeys(dd);
		FromDate.sendKeys(yy);
	}
	
	public void ToDate(String mm, String dd, String yy) {
		ToDate.sendKeys(mm);
		ToDate.sendKeys(dd);
		ToDate.sendKeys(yy);
	}
	
	public void MinimumValue(String minVal) {
		MinTransactionvalue.sendKeys(minVal);
	}
	
	public void NoTransaction(String noTrans) {
		NoTransactions.sendKeys(noTrans);
	}
	
	public void ButtonSubmit() {
		BtnSubmit.click();
	}
}
