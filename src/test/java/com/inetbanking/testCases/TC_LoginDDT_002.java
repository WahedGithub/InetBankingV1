package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.Utilities.XLUtils;
import com.inetbanking.Utilities.XLUtils2;
import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginDDT_002 extends BaseClass 
{

	@Test(dataProvider= "LoginData")
	public void LoginDDT(String username, String pwd)
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(pwd);
		logger.info("Password is provided");
		lp.clicksubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent(); // this command focus on the main page
			Assert.assertTrue(false); // using false here coz its a failure case
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true); // this is passed case if the alert is not present when valid credentials are passed
			logger.info("Login successfully");
			lp.clickLogout();
			driver.switchTo().alert().accept(); // close logout alert
			driver.switchTo().defaultContent();
		}
		
		
	}
	
	public boolean isAlertPresent() // user defined method created to check alert is present or not
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name= "LoginData")
	String [][] getData() throws Exception
	{
		//XLUtils reader= new XLUtils("D:\\Eclispe\\MavenProject\\src\\test\\java\\com\\inetbanking\\testData\\LoginCredentails.xlsx");
		String path= System.getProperty("user.dir")+ "\\src\\test\\java\\com\\inetbanking\\testData\\LoginCredentails.xlsx";
		
		//int rownum= reader.getRowCount("Sheet1");
		
		int rownum= XLUtils2.getRowCount(path, "Sheet1");
		int colcount = XLUtils2.getCellCount(path, "Sheet1", 1);
		
		//int colcount = reader.getColumnCount("Sheet1");
		
		String logindata[][]= new String[rownum][colcount];
		
		for(int i=1; i<=rownum; i++)
		{
			for(int j =0; j<colcount; j++)
			{
				logindata[i-1][j]= XLUtils2.getCellData(path, "Sheet1", i, j); //1 ,0
			}
		}
		return logindata;
	}
}
