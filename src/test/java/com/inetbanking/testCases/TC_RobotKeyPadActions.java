package com.inetbanking.testCases;

import org.testng.annotations.Test;
import com.inetbanking.pageObjects.*;

public class TC_RobotKeyPadActions extends BaseClass{

	@Test
	public void RobotKeyPadActions() throws Exception
	{
		driver.get(AlertURL);
		Thread.sleep(5000);
		logger.info("URL is opened");
		
		RobotKeyPadActions rbKey= new RobotKeyPadActions(driver);
		
		Thread.sleep(5000);
		rbKey.sendTexttoBox("Hello Buddy");
		
		Thread.sleep(3000);
		RobotKeyboardActions();
		
		rbKey.sendTexttoPDFBox("Hello Chindi PDF");
		
		Thread.sleep(3000);
		
		ScrollToViewByElement(rbKey.ScrollButton());
		RobotKeyboardActions();
	}
}

