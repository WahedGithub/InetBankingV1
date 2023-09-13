package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	
	//In this class we are opening the configuration file and creating the methods(with return) for all the configurations or environments 
	
	Properties pro; // properties is the Java class
	
	public ReadConfig()
	{
		File src =new File("./Configuration/config.properties"); // "./" this will start from current directory in config file class
		
		try {
			pro= new Properties();
			FileInputStream fis = new FileInputStream(src); // config file is considered as excel
			pro.load(fis); // this is for loading the file
			
		}catch(Exception e) {
			//e.printStackTrace();
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChromepath()
	{
		String chromepath= pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefoxpath()
	{
		String firefoxpath= pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	public String getIEpath()
	{
		String iepath= pro.getProperty("iepath");
		return iepath;
	}
	
	public String getSwitchingWindowURL()
	{
		String windowurl=pro.getProperty("SwitchingWindowURL");
		return windowurl;
	}
	
	public String getAlertURL()
	{
		String alerturl=pro.getProperty("AlertURL");
		return alerturl;
	}
	
	public String getDownloadFileURL()
	{
		String downloadfileurl=pro.getProperty("DownloadFileURL");
		return downloadfileurl;
	}
	
	public String FormyURL()
	{
		String formyurl=pro.getProperty("FormyURL");
		return formyurl;
	}
	
	public String DemoQAURL()
	{
		String demoqaurl=pro.getProperty("DemoQAURL");
		return demoqaurl;
	}
}
