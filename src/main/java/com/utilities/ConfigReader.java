package com.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
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

	public static String excelPath() {
		// TODO Auto-generated method stub
		return null;
	}

}
