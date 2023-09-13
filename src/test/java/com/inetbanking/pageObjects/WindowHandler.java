package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowHandler {

	WebDriver ldriver;
	
	public WindowHandler(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "//a[contains(text(),'Open New Tabbed Windows')]")
	WebElement WindowTab;
	
	@FindBy(xpath= "//body/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/a[1]/button[1]" )
	WebElement BtnClick;
	
	public void clickWindowTab()
	{
		WindowTab.click();
	}
	
	public void clickButton()
	{
		BtnClick.click();
	}
}
