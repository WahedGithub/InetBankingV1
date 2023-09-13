package com.inetbanking.testCases;

import org.testng.annotations.Test;
import com.inetbanking.pageObjects.*;
public class TC_WindowHandler extends BaseClass{

	@Test
	public void WindowHandler() throws Exception
	{
		driver.get(WindowURL);
		logger.info("URL is opened");
		
		WindowHandler wh= new WindowHandler(driver);
		
		wh.clickWindowTab();
		logger.info("Window Tab opened");
		wh.clickButton();
		logger.info("Multiple Windows opened");
		
		Thread.sleep(5000);
		
		TwoWindowHandler("Selenium");
	}
}
