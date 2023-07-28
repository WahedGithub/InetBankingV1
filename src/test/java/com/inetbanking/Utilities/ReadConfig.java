package com.inetbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;
	
	public ReadConfig()
	{
		File src =new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src); // config file is considered as xml
			pro= new Properties();
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
	
	
}
