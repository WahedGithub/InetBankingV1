package com.inetbanking.testCases;

import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.MultipleMethods;

public class FormyMultipleMethods extends BaseClass {

	@Test
	public void FillingForm() throws InterruptedException, IOException {
		driver.get(AlertURL);
		
		logger.info("URL is opened");
		
		MultipleMethods mm= new MultipleMethods(driver);
		
		mm.EnterFirstName("Abdul");
		mm.EnterLastName("Wahed");
		mm.EnterJobTitle("Engineer");
		Thread.sleep(3000);
		
		List<WebElement> radioButtons= mm.ClickRadioButton();
		selectRadioButton(radioButtons, "High School");
		Thread.sleep(3000);
		
		List<WebElement> cb= mm.ClickCheckBoxes();
		selectCheckBox(cb, "Male", "FeMale");
		Thread.sleep(3000);
		
		WebElement dropdown = mm.ClickDropDown();
		
		Thread.sleep(3000);
		selectDropDown(dropdown, "5-9");
		
		Thread.sleep(3000);
		mm.DatePicker("12/", "23/", "2024");
		Thread.sleep(1000);
		mm.ClickSubmitButton();
		
		Thread.sleep(5000);
		String Title= driver.getTitle();
		System.out.println(Title);
		if(Title.equalsIgnoreCase("Formy"))
		{
				Assert.assertTrue(true);
				logger.info("Test Passed");
		}
		else {
			CaptureScreen(driver, "FormyTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		
		}
		
		//selectRadioButton("Sex", "Male");
		
		
	}
}
