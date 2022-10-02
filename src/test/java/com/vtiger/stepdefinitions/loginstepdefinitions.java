package com.vtiger.stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.vtiger.pages.AccountPage;
import com.vtiger.pages.HomePage;
import com.vtiger.pages.LeadPage;
import com.vtiger.pages.LoginPage;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class loginstepdefinitions extends BaseDefinition {
	
	public LoginPage lp;
	public HomePage hp;
	public LeadPage ldp;
	public AccountPage ac;
	
	String TCName;
	
	
	@Before
	public void before(Scenario scenario) {
	    this.scenario = scenario;
	}
	
	
	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		init();
		TCName = scenario.getName();
		logger = extent.createTest(TCName);
		 lp = new LoginPage(driver,logger);
		 hp = new HomePage(driver,logger);
		 ldp = new LeadPage(driver,logger);
		 ac = new AccountPage(driver,logger);
	   
	}
	@When("user enters valid userid and enters valid password")
	public void user_enters_valid_userid_and_enters_valid_password() {
		lp.setUserid(data.get(TCName).get("Userid"));
		lp.setPassword(data.get(TCName).get("Password"));
	    
	}
	@When("Click on login button")
	public void click_on_login_button() {
		lp.clickLogin();
	    
	}
	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	    hp.verifyPipeline();
	}
	@Then("logout link should be appear on right top corner")
	public void logout_link_should_be_appear_on_right_top_corner() {
		hp.clickLogout();
	   
	}
	
	@When("user enters invalid userid and enters invalid password")
	public void user_enters_invalid_userid_and_enters_invalid_password() {
		lp.setUserid(data.get(TCName).get("Userid"));
		lp.setPassword(data.get(TCName).get("Password"));
	}
	@Then("user can see error message on login page")
	public void user_can_see_error_message_on_login_page() {
	    lp.verifyErrorMessage();
	}
	
	@When("user enters invalid userid as {string} and enters invalid password as {string}")
	public void user_enters_invalid_userid_as_and_enters_invalid_password_as(String userid, String pwd) {
		lp.setUserid(userid);
		lp.setPassword(pwd);
	}
	
	
	@When("user click on New Lead link")
	public void user_click_on_new_lead_link() {
	    hp.clickNewLead();
	}
	@Then("user can see create lead page open")
	public void user_can_see_create_lead_page_open() {
	     ldp.verifyLastNameDisplay();
	}
	@When("User enters the all mandatory fields and click on save button")
	public void user_enters_the_all_mandatory_fields_and_click_on_save_button() {
	     ldp.createLeadwithmandatoryFields(data.get(TCName).get("LastName"), data.get(TCName).get("Company"));
	}
	@Then("lead should be save successfully")
	public void lead_should_be_save_successfully() {
	    ldp.verifyLeadCreation(data.get(TCName).get("LastName"), data.get(TCName).get("Company"));
	}
	
	@When("user click on New Account link")
	public void user_click_on_new_account_link() {
	    ac.clickNewAccount();
	}
	@Then("user can see create account page open")
	public void user_can_see_create_account_page_open() {
	     ac.verifyAccountNameDisplay();
	}
	@When("User enters the detail in account name fields and click on save button")
	public void user_enters_the_detail_in_account_name_fields_and_click_on_save_button() {
	     ac.createAccount(data.get(TCName).get("AccountName"));
	}
	@Then("account should be save successfully")
	public void account_should_be_save_successfully() {
	     ac.verifyAccountCreation(data.get(TCName).get("AccountName"));
	}
	
	
	
	
	
	@Then("close browser")
	public void close_browser() {
		extent.flush();
	    driver.quit();
	}


}
