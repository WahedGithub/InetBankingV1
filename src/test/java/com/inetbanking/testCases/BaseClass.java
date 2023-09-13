package com.inetbanking.testCases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;


public class BaseClass {

	ReadConfig rc= new ReadConfig();
	//Select select=new Select(null);
	
	public String baseURL =rc.getApplicationURL();
	public String WindowURL =rc.getSwitchingWindowURL();
	public String AlertURL =rc.getAlertURL();
	public String DownloadFileURL =rc.getDownloadFileURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) throws AWTException
	{
		
		logger= Logger.getLogger("EBanking");
		PropertyConfigurator.configure("Log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", rc.getChromepath());
		driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", rc.getFirefoxpath());
			driver=new FirefoxDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", rc.getIEpath());
			driver=new EdgeDriver();
		}
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		/*driver.get(baseURL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();*/
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void CaptureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken for the complete page");
		
	}
	
	public void ScreenshotWebElement(WebDriver driver,WebElement element, String tname) throws IOException {
		File source =element.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+ tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot Taken for WebElement/Sections of page");
		
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e) {
			return false;
		}
	}
	
	public void handleAlertAccept() // user defined method created to check alert is present or not
	{
		 Alert alert= driver.switchTo().alert();
		 String text = alert.getText();
		 System.out.println("Alert is present with the text: " +text);
		 alert.accept();
		 driver.switchTo().defaultContent();
	}
	
	public void handleAlertDismiss() // user defined method created to check alert is present or not
	{
		 Alert alert= driver.switchTo().alert();
		 String text = alert.getText();
		 System.out.println("Alert is present with the text and its dismissed:" +text);
		 alert.dismiss();
		 driver.switchTo().defaultContent(); // this command focus on the main page
	}
	
	public String randomstring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public String randomNum()
	{
		String generatedstring2=RandomStringUtils.randomNumeric(4);
		return(generatedstring2);
	}
	public boolean isAdPresent() {
		try {
			driver.getWindowHandle().equals(true);
			return true;
		}
		catch(Exception e) {
			return false;
			
		}
	}
	public void WindowHandler() throws Exception {
	String mainWinHandler = driver.getWindowHandle(); // Get your main window
	System.out.println(mainWinHandler);
	String subWinHandler = null;

	Set<String> allHandle = driver.getWindowHandles(); // Fetch all handles
	Iterator<String> iterator = allHandle.iterator();
	if (iterator.hasNext()){
	    subWinHandler = iterator.next();
	    System.out.println(mainWinHandler);
	}
	WebDriver Popup= driver.switchTo().window(subWinHandler); // switch to popup 
	
	Popup.close(); //Write code to close Ad or skip                                            

	driver.switchTo().window(mainWinHandler);
}
	
	public void TwoWindowHandler(String text) {
		String ParentWinHandler= driver.getWindowHandle();
		System.out.println(ParentWinHandler);
		String ChildWinHandler;
		
		Set <String> s=driver.getWindowHandles();
		
		for(String ChildWinHandler1 : s) {
			//System.out.println(ChildWinHandler1);
			String t= driver.switchTo().window(ChildWinHandler1).getTitle();
			System.out.println(t);
			if(t.contains(text)) {
				driver.close();
		}
		}
	}
	
	
	public void AdClose() {
		String MWD= driver.getWindowHandle();
		System.out.println(MWD);
		WebDriver popup= driver.switchTo().window(MWD);
		popup.close();
	}
	
	public void Ad() throws AWTException, InterruptedException {
		//driver.findElement(By.id("PopUp")).click(); // Clicking on the popup button
		Robot robot = new Robot();
		robot.mouseMove(400, 0);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		Thread.sleep(2000);
		driver.quit();
	}
	
	public void RobotKeyboardActions() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		robot.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		
	}
	
	public void ScrollToViewByElement(WebElement element) {
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void selectRadioButton(List<WebElement>radioButtons, String value) {
		//WebElement radioButtonGroup= driver.findElement(By.name(radioButtonGroupName));
		//List<WebElement>radioButtons= driver.findElements(By.xpath("//input[@type='radio' and contains(@id,'radio-button-')]"));
		int totalNoOfRadioButtons= radioButtons.size();
		System.out.println("RB:"+ totalNoOfRadioButtons);
		
		for(WebElement rb1 : radioButtons) {
			//String radiobtn= rb1.getAttribute(value);
			if(rb1.getText().equals(value)) 
			{
				rb1.click();
				//break;
			}
		}
		
	}
	
	public void selectCheckBox(List<WebElement>checkboxes, String...value) {
		//WebElement radioButtonGroup= driver.findElement(By.name(radioButtonGroupName));
		//List<WebElement>checkboxes= driver.findElements(By.xpath("//input[@type='checkbox' and contains(@id,'checkbox-')]"));
		int totalNoOfCheckBoxes= checkboxes.size();
		System.out.println("CB:" +totalNoOfCheckBoxes);
		
		for(WebElement chbx : checkboxes) {
			String cb= chbx.getText();
			if(cb.equals(value) || cb.equals(value))
			{
				chbx.click();
				//break;
			}
		}
		
	}
	public void selectDropDown(WebElement dropdown, String value) {
		Select select= new Select(dropdown);
		select.selectByVisibleText(value);
	}
	
	public void selectFutureDate(WebElement datepicker, WebElement Next, WebElement MY, String monthyear, String date) {
		datepicker.click();
		Select select= new Select(datepicker);
		
		for(int i=5; i>=1; i--) {
			
		Next.click();
		String NMY= MY.getText();
		
		if(NMY.equalsIgnoreCase(monthyear)) {
			select.selectByVisibleText(date);
			break;
		}
	}
	
	}
	public void MouseActions(WebElement Int, WebElement Droppable) throws InterruptedException {
		Actions act= new Actions(driver);
		
		act.moveToElement(Int).build().perform();
		Int.click();
		Thread.sleep(5000);
		act.moveToElement(Droppable).build().perform();
		Droppable.click();
		
	
	}
}

