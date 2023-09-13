package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AlertHandle;

public class TC_AlertHandle extends BaseClass{

	@Test(priority=1)
	public void AlertWithOk() throws InterruptedException {
		
		driver.get(AlertURL);
		logger.info("URL is opened");
		
		AlertHandle al= new AlertHandle(driver);
		
		al.ClickAlertOk();
		
		al.ClickAlertButton();
		
		Thread.sleep(3000);
		if(isAlertPresent()==true) {
			handleAlertAccept();
		}
	}
		
@Test(priority=2)
		public void AlertWithOkDismiss() throws InterruptedException {
			
			driver.get(AlertURL);
			logger.info("URL is opened");
			
			AlertHandle al= new AlertHandle(driver);
			
			al.ClickAlertOk();
			
			al.ClickAlertButton();
			
			Thread.sleep(3000);
			if(isAlertPresent()==true) {
				handleAlertDismiss();
			}
			
		}


@Test(priority=3)
			public void AlertWithOkCancel() throws InterruptedException {
				
				driver.get(AlertURL);
				logger.info("URL is opened");
				
				AlertHandle al= new AlertHandle(driver);
				
				al.ClickAlertOkCancel();
				
				al.ClickAlertConfirm();
				
				Thread.sleep(3000);
				if(isAlertPresent()==true) {
					handleAlertDismiss();
				}
			
		
	}
}
