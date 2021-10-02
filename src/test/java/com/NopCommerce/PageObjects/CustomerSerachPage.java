package com.NopCommerce.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomerSerachPage {

	WebDriver ldriver;
	public CustomerSerachPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	@FindBy(id="SearchEmail")
	WebElement searchEmailInputBox;
	
	@FindBy(id="SearchFirstName")
	WebElement searchFirstNameInputBox;
	
	@FindBy(id="SearchLastName")
	WebElement searchLastNameInputBox;
	
	@FindBy(id="SearchMonthOfBirth")
	WebElement drpMonthOfBirthInputBox;
	
	@FindBy(id="SearchDayOfBirth")
	WebElement drpDayOfBirthInputBox;
	
	@FindBy (id="search-customers")
	WebElement searchbutton;
	
	public void clickOnSearchBox(String email)
	{
		searchEmailInputBox.sendKeys(email);	
	}
	public void EnteredFirstName(String fname)
	{
		searchFirstNameInputBox.sendKeys(fname);
	}
	public void EnteredLastName(String lname)
	{
		searchLastNameInputBox.sendKeys(lname);
	}
	public void setDateofMonth(String mon)
	{
		Select drp = new Select(drpMonthOfBirthInputBox);
		drp.selectByVisibleText(mon);
	}
	public void setDateofBirth(String day)
	{
		Select drp = new Select(drpDayOfBirthInputBox);
		drp.selectByVisibleText(day);
	}
	public void clickonSearchButton()
	{
		searchbutton.click();
	}
}
