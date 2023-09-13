package com.inetbanking.testCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.MouseHover_Actions;

public class TC_MouseHovers_Actions extends BaseClass {

	@Test
	public void MouseHovers() throws InterruptedException {
		driver.get(AlertURL);
		Thread.sleep(4000);
		MouseHover_Actions mh= new MouseHover_Actions(driver);
		
		WebElement Drop= mh.returnDroppable();
		WebElement Int= mh.returnInteractions();
		MouseActions(Int, Drop);
		Thread.sleep(5000);
	}
}
