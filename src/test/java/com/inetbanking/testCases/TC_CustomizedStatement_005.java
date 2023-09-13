package com.inetbanking.testCases;

import org.checkerframework.checker.units.qual.cd;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.*;

public class TC_CustomizedStatement_005 extends BaseClass {

	
	@Test
	public void CustomizedStatement() throws InterruptedException {
		
		LoginPage lp =new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("Provided the UserName");
		lp.setPassword(password);
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		CustomizedStatement cs= new CustomizedStatement(driver);
		cs.ClickCustomizedStatement();
		Thread.sleep(2000);
		cs.CustomerAccountNo("124861");
		cs.FromDate("10", "08", "2023");
		cs.ToDate("12", "12", "2023");
		
		cs.MinimumValue("10");
		cs.NoTransaction("25");
		
		Thread.sleep(3000);
		cs.ButtonSubmit();
		
		Thread.sleep(5000);
		
	}
}
