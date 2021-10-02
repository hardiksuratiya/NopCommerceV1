package com.NopCommerce.PageObjects;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCustomerPage {
	WebDriver ldriver;
	WebElement listitem;
	public AddCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a")
	WebElement lnkCustomers_menu;
	
	@FindBy(xpath="/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p")
	WebElement lnkCustomers_menulist;
	
	//@FindBy(xpath="//a[normalize-space()='Add new']")
	@CacheLookup
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement btnAddnew;
	
	@FindBy(xpath="//input[@id='Email']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement txtpassword;
	
	@FindBy(xpath="//input[@id='FirstName']")
	WebElement txtFirstName;
	
	@FindBy(xpath="//input[@id='LastName']")
	WebElement txtLastName;
	
	
	@FindBy(xpath="//*[@id='Gender_Male']")
	WebElement rdMale;
	
	@FindBy(xpath="//*[@id=\"Gender_Female\"]")
	WebElement rdFemale;
	
	@FindBy(xpath="//*[@id='DateOfBirth']")
	WebElement txtDoB;
	
	@FindBy(xpath="//*[@id='Company']")
	WebElement txtCompanyName;
	
//	@FindBy(xpath="//div[@class='k-widget k-multiselect k-multiselect-clearable']")
//	WebElement txtnewsLetter;
//	k-widget k-multiselect k-multiselect-clearable
//	
//	//@FindBy(xpath="//div/ul[@class='SelectedCustomerRoleIds_taglist']")  
//	@FindBy(xpath="//select[@id='SelectedCustomerRoleIds']")
//	WebElement txtcustomerRoles;
//	
//	@FindBy (xpath="//select[contains(text(),'Administrators')]") 
//	WebElement listitemAdministrator;
//	
//	@FindBy (xpath="//select[contains(text(),'Forum Moderators')]")
//	WebElement listitemForumModerators;
//	
//	@FindBy(xpath="//select[contains(text(),'Guests')]")
//	WebElement listitemGuests;
//	
//	@FindBy(xpath="//select[contains(text(),'Registered')]")
//	WebElement listitemRegistered;
//	
//	@FindBy(xpath="//select[contains(text(),'Vendors')]")
//	WebElement listitemVendors;

    By txtcustomerRoles=By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");
	
	By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
	
	
	@FindBy (xpath="//*[@id='VendorId']")
	WebElement drpVendorbtn ;
	
	//@FindBy (xpath="//*[@id='VendorId']/option")
	//WebElement drpVendorOptions;
	
	@FindBy (xpath="//button[@name='save']")
	WebElement btnsave;
	
	@FindBy (xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement txtsmsg;
	
	public void clickonCustomersMenu()
	{
		lnkCustomers_menu.click();
	}
	
	public void clickonCustomersMenuItem()
	{
		lnkCustomers_menulist.click();
	}
	
	public void clickonAddNew()
	{
		btnAddnew.click();
	}
	
	public void setEmail(String email) 
	{
		txtEmail.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		txtpassword.sendKeys(pwd);
	}
	
	public void setFirstName(String fname)
	{
		txtFirstName.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		txtLastName.sendKeys(lname);
	}
	
	public void setGenderButton(String gender)
	{
		if(gender.equals("Male"))
		{
			rdMale.click();
		} 
		else if (gender.equals("Female"))
		{
			rdFemale.click();
		}
		else
		{
			rdMale.click(); //default
		}
	}
	
	public void setDOB(String dob)
	{
		txtDoB.sendKeys(dob);
	}
	
//	public void setCompanyName(String companyname)
//	{
//		txtCompanyName.sendKeys(companyname);
//	}
//	
//	public void setCustomerRoles(String role)
//	{
//		
//		ldriver.findElement(By.id("//div[@class='k-multiselect-wrap k-floatwrap']")).click();
//		
//		//txtcustomerRoles.click();
//		
//		//ldriver.findElement(By.xpath("//span[@title='delete']")).click();  //working
//		
////		//ldriver.findElement(By.id("//ul[@id='SelectedCustomerRoleIds_taglist']")).click();
//		WebElement listitem=null ;
//		switch(role)
//		{
//		case "Administrator": listitem=listitemAdministrator;
//		break;
//		case "Guests": listitem=listitemGuests;
//		break;
//		case "Registered": listitem=listitemRegistered;
//		break;
//		case "Vendors":	listitem=listitemVendors;
//		break;
//		case "Forum Moderators":	listitem=listitemForumModerators;
//		break;
//		}
//		JavascriptExecutor js = (JavascriptExecutor) ldriver;
//		js.executeScript("arguments[0].click();", listitem);
//	 
//	}
	
	
	public void setCustomerRoles(String role) throws InterruptedException, AWTException 
	{
		
		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_TAB);
		rob.keyRelease(KeyEvent.VK_TAB);
		
		//ldriver.findElement(txtcustomerRoles).click();
	
		Thread.sleep(3000);
		
		if(role.equals("Registered"))
		{
			listitem=ldriver.findElement(lstitemRegistered); 
		}
		else if(role.equals("Administrators"))
		{
			listitem=ldriver.findElement(lstitemAdministrators); 
		}
		else if(role.equals("Guests"))
		{
			// Here user can be Registered (or) Guest, only one
			ldriver.findElement(By.xpath("//*[@id=\"SelectedCustomerRoleIds_taglist\"]/li/span[2]")).click(); //delete registered
			listitem=ldriver.findElement(lstitemGuests);
		}
		else if(role.equals("Vendors"))
		{
			listitem=ldriver.findElement(lstitemVendors);
		}
		else
		{
			listitem=ldriver.findElement(lstitemGuests);
		}
				
		//listitem.click();  //Not working
		
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", listitem);
		
//		rob.keyPress(KeyEvent.VK_TAB);
//		rob.keyRelease(KeyEvent.VK_TAB);
		
}
	
	public void setVendors(String value)
	{
		Select drp = new Select(drpVendorbtn);
		drp.selectByVisibleText(value);
		
	}
	
	public void clickOnSave()
	{
		btnsave.click();
	}
	
	 public boolean verifyConfirmationMsg()
	 {
		 if(txtsmsg.getText().equals("The new customer has been added successfully."))
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
