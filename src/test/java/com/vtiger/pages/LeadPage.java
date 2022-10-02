package com.vtiger.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

public class LeadPage extends HeaderPage {
	
	public LeadPage(WebDriver driver,ExtentTest logger)
	{
		super(driver,logger);				
	}
	
	@FindBy(name="lastname")
	WebElement tblastname;
	
	@FindBy(name="button")
	WebElement tbbutton;
	
	@FindBy(name="company")
	WebElement tbcompany;
	
	@FindBy(xpath="//td[text()='Last Name:']/following::td[1]")
	WebElement txtLNValue;
	
	@FindBy(xpath="//td[text()='Company:']/following::td[1]")
	WebElement txtCMValue;
	
	
	public void verifyLastNameDisplay()
	{
		cm.CheckDisplay(tblastname, "Last Name textbox is available on the page");
	}
	
	public void verifyLeadCreation(String val1,String val2)
	{
		String str = cm.verifyText(txtLNValue, "Last Name value retrived text from label");
		Assert.assertEquals(val1, str);
		String str2 = cm.verifyText(txtCMValue, "Company Name value retrived text from label");
		Assert.assertEquals(val2, str2);
	}
	
	public void createLeadwithmandatoryFields(String lname, String comp)
	{
		setLastname(lname);
		setCompany(comp);
		ClickSave();
	}
	
	public void setLastname(String val)
	{
		cm.EnterValue(tblastname, val,"Text "+val +" has been entered into LastName field");
	}
	
	public void setCompany(String val)
	{
		cm.EnterValue(tbcompany, val,"Text "+val +" has been entered into Company field");
	}
	
	public void ClickSave()
	{
		cm.ClickELement(tbbutton,"Save button clicked");
	}


}
