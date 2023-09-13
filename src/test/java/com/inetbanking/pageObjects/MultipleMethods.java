package com.inetbanking.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MultipleMethods {

	WebDriver ldriver;
	public MultipleMethods(WebDriver rdriver) {
		ldriver =rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id= "first-name")
	WebElement FirstName;
	
	@FindBy(id= "last-name")
	WebElement LastName;
	
	@FindBy(id= "job-title")
	WebElement JobTitle;
	
	@FindBy(xpath= "//input[@type='radio' and contains(@id,'radio-button-')]\")")
	List<WebElement> RadioButtons;
	//div[@class='input-group']//div[@class='col-sm-8 col-sm-offset-2'] //input[@type='radio' and contains(@id, 'radio-button-')]
	
	@FindBy(xpath= "//input[@type='checkbox' and contains(@id,'checkbox-')]")
	List<WebElement> CheckBoxes;
	
	
	@FindBy(id= "select-menu")
	WebElement dropdown;
	
	@FindBy(id= "datepicker")
	WebElement DatePicker;
	
	@FindBy(xpath= "//body[1]/div[2]/div[2]/table[1]/thead[1]/tr[2]/th[1]")
	WebElement Previous;
	
	@FindBy(xpath= " //body[1]/div[2]/div[2]/table[1]/thead[1]/tr[2]/th[3]")
	WebElement Next;
	
	@FindBy(xpath= "//tbody/tr[2]/td[3]")
	WebElement Date;
	
	@FindBy(xpath="//a[contains(text(),'Submit')]")
	WebElement SubmitBtn;
	
	public void EnterFirstName(String FName) {
		FirstName.sendKeys(FName);
		}
	
	public void EnterLastName(String LName) {
		LastName.sendKeys(LName);
		}
	
	public void EnterJobTitle(String Jtitle) {
		JobTitle.sendKeys(Jtitle);
		}
	
	public List<WebElement> ClickRadioButton() {
		return RadioButtons;
	}
	
	public List<WebElement> ClickCheckBoxes() {
		return CheckBoxes;
	}

	public WebElement ClickDropDown() {
		//dropdown.click();
		return dropdown;
		}
	
	public void DatePicker(String mm, String dd, String yy) {
		DatePicker.sendKeys(mm);
		DatePicker.sendKeys(dd);
		DatePicker.sendKeys(yy);
		
	}
	public WebElement ClickDatePicker() {
		return DatePicker;
	}
	
	public WebElement ClickNext() {
		return Next;
		}
	
	public WebElement ClickPrevious() {
		return Previous;
		}
	
	public void ClickSubmitButton() {
		SubmitBtn.click();
	}
}
