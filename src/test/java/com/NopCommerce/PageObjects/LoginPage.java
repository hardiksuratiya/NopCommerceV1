package com.NopCommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy (name="Email")
	WebElement txtemailinput;
	
	@FindBy (name="Password")
	WebElement txtpasswordinput;
	
	//@FindBy(how=How.CLASS_NAME , using="button-1 login-button")
	@FindBy (xpath="/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	@CacheLookup
	WebElement lnklogout;
	
	public void setEmail(String uname)
	{
		txtemailinput.clear();
		txtemailinput.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtpasswordinput.clear();
		txtpasswordinput.sendKeys(pwd);
	}
	public void clicklogin()
	{
		loginbtn.click();
	}
	public void clicklogout()
	{
		lnklogout.click();
	}
	
	
}
