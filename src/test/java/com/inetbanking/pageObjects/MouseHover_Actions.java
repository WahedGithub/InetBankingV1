package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MouseHover_Actions {

	WebDriver ldriver;
	public MouseHover_Actions(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath= "//h5[contains(text(),'Interactions')]")
	WebElement Interactions;
	
	@FindBy(xpath= "//span[contains(text(),'Droppable')]" )
	WebElement Droppable;
	
	public WebElement returnInteractions() {
		return Interactions;
	}
	
	public WebElement returnDroppable() {
		return Droppable;
	}
}
