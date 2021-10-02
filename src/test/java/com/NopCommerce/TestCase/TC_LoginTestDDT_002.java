package com.NopCommerce.TestCase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.NopCommerce.PageObjects.LoginPage;
import com.NopCommerce.Utilities.XLUtils;

public class TC_LoginTestDDT_002 extends BaseClass
{
		
	 
	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) throws InterruptedException, IOException
	{
		driver.get(baseURL);
		logger.info("URL is opened...");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(user);
		logger.info("username is provided...");
		
		lp.setPassword(pwd);
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
		//	captureScreen(driver,"logintest");
			Assert.assertTrue(false);
			logger.info("Login is failed...");
		} 
	}
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path ="/Users/patel/eclipse-workspace/nopCommerceV1/src/test/java/com/NopCommerceTestData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]= new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0; j<colcount;j++)
			{
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return loginData;
	}
	
}
