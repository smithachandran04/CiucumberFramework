package com.vtiger.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class AccountPage extends HeaderPage {
	
	public AccountPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);				
	}
	
	@FindBy(name="accountname")
	WebElement tbaccountname;
	
	@FindBy(name="button")
	WebElement btnsave;
	
	
	@FindBy(xpath="//td[text()='Account Name:']/following::td[1]")
	WebElement txtACValue;
	
	public void createAccount(String val)
	{
		setAccountName(val);
		ClickSave();
	}
	
	public void setAccountName(String val)
	{
		cm.EnterValue(tbaccountname, val,"Text "+val+" has been entered into AccountName field");
	}
	
	public void ClickSave()
	{
		cm.ClickELement(btnsave,"Save button clicked");
	}
	
	public void verifyAccountNameDisplay()
	{
		cm.CheckDisplay(tbaccountname, "Account Name textbox is available on the page");
	}
	
	public void verifyAccountCreation(String val)
	{
		String str = cm.verifyText(txtACValue, "Retrived text from label");
		Assert.assertEquals(val, str);
	}

}
