@regression
Feature: Lead and account functionlity


Background:
Given user should be on login page
When user enters valid userid and enters valid password
And Click on login button
Then user should be navigated to home page



Scenario: TC03_createleadwithMandatoryFileds
When user click on New Lead link
Then user can see create lead page open
When User enters the all mandatory fields and click on save button
Then lead should be save successfully
And close browser




Scenario: TC04_createNewAccount
When user click on New Account link
Then user can see create account page open
When User enters the detail in account name fields and click on save button
Then account should be save successfully
And close browser