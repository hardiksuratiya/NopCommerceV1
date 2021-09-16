package com.NopCommerce.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig()
	{
		File src = new File("/Users/patel/eclipse-workspace/nopCommerceV1/src/test/java/configuration/config.properties");
		
		try 
		{	
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is "+e.getMessage());
		}
		
	}
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}

	public String getUserEmail()
	{
		String usr=pro.getProperty("useremail");
		return usr;
	}
	public String getPassword()
	{
		String pass= pro.getProperty("password");
		return pass;
	}
}
