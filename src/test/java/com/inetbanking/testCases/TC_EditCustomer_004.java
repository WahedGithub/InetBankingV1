package com.inetbanking.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_EditCustomer_004 extends BaseClass {

	@Test
	public void EditCustomer() throws InterruptedException, AWTException {
		
		Robot robot = new Robot();
		
		LoginPage lp= new LoginPage(driver);
		
		lp.setUserName(username);
		
		lp.setPassword(password);
		
		lp.clicksubmit();
		
		Thread.sleep(3000);
		
		EditCustomerPage ec= new EditCustomerPage(driver);
		
		ec.clickEditCustomer();
		System.out.println(driver.getTitle());
		Thread.sleep(5000);
		
		if(isAdPresent()==true) {
			System.out.println(driver.getTitle());
			 String p= driver.getWindowHandle();
			 System.out.println(p);
			
			
			//AdWindowHandler();
		}

		else {
			System.out.println("No Ad occured");
		}
		
		//Thread.sleep(5000);
		ec.setCustomerID(67237);
		ec.clickSubmitButton();
		
		Thread.sleep(2000);
		
		ec.EditCustomerAddress("USA");
		ec.EditCustomerPin("456123");
		ec.EditTelephoneNo("7894561230");
		
		Thread.sleep(5000);

		ec.loginSubmit();
		
		Thread.sleep(2000);
		
		if(isAlertPresent()==true) {
			handleAlertAccept();
		}
		else {
			System.out.println("NoAlertFound");
		}
		
		
	}
}
