package com.NopCommerce.TestCase;

import org.testng.annotations.Test;

import com.NopCommerce.PageObjects.AddCustomerPage;
import com.NopCommerce.PageObjects.CustomerSerachPage;
import com.NopCommerce.PageObjects.LoginPage;

public class TC_SearchCustomer_004 extends BaseClass
{
	@Test
	public void searchCustomerTest() throws InterruptedException
	{
		driver.get(baseURL);
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(username);
		lp.setPassword(password);
		lp.clicklogin();
		
		Thread.sleep(4000);
		
		AddCustomerPage addcustomer = new AddCustomerPage(driver);
		
		addcustomer.clickonCustomersMenu();
		addcustomer.clickonCustomersMenuItem();
		Thread.sleep(2000);
		
		CustomerSerachPage searchcust = new CustomerSerachPage(driver);
		searchcust.clickOnSearchBox("admin@yourStore.com");
		searchcust.clickonSearchButton();
		Thread.sleep(3000);
		
	}	
}
