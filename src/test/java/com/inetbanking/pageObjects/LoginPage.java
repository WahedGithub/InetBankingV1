package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	//This is a constructor
	public LoginPage(WebDriver rdriver){
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	WebElement UserName;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(name="btnLogin")
	WebElement btnLogin;
	
	@FindBy(name="//a[contains(text(),'Log out')]")
	WebElement Logout;
	
	public void setUserName(String uname) 
	{
		UserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		Password.sendKeys(pwd);
	}
	
	public void clicksubmit()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		Logout.click();
	}
}
