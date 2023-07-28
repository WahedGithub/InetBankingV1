package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {
	
	@Test
	public void LoginTest() throws InterruptedException, IOException 
	{
		
		
		logger.info("URL is opened");
		LoginPage lp= new LoginPage(driver);
		
		
		lp.setUserName(username);
		logger.info("Entered Username");
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clicksubmit();
		
		Thread.sleep(4000);
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			CaptureScreen(driver, "LoginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
