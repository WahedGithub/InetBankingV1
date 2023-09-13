package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RobotKeyPadActions {


WebDriver ldriver;
	
	public RobotKeyPadActions(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id= "textbox")
	WebElement TextBox;
	
	@FindBy(id= "pdfbox")
	WebElement PDFBox;
	
	@FindBy(id="Button1")
	WebElement ScrollButton;
	
	public void sendTexttoBox(String text) {
		TextBox.sendKeys(text);
	}
	
	public void sendTexttoPDFBox(String text) {
		PDFBox.sendKeys(text);
	}
	
	public WebElement ScrollButton() {
		//ScrollButton.click();
		return ScrollButton;
	}
	
	
	
	
}
