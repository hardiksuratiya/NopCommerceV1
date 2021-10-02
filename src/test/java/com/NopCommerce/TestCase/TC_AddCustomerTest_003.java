package com.NopCommerce.TestCase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.NopCommerce.PageObjects.AddCustomerPage;
import com.NopCommerce.PageObjects.LoginPage;
import com.NopCommerce.Utilities.XLUtils;

public class TC_AddCustomerTest_003 extends BaseClass {

	static String path= "/Users/patel/eclipse-workspace/NopCommerceV1/src/test/java/com/NopCommerceTestData/LoginDataCredentials.xlsx";
	@Test
	public void addCustomerTest() throws InterruptedException, AWTException, IOException
	{
		
		driver.get(baseURL);
		//logger.info("URL is opened...");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(username);
		//logger.info("username is provided..."); 
		
		lp.setPassword(password);
		//logger.info("password is provided....");
		
		lp.clicklogin();
		
		Thread.sleep(4000);
		
		AddCustomerPage addcustomer = new AddCustomerPage(driver);
		
		addcustomer.clickonCustomersMenu();
		addcustomer.clickonCustomersMenuItem();
		//logger.info("Customer Adding Page is opened");
		Thread.sleep(2000);
		
		addcustomer.clickonAddNew();
		//logger.info("add button is selected");
		String email = randomstring() + "@gmail.com";
		addcustomer.setEmail(email);	
		
		
		//logger.info("Entered email");
		
		String pass = randomNum();
		addcustomer.setPassword(pass);
		
		
		//logger.info("Entered password");
		addcustomer.setFirstName("John");
		addcustomer.setLastName("Cornor");
		//logger.info("Entered First and Last Name");
		addcustomer.setGenderButton("Male");
		addcustomer.setDOB("02/15/1991"); //mm/dd/yyy
		//logger.info("Selected Male radio button and Entered DOB");
		
		addcustomer.setCustomerRoles("Guests");
	 	addcustomer.setVendors("Vendor 1");
		addcustomer.clickOnSave();
		addcustomer.verifyConfirmationMsg();
		
	}
	
	
	

}
