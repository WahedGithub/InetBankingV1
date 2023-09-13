package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertHandle {

WebDriver ldriver;
	
	public AlertHandle(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")
	WebElement AlertWithOk;
	
	@FindBy(xpath = "//button[contains(text(),'alert box:')]")
	WebElement BtnAlert;
	
	//Second case
	@FindBy(xpath= "//a[contains(text(),'Alert with OK & Cancel')]")
	WebElement AlertWithOkCancel;
	
	@FindBy(xpath= "//button[contains(text(),'click the button to display a confirm box')]")
	WebElement AlertConfirmbox;
	
	
	
	public void ClickAlertOk() {
		AlertWithOk.click();
	}
	
	public void ClickAlertButton() {
		BtnAlert.click();
	}
	
	public void ClickAlertOkCancel() {
		AlertWithOkCancel.click();
	}
	
	public void ClickAlertConfirm() {
		AlertConfirmbox.click();
	}
	
}
