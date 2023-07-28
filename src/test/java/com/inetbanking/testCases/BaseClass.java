package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig rc= new ReadConfig();
	
	public String baseURL =rc.getApplicationURL();
	public String username=rc.getUsername();
	public String password=rc.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
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
		driver.get(baseURL);
		
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
		System.out.println("Screenshot Taken");
		
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
}
