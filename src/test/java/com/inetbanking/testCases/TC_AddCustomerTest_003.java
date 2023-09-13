package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass{

	@Test
	public void AddNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Provided the UserName");
		lp.setPassword(password);
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage AC= new AddCustomerPage(driver);
		
		AC.clickAddNewCustomer();
		logger.info("Started adding new customer");
		AC.CustName("Wahed");
		logger.info("Provided the Name");
		AC.CustGender("Male");
		AC.CustDOB("01", "05", "1989");
		logger.info("Provided the DOB");
		Thread.sleep(3000);
		AC.CustAddress("India");
		AC.CustCity("Hyderabad");
		AC.CustState("TG");
		AC.CustPinNo("500024");
		AC.CustTelephoneNo("1234567890");
		
		String email=randomstring()+"@gmail.com"; //  this we are calling from BaseClass
		AC.Custemailid(email);
		logger.info("Provided the randomgenerated email address");
		AC.CustPassword("abcdef");
		Thread.sleep(3000);
		AC.Custsubmit();
		
		Thread.sleep(8000);
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		if(res==true)
		{
			Assert.assertTrue(true);
		}
		else {
			CaptureScreen(driver, "AddNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
}
