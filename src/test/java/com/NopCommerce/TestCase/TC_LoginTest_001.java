package com.NopCommerce.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.NopCommerce.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass{

	
	@Test
	public void logintest() throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened...");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(username);
		logger.info("username is provided...");
		
		lp.setPassword(password);
		logger.info("password is provided....");
		
		lp.clicklogin();
		
		Thread.sleep(6000);
		if(driver.getTitle().equals("Dashboard / nopCommerce administration"))
		{
			logger.info("login is successful");
			Assert.assertTrue(true);
			lp.clicklogout();
			logger.info("SuccessFully logOut from the application");
			
		}
		else
		{
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login is failed...");
		}
	}

}
