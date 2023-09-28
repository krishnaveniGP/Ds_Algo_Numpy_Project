package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	
	public Properties initProp()
	
	{
		prop=new Properties();
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/Config/config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return prop;
		
	}

	
	public String getUserName()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;		
	}
	
	public String getUrl1()
	{   
		
		String getUrl=prop.getProperty("url");
		if(getUrl!=null)
		{
			return getUrl;
		}else
		{
			System.out.println("url not mentioned in config properties");
		}	return getUrl;	
	}
	
	public static String homePage() {
		String homepageurl = prop.getProperty("homePageUrl");
		if (homepageurl != null)
			return homepageurl;
		else
			throw new RuntimeException("HomePageurl not specified in the Config.properties file");
	}
	
	public static String registerPage()
	{
		String registerpageurl=prop.getProperty("registerPageUrl");
		if(registerpageurl != null)
		return registerpageurl;
		else throw new RuntimeException("RegisterPageurl not specified in the Config.properties file");			
	}
	
	public static String excelPath()
	{
		String ExcelPath=prop.getProperty("ExceldataPath");
		if(ExcelPath!=null)		
			return ExcelPath;
			else throw new RuntimeException("Excel data path missing");
		
	}

}
